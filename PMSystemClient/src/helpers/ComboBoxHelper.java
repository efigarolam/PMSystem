/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class ComboBoxHelper {
    
    private String title;
    private int ID;
    
    public ComboBoxHelper(int ID, String title) {
        this.ID = ID;
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public int getID() {
        return this.ID;
    }
    
    @Override
    public String toString() {
        return this.title;
    }
    
}