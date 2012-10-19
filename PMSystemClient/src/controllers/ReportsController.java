/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import PMSystem.Configuration;
import PMSystem.GeneralReportData;
import helpers.GanttData;
import java.util.ArrayList;
import models.ReportsModel;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class ReportsController extends AbstractController {
    
    private ReportsModel model;
    
    public ReportsController(String args[]) {
        this.model = new ReportsModel(args, "Report");
    }
    
    public GeneralReportData getGeneralReport() {
        return this.model.getGeneralReport();
    }
    
    public void addMissingTranslation(String translation) {
        this.model.addMissingTranslation(translation);
    }
    
    public GanttData getGanttData(int ID_Project) {
        return this.model.getGanttData(ID_Project);
    }
    
    public ArrayList getLogins(int days) {
        return this.model.getLoginsData(days);
    }
    
    public Configuration getConfiguration() {
        return this.model.getConfiguration();
    }
    
    public String[] setConfiguration(String language, String theme) {
        return this.model.setConfiguration(language, theme);
    }
    
}