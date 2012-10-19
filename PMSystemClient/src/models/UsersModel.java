/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import PMSystem.*;
import controllers.MainController;
import helpers.StringsHelper;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class UsersModel extends AbstractModel {
    
    private User rUser;
    private StringsHelper stringsHelper = new StringsHelper();
   
    public UsersModel(String args[], String objName) {
        try {
            this.objName = objName;
            
            this.initCORBA(args);
            rUser = UserHelper.narrow(UsersModel.ncRef.resolve_str(this.objName));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        
    }
    
    public boolean login(String username, String password, String time) {
        String encPwd = this.stringsHelper.encrypt(password, 2);
        return rUser.login(this.stringsHelper.clean(username), encPwd, time);
    }
    
    public String[] getSessionData(String username){
        return rUser.getSessionData(username);
    }
    
    public String[] setUser(String username, String password, String password2, String privilege, String name, String email, String gender, String birthday, String location, String state) {
        try {
            if(!this.stringsHelper.isEmpty(username, 7)) {
                String[] message = {"You need to write a valid username", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(password, 7)) {
                String[] message = {"You need to write a valid password", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(name, 6)) {
                String[] message = {"You need to write a valid name", "error"};
                return message;  
            } else if(!this.stringsHelper.validateEmail(email)) {
                String[] message = {"You need to write a valid email", "error"};
                return message;
            }
            
            String encPwd = this.stringsHelper.encrypt(password, 2);
            String encPwd2 = this.stringsHelper.encrypt(password2, 2);
            if(!encPwd.equals(encPwd2)) {
                String[] message = {"The passwords are different", "error"};
                return message; 
            }
                
            int result = rUser.setUser(this.stringsHelper.clean(username), encPwd, this.stringsHelper.clean(privilege), this.stringsHelper.clean(name), this.stringsHelper.clean(email), this.stringsHelper.clean(gender), this.stringsHelper.clean(birthday), this.stringsHelper.clean(location), this.stringsHelper.clean(state));
        
            if(result > 0) {
                String[] message = {"The user has been saved correctly!", "information"};
                return message;        
            } else if(result == 0) {
                String[] message = {"An unexpected error has ocurred...", "error"};
                return message;   
            } else if(result == -1) {
                String[] message = {"The specified email already exists!", "error"};
                return message; 
            } else if(result == -2) {
                String[] message = {"The specified username already exists!", "error"};
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
    
    public String[] updateUser(int id, String username, String password, String password2, String privilege, String name, String email, String gender, String birthday, String location, String state) {
        try {
            if(!this.stringsHelper.isEmpty(username, 7)) {
                String[] message = {"You need to write a valid username", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(name, 6)) {
                String[] message = {"You need to write a valid name", "error"};
                return message;  
            } else if(!this.stringsHelper.validateEmail(email)) {
                String[] message = {"You need to write a valid email", "error"};
                return message;
            }
            
            int result = 0;
            if(!password.equals("")) {
                String encPwd = this.stringsHelper.encrypt(password, 2);
                String encPwd2 = this.stringsHelper.encrypt(password2, 2);
                if(!encPwd.equals(encPwd2)) {
                    result = rUser.updateUser(id, this.stringsHelper.clean(username), "", this.stringsHelper.clean(privilege), this.stringsHelper.clean(name), this.stringsHelper.clean(email), this.stringsHelper.clean(gender), this.stringsHelper.clean(birthday), this.stringsHelper.clean(location), this.stringsHelper.clean(state));
                    String[] message = {"The passwords doesn't change because was different, all up-to-date", "information"};
                    return message; 
                } else {
                    result = rUser.updateUser(id, this.stringsHelper.clean(username), encPwd, this.stringsHelper.clean(privilege), this.stringsHelper.clean(name), this.stringsHelper.clean(email), this.stringsHelper.clean(gender), this.stringsHelper.clean(birthday), this.stringsHelper.clean(location), this.stringsHelper.clean(state));
                }
            } else {
                result = rUser.updateUser(id, this.stringsHelper.clean(username), this.stringsHelper.clean(password), this.stringsHelper.clean(privilege), this.stringsHelper.clean(name), this.stringsHelper.clean(email), this.stringsHelper.clean(gender), this.stringsHelper.clean(birthday), this.stringsHelper.clean(location), this.stringsHelper.clean(state));
            }          
        
            if(result > 0) {
                String[] message = {"The user has been edited correctly!", "information"};
                return message;        
            } else if(result == 0) {
                String[] message = {"An unexpected error has ocurred...", "error"};
                return message;   
            } else if(result == -1) {
                String[] message = {"The specified email already exists!", "error"};
                return message; 
            } else if(result == -2) {
                String[] message = {"The specified username already exists!", "error"};
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
    
    public UsersBasicData[] getAllUsers() {
        return rUser.getAllUsers();
    }
    
    public UserData getUser(int id) {
        return rUser.getUser(id);
    }
    
    public UserData[] getUsers(String str) {
        return rUser.getUsers(str);
    }
    
    public boolean trashUser(int id) {
        if(MainController.userOnlineID == id) {
            return false;
        }
        
        return rUser.trash(id);
    }
    
    public boolean deleteUser(int id) {
        if(MainController.userOnlineID == id) {
            return false;
        }
            
        return rUser.delete(id);
    }
    
    public boolean restoreUser(int id) {
        return rUser.restore(id);
    }
    
    public void logout(int id, String time) {
        rUser.logout(id, time);
    }
    
    public UsersOnlineInfo[] getOnlineUsers() {
        return rUser.getOnlineUsers();
    }
    
}