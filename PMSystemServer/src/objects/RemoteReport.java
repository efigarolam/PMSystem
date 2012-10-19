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
public class RemoteReport extends ReportPOA {
    private ORB orb;
	
    public void setORB(ORB orb_val) {
        this.orb = orb_val;
    }

    @Override
    public GeneralReportData getGeneralReportData() {
        AbstractReport report = new AbstractReport();
        
        return report.getGeneralReportData();
    }

    @Override
    public void addMissingTranslation(String translation) {
        AbstractReport report = new AbstractReport();
        
        report.addMissingTranslation(translation);
    }

    @Override
    public int getLogins(String date, String datelimit) {
        AbstractReport report = new AbstractReport();
        
        return report.getLogins(date, datelimit);
    }

    @Override
    public Configuration getConfig() {
        AbstractReport config = new AbstractReport();
        
        return config.getConfig();
    }

    @Override
    public boolean setConfig(String language, String theme) {
        AbstractReport config = new AbstractReport();
        
        return config.setConfig(language, theme);      
    }
    
}