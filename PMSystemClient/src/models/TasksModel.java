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
public class TasksModel extends AbstractModel {
    
    private Task rTask;
    private StringsHelper stringsHelper = new StringsHelper();
    private TimeHelper timeHelper = new TimeHelper();
   
    public TasksModel(String args[], String objName) {
        try {
            this.objName = objName;
            
            this.initCORBA(args);
            rTask = TaskHelper.narrow(TasksModel.ncRef.resolve_str(this.objName));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    public String[] saveTask(int ID_Project, String[] users, String title, String description, String start_date, String end_date, int progress, String priority, String state) {
        try {
            Date start = this.timeHelper.toDate(start_date);
            Date end   = this.timeHelper.toDate(end_date);
            
            if(ID_Project < 1) {
                String[] message = {"You need to select a project", "error"};
                return message;
            } else if(users.length < 1) {
                String[] message = {"You need to select one user at least", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(title, 5)) {
                String[] message = {"You need to write a valid title", "error"};
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
            
            int result = rTask.setTask(ID_Project, users, this.stringsHelper.clean(title), this.stringsHelper.clean(description), this.stringsHelper.clean(start_date), this.stringsHelper.clean(end_date), progress, this.stringsHelper.clean(priority), this.stringsHelper.clean(state));
        
            if(result > 0) {
                String[] message = {"The task has been saved correctly!", "information"};
                return message;        
            } else if(result == 0) {
                String[] message = {"An unexpected error has ocurred...", "error"};
                return message;   
            } else if(result == -1) {
                String[] message = {"The specified task already exists!", "error"};
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
    
    public String[] editTask(int ID_Task, int ID_Project, String[] users, String title, String description, String start_date, String end_date, int progress, String priority, String state) {
        try {
            Date start = this.timeHelper.toDate(start_date);
            Date end   = this.timeHelper.toDate(end_date);
            
            if(ID_Task < 1) {
                String[] message = {"You need to select a task", "error"};
                return message;
            } else if(ID_Project < 1) {
                String[] message = {"You need to select a project", "error"};
                return message;
            } else if(users.length < 1) {
                String[] message = {"You need to select one user at least", "error"};
                return message;  
            } else if(!this.stringsHelper.isEmpty(title, 5)) {
                String[] message = {"You need to write a valid title", "error"};
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
            
            int result = rTask.updateTask(ID_Task, ID_Project, users, this.stringsHelper.clean(title), this.stringsHelper.clean(description), this.stringsHelper.clean(start_date), this.stringsHelper.clean(end_date), progress, this.stringsHelper.clean(priority), this.stringsHelper.clean(state));    
        
            if(result > 0) {
                String[] message = {"The task has been saved correctly!", "information"};
                return message;        
            } else if(result == 0) {
                String[] message = {"An unexpected error has ocurred...", "error"};
                return message;   
            } else if(result == -1) {
                String[] message = {"The specified task already exists!", "error"};
                return message; 
            } else if(result == -2) {
                String[] message = {"The specified task not exists!", "error"};
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
    
    public String[] updateTaskProgress(int ID_Task, int progress, String notes, String state) {
        try {
            if(ID_Task < 1) {
                String[] message = {"You need to select a task", "error"};
                return message;
            }
            
            int result = rTask.updateProgress(ID_Task, progress, this.stringsHelper.clean(notes), this.stringsHelper.clean(state));    
        
            if(result > 0) {
                String[] message = {"The progress has been updated correctly!", "information"};
                return message;        
            } else if(result == 0) {
                String[] message = {"An unexpected error has ocurred...", "error"};
                return message;   
            } else if(result == -1) {
                String[] message = {"The specified task not exists!", "error"};
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
    
    public TasksBasicData[] getAllTasks() {
        return rTask.getAllTasks();
    }
    
    public TaskData getTask(int id) {
        return rTask.getTask(id);
    }
    
    public TaskData[] getTasks(String str) {
        return rTask.getTasks(str);
    }
    
    public TaskData[] getTasksByUser(int id_user) {
        return rTask.getTasksByUser(id_user);
    }
    
    public boolean trashTask(int id) {
        return rTask.trash(id);
    }
    
    public boolean deleteTask(int id) {
        return rTask.delete(id);
    }
    
    public boolean restoreTask(int id) {
        return rTask.restore(id);
    }
    
}