/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class SplashView extends JWindow {
    
    public SplashView(int time) {
        ImageIcon img = new ImageIcon(getClass().getResource("/img/splash.png"));
        JScrollPane jsp = new JScrollPane(new JLabel(img));
        getContentPane().add(jsp);
        setSize(550,345);
        center();
        setVisible(true);
        
        if(time != 0) {
            try {
                Thread.sleep(time);
                dispose();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }        
    }
    
    public void center() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((d.getWidth() - getWidth()) / 2);
        int y = (int) ((d.getHeight() - getHeight()) / 2);
        setLocation(x,y);
    }
    
}
