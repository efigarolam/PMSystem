/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import helpers.LanguagesHelper;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * 
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public abstract class AbstractJFrameView extends JFrame implements Translations {
    public LanguagesHelper languagesHelper = new LanguagesHelper();
    
    public void center() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((d.getWidth() - getWidth()) / 2);
        int y = (int) ((d.getHeight() - getHeight()) / 2);
        setLocation(x,y);
    }  
    
    public void setTheme(int id) {
        
    }
    
    @Override
    public String __(String str) {
        return languagesHelper.getTranslation(str);
    }
}