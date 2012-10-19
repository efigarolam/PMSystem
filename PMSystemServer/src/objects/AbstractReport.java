/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import PMSystem.Configuration;
import PMSystem.GeneralReportData;
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
public class AbstractReport {
    
    private ActiveRecord db = null;
  
    public AbstractReport() {
        this.db = new ActiveRecord("jdbc:mysql://localhost/pmsdb","root","", "pms");
    }
    
    public GeneralReportData getGeneralReportData() {
        GeneralReportData report = new GeneralReportData();
        ArrayList result;
        HashMap resultMap;
        
        this.db.setTable("users", "*");
        report.total_users = this.db.countAll();
        report.total_administrators = this.db.countBySQL("Privilege = 'Administrator'");
        report.total_normalusers = this.db.countBySQL("Privilege = 'User'");
        report.total_men = this.db.countBySQL("Gender = 'Male'");
        report.total_women = this.db.countBySQL("Gender = 'Female'");
        report.total_activeusers = this.db.countBySQL("State = 'Active'");
        report.total_inactiveusers = this.db.countBySQL("State = 'Inactive'");
        
        this.db.setTable("usersonline", "*");
        report.total_logins = this.db.countAll();
        
        result = this.db.findBySQL("State = 'Active' ORDER BY ID DESC LIMIT 1");
        
        String start_date = "";
        String username = "";
        if(result != null) {
            resultMap = (HashMap) result.get(0);
            if(resultMap.get("ID_User") != null && resultMap.get("Start_Date") != null) {
                int id_user = Integer.parseInt(resultMap.get("ID_User").toString());
                start_date = resultMap.get("Start_Date").toString();
                this.db.setTable("users", "*");
                result = this.db.find(id_user);
                resultMap = (HashMap) result.get(0);
                if(resultMap.get("Username") != null) {
                    username = resultMap.get("Username").toString();
                }
            }
            report.last_login = username + " at " + start_date;
        } else {
            report.last_login = "";
        }
        
        
        
        this.db.setTable("projects", "*");
        report.total_projects = this.db.countAll();
        report.total_activeprojects = this.db.countBySQL("State = 'Active'");
        report.total_inactiveprojects = this.db.countBySQL("State = 'Inactive'");
        
        result = this.db.findBySQL("ID > 0 ORDER BY ID DESC LIMIT 1");
        if(result != null) {
            resultMap = (HashMap) result.get(0);
            String project = "";
            if(resultMap.get("Name") != null) {
                project = resultMap.get("Name").toString();
            }
            report.last_project = project;
        } else {
            report.last_project = "";
        }
        
        
        this.db.setTable("tasks", "*");
        report.total_tasks = this.db.countAll();
        report.total_started = this.db.countBySQL("State = 'Started'");
        report.total_paused = this.db.countBySQL("State = 'Paused'");
        report.total_stoped = this.db.countBySQL("State = 'Stoped'");
        report.total_finished = this.db.countBySQL("State = 'Finished'");
        report.total_inactive = this.db.countBySQL("State = 'Inactive'");
        report.total_urgent = this.db.countBySQL("Priority = 'Urgent'");
        report.total_high = this.db.countBySQL("Priority = 'High'");
        report.total_medium = this.db.countBySQL("Priority = 'Medium'");
        report.total_low = this.db.countBySQL("Priority = 'Low'");
        
        result = this.db.findBySQL("ID > 0 ORDER BY ID DESC LIMIT 1");
        
        if(result != null) {
            resultMap = (HashMap) result.get(0);
            String task = "";
            if(resultMap.get("Title") != null) {
                task = resultMap.get("Title").toString();
            }
            report.last_task = task;
        } else {
            report.last_task = "";
        }
        
        return report;
    }
    
    public void addMissingTranslation(String translation) {
        this.db.setTable("missing_translations", "Translation");
        
        if(this.db.countBySQL("Translation = '"+translation+"'") == 0) {
            this.db.setValues("'"+translation+"'");
            this.db.save(0);
        }
    }
    
    public int getLogins(String date, String datelimit) {
        this.db.setTable("usersonline", "*");
        return this.db.countBySQL("Start_Date < '"+date+"' AND Start_Date > '"+datelimit+"'");
    }
    
    public Configuration getConfig() {
        this.db.setTable("config", "*");
        
        ArrayList result = this.db.find(1);
        HashMap row = (HashMap) result.get(0);
        Configuration config = new Configuration();
        
        if(row.get("Language") != null) {
            config.language = row.get("Language").toString();
        } else {
            config.language = "";
        }
        
        if(row.get("Theme") != null) {
            config.theme = row.get("Theme").toString();
        } else {
            config.theme = "";
        }
        
        return config;
    }
    
    public boolean setConfig(String language, String theme) {
        this.db.setTable("config", "*");
        this.db.setValues("Language = '"+language+"', Theme = '"+theme+"'");
        
        if(this.db.save(1) > 0) {
            return true;
        } else {
            return false;
        }
    }
    
}