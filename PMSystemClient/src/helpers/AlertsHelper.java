/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */ 
public class AlertsHelper extends JOptionPane {
    
    public void showAlert(String message, String type) {
        if("information".equals(type)) {
            JOptionPane.showMessageDialog(null, message, "Success!", JOptionPane.INFORMATION_MESSAGE);
        } else if("error".equals(type)) {
            JOptionPane.showMessageDialog(null, message, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean showConfirm(String message, String type) {
        int selectedOption = 1;
        if("question".equals(type)) {
            selectedOption = JOptionPane.showConfirmDialog(null, message, "Confirm!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } else if("warning".equals(type)) {
            selectedOption = JOptionPane.showConfirmDialog(null, message, "Confirm!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        } 
        
        if(selectedOption == 0) {
            return true;
        } else if(selectedOption == 1) {
            return false;
        } else {
            return false;
        }
    }
    
}