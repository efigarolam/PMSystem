/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public abstract class AbstractModel {
    
    public static ORB orb;
    public static org.omg.CORBA.Object objRef;
    public static NamingContextExt ncRef;
    public String objName;
    
    public void initCORBA(String args[]) {
        try {
            AbstractModel.orb = ORB.init(args, null);
            AbstractModel.objRef = AbstractModel.orb.resolve_initial_references("NameService");
            AbstractModel.ncRef = NamingContextExtHelper.narrow(AbstractModel.objRef);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}