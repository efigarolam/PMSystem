/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import PMSystem.ProjectData;
import PMSystem.ProjectsBasicData;
import models.ProjectsModel;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class ProjectsController extends AbstractController {
    
    private ProjectsModel model;
    
    public ProjectsController(String args[]) {
        this.model = new ProjectsModel(args, "Project");
    }
    
    public String[] saveProject(int ID_User, String name, String description, String start_date, String end_date, String state) {
        return this.model.saveProject(ID_User, name, description, start_date, end_date, state);
    }
    
    public String[] editProject(int ID_Project, int ID_User, String name, String description, String start_date, String end_date, String state) {
        return this.model.editProject(ID_Project, ID_User, name, description, start_date, end_date, state);
    }
    
    public ProjectsBasicData[] getAllProjects() {
        return this.model.getAllProjects();
    }
    
    public ProjectData getProject(int id) {
        return this.model.getProject(id);
    }
    
    public ProjectData[] getProjects(String str) {
        return this.model.getProjects(str);
    }
    
    public boolean trashProject(int id) {
        return this.model.trashProject(id);
    }
    
    public boolean deleteProject(int id) {
        return this.model.deleteProject(id);
    }
    
    public boolean restoreProject(int id) {
        return this.model.restoreProject(id);
    }
}