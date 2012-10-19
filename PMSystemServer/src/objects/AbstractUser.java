/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import PMSystem.UsersOnlineInfo;
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
public class AbstractUser {
    
    private ActiveRecord db = null;
    private String table;
    private int ID;
    private String username  = "";
    private String password  = "";
    private String privilege = "";
    private String name      = "";
    private String email     = "";
    private String gender    = "";
    private String birthday  = "1970-01-01";
    private String location  = "";
    private String state     = "";
	
    public AbstractUser() {
        this.db = new ActiveRecord("jdbc:mysql://localhost/pmsdb","root","", "pms");
        this.table = "users";
    }
	
    public void save() {
        try {
            String params = "'"+this.getUsername()+"', '"+this.getPassword()+"', '"+this.getPrivilege()+"', '"+this.getName()+"', '"+this.getEmail()+"', '"+this.getGender()+"', '"+this.getBirthday()+"', '"+this.getLocation()+"', '"+this.getState()+"'";
            ArrayList query = this.db.call("setUser", params);
            HashMap result;
            
            if(query != null) {
                result = (HashMap) query.get(0);
                
                if(result.get("Email_Exists") != null) {
                    this.setID(-1);
                } else if(result.get("Username_Exists") != null) {
                    this.setID(-2);
                } else if(result.get("ID") != null) {
                    this.setID(Integer.parseInt(result.get("ID").toString()));
                }
            } else {
                this.setID(0);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }		
    }
	
    public void edit() {
        try {
            String params = "'"+this.getID()+"', '"+this.getUsername()+"', '"+this.getPassword()+"', '"+this.getPrivilege()+"', '"+this.getName()+"', '"+this.getEmail()+"', '"+this.getGender()+"', '"+this.getBirthday()+"', '"+this.getLocation()+"', '"+this.getState()+"'";
            ArrayList query = this.db.call("updateUser", params);
            HashMap result;
            
            if(query != null) {
                result = (HashMap) query.get(0);
                
                if(result.get("Email_Exists") != null) {
                    this.setID(-1);
                } else if(result.get("Username_Exists") != null) {
                    this.setID(-2);
                } else if(result.get("User_Not_Exists") != null) {
                    this.setID(-3);
                } else if(result.get("ID") != null) {
                    this.setID(Integer.parseInt(result.get("ID").toString()));
                }
            } else {
                this.setID(0);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
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
            String values = "State = 'Active'";
            
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
	
    public void getByID(int ID) {
        try {
            ArrayList dataUser;
            HashMap dataUserMap;

            this.db.setTable(this.table,"*");
            dataUser = this.db.find(ID);

            if(dataUser != null) {
                dataUserMap = (HashMap) dataUser.get(0);

                if(dataUserMap.get("ID") != null) {
                    this.setID(Integer.parseInt(dataUserMap.get("ID").toString()));
                }

                if(dataUserMap.get("Username") != null) {
                    this.setUsername(dataUserMap.get("Username").toString());
                }

                if(dataUserMap.get("Password") != null) {
                    this.setPassword(dataUserMap.get("Password").toString());
                }

                if(dataUserMap.get("Privilege") != null) {
                    this.setPrivilege(dataUserMap.get("Privilege").toString());
                }
                
                if(dataUserMap.get("Name") != null) {
                    this.setName(dataUserMap.get("Name").toString());
                }

                if(dataUserMap.get("Email") != null) {
                    this.setEmail(dataUserMap.get("Email").toString());
                }
                
                 if(dataUserMap.get("Gender") != null) {			
                    this.setGender(dataUserMap.get("Gender").toString());
                }

                if(dataUserMap.get("Birthday") != null) {
                    this.setBirthday(dataUserMap.get("Birthday").toString());
                }

                if(dataUserMap.get("Location") != null) {
                    this.setLocation(dataUserMap.get("Location").toString());
                }
                
                if(dataUserMap.get("State") != null) {
                    this.setState(dataUserMap.get("State").toString());
                }				
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }		
    }
	
    public AbstractUser[] getBySQL(String sql) {
        try {
            ArrayList dataUsers;
            HashMap dataUsersMap;

            this.db.setTable(this.table,"*");
            dataUsers = this.db.findBySQL(sql);
            AbstractUser[] users;

            if(dataUsers != null) {		
                users = new AbstractUser[dataUsers.size()];		
                for(int i = 0; i < dataUsers.size(); i++) {
                    dataUsersMap = (HashMap) dataUsers.get(i);
                    users[i] = new AbstractUser();

                    if(dataUsersMap.get("ID") != null) {
                        users[i].setID(Integer.parseInt(dataUsersMap.get("ID").toString()));
                    }

                    if(dataUsersMap.get("Username") != null) {
                        users[i].setUsername(dataUsersMap.get("Username").toString());
                    }

                    if(dataUsersMap.get("Password") != null) {
                        users[i].setPassword(dataUsersMap.get("Password").toString());
                    }

                    if(dataUsersMap.get("Privilege") != null) {
                        users[i].setPrivilege(dataUsersMap.get("Privilege").toString());
                    }
                    
                    if(dataUsersMap.get("Name") != null) {
                        users[i].setName(dataUsersMap.get("Name").toString());
                    }
                            
                    if(dataUsersMap.get("Email") != null) {
                        users[i].setEmail(dataUsersMap.get("Email").toString());
                    }
                    
                    if(dataUsersMap.get("Gender") != null) {
                        users[i].setGender(dataUsersMap.get("Gender").toString());
                    }
                    
                    if(dataUsersMap.get("Birthday") != null) {
                        users[i].setBirthday(dataUsersMap.get("Birthday").toString());
                    }
                    
                    if(dataUsersMap.get("Location") != null) {
                        users[i].setLocation(dataUsersMap.get("Location").toString());
                    }
                    if(dataUsersMap.get("State") != null) {
                        users[i].setState(dataUsersMap.get("State").toString());
                    }	
                }			
            } else {
                users = null;
            }

            return users;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }		
    }
    
    public AbstractUser[] getAll() {
        try {
            ArrayList dataUsers;
            HashMap dataUsersMap;

            this.db.setTable(this.table,"*");
            dataUsers = this.db.findBySQL("ID > 0 AND State != 'Inactive'");
            AbstractUser[] users;

            if(dataUsers != null) {		
                users = new AbstractUser[dataUsers.size()];		
                for(int i = 0; i < dataUsers.size(); i++) {
                    dataUsersMap = (HashMap) dataUsers.get(i);
                    users[i] = new AbstractUser();

                    if(dataUsersMap.get("ID") != null) {
                        users[i].setID(Integer.parseInt(dataUsersMap.get("ID").toString()));
                    }

                    if(dataUsersMap.get("Username") != null) {
                        users[i].setUsername(dataUsersMap.get("Username").toString());
                    }

                    if(dataUsersMap.get("Password") != null) {
                        users[i].setPassword(dataUsersMap.get("Password").toString());
                    }

                    if(dataUsersMap.get("Privilege") != null) {
                        users[i].setPrivilege(dataUsersMap.get("Privilege").toString());
                    }
                    
                    if(dataUsersMap.get("Name") != null) {
                        users[i].setName(dataUsersMap.get("Name").toString());
                    }
                            
                    if(dataUsersMap.get("Email") != null) {
                        users[i].setEmail(dataUsersMap.get("Email").toString());
                    }
                    
                    if(dataUsersMap.get("Gender") != null) {
                        users[i].setGender(dataUsersMap.get("Gender").toString());
                    }
                    
                    if(dataUsersMap.get("Birthday") != null) {
                        users[i].setBirthday(dataUsersMap.get("Birthday").toString());
                    }
                    
                    if(dataUsersMap.get("Location") != null) {
                        users[i].setLocation(dataUsersMap.get("Location").toString());
                    }
                    if(dataUsersMap.get("State") != null) {
                        users[i].setState(dataUsersMap.get("State").toString());
                    }	
                }			
            } else {
                users = null;
            }

            return users;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }		
    }

    public String[] getSessionData(String username) {
         try {
            ArrayList dataUser;
            HashMap dataUserMap;
            
            this.db.setTable(this.table, "ID, Username, Privilege");
            dataUser = this.db.findBySQL("Username = '"+username+"'");
            if(dataUser != null) {
                dataUserMap = (HashMap) dataUser.get(0);
                String[] sessionData = new String[3];
                
                if(dataUserMap.get("ID") != null) {
                    sessionData[0] = dataUserMap.get("ID").toString();
                }
                
                if(dataUserMap.get("Username") != null) {
                    sessionData[1] = dataUserMap.get("Username").toString();
                }
                
                if(dataUserMap.get("Privilege") != null) {
                     sessionData[2] = dataUserMap.get("Privilege").toString();
                }
                
                return sessionData;
            } else {
                return null;
            } 
         } catch(Exception e) {
            return null;
         }
    }
    
    public boolean login(String time) {
        try {
            ArrayList dataUser;
            HashMap dataUserMap;

            this.db.setTable(this.table,"*");
            dataUser = this.db.findBySQL("Username = '"+this.getUsername()+"' AND Password = '"+this.getPassword()+"' AND State = 'Active'");

            if(dataUser != null) {
                dataUserMap = (HashMap) dataUser.get(0);

                if(dataUserMap.get("ID") != null) {
                    this.setID(Integer.parseInt(dataUserMap.get("ID").toString()));
                    if(this.getID() > 0) {
                        this.db.setTable("usersonline","ID_User, Start_Date, State");
                        this.db.setValues("'"+this.getID()+"', '"+time+"', 'Active'");
                        this.db.save(0);
                        
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }		
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public void logout(String time) {
        try {
            this.db.setTable("usersonline","*");
            this.db.setValues("End_Date = '"+time+"', State = 'Inactive'");
            
            this.db.updateBySQL("ID_User = '"+this.getID()+"' AND State = 'Active'");
        } catch(Exception ex) {
            
        }
    }
    
    public UsersOnlineInfo[] getOnlineUsers() {
        try {
            ArrayList usersOnline;
            HashMap usersOnlineMap;

            this.db.setTable("usersonline","*");
            usersOnline = this.db.findBySQL("State = 'Active'");
            UsersOnlineInfo[] users;
            
            this.db.setTable("users","Username, Privilege, Location");
            ArrayList userInfo;
            HashMap userInfoMap;
            
            if(usersOnline != null) {		
                users = new UsersOnlineInfo[usersOnline.size()];		
                for(int i = 0; i < usersOnline.size(); i++) {
                    usersOnlineMap = (HashMap) usersOnline.get(i);
                    users[i] = new UsersOnlineInfo();
                    
                    if(usersOnlineMap.get("State") != null) {
                        users[i].state = usersOnlineMap.get("State").toString();
                    }
                    
                    if(usersOnlineMap.get("Start_Date") != null) {
                        users[i].start_date = usersOnlineMap.get("Start_Date").toString();
                    }
                       
                    if(usersOnlineMap.get("ID_User") != null) {
                        users[i].id_user = Integer.parseInt(usersOnlineMap.get("ID_User").toString());
                        userInfo = this.db.find(users[i].id_user);
                        
                        userInfoMap = (HashMap) userInfo.get(0);
                        
                        if(userInfoMap.get("Username") != null) {
                            users[i].username = userInfoMap.get("Username").toString();
                        }
                        
                        if(userInfoMap.get("Privilege") != null) {
                            users[i].privilege = userInfoMap.get("Privilege").toString();
                        }
                        
                        if(userInfoMap.get("Location") != null) {
                            users[i].location = userInfoMap.get("Location").toString();
                        }
                    }	
                }
            } else {
                users = new UsersOnlineInfo[1];
                users[0].id_user = 0;
                users[0].username = "";
                users[0].privilege = "";
                users[0].location = "";
                users[0].start_date = "";
                users[0].state = "";
            }

            return users;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getPrivilege() {
        return this.privilege;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setBirthday(String birthday) {
        if(!birthday.equals("")) {
            this.birthday = birthday;
        }
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}