/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import PMSystem.Configuration;
import views.LoginView;
import views.MainAdminView;
import views.MainUserView;
import controllers.ReportsController;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class MainController extends AbstractController {
    
    public static MainAdminView adminView;
    public static MainUserView userView;
    public static int userOnlineID;
    public static String userOnlineName;
    public static String userOnlinePrivilege;
    public static LoginView loginView;
    public static String language;
    private static int theme = 1;
    public static String[] orbdConfig;
    private ReportsController reportsController;
    
    public MainController(String args[], boolean login) {
        this.orbdConfig = args;
        this.reportsController = new ReportsController(args);
        Configuration config = this.reportsController.getConfiguration();
        setTheme(config.theme);
        setLanguage(config.language);
        if(login == true) {
            loginView = new LoginView(args);
        } 
    }
    
    public void mainProgram(int userID, String userName, String userPrivilege) {
        userOnlineID = userID;
        userOnlineName = userName;
        userOnlinePrivilege = userPrivilege;
        if(userOnlinePrivilege.equals("Administrator")) {
           adminView = new MainAdminView(this.orbdConfig); 
        } else if(userOnlinePrivilege.equals("User")) {
           userView = new MainUserView(this.orbdConfig); 
        }
    }
    
    public static void setTheme(String theme) {
        if(theme.equals("Dark")) {
            MainController.theme = 1;
        } else if(theme.equals("Light")) {
            MainController.theme = 2;
        }
        
    }
    
    public static int getTheme() {
        return MainController.theme;
    }
     
    public static void setLanguage(String language) {
        MainController.language = language;
    }
    
    public static String getLanguage() {
        return MainController.language;
    }
}