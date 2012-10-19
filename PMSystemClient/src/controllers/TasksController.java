/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import PMSystem.TaskData;
import PMSystem.TasksBasicData;
import models.TasksModel;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class TasksController extends AbstractController {
    
    private TasksModel model;
    
    public TasksController(String args[]) {
        this.model = new TasksModel(args, "Task");
    }
    
    public String[] saveTask(int ID_Project, String[] users, String title, String description, String start_date, String end_date, int progress, String priority, String state) {
        return this.model.saveTask(ID_Project, users, title, description, start_date, end_date, progress, priority, state);
    }
    
    public String[] editTask(int ID_Task, int ID_Project, String[] users, String title, String description, String start_date, String end_date, int progress, String priority, String state) {
        return this.model.editTask(ID_Task, ID_Project, users, title, description, start_date, end_date, progress, priority, state);
    }
    
    public String[] updateTaskProgress(int ID_Task, int progress, String notes, String state) {
        return this.model.updateTaskProgress(ID_Task, progress, notes, state);
    }
    
    public TasksBasicData[] getAllTasks() {
        return this.model.getAllTasks();
    }
    
    public TaskData getTask(int id) {
        return this.model.getTask(id);
    }
    
    public TaskData[] getTasks(String str) {
        return this.model.getTasks(str);
    }
    
    public TaskData[] getTasksByUser(int id_user) {
        return this.model.getTasksByUser(id_user);
    }
    
    public boolean trashTask(int id) {
        return this.model.trashTask(id);
    }
    
    public boolean deleteTask(int id) {
        return this.model.deleteTask(id);
    }
    
    public boolean restoreTask(int id) {
        return this.model.restoreTask(id);
    }
}
