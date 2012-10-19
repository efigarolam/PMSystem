/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import PMSystem.*;
import helpers.StringsHelper;
import helpers.GanttData;
import controllers.ProjectsController;
import controllers.TasksController;
import helpers.TimeHelper;
import java.util.ArrayList;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class ReportsModel extends AbstractModel {
      
    private Report rReport;
    public ProjectsController projectsController;
    public TasksController tasksController;
    public StringsHelper stringsHelper = new StringsHelper();
    public TimeHelper timeHelper = new TimeHelper();
    
    public ReportsModel(String args[], String objName) {
        try {
            this.objName = objName;
           
            this.initCORBA(args);
            this.projectsController = new ProjectsController(args);
            this.tasksController    = new TasksController(args);
            
            rReport = ReportHelper.narrow(ReportsModel.ncRef.resolve_str(this.objName));
        } catch (Exception ex) {
            // Handle ex
        } 
    }
    
    public GeneralReportData getGeneralReport() {
        return rReport.getGeneralReportData();
    }
    
    public void addMissingTranslation(String translation) {
        rReport.addMissingTranslation(stringsHelper.clean(translation));
    }
    
    public GanttData getGanttData(int ID_Project) {
        ProjectData project = this.projectsController.getProject(ID_Project);
        TaskData[] tasks    = this.tasksController.getTasks("ID_Project = '"+ID_Project+"' ORDER BY Start_Date ASC");
        
        GanttData ganttData = new GanttData(project, tasks);
        return ganttData;
    }
    
    public ArrayList getLoginsData(int days) {
        String firstDay       = this.timeHelper.getPastTime(-1);
        String secondDay      = this.timeHelper.getPastTime(-2);
        String thirdDay       = this.timeHelper.getPastTime(-3);
        String fourthDay      = this.timeHelper.getPastTime(-4);
        String sProyectionDay = this.timeHelper.getPastTime(0);
        
        int firstDayCount = rReport.getLogins(firstDay, secondDay);
        int secondDayCount = rReport.getLogins(secondDay, thirdDay);
        int thirdDayCount = rReport.getLogins(thirdDay, fourthDay);
        
        double b = (double) ((firstDayCount - secondDayCount) + (secondDayCount - thirdDayCount)) / 2;
        
        double firstProyection = (double) firstDayCount + (b * days);
        
        b = (double) ((firstProyection - firstDayCount) + (firstDayCount - secondDayCount) + (secondDayCount - thirdDayCount)) / 3;
        double secondProyection = (double) firstProyection + (b * days);
        
        ArrayList results = new ArrayList();
        
        sProyectionDay = sProyectionDay.substring(0, 10);
        String[] secondProyectedDayData = {sProyectionDay, String.valueOf(secondProyection)};
        results.add(secondProyectedDayData);
        firstDay = firstDay.substring(0, 10);
        String[] firstProyectedDayData = {firstDay, String.valueOf(firstProyection)};
        results.add(firstProyectedDayData);
        secondDay = secondDay.substring(0, 10);
        String[] firstDayData = {secondDay, Integer.toString(firstDayCount)};
        results.add(firstDayData);
        thirdDay = thirdDay.substring(0, 10);
        String[] secondDayData = {thirdDay, Integer.toString(secondDayCount)};
        results.add(secondDayData);
        fourthDay = fourthDay.substring(0, 10);
        String[] thirdDayData = {fourthDay, Integer.toString(thirdDayCount)};
        results.add(thirdDayData);
        
        
        return results;
    }
    
    public Configuration getConfiguration() {
        return rReport.getConfig();
    }
    
    public String[] setConfiguration(String language, String theme) {
        if(rReport.setConfig(language, theme)) {
            String[] message = {"The configuration has been saved correctly, if you changed the theme, you need to restart Project.Me System to see the changes", "information"};
            return message;
        } else {
            String[] message = {"Something was wrong", "error"};
            return message;
        }
    }
    
}