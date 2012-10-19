/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import helpers.AlertsHelper;
import helpers.LanguagesHelper;
import javax.swing.JInternalFrame;

/**
 *
 * 
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public abstract class AbstractIFrameView extends JInternalFrame implements Translations {    
    public AlertsHelper alertsHelper = new AlertsHelper();
    public LanguagesHelper languagesHelper = new LanguagesHelper();
    
    @Override
    public String __(String str) {
        return languagesHelper.getTranslation(str);
    }
}