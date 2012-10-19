/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import classes.ActiveRecord;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class AbstractMessage {
    
    private ActiveRecord db = null;
    private String table;
    private int ID          = 0;
    private int ID_Sender   = 0;
    private int ID_Receiver = 0;
    private String subject  = "";
    private String message  = "";
    private String date     = "";
    private String state    = "";
    private String sender   = "";
    private String receiver = "";
    
    public AbstractMessage() {
        this.db = new ActiveRecord("jdbc:mysql://localhost/pmsdb","root","", "pms");
        this.table = "messages";
    }
    
    public void sendMessage() {
        this.db.setTable(this.table, "Sender, Receiver, Subject, Message, Date, State");
        
        String values = "'"+this.getID_Sender()+"', '"+this.getID_Receiver()+"', '"+this.getSubject()+"', '"+this.getMessage()+"', '"+this.getDate()+"', '"+this.getState()+"'";
        this.db.setValues(values);
        
        int result = this.db.save(0);
        if(result > 0) {
            this.setID(result);
        } else {
            this.setID(-1);
        }       
    }
    
    public boolean updateState() {
        this.db.setTable(this.table, "*");
        this.db.setValues("State = '"+this.getState()+"'");
        
        if(this.db.save(this.getID()) > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean trash() {
        try {
            this.db.setTable(this.table, "*");
            String values = "State = 'Inactive'";
            
            this.db.setValues(values);
            if(this.db.save(this.getID()) > 0) {
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean restore() {
        try {
            this.db.setTable(this.table, "*");
            String values = "State = 'Read'";
            
            this.db.setValues(values);
            if(this.db.save(this.getID()) > 0) {
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean delete() {
        try {
            this.db.setTable(this.table, "*");
            return this.db.doDelete(this.getID());
        } catch(Exception e) {
            return false;
        }
    }
    
    public int countUnread() {
        this.db.setTable(this.table, "*");
        return this.db.countBySQL("Receiver = '"+this.getID_Receiver()+"' AND State = 'Unread'");
    }
    
    public void getByID(int ID) {
        ArrayList dataMessage, dataUser;
        HashMap dataMessageMap, dataUserMap;
        
        this.db.setTable(this.table,"*");
        dataMessage = this.db.find(ID);
        
        this.db.setTable("users","*");
        
        if(dataMessage != null) {
            dataMessageMap = (HashMap) dataMessage.get(0);
            
            if(dataMessageMap.get("ID") != null) {
                this.setID(Integer.parseInt(dataMessageMap.get("ID").toString()));
            }
            
            if(dataMessageMap.get("Sender") != null) {
                this.setID_Sender(Integer.parseInt(dataMessageMap.get("Sender").toString()));
                
                dataUser    = this.db.find(this.getID_Sender());
                dataUserMap = (HashMap) dataUser.get(0);

                if(dataUserMap.get("Name") != null) {
                    this.setSender(dataUserMap.get("Name").toString());
                }
            }
            
            if(dataMessageMap.get("Receiver") != null) {
                this.setID_Receiver(Integer.parseInt(dataMessageMap.get("Receiver").toString()));
                        
                dataUser    = this.db.find(this.getID_Receiver());
                dataUserMap = (HashMap) dataUser.get(0);

                if(dataUserMap.get("Name") != null) {
                    this.setReceiver(dataUserMap.get("Name").toString());
                }
            }
            
            if(dataMessageMap.get("Subject") != null) {
                this.setSubject(dataMessageMap.get("Subject").toString());
            }
            
            if(dataMessageMap.get("Message") != null) {
                this.setMessage(dataMessageMap.get("Message").toString());
            }
            
            if(dataMessageMap.get("Date") != null) {
                this.setDate(dataMessageMap.get("Date").toString());
            }
            
            if(dataMessageMap.get("State") != null) {
                this.setState(dataMessageMap.get("State").toString());
            }
        }        
    }
    
    public AbstractMessage[] getInboxMessages() {
        try {
            ArrayList dataMessages;
            HashMap dataMessagesMap;
            
            this.db.setTable(this.table,"*");
            dataMessages = this.db.findBySQL("Receiver = '"+this.getID_Receiver()+"' AND State != 'Inactive' ORDER BY Date DESC");
            AbstractMessage[] messages;
            
            ArrayList dataUser;
            HashMap dataUserMap;
            this.db.setTable("users", "Name");
                                   
            if(dataMessages != null) {		
                messages = new AbstractMessage[dataMessages.size()];		
                for(int i = 0; i < dataMessages.size(); i++) {
                    dataMessagesMap = (HashMap) dataMessages.get(i);
                    messages[i] = new AbstractMessage();

                    if(dataMessagesMap.get("ID") != null) {
                        messages[i].setID(Integer.parseInt(dataMessagesMap.get("ID").toString()));
                    }
                    
                    if(dataMessagesMap.get("Receiver") != null) {
                        messages[i].setID_Receiver(Integer.parseInt(dataMessagesMap.get("Receiver").toString()));
                        
                        dataUser    = this.db.find(messages[i].getID_Receiver());
                        dataUserMap = (HashMap) dataUser.get(0);

                        if(dataUserMap.get("Name") != null) {
                            messages[i].setReceiver(dataUserMap.get("Name").toString());
                        }
                    }
                    
                    if(dataMessagesMap.get("Sender") != null) {
                        messages[i].setID_Sender(Integer.parseInt(dataMessagesMap.get("Sender").toString()));
                        
                        dataUser    = this.db.find(messages[i].getID_Sender());
                        dataUserMap = (HashMap) dataUser.get(0);

                        if(dataUserMap.get("Name") != null) {
                            messages[i].setSender(dataUserMap.get("Name").toString());
                        }
                    }
                    
                    if(dataMessagesMap.get("Subject") != null) {
                        messages[i].setSubject(dataMessagesMap.get("Subject").toString());
                    }
                    
                    if(dataMessagesMap.get("Message") != null) {
                        messages[i].setMessage(dataMessagesMap.get("Message").toString());
                    }
                    
                    if(dataMessagesMap.get("Date") != null) {
                        messages[i].setDate(dataMessagesMap.get("Date").toString());
                    }
                    
                    if(dataMessagesMap.get("State") != null) {
                        messages[i].setState(dataMessagesMap.get("State").toString());
                    }
                }			
            } else {
                messages = null;
            }

            return messages;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }		
    }
    
    public AbstractMessage[] getOutboxMessages() {
        try {
            ArrayList dataMessages;
            HashMap dataMessagesMap;

            this.db.setTable(this.table,"*");
            dataMessages = this.db.findBySQL("Sender = '"+this.getID_Sender()+"' AND State != 'Inactive' ORDER BY Date DESC");
            AbstractMessage[] messages;
            
            ArrayList dataUser;
            HashMap dataUserMap;
            this.db.setTable("users", "Name");
                                   
            if(dataMessages != null) {		
                messages = new AbstractMessage[dataMessages.size()];		
                for(int i = 0; i < dataMessages.size(); i++) {
                    dataMessagesMap = (HashMap) dataMessages.get(i);
                    messages[i] = new AbstractMessage();

                    if(dataMessagesMap.get("ID") != null) {
                        messages[i].setID(Integer.parseInt(dataMessagesMap.get("ID").toString()));
                    }
                    
                    if(dataMessagesMap.get("Receiver") != null) {
                        messages[i].setID_Receiver(Integer.parseInt(dataMessagesMap.get("Receiver").toString()));
                        
                        dataUser    = this.db.find(messages[i].getID_Receiver());
                        dataUserMap = (HashMap) dataUser.get(0);

                        if(dataUserMap.get("Name") != null) {
                            messages[i].setReceiver(dataUserMap.get("Name").toString());
                        }
                    }
                    
                    if(dataMessagesMap.get("Sender") != null) {
                        messages[i].setID_Sender(Integer.parseInt(dataMessagesMap.get("Sender").toString()));
                        
                        dataUser    = this.db.find(messages[i].getID_Sender());
                        dataUserMap = (HashMap) dataUser.get(0);

                        if(dataUserMap.get("Name") != null) {
                            messages[i].setSender(dataUserMap.get("Name").toString());
                        }
                    }
                    
                    if(dataMessagesMap.get("Subject") != null) {
                        messages[i].setSubject(dataMessagesMap.get("Subject").toString());
                    }
                    
                    if(dataMessagesMap.get("Message") != null) {
                        messages[i].setMessage(dataMessagesMap.get("Message").toString());
                    }
                    
                    if(dataMessagesMap.get("Date") != null) {
                        messages[i].setDate(dataMessagesMap.get("Date").toString());
                    }
                    
                    if(dataMessagesMap.get("State") != null) {
                        messages[i].setState(dataMessagesMap.get("State").toString());
                    }
                }			
            } else {
                messages = null;
            }

            return messages;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }		
    }
    
    public AbstractMessage[] getTrashMessages() {
        try {
            ArrayList dataMessages;
            HashMap dataMessagesMap;

            this.db.setTable(this.table,"*");
            dataMessages = this.db.findBySQL("(Sender = '"+this.getID_Sender()+"' OR Receiver = '"+this.getID_Sender()+"') AND State = 'Inactive' ORDER BY Date ASC");
            AbstractMessage[] messages;
            
            ArrayList dataUser;
            HashMap dataUserMap;
            this.db.setTable("users", "Name");
                                   
            if(dataMessages != null) {		
                messages = new AbstractMessage[dataMessages.size()];		
                for(int i = 0; i < dataMessages.size(); i++) {
                    dataMessagesMap = (HashMap) dataMessages.get(i);
                    messages[i] = new AbstractMessage();

                    if(dataMessagesMap.get("ID") != null) {
                        messages[i].setID(Integer.parseInt(dataMessagesMap.get("ID").toString()));
                    }
                    
                    if(dataMessagesMap.get("Receiver") != null) {
                        messages[i].setID_Receiver(Integer.parseInt(dataMessagesMap.get("Receiver").toString()));
                        
                        dataUser    = this.db.find(messages[i].getID_Receiver());
                        dataUserMap = (HashMap) dataUser.get(0);

                        if(dataUserMap.get("Name") != null) {
                            messages[i].setReceiver(dataUserMap.get("Name").toString());
                        }
                    }
                    
                    if(dataMessagesMap.get("Sender") != null) {
                        messages[i].setID_Sender(Integer.parseInt(dataMessagesMap.get("Sender").toString()));
                        
                        dataUser    = this.db.find(messages[i].getID_Sender());
                        dataUserMap = (HashMap) dataUser.get(0);

                        if(dataUserMap.get("Name") != null) {
                            messages[i].setSender(dataUserMap.get("Name").toString());
                        }
                    }
                    
                    if(dataMessagesMap.get("Subject") != null) {
                        messages[i].setSubject(dataMessagesMap.get("Subject").toString());
                    }
                    
                    if(dataMessagesMap.get("Message") != null) {
                        messages[i].setMessage(dataMessagesMap.get("Message").toString());
                    }
                    
                    if(dataMessagesMap.get("Date") != null) {
                        messages[i].setDate(dataMessagesMap.get("Date").toString());
                    }
                    
                    if(dataMessagesMap.get("State") != null) {
                        messages[i].setState(dataMessagesMap.get("State").toString());
                    }
                }			
            } else {
                messages = null;
            }

            return messages;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }		
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }
    
    public void setID_Sender(int ID_Sender) {
        this.ID_Sender = ID_Sender;
    }

    public int getID_Sender() {
        return this.ID_Sender;
    }
    
    public void setID_Receiver(int ID_Receiver) {
        this.ID_Receiver = ID_Receiver;
    }

    public int getID_Receiver() {
        return this.ID_Receiver;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getSubject() {
        return this.subject;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return this.sender;
    }
    
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver() {
        return this.receiver;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}