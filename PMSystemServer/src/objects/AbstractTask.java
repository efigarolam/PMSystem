/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

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
public class AbstractTask {
    private ActiveRecord db = null;
    private String table;
    private int ID;
    private int[] ID_Users;
    private String[] users;
    private int ID_Project;
    private String title       = "";
    private String description = "";
    private String start_date  = "";
    private String end_date    = "";
    private int progress       = 0;
    private String priority    = "";
    private String state       = "";
    private String notes       = "";
    private String project     = "";
    
    public AbstractTask() {
        this.db = new ActiveRecord("jdbc:mysql://localhost/pmsdb","root","", "pms");
        this.table = "tasks";
    }
    
    public void save() {
        try {
            this.getAndSetIDUsers(this.users);
            
            String params = "'"+this.getID_Project()+"', '"+this.getTitle()+"', '"+this.getDescription()+"', '"+this.getStart_Date()+"', '"+this.getEnd_Date()+"', '"+this.getProgress()+"', '"+this.getPriority()+"', '"+this.getState()+"'";
            ArrayList query = this.db.call("setTask", params);
            HashMap result;
            
            if(query != null) {
                result = (HashMap) query.get(0);
                
                if(result.get("Task_Exists") != null) {
                    this.setID(-1);
                } else if(result.get("ID") != null) {
                   this.setID(Integer.parseInt(result.get("ID").toString()));
                   
                   for(int i = 0; i < this.ID_Users.length; i++) {
                       params = "'"+this.ID_Users[i]+"', '"+this.getID()+"', '"+this.getID_Project()+"'";
                       this.db.call("setUserTask", params);
                   }
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
            this.getAndSetIDUsers(this.users); 
            
            String params = "'"+this.getID()+"', '"+this.getID_Project()+"', '"+this.getTitle()+"', '"+this.getDescription()+"', '"+this.getStart_Date()+"', '"+this.getEnd_Date()+"', '"+this.getProgress()+"', '"+this.getPriority()+"', '"+this.getState()+"'";
            ArrayList query = this.db.call("updateTask", params);
            HashMap result;
            
            if(query != null) {
                result = (HashMap) query.get(0);
                
                if(result.get("Task_Exists") != null) {
                    this.setID(-1);
                } else if(result.get("Task_Not_Exists") != null) {
                    this.setID(-2);
                } else if(result.get("ID") != null) {
                    this.setID(Integer.parseInt(result.get("ID").toString()));
                    
                    this.db.setTable("userstasks", "*");
                    this.db.deleteBy("ID_Task", "'"+this.getID()+"'");
                    
                    for(int i = 0; i < this.ID_Users.length; i++) {
                       params = "'"+this.ID_Users[i]+"', '"+this.getID()+"', '"+this.getID_Project()+"'";
                       this.db.call("setUserTask", params);
                    }
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
            String values = "State = 'Started'";
            
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
    
    public void updateProgress() {
        try {
            String params = "'"+this.getID()+"', '"+this.getProgress()+"', '"+this.getNotes()+"', '"+this.getState()+"'";
            ArrayList query = this.db.call("updateProgressTask", params);
            HashMap result;
            
            if(query != null) {
                result = (HashMap) query.get(0);
                
                if(result.get("Task_Not_Exists") != null) {
                    this.setID(-1);
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
    
    public void getAndSetIDUsers(String[] users) {
        this.db.setTable("users", "ID");
        int[] IDs = new int[users.length];
        for(int i = 0; i < users.length; i++) {
            IDs[i] = this.db.getIDBy("Username", users[i]);            
        }
        this.setID_Users(IDs);
    }
    
    public void getByID(int ID) {
        try {
            ArrayList dataTask;
            HashMap dataTaskMap;

            this.db.setTable(this.table,"*");
            dataTask = this.db.find(ID);

            if(dataTask != null) {
                dataTaskMap = (HashMap) dataTask.get(0);

                if(dataTaskMap.get("ID") != null) {
                    this.setID(Integer.parseInt(dataTaskMap.get("ID").toString()));
                }

                if(dataTaskMap.get("ID_Project") != null) {
                    this.setID_Project(Integer.parseInt(dataTaskMap.get("ID_Project").toString()));
                }
                
                ArrayList taskUsers;
                HashMap userRow;
                this.db.setTable("userstasks","*");
                taskUsers = this.db.findBySQL("ID_Task = '"+this.getID()+"'");

                if(taskUsers != null) {
                    String[] users = new String[taskUsers.size()];
                    ArrayList user;
                    HashMap username;
                    this.db.setTable("users", "Username");
                    for(int j = 0; j < taskUsers.size(); j++) {
                        userRow = (HashMap) taskUsers.get(j);
                        if(userRow.get("ID_User") != null) {
                            user = this.db.find(Integer.parseInt(userRow.get("ID_User").toString()));
                            username = (HashMap) user.get(0);
                            if(username.get("Username") != null) {
                                users[j] = username.get("Username").toString();
                            }
                        }
                    }
                    this.setUsers(users);                    
                } else {
                    this.setUsers(null);
                }               

                if(dataTaskMap.get("Title") != null) {
                    this.setTitle(dataTaskMap.get("Title").toString());
                }

                if(dataTaskMap.get("Description") != null) {
                    this.setDescription(dataTaskMap.get("Description").toString());
                }
                
                if(dataTaskMap.get("Start_Date") != null) {
                    this.setStart_Date(dataTaskMap.get("Start_Date").toString());
                }

                if(dataTaskMap.get("End_Date") != null) {
                    this.setEnd_Date(dataTaskMap.get("End_Date").toString());
                }
                
                if(dataTaskMap.get("Progress") != null) {
                    this.setProgress(Integer.parseInt(dataTaskMap.get("Progress").toString()));
                }
                
                if(dataTaskMap.get("Priority") != null) {
                    this.setPriority(dataTaskMap.get("Priority").toString());
                }   
                
                if(dataTaskMap.get("Notes") != null) {
                    this.setNotes(dataTaskMap.get("Notes").toString());
                } 
                
                if(dataTaskMap.get("State") != null) {
                    this.setState(dataTaskMap.get("State").toString());
                }				
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }		
    }
    
    public AbstractTask[] getAll() {
        try {
            ArrayList dataTasks;
            HashMap dataTasksMap;

            this.db.setTable(this.table,"*");
            dataTasks = this.db.findBySQL("ID > 0 AND State != 'Inactive'");
            AbstractTask[] tasks;

            if(dataTasks != null) {		
                tasks = new AbstractTask[dataTasks.size()];		
                for(int i = 0; i < dataTasks.size(); i++) {
                    dataTasksMap = (HashMap) dataTasks.get(i);
                    tasks[i] = new AbstractTask();

                    if(dataTasksMap.get("ID") != null) {
                        tasks[i].setID(Integer.parseInt(dataTasksMap.get("ID").toString()));
                    }

                    if(dataTasksMap.get("ID_Project") != null) {
                        tasks[i].setID_Project(Integer.parseInt(dataTasksMap.get("ID_Project").toString()));
                    }
                    
                    ArrayList taskUsers;
                    HashMap userRow;
                    this.db.setTable("userstasks","*");
                    taskUsers = this.db.findBySQL("ID_Task = '"+tasks[i].getID()+"'");
                    
                    if(taskUsers != null) {
                        String[] users = new String[taskUsers.size()];
                        ArrayList user;
                        HashMap username;
                        this.db.setTable("users", "Username");
                        for(int j = 0; j < taskUsers.size(); j++) {
                            userRow = (HashMap) taskUsers.get(j);
                            if(userRow.get("ID_User") != null) {
                                user = this.db.find(Integer.parseInt(userRow.get("ID_User").toString()));
                                username = (HashMap) user.get(0);
                                if(username.get("Username") != null) {
                                    users[j] = username.get("Username").toString();
                                }
                            }
                        }
                        tasks[i].setUsers(users);                    
                    } else {
                        tasks[i].setUsers(null);
                    }      

                    if(dataTasksMap.get("Title") != null) {
                        tasks[i].setTitle(dataTasksMap.get("Title").toString());
                    }

                    if(dataTasksMap.get("Description") != null) {
                        tasks[i].setDescription(dataTasksMap.get("Description").toString());
                    }
                    
                    if(dataTasksMap.get("Start_Date") != null) {
                        tasks[i].setStart_Date(dataTasksMap.get("Start_Date").toString());
                    }
                            
                    if(dataTasksMap.get("End_Date") != null) {
                        tasks[i].setEnd_Date(dataTasksMap.get("End_Date").toString());
                    }
                    
                    if(dataTasksMap.get("Progress") != null) {
                        tasks[i].setProgress(Integer.parseInt(dataTasksMap.get("Progress").toString()));
                    }
                            
                    if(dataTasksMap.get("Priority") != null) {
                        tasks[i].setPriority(dataTasksMap.get("Priority").toString());
                    }
                    
                    if(dataTasksMap.get("Notes") != null) {
                        tasks[i].setNotes(dataTasksMap.get("Notes").toString());
                    }
                    
                    if(dataTasksMap.get("State") != null) {
                        tasks[i].setState(dataTasksMap.get("State").toString());
                    }	
                }			
            } else {
                tasks = null;
            }

            return tasks;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }		
    }
    
    public AbstractTask[] getBySQL(String sql) {
        try {
            ArrayList dataTasks;
            HashMap dataTasksMap;

            this.db.setTable(this.table,"*");
            dataTasks = this.db.findBySQL(sql);
            AbstractTask[] tasks;
            
            ArrayList dataProject;
            HashMap dataProjectMap;

            if(dataTasks != null) {		
                tasks = new AbstractTask[dataTasks.size()];		
                for(int i = 0; i < dataTasks.size(); i++) {
                    dataTasksMap = (HashMap) dataTasks.get(i);
                    tasks[i] = new AbstractTask();

                    if(dataTasksMap.get("ID") != null) {
                        tasks[i].setID(Integer.parseInt(dataTasksMap.get("ID").toString()));
                    }

                    if(dataTasksMap.get("ID_Project") != null) {
                        tasks[i].setID_Project(Integer.parseInt(dataTasksMap.get("ID_Project").toString()));
                    }
                    
                    this.db.setTable("projects", "Name");
                    dataProject    = this.db.find(tasks[i].getID_Project());
                    dataProjectMap = (HashMap) dataProject.get(0);
                    
                    if(dataProjectMap.get("Name") != null) {
                        tasks[i].setProject(dataProjectMap.get("Name").toString());
                    }
                    
                    ArrayList taskUsers;
                    HashMap userRow;
                    this.db.setTable("userstasks","*");
                    taskUsers = this.db.findBySQL("ID_Task = '"+tasks[i].getID()+"'");
                    
                    if(taskUsers != null) {
                        String[] users = new String[taskUsers.size()];
                        ArrayList user;
                        HashMap username;
                        this.db.setTable("users", "Username");
                        for(int j = 0; j < taskUsers.size(); j++) {
                            userRow = (HashMap) taskUsers.get(j);
                            if(userRow.get("ID_User") != null) {
                                user = this.db.find(Integer.parseInt(userRow.get("ID_User").toString()));
                                username = (HashMap) user.get(0);
                                if(username.get("Username") != null) {
                                    users[j] = username.get("Username").toString();
                                }
                            }
                        }
                        tasks[i].setUsers(users);                    
                    } else {
                        tasks[i].setUsers(null);
                    }      

                    if(dataTasksMap.get("Title") != null) {
                        tasks[i].setTitle(dataTasksMap.get("Title").toString());
                    }

                    if(dataTasksMap.get("Description") != null) {
                        tasks[i].setDescription(dataTasksMap.get("Description").toString());
                    }
                    
                    if(dataTasksMap.get("Start_Date") != null) {
                        tasks[i].setStart_Date(dataTasksMap.get("Start_Date").toString());
                    }
                            
                    if(dataTasksMap.get("End_Date") != null) {
                        tasks[i].setEnd_Date(dataTasksMap.get("End_Date").toString());
                    }
                    
                    if(dataTasksMap.get("Progress") != null) {
                        tasks[i].setProgress(Integer.parseInt(dataTasksMap.get("Progress").toString()));
                    }
                            
                    if(dataTasksMap.get("Priority") != null) {
                        tasks[i].setPriority(dataTasksMap.get("Priority").toString());
                    }
                    
                    if(dataTasksMap.get("Notes") != null) {
                        tasks[i].setNotes(dataTasksMap.get("Notes").toString());
                    }
                    
                    if(dataTasksMap.get("State") != null) {
                        tasks[i].setState(dataTasksMap.get("State").toString());
                    }	
                }			
            } else {
                tasks = null;
            }

            return tasks;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }		
    }
    
    public AbstractTask[] getByID_User(int id_user) {
        try {
            ArrayList dataRelated;
            HashMap dataRelatedMap;
            
            this.db.setTable("userstasks", "*");
            dataRelated = this.db.findBySQL("ID_User = '"+id_user+"'");
            
            if(dataRelated != null) {
                
                ArrayList dataTasks;
                HashMap dataTasksMap;
                AbstractTask[] tasks;
                
                ArrayList dataProject;
                HashMap dataProjectMap;
                
                ArrayList taskUsers;
                HashMap userRow;
                
                tasks = new AbstractTask[dataRelated.size()];
                
                for(int l = 0; l < dataRelated.size(); l++) {
                    dataRelatedMap = (HashMap) dataRelated.get(l);
                    int id_task;
                    
                    if(dataRelatedMap.get("ID_Task") != null) {
                        id_task = Integer.parseInt(dataRelatedMap.get("ID_Task").toString());
                    } else {
                        id_task = 0;
                    }
                    
                    this.db.setTable(this.table,"*");
                    dataTasks = this.db.findBySQL("ID = '"+id_task+"' AND State != 'Inactive'");
                    
                    if(dataTasks != null) {                    	
                        dataTasksMap = (HashMap) dataTasks.get(0);
                        tasks[l] = new AbstractTask();

                        if(dataTasksMap.get("ID") != null) {
                            tasks[l].setID(Integer.parseInt(dataTasksMap.get("ID").toString()));
                        }

                        if(dataTasksMap.get("ID_Project") != null) {
                            tasks[l].setID_Project(Integer.parseInt(dataTasksMap.get("ID_Project").toString()));
                        }

                        this.db.setTable("projects", "Name");
                        dataProject    = this.db.find(tasks[l].getID_Project());
                        dataProjectMap = (HashMap) dataProject.get(0);

                        if(dataProjectMap.get("Name") != null) {
                            tasks[l].setProject(dataProjectMap.get("Name").toString());
                        }
                       
                        this.db.setTable("userstasks","*");
                        taskUsers = this.db.findBySQL("ID_Task = '"+tasks[l].getID()+"'");

                        if(taskUsers != null) {
                            String[] users = new String[taskUsers.size()];
                            ArrayList user;
                            HashMap username;
                            this.db.setTable("users", "Username");
                            for(int j = 0; j < taskUsers.size(); j++) {
                                userRow = (HashMap) taskUsers.get(j);
                                if(userRow.get("ID_User") != null) {
                                    user = this.db.find(Integer.parseInt(userRow.get("ID_User").toString()));
                                    username = (HashMap) user.get(0);
                                    if(username.get("Username") != null) {
                                        users[j] = username.get("Username").toString();
                                    }
                                }
                            }
                            tasks[l].setUsers(users);                    
                        } else {
                            tasks[l].setUsers(null);
                        }      

                        if(dataTasksMap.get("Title") != null) {
                            tasks[l].setTitle(dataTasksMap.get("Title").toString());
                        }

                        if(dataTasksMap.get("Description") != null) {
                            tasks[l].setDescription(dataTasksMap.get("Description").toString());
                        }

                        if(dataTasksMap.get("Start_Date") != null) {
                            tasks[l].setStart_Date(dataTasksMap.get("Start_Date").toString());
                        }

                        if(dataTasksMap.get("End_Date") != null) {
                            tasks[l].setEnd_Date(dataTasksMap.get("End_Date").toString());
                        }

                        if(dataTasksMap.get("Progress") != null) {
                            tasks[l].setProgress(Integer.parseInt(dataTasksMap.get("Progress").toString()));
                        }

                        if(dataTasksMap.get("Priority") != null) {
                            tasks[l].setPriority(dataTasksMap.get("Priority").toString());
                        }
                        
                        if(dataTasksMap.get("Notes") != null) {
                            tasks[l].setNotes(dataTasksMap.get("Notes").toString());
                        }

                        if(dataTasksMap.get("State") != null) {
                            tasks[l].setState(dataTasksMap.get("State").toString());
                        }	
                    } else {
                        tasks[l] = null;
                    }
                    
                }
                return tasks;
            } else {
                return null;
            }          
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
    
    public void setID_Project(int ID_Project) {
        this.ID_Project = ID_Project;
    }

    public int getID_Project() {
        return this.ID_Project;
    }
    
    public void setProject(String project) {
        this.project = project;
    }
    
    public String getProject() {
        return this.project;
    }
    
    public void setID_Users(int[] ID_Users) {
        this.ID_Users = ID_Users;
    }
    
    public int[] getID_Users() {
        return this.ID_Users;
    }
    
    public void setUsers(String[] users) {
        this.users = users;       
    }
    
    public String[] getUsers() {
        return this.users;
    }   
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setStart_Date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_Date() {
        return this.start_date;
    }
    
    public void setEnd_Date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_Date() {
        return this.end_date;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return this.priority;
    }
    
    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return this.progress;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}