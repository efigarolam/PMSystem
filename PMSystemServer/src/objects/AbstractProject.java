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
public class AbstractProject {
    
    private ActiveRecord db = null;
    private String table;
    private int ID;
    private int ID_User;
    private String leader      = "";
    private String name        = "";
    private String description = "";
    private String start_date  = "";
    private String end_date    = "";
    private String state       = "";
    
    public AbstractProject() {
        this.db = new ActiveRecord("jdbc:mysql://localhost/pmsdb","root","", "pms");
        this.table = "projects";
    }
    
    public void save() {
        try {
            String params = "'"+this.getID_User()+"', '"+this.getName()+"', '"+this.getDescription()+"', '"+this.getStart_Date()+"', '"+this.getEnd_Date()+"', '"+this.getState()+"'";
            ArrayList query = this.db.call("setProject", params);
            HashMap result;
            
            if(query != null) {
                result = (HashMap) query.get(0);
                
                if(result.get("Project_Exists") != null) {
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
	
    public void edit() {
        try {
            String params = "'"+this.getID()+"','"+this.getID_User()+"', '"+this.getName()+"', '"+this.getDescription()+"', '"+this.getStart_Date()+"', '"+this.getEnd_Date()+"', '"+this.getState()+"'";
            ArrayList query = this.db.call("updateProject", params);
            HashMap result;
            
            if(query != null) {
                result = (HashMap) query.get(0);
                
                if(result.get("Project_Exists") != null) {
                    this.setID(-1);
                } else if(result.get("Project_Not_Exists") != null) {
                    this.setID(-2);
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
    
    public boolean trash() {
        try {
            this.db.setTable(this.table, "*");
            String values = "State = 'Inactive'";
            
            this.db.setValues(values);
            if(this.db.save(this.getID()) > 0) {
                this.db.setTable("userstasks", "ID_Task");
                ArrayList tasksToTrash = this.db.findBySQL("ID_Project = '"+this.getID()+"'");
                HashMap task;
                
                if(tasksToTrash != null) {
                    int id_task = 0;
                    this.db.setTable("tasks", "*");
                    for(int i = 0; i < tasksToTrash.size(); i++) {
                        task = (HashMap) tasksToTrash.get(i);
                        
                        if(task.get("ID_Task") != null) {
                            id_task = Integer.parseInt(task.get("ID_Task").toString());
                            this.db.setValues("State = 'Inactive'");
                            this.db.save(id_task);
                        }
                    }                   
                }
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean trashByUser() {
        try {
            this.db.setTable(this.table, "*");
            ArrayList projectsData = this.db.findBySQL("ID_User = '"+this.getID_User()+"'");
            HashMap projectsDataMap;
            
            if(projectsData != null) {
                for(int j = 0; j < projectsData.size(); j++) {
                    projectsDataMap = (HashMap) projectsData.get(j);
                    
                    if(projectsDataMap.get("ID") != null) {
                        this.db.setTable(this.table, "*");
                        this.db.setValues("State = 'Inactive'");
                        if(this.db.save(Integer.parseInt(projectsDataMap.get("ID").toString())) > 0) {
                            this.db.setTable("userstasks", "ID_Task");
                            ArrayList tasksToTrash = this.db.findBySQL("ID_Project = '"+Integer.parseInt(projectsDataMap.get("ID").toString())+"'");
                            HashMap task;

                            if(tasksToTrash != null) {
                                int id_task = 0;
                                this.db.setTable("tasks", "*");
                                for(int i = 0; i < tasksToTrash.size(); i++) {
                                    task = (HashMap) tasksToTrash.get(i);

                                    if(task.get("ID_Task") != null) {
                                        id_task = Integer.parseInt(task.get("ID_Task").toString());
                                        this.db.setValues("State = 'Inactive'");
                                        this.db.save(id_task);
                                    }
                                }                   
                            }
                        } 
                    }                      
                }
            } else {
                return false;
            }
            
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean restore() {
        try {
            this.db.setTable(this.table, "*");
            String values = "State = 'Active'";
            
            this.db.setValues(values);
            if(this.db.save(this.getID()) > 0) {
                this.db.setTable("userstasks", "ID_Task");
                ArrayList tasksToTrash = this.db.findBySQL("ID_Project = '"+this.getID()+"'");
                HashMap task;
                
                if(tasksToTrash != null) {
                    int id_task = 0;
                    this.db.setTable("tasks", "*");
                    for(int i = 0; i < tasksToTrash.size(); i++) {
                        task = (HashMap) tasksToTrash.get(i);
                        
                        if(task.get("ID_Task") != null) {
                            id_task = Integer.parseInt(task.get("ID_Task").toString());
                            this.db.setValues("State = 'Started'");
                            this.db.save(id_task);
                        }
                    }                   
                }
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean restoreByUser() {
        try {
            this.db.setTable(this.table, "*");
            ArrayList projectsData = this.db.findBySQL("ID_User = '"+this.getID_User()+"'");
            HashMap projectsDataMap;
            
            if(projectsData != null) {
                for(int j = 0; j < projectsData.size(); j++) {
                    projectsDataMap = (HashMap) projectsData.get(j);
                    
                    if(projectsDataMap.get("ID") != null) {
                        this.db.setTable(this.table, "*");
                        this.db.setValues("State = 'Active'");
                        
                        if(this.db.save(Integer.parseInt(projectsDataMap.get("ID").toString())) > 0) {
                            this.db.setTable("userstasks", "ID_Task");
                            ArrayList tasksToTrash = this.db.findBySQL("ID_Project = '"+Integer.parseInt(projectsDataMap.get("ID").toString())+"'");
                            HashMap task;

                            if(tasksToTrash != null) {
                                int id_task = 0;
                                this.db.setTable("tasks", "*");
                                for(int i = 0; i < tasksToTrash.size(); i++) {
                                    task = (HashMap) tasksToTrash.get(i);

                                    if(task.get("ID_Task") != null) {
                                        id_task = Integer.parseInt(task.get("ID_Task").toString());
                                        this.db.setValues("State = 'Started'");
                                        this.db.save(id_task);
                                    }
                                }                   
                            }
                        } 
                    }                      
                }
            } else {
                return false;
            }
            
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
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
    
    public void getByID(int ID) {
        try {
            ArrayList dataProject;
            HashMap dataProjectMap;

            this.db.setTable(this.table,"*");
            dataProject = this.db.find(ID);
            
            ArrayList dataUser;
            HashMap dataUserMap;
            this.db.setTable("users", "Name");

            if(dataProject != null) {
                dataProjectMap = (HashMap) dataProject.get(0);

                if(dataProjectMap.get("ID") != null) {
                    this.setID(Integer.parseInt(dataProjectMap.get("ID").toString()));
                }

                if(dataProjectMap.get("ID_User") != null) {
                    this.setID_User(Integer.parseInt(dataProjectMap.get("ID_User").toString()));
                }
                
                dataUser    = this.db.find(this.getID_User());
                dataUserMap = (HashMap) dataUser.get(0);

                if(dataUserMap.get("Name") != null) {
                    this.setLeader(dataUserMap.get("Name").toString());
                }

                if(dataProjectMap.get("Name") != null) {
                    this.setName(dataProjectMap.get("Name").toString());
                }

                if(dataProjectMap.get("Description") != null) {
                    this.setDescription(dataProjectMap.get("Description").toString());
                }
                
                if(dataProjectMap.get("Start_Date") != null) {
                    this.setStart_Date(dataProjectMap.get("Start_Date").toString());
                }

                if(dataProjectMap.get("End_Date") != null) {
                    this.setEnd_Date(dataProjectMap.get("End_Date").toString());
                }
                
                if(dataProjectMap.get("State") != null) {
                    this.setState(dataProjectMap.get("State").toString());
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }		
    }
    
    public AbstractProject[] getAll() {
        try {
            ArrayList dataProjects;
            HashMap dataProjectsMap;

            this.db.setTable(this.table,"*");
            dataProjects = this.db.findBySQL("ID > 0 AND State != 'Inactive'");
            AbstractProject[] projects;

            if(dataProjects != null) {		
                projects = new AbstractProject[dataProjects.size()];		
                for(int i = 0; i < dataProjects.size(); i++) {
                    dataProjectsMap = (HashMap) dataProjects.get(i);
                    projects[i] = new AbstractProject();

                    if(dataProjectsMap.get("ID") != null) {
                        projects[i].setID(Integer.parseInt(dataProjectsMap.get("ID").toString()));
                    }

                    if(dataProjectsMap.get("ID_User") != null) {
                        projects[i].setID_User(Integer.parseInt(dataProjectsMap.get("ID_User").toString()));
                    }

                    if(dataProjectsMap.get("Name") != null) {
                        projects[i].setName(dataProjectsMap.get("Name").toString());
                    }

                    if(dataProjectsMap.get("Description") != null) {
                        projects[i].setDescription(dataProjectsMap.get("Description").toString());
                    }
                    
                        if(dataProjectsMap.get("Start_Date") != null) {
                        projects[i].setStart_Date(dataProjectsMap.get("Start_Date").toString());
                    }
                            
                    if(dataProjectsMap.get("End_Date") != null) {
                        projects[i].setEnd_Date(dataProjectsMap.get("End_Date").toString());
                    }
                    
                    if(dataProjectsMap.get("State") != null) {
                        projects[i].setState(dataProjectsMap.get("State").toString());
                    }	
                }			
            } else {
                projects = null;
            }

            return projects;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }		
    }
    
    public AbstractProject[] getBySQL(String sql) {
        try {
            ArrayList dataProjects;
            HashMap dataProjectsMap;

            this.db.setTable(this.table,"*");
            dataProjects = this.db.findBySQL(sql);
            AbstractProject[] projects;
            
            ArrayList dataUser;
            HashMap dataUserMap;
            this.db.setTable("users", "Name");
                                    
            if(dataProjects != null) {		
                projects = new AbstractProject[dataProjects.size()];		
                for(int i = 0; i < dataProjects.size(); i++) {
                    dataProjectsMap = (HashMap) dataProjects.get(i);
                    projects[i] = new AbstractProject();

                    if(dataProjectsMap.get("ID") != null) {
                        projects[i].setID(Integer.parseInt(dataProjectsMap.get("ID").toString()));
                    }
                    
                    if(dataProjectsMap.get("ID_User") != null) {
                        projects[i].setID_User(Integer.parseInt(dataProjectsMap.get("ID_User").toString()));
                    }
                    
                    dataUser    = this.db.find(projects[i].getID_User());
                    dataUserMap = (HashMap) dataUser.get(0);
                    
                    if(dataUserMap.get("Name") != null) {
                        projects[i].setLeader(dataUserMap.get("Name").toString());
                    }

                    if(dataProjectsMap.get("Name") != null) {
                        projects[i].setName(dataProjectsMap.get("Name").toString());
                    }

                    if(dataProjectsMap.get("Description") != null) {
                        projects[i].setDescription(dataProjectsMap.get("Description").toString());
                    }
                    
                        if(dataProjectsMap.get("Start_Date") != null) {
                        projects[i].setStart_Date(dataProjectsMap.get("Start_Date").toString());
                    }
                            
                    if(dataProjectsMap.get("End_Date") != null) {
                        projects[i].setEnd_Date(dataProjectsMap.get("End_Date").toString());
                    }
                    
                    if(dataProjectsMap.get("State") != null) {
                        projects[i].setState(dataProjectsMap.get("State").toString());
                    }	
                }			
            } else {
                projects = null;
            }

            return projects;
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
    
    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public int getID_User() {
        return this.ID_User;
    }
    
    public void setLeader(String userName) {
        this.leader = userName;
    }
    
    public String getLeader() {
        return this.leader;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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
    
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}