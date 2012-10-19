/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import PMSystem.UserData;
import PMSystem.UsersBasicData;
import PMSystem.UsersOnlineInfo;
import models.UsersModel;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class UsersController extends AbstractController {
    
    private UsersModel model;
    
    public UsersController(String args[]) {
        this.model = new UsersModel(args, "User");
    }
   
    public String[] saveUser(String username, String password, String password2, String privilege, String name, String email, String gender, String birthday, String location, String state) {
        return this.model.setUser(username, password, password2, privilege, name, email, gender, birthday, location, state);      
    }
    
    public String[] editUser(int id, String username, String password, String password2, String privilege, String name, String email, String gender, String birthday, String location, String state) {
        return this.model.updateUser(id, username, password, password2, privilege, name, email, gender, birthday, location, state);      
    }
    
    public UsersBasicData[] getAllUsers() {
        return this.model.getAllUsers();
    }
    
    public UserData getUser(int id) {
        return this.model.getUser(id);
    }
    
    public boolean login(String username, String password, String time) {
        return this.model.login(username, password, time);
    }
    
    public String[] getSessionData(String username){
        return this.model.getSessionData(username);
    }
    
    public UserData[] getUsers(String str) {
        return this.model.getUsers(str);
    }
    
    public boolean trashUser(int id) {
        return this.model.trashUser(id);
    }
    
    public boolean deleteUser(int id) {
        return this.model.deleteUser(id);
    }
    
    public boolean restoreUser(int id) {
        return this.model.restoreUser(id);
    }
    
    public void logout(int id, String time) {
        this.model.logout(id, time);
    }
    
    public UsersOnlineInfo[] getOnlineUsers() {
        return this.model.getOnlineUsers();
    }
}