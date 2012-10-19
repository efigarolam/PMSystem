/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.MainController;
import views.SplashView;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class Main {
    
    public static void main(String args[]) {
        SplashView splash = new SplashView(800);
        MainController mainController = new MainController(args, true);
    }
}