/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import PMSystem.*;
import helpers.StringsHelper;
import helpers.TimeHelper;
import java.util.Date;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class ProjectsModel extends AbstractModel {
    
    private Project rProject;
    private StringsHelper stringsHelper = new StringsHelper();
    private TimeHelper timeHelper = new TimeHelper();
   
    public ProjectsModel(String args[], String objName) {
        try {
            this.objName = objName;
            
            this.initCORBA(args);
            rProject = ProjectHelper.narrow(ProjectsModel.ncRef.resolve_str(this.objName));
        } catch (Exception ex) {
            // Handle ex
        } 
    }
    
    public String[] saveProject(int ID_User, String name, String description, String start_date, String end_date, String state) {
        try {
            Date start = this.timeHelper.toDate(start_date);
            Date end   = this.timeHelper.toDate(end_date);
            
            if(ID_User < 1) {
                String[] message = {"You need to select a user", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(name, 5)) {
                String[] message = {"You need to write a valid name", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(description, 5)) {
                String[] message = {"You need to write a valid description", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(start_date, 10)) {
                String[] message = {"You need to select a valid start date", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(end_date, 10)) {
                String[] message = {"You need to select a valid end date", "error"};
                return message;  
            } else if(!this.timeHelper.validateStartEnd(start, end)) {
                String[] message = {"The start date is bigger than the end date", "error"};
                return message; 
            }
            
            int result = rProject.setProject(ID_User, this.stringsHelper.clean(name), this.stringsHelper.clean(description), this.stringsHelper.clean(start_date), this.stringsHelper.clean(end_date), this.stringsHelper.clean(state));
        
            if(result > 0) {
                String[] message = {"The project has been saved correctly!", "information"};
                return message;        
            } else if(result == 0) {
                String[] message = {"An unexpected error has ocurred...", "error"};
                return message;   
            } else if(result == -1) {
                String[] message = {"The specified project already exists!", "error"};
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
    
    public String[] editProject(int ID_Project, int ID_User, String name, String description, String start_date, String end_date, String state) {
        try {
            Date start = this.timeHelper.toDate(start_date);
            Date end   = this.timeHelper.toDate(end_date);
            
            if(ID_User < 1) {
                String[] message = {"You need to select a user", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(name, 5)) {
                String[] message = {"You need to write a valid name", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(description, 5)) {
                String[] message = {"You need to write a valid description", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(start_date, 10)) {
                String[] message = {"You need to select a valid start date", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(end_date, 10)) {
                String[] message = {"You need to select a valid end date", "error"};
                return message;  
            } else if(!this.timeHelper.validateStartEnd(start, end)) {
                String[] message = {"The start date is bigger than the end date", "error"};
                return message; 
            }
            
            int result = rProject.updateProject(ID_Project, ID_User, this.stringsHelper.clean(name), this.stringsHelper.clean(description), this.stringsHelper.clean(start_date), this.stringsHelper.clean(end_date), this.stringsHelper.clean(state));
        
            if(result > 0) {
                String[] message = {"The project has been edited correctly!", "information"};
                return message;        
            } else if(result == 0) {
                String[] message = {"An unexpected error has ocurred...", "error"};
                return message;   
            } else if(result == -1) {
                String[] message = {"The specified project already exists!", "error"};
                return message; 
            } else if(result == -2) {
                String[] message = {"The specified project not exists!", "error"};
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
    
    public ProjectsBasicData[] getAllProjects() {
        return rProject.getAllProjects();
    }
    
    public ProjectData getProject(int id) {
        return rProject.getProject(id);
    }
    
    public ProjectData[] getProjects(String str) {
        return rProject.getProjects(str);
    }
    
    public boolean trashProject(int id) {
        return rProject.trash(id);
    }
    
    public boolean deleteProject(int id) {
        return rProject.delete(id);
    }
    
    public boolean restoreProject(int id) {
        return rProject.restore(id);
    }
    
}