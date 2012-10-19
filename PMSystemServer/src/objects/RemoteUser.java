/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import PMSystem.*;
import org.omg.CORBA.*;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 */
public class RemoteUser extends UserPOA {
    private ORB orb;
	
    public void setORB(ORB orb_val) {
        this.orb = orb_val;
    }

    @Override
    public int setUser(String username, String password, String privilege, String name, String email, String gender, String birthday, String location, String state) {
        AbstractUser user = new AbstractUser();
        
        user.setUsername(username);
        user.setPassword(password);
        user.setPrivilege(privilege);
        user.setName(name);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setLocation(location);
        user.setState(state);
        
        user.save();
        
        return user.getID();       
    }
    
    @Override
    public int updateUser(int id, String username, String password, String privilege, String name, String email, String gender, String birthday, String location, String state) {
        AbstractUser user = new AbstractUser();
        
        user.setID(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setPrivilege(privilege);
        user.setName(name);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setLocation(location);
        user.setState(state);
        
        user.edit();
        
        return user.getID(); 
    }

    @Override
    public UsersBasicData[] getAllUsers() {
        UsersBasicData[] users;
        
        AbstractUser user = new AbstractUser();
        AbstractUser list[];
        
        list = user.getAll();
        if(list != null) {
            users = new UsersBasicData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                users[i] = new UsersBasicData();
                users[i].id = list[i].getID();
                users[i].username = list[i].getUsername();           
            }

            return users;
        } else {
            users = new UsersBasicData[1];
            users[0] = new UsersBasicData();
            users[0].id = 0;
            users[0].username = "";
            
            return users;
        }                
    }

    @Override
    public UserData getUser(int id) {
        AbstractUser result = new AbstractUser();
        result.getByID(id);
        
        UserData user = new UserData();
        
        user.id = result.getID();
        user.username = result.getUsername();
        user.password = result.getPassword();
        user.privilege = result.getPrivilege();
        user.name = result.getName();
        user.email = result.getEmail();
        user.gender = result.getGender();
        user.birthday = result.getBirthday();
        user.location = result.getLocation();
        user.state = result.getState();
        
        return user;        
    }

    @Override
    public boolean login(String username, String password, String time) {
        AbstractUser result = new AbstractUser();
        
        result.setUsername(username);
        result.setPassword(password);
        return result.login(time);
    }

    @Override
    public String[] getSessionData(String username) {
        AbstractUser result = new AbstractUser();
        return result.getSessionData(username);
    }

    @Override
    public UserData[] getUsers(String str) {
        UserData[] users;
        
        AbstractUser user = new AbstractUser();
        AbstractUser list[];
        
        list = user.getBySQL(str);
        
        if(list != null) {
            users = new UserData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                users[i] = new UserData();
                users[i].id        = list[i].getID();
                users[i].username  = list[i].getUsername();
                users[i].password  = "";
                users[i].privilege = list[i].getPrivilege();
                users[i].name      = list[i].getName();
                users[i].email     = list[i].getEmail();
                users[i].gender    = list[i].getGender();
                users[i].birthday  = list[i].getBirthday();
                users[i].location  = list[i].getLocation();
                users[i].state     = list[i].getState();
            }
            
            return users;
        } else {
            users = new UserData[1];
            users[0] = new UserData();
            users[0].id        = 0;
            users[0].username  = "";
            users[0].password  = "";
            users[0].privilege = "";
            users[0].name      = "";
            users[0].email     = "";
            users[0].gender    = "";
            users[0].birthday  = "";
            users[0].location  = "";
            users[0].state     = "";
            
            return users;
        }
    }

    @Override
    public boolean trash(int id) {
        AbstractUser user = new AbstractUser();
        user.setID(id);
        
        AbstractProject project = new AbstractProject();
        project.setID_User(id);
        project.trashByUser();
        
        return user.trash();
    }

    @Override
    public boolean delete(int id) {
        AbstractUser user = new AbstractUser();
        user.setID(id);
        
        return user.delete();
    }

    @Override
    public boolean restore(int id) {
        AbstractUser user = new AbstractUser();
        user.setID(id);
        
        AbstractProject project = new AbstractProject();
        project.setID_User(id);
        project.restoreByUser();
        
        return user.restore();
    }

    @Override
    public void logout(int id, String time) {
       AbstractUser user = new AbstractUser();
       user.setID(id);
       
       user.logout(time);
    }

    @Override
    public UsersOnlineInfo[] getOnlineUsers() {
        AbstractUser user = new AbstractUser();
        
        return user.getOnlineUsers();
    }
    
}