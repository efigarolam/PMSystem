/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import PMSystem.*;
import objects.RemoteMessage;
import objects.RemoteUser;
import objects.RemoteProject;
import objects.RemoteReport;
import objects.RemoteTask;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;


/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            RemoteUser remoteUser = new RemoteUser();
            remoteUser.setORB(orb);
            
            RemoteProject remoteProject = new RemoteProject();
            remoteProject.setORB(orb);
            
            RemoteTask remoteTask = new RemoteTask();
            remoteTask.setORB(orb);
            
            RemoteReport remoteReport = new RemoteReport();
            remoteReport.setORB(orb);
            
            RemoteMessage remoteMessage = new RemoteMessage();
            remoteMessage.setORB(orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(remoteUser);
            User href = UserHelper.narrow(ref);
            
            ref = rootpoa.servant_to_reference(remoteProject);
            Project href2 = ProjectHelper.narrow(ref);
            
            ref = rootpoa.servant_to_reference(remoteTask);
            Task href3 = TaskHelper.narrow(ref);
            
            ref = rootpoa.servant_to_reference(remoteReport);
            Report href4 = ReportHelper.narrow(ref);
            
            ref = rootpoa.servant_to_reference(remoteMessage);
            Message href5 = MessageHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "User";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path,href);
            
            name = "Project";
            NameComponent path2[] = ncRef.to_name(name);
            ncRef.rebind(path2,href2);
            
            name = "Task";
            NameComponent path3[] = ncRef.to_name(name);
            ncRef.rebind(path3,href3);
            
            name = "Report";
            NameComponent path4[] = ncRef.to_name(name);
            ncRef.rebind(path4,href4);
            
            name = "Message";
            NameComponent path5[] = ncRef.to_name(name);
            ncRef.rebind(path5,href5);
            
            System.out.println("PMSystem ready and waiting...");

            orb.run();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("PMSystem exiting ...");
    }
}