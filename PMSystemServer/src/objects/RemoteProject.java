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
public class RemoteProject extends ProjectPOA {
    private ORB orb;
	
    public void setORB(ORB orb_val) {
        this.orb = orb_val;
    }
    
    @Override
    public int setProject(int id_user, String name, String description, String start_date, String end_date, String state) {
        AbstractProject project = new AbstractProject();
        
        project.setID_User(id_user);
        project.setName(name);
        project.setDescription(description);
        project.setStart_Date(start_date);
        project.setEnd_Date(end_date);
        project.setState(state);
        
        project.save();
        
        return project.getID();        
    }

    @Override
    public int updateProject(int id, int id_user, String name, String description, String start_date, String end_date, String state) {
        AbstractProject project = new AbstractProject();
        
        project.setID(id);
        project.setID_User(id_user);
        project.setName(name);
        project.setDescription(description);
        project.setStart_Date(start_date);
        project.setEnd_Date(end_date);
        project.setState(state);
        
        project.edit();
        
        return project.getID(); 
    }

    @Override
    public ProjectsBasicData[] getAllProjects() {
        ProjectsBasicData[] projects;
        
        AbstractProject project = new AbstractProject();
        AbstractProject list[];
        
        list = project.getAll();
        if(list != null) {
            projects = new ProjectsBasicData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                projects[i] = new ProjectsBasicData();
                projects[i].id = list[i].getID();
                projects[i].name = list[i].getName();           
            }

            return projects;
        } else {
            projects = new ProjectsBasicData[1];
            projects[0] = new ProjectsBasicData();
            projects[0].id = 0;
            projects[0].name = "";
            
            return projects;
        }
    }

    @Override
    public ProjectData getProject(int id) {
        AbstractProject result = new AbstractProject();
        result.getByID(id);
        
        ProjectData project = new ProjectData();
        
        project.id = result.getID();
        project.id_user = result.getID_User();
        project.user_name = result.getLeader();
        project.name = result.getName();
        project.description = result.getDescription();
        project.start_date = result.getStart_Date();
        project.end_date = result.getEnd_Date();
        project.state = result.getState();
        
        return project;
    }

    @Override
    public ProjectData[] getProjects(String str) {
        ProjectData[] projects;
        
        AbstractProject project = new AbstractProject();
        AbstractProject list[];
        
        list = project.getBySQL(str);
        
        if(list != null) {
            projects = new ProjectData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                projects[i] = new ProjectData();
                projects[i].id          = list[i].getID();
                projects[i].id_user     = list[i].getID_User();
                projects[i].user_name   = list[i].getLeader();
                projects[i].name        = list[i].getName();
                projects[i].description = list[i].getDescription();
                projects[i].start_date  = list[i].getStart_Date();
                projects[i].end_date    = list[i].getEnd_Date();
                projects[i].state       = list[i].getState();
            }
            
            return projects;
        } else {
            projects = new ProjectData[1];
            projects[0] = new ProjectData();
            projects[0].id          = 0;
            projects[0].id_user     = 0;
            projects[0].user_name   = "";
            projects[0].name        = "";
            projects[0].description = "";
            projects[0].start_date  = "";
            projects[0].end_date    = "";
            projects[0].state       = "";
            
            return projects;
        }
    }

    @Override
    public boolean trash(int id) {
        AbstractProject project = new AbstractProject();
        project.setID(id);
        
        return project.trash();
    }

    @Override
    public boolean delete(int id) {
        AbstractProject project = new AbstractProject();
        project.setID(id);
        
        return project.delete();
    }

    @Override
    public boolean restore(int id) {
        AbstractProject project = new AbstractProject();
        project.setID(id);
        
        return project.restore();
    }
    
}