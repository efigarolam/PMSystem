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
public class RemoteTask extends TaskPOA {
    private ORB orb;
	
    public void setORB(ORB orb_val) {
        this.orb = orb_val;
    }
    
    @Override
    public int setTask(int id_project, String[] users, String title, String description, String start_date, String end_date, int progress, String priority, String state) {
        AbstractTask task = new AbstractTask();
        
        task.setID_Project(id_project);
        task.setUsers(users);
        task.setTitle(title);
        task.setDescription(description);
        task.setStart_Date(start_date);
        task.setEnd_Date(end_date);
        task.setProgress(progress);
        task.setPriority(priority);
        task.setState(state);
        
        task.save();
        
        return task.getID();
    }

    @Override
    public int updateTask(int id, int id_project, String[] users, String title, String description, String start_date, String end_date, int progress, String priority, String state) {
        AbstractTask task = new AbstractTask();
        
        task.setID(id);
        task.setID_Project(id_project);
        task.setUsers(users);
        task.setTitle(title);
        task.setDescription(description);
        task.setStart_Date(start_date);
        task.setEnd_Date(end_date);
        task.setProgress(progress);
        task.setPriority(priority);
        task.setState(state);
        
        task.edit();
        
        return task.getID();
    }
    
    @Override
    public TaskData getTask(int id) {
        AbstractTask result = new AbstractTask();
        result.getByID(id);
        
        TaskData task = new TaskData();
        
        task.id          = result.getID();
        task.id_project  = result.getID_Project();
        task.project     = "";
        task.users       = result.getUsers();
        task.title       = result.getTitle();
        task.description = result.getDescription();
        task.start_date  = result.getStart_Date();
        task.end_date    = result.getEnd_Date();
        task.progress    = result.getProgress();
        task.priority    = result.getPriority();
        task.notes       = result.getNotes();
        task.state       = result.getState();
        
        return task;
    }

    @Override
    public TasksBasicData[] getAllTasks() {
        TasksBasicData[] tasks;
        
        AbstractTask task = new AbstractTask();
        AbstractTask list[];
        
        list = task.getAll();
        if(list != null) {
            tasks = new TasksBasicData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                tasks[i] = new TasksBasicData();
                tasks[i].id = list[i].getID();
                tasks[i].title = list[i].getTitle();           
            }

            return tasks;
        } else {
            tasks = new TasksBasicData[1];
            tasks[0] = new TasksBasicData();
            tasks[0].id = 0;
            tasks[0].title = "";
            
            return tasks;
        }
    }

    @Override
    public TaskData[] getTasks(String str) {
        TaskData[] tasks;
        
        AbstractTask task = new AbstractTask();
        AbstractTask list[];
        
        list = task.getBySQL(str);
        
        if(list != null) {
            tasks = new TaskData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                tasks[i] = new TaskData();
                tasks[i].id          = list[i].getID();
                tasks[i].id_project  = list[i].getID_Project();
                tasks[i].project     = list[i].getProject();
                tasks[i].users       = list[i].getUsers();
                tasks[i].title       = list[i].getTitle();
                tasks[i].description = list[i].getDescription();
                tasks[i].start_date  = list[i].getStart_Date();
                tasks[i].end_date    = list[i].getEnd_Date();
                tasks[i].progress    = list[i].getProgress();
                tasks[i].priority    = list[i].getPriority();
                tasks[i].notes       = list[i].getNotes();
                tasks[i].state       = list[i].getState();
            }
            
            return tasks;
        } else {
            tasks = new TaskData[1];
            tasks[0] = new TaskData();
            tasks[0].id          = 0;
            tasks[0].id_project  = 0;
            tasks[0].project     = "";
            String[] cad = new String[1];
            cad[0] = "";
            tasks[0].users       = cad;
            tasks[0].title       = "";
            tasks[0].description = "";
            tasks[0].start_date  = "";
            tasks[0].end_date    = "";
            tasks[0].progress    = 0;
            tasks[0].priority    = "";
            tasks[0].notes       = "";
            tasks[0].state       = "";
            
            return tasks;
        }
    }

    @Override
    public boolean trash(int id) {
        AbstractTask task = new AbstractTask();
        task.setID(id);
        
        return task.trash();
    }

    @Override
    public boolean delete(int id) {
        AbstractTask task = new AbstractTask();
        task.setID(id);
        
        return task.delete();
    }

    @Override
    public boolean restore(int id) {
        AbstractTask task = new AbstractTask();
        task.setID(id);
        
        return task.restore();
    }

    @Override
    public TaskData[] getTasksByUser(int id) {
        TaskData[] tasks;
        
        AbstractTask task = new AbstractTask();
        AbstractTask list[];
        
        list = task.getByID_User(id);
        
        if(list != null) {
            tasks = new TaskData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                tasks[i] = new TaskData();
                if(list[i] != null) {
                    tasks[i].id          = list[i].getID();
                    tasks[i].id_project  = list[i].getID_Project();
                    tasks[i].project     = list[i].getProject();
                    tasks[i].users       = list[i].getUsers();
                    tasks[i].title       = list[i].getTitle();
                    tasks[i].description = list[i].getDescription();
                    tasks[i].start_date  = list[i].getStart_Date();
                    tasks[i].end_date    = list[i].getEnd_Date();
                    tasks[i].progress    = list[i].getProgress();
                    tasks[i].priority    = list[i].getPriority();
                    tasks[i].notes       = list[i].getNotes();
                    tasks[i].state       = list[i].getState();
                } else {
                    tasks[i].id          = 0;
                    tasks[i].id_project  = 0;
                    tasks[i].project     = "";
                    String[] cad = new String[1];
                    cad[0] = "";
                    tasks[i].users       = cad;
                    tasks[i].title       = "";
                    tasks[i].description = "";
                    tasks[i].start_date  = "";
                    tasks[i].end_date    = "";
                    tasks[i].progress    = 0;
                    tasks[i].priority    = "";
                    tasks[i].notes       = "";
                    tasks[i].state       = "";
                }
            }
            
            return tasks;
        } else {
            tasks = new TaskData[1];
            tasks[0] = new TaskData();
            tasks[0].id          = 0;
            tasks[0].id_project  = 0;
            tasks[0].project     = "";
            String[] cad = new String[1];
            cad[0] = "";
            tasks[0].users       = cad;
            tasks[0].title       = "";
            tasks[0].description = "";
            tasks[0].start_date  = "";
            tasks[0].end_date    = "";
            tasks[0].progress    = 0;
            tasks[0].priority    = "";
            tasks[0].notes       = "";
            tasks[0].state       = "";
            
            return tasks;
        }
    }

    @Override
    public int updateProgress(int id, int progress, String notes, String state) {
        AbstractTask task = new AbstractTask();
        
        task.setID(id);
        task.setProgress(progress);
        task.setNotes(notes);
        task.setState(state);
        
        task.updateProgress();
        
        return task.getID();
    }
    
}