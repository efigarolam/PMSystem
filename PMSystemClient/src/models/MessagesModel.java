/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import PMSystem.*;
import helpers.StringsHelper;
import controllers.UsersController;
import helpers.EmailHelper;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class MessagesModel extends AbstractModel {
    
    private Message rMessage;
    private StringsHelper stringsHelper = new StringsHelper();
    private UsersController usersController;
    private EmailHelper emailHelper = new EmailHelper();
   
    public MessagesModel(String args[], String objName) {
        try {
            this.objName = objName;
            
            this.initCORBA(args);
            rMessage = MessageHelper.narrow(MessagesModel.ncRef.resolve_str(this.objName));
            this.usersController = new UsersController(args);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    public String[] sendMessage(int sender, int receiver, String subject, String msg, String date, String state, boolean email) {
        try {
            if(receiver < 1) {
                String[] message = {"You need to select a user", "error"};
                return message;  
            } else if(sender == receiver) {
                String[] message = {"You can't message yourself", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(subject, 5)) {
                String[] message = {"You need to write a valid subject", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(msg, 5)) {
                String[] message = {"You need to write a valid message", "error"};
                return message;  
            } 
            
            boolean result = rMessage.sendMessage(sender, receiver, this.stringsHelper.clean(subject), this.stringsHelper.clean(msg), this.stringsHelper.clean(date), this.stringsHelper.clean(state));
        
            if(result) {
                if(email) {
                    UserData userto = this.usersController.getUser(receiver);
                    UserData userfrom = this.usersController.getUser(sender);
                    String fromInfo = userfrom.name + " (" + userfrom.email + ")";
                    this.emailHelper.setEmail(userto.email, fromInfo, subject, msg);
                    Thread t = new Thread(this.emailHelper);
                    t.start();
                }
                
                String[] message = {"The message has been sent correctly!", "information"};
                return message;        
            } else {
                String[] message = {"An unexpected error has ocurred...", "error"};
                return message;
            } 
        } catch(Exception e) {
            String[] message = {e.getMessage(), "error"};
            return message;
        }
    }
       
    public MessageData[] getInboxMessages(int id_user) {
        return rMessage.getInboxMessages(id_user);
    }
    
    public MessageData[] getOutboxMessages(int id_user) {
        return rMessage.getOutboxMessages(id_user);
    }
    
    public MessageData[] getTrashMessages(int id_user) {
        return rMessage.getTrashMessages(id_user);
    }
    
    public MessageData getMessage(int id) {
        return rMessage.getMessage(id);
    }
    
    public boolean updateMessageState(int id, String state) {
        return rMessage.updateState(id, state);
    }
    
    public boolean sendToTrash(int id) {
        return rMessage.trash(id);
    }
    
    public boolean deleteMessage(int id) {
        return rMessage.delete(id);
    }
    
    public boolean restoreMessage(int id) {
        return rMessage.restore(id);
    }
    
    public int countNewMessages(int receiver) {
        return rMessage.areNewMessages(receiver);
    }
    
}