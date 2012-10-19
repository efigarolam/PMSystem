    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import controllers.MainController;
import controllers.ReportsController;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class LanguagesHelper {
    
    public ReportsController reportsController;
    
    public LanguagesHelper() {
        this.reportsController = new ReportsController(MainController.orbdConfig);
    }
    
    public String getTranslation(String str) {    
        if(MainController.language.equals("English")) {
            try {
                return new String(str.getBytes("UTF-8"));  
            } catch(Exception e) {
                System.out.println(e.getMessage());
                return str;
            }            
        } else if(MainController.language.equals("Spanish")) {
            try {
                
               if(str.equals("Username")) {
                   return new String("Usuario".getBytes("UTF-8"));
               } else if(str.equals("Home")) {
                   return new String("Inicio".getBytes("UTF-8"));
               } else if(str.equals("Edit profile")) {
                   return new String("Editar perfil".getBytes("UTF-8"));
               } else if(str.equals("View online users")) {
                   return new String("Ver usuarios en línea".getBytes("UTF-8"));
               } else if(str.equals("Users")) {
                   return new String("Usuarios".getBytes("UTF-8"));
               } else if(str.equals("New")) {
                   return new String("Nuevo".getBytes("UTF-8"));
               } else if(str.equals("Edit")) {
                   return new String("Editar".getBytes("UTF-8"));
               } else if(str.equals("Find")) {
                   return new String("Consultar".getBytes("UTF-8"));
               } else if(str.equals("Projects")) {
                   return new String("Proyectos".getBytes("UTF-8"));
               } else if(str.equals("Tasks")) {
                   return new String("Tareas".getBytes("UTF-8"));
               } else if(str.equals("Reports")) {
                   return new String("Reportes".getBytes("UTF-8"));
               } else if(str.equals("General")) {
                   return new String("General".getBytes("UTF-8"));
               } else if(str.equals("Messages")) {
                   return new String("Mensajes".getBytes("UTF-8"));
               } else if(str.equals("Inbox")) {
                   return new String("Buzón de entrada".getBytes("UTF-8"));
               } else if(str.equals("Latest Projects")) {
                   return new String("Últimos Proyectos".getBytes("UTF-8"));
               } else if(str.equals("Latest Tasks")) {
                   return new String("Últimas Tareas".getBytes("UTF-8"));
               } else if(str.equals("Latest Users")) {
                   return new String("Últimos Usuarios".getBytes("UTF-8"));
               } else if(str.equals("Welcome, ")) {
                   return new String("Bienvenido, ".getBytes("UTF-8"));
               } else if(str.equals("Add")) {
                   return new String("Añadir ".getBytes("UTF-8"));
               } else if(str.equals("Send to trash")) {
                   return new String("Enviar a la papelera".getBytes("UTF-8"));
               } else if(str.equals("Delete")) {
                   return new String("Eliminar".getBytes("UTF-8"));
               } else if(str.equals("Send message to leader")) {
                   return new String("Mandar mensaje al líder".getBytes("UTF-8"));
               } else if(str.equals("ID")) {
                   return new String("ID".getBytes("UTF-8"));
               } else if(str.equals("Name")) {
                   return new String("Nombre".getBytes("UTF-8"));
               } else if(str.equals("Privilege")) {
                   return new String("Privilegio".getBytes("UTF-8"));
               } else if(str.equals("Birthday")) {
                   return new String("Cumpleaños".getBytes("UTF-8"));
               } else if(str.equals("Location")) {
                   return new String("Ubicación".getBytes("UTF-8"));
               } else if(str.equals("Email")) {
                   return new String("Correo".getBytes("UTF-8"));
               } else if(str.equals("Gender")) {
                   return new String("Género".getBytes("UTF-8"));
               } else if(str.equals("State")) {
                   return new String("Estado".getBytes("UTF-8"));
               } else if(str.equals("Do you want to send to trash the project?")) {
                   return new String("¿Quieres mandar a la papelera el proyecto?".getBytes("UTF-8"));
               } else if(str.equals("Do you want to delete the project?")) {
                   return new String("¿Quieres eliminar el proyecto?".getBytes("UTF-8"));
               } else if(str.equals("Please select a row")) {
                   return new String("Por favor selecciona una fila".getBytes("UTF-8"));
               } else if(str.equals("Do you want to delete the user?")) {
                   return new String("¿Quieres eliminar el usuario?".getBytes("UTF-8"));
               } else if(str.equals("Ups! an unexpected error has ocurred")) {
                   return new String("¡Ups! Un error inesperado ha ocurrido".getBytes("UTF-8"));
               } else if(str.equals("Do you want to send to trash the user?")) {
                   return new String("¿Quieres mandar a la papelera el usuario?".getBytes("UTF-8"));
               } else if(str.equals("ID_Leader")) {
                   return new String("ID_Líder".getBytes("UTF-8"));
               } else if(str.equals("Leader")) {
                   return new String("Líder".getBytes("UTF-8"));
               } else if(str.equals("Description")) {
                   return new String("Descripción".getBytes("UTF-8"));
               } else if(str.equals("End_Date")) {
                   return new String("Fecha_Final".getBytes("UTF-8"));
               } else if(str.equals("Start Date")) {
                   return new String("Fecha Inicial".getBytes("UTF-8"));
               } else if(str.equals("Title")) {
                   return new String("Título".getBytes("UTF-8"));
               } else if(str.equals("Project")) {
                   return new String("Proyecto".getBytes("UTF-8"));
               } else if(str.equals("End Date")) {
                   return new String("Fecha Final".getBytes("UTF-8"));
               } else if(str.equals("Progress")) {
                   return new String("Progreso".getBytes("UTF-8"));
               } else if(str.equals("Priority")) {
                   return new String("Prioridad".getBytes("UTF-8"));
               } else if(str.equals("Name:")) {
                   return new String("Nombre:".getBytes("UTF-8"));
               } else if(str.equals("Username:")) {
                   return new String("Usuario:".getBytes("UTF-8"));
               } else if(str.equals("Privilege:")) {
                   return new String("Privilegio:".getBytes("UTF-8"));
               } else if(str.equals("Email:")) {
                   return new String("Correo:".getBytes("UTF-8"));
               } else if(str.equals("Gender:")) {
                   return new String("Género:".getBytes("UTF-8"));
               } else if(str.equals("Location:")) {
                   return new String("Ubicación:".getBytes("UTF-8"));
               } else if(str.equals("State:")) {
                   return new String("Estado:".getBytes("UTF-8"));
               } else if(str.equals("Birthday:")) {
                   return new String("Cumpleaños:".getBytes("UTF-8"));
               } else if(str.equals("Edit User")) {
                   return new String("Editar Usuario".getBytes("UTF-8"));
               } else if(str.equals("Select a User:")) {
                   return new String("Seleccionar Usuario:".getBytes("UTF-8"));
               } else if(str.equals("Return to home")) {
                   return new String("Regresar al inicio".getBytes("UTF-8"));
               } else if(str.equals("Cancel")) {
                   return new String("Cancelar".getBytes("UTF-8"));
               } else if(str.equals("Find Users")) {
                   return new String("Buscar Usuarios".getBytes("UTF-8"));
               } else if(str.equals("Refresh")) {
                   return new String("Actualizar".getBytes("UTF-8"));
               } else if(str.equals("Select All")) {
                   return new String("Seleccionar todos".getBytes("UTF-8"));
               } else if(str.equals("All")) {
                   return new String("Todos".getBytes("UTF-8"));
               } else if(str.equals("By Username")) {
                   return new String("Por Usuario".getBytes("UTF-8"));
               } else if(str.equals("By Name")) {
                   return new String("Por Nombre".getBytes("UTF-8"));
               } else if(str.equals("By Email")) {
                   return new String("Por Correo".getBytes("UTF-8"));
               } else if(str.equals("By State (Trash)")) {
                   return new String("Por Estado (Papelera)".getBytes("UTF-8"));
               } else if(str.equals("Edit Project")) {
                   return new String("Editar Proyecto".getBytes("UTF-8"));
               } else if(str.equals("End date:")) {
                   return new String("Fecha final:".getBytes("UTF-8"));
               } else if(str.equals("Start date:")) {
                   return new String("Fecha inicial:".getBytes("UTF-8"));
               } else if(str.equals("Select a Project:")) {
                   return new String("Selecciona un Proyecto:".getBytes("UTF-8"));
               } else if(str.equals("Description:")) {
                   return new String("Descripción:".getBytes("UTF-8"));
               } else if(str.equals("Find Projects")) {
                   return new String("Buscar Proyectos".getBytes("UTF-8"));
               } else if(str.equals("User:")) {
                   return new String("Usuario:".getBytes("UTF-8"));
               } else if(str.equals("By User")) {
                   return new String("Por Usuario".getBytes("UTF-8"));
               } else if(str.equals("My Projects")) {
                   return new String("Mis Proyectos".getBytes("UTF-8"));
               } else if(str.equals("Find Tasks")) {
                   return new String("Buscar Tareas".getBytes("UTF-8"));
               } else if(str.equals("Update Progress")) {
                   return new String("Actualizar Progreso".getBytes("UTF-8"));
               } else if(str.equals("Title:")) {
                   return new String("Título:".getBytes("UTF-8"));
               } else if(str.equals("By Title")) {
                   return new String("Por Título".getBytes("UTF-8"));
               } else if(str.equals("Project:")) {
                   return new String("Proyecto:".getBytes("UTF-8"));
               } else if(str.equals("By Project")) {
                   return new String("Por Proyecto".getBytes("UTF-8"));
               } else if(str.equals("Priority:")) {
                   return new String("Prioridad:".getBytes("UTF-8"));
               } else if(str.equals("By Priority")) {
                   return new String("Por Prioridad".getBytes("UTF-8"));
               } else if(str.equals("My Tasks")) {
                   return new String("Mis Tareas".getBytes("UTF-8"));
               } else if(str.equals("My Messages")) {
                   return new String("Mis Mensajes".getBytes("UTF-8"));
               } else if(str.equals("Mark as read")) {
                   return new String("Marcar como leído".getBytes("UTF-8"));
               } else if(str.equals("Message")) {
                   return new String("Mensaje".getBytes("UTF-8"));
               } else if(str.equals("Subject")) {
                   return new String("Asunto".getBytes("UTF-8"));
               } else if(str.equals("From")) {
                   return new String("De".getBytes("UTF-8"));
               } else if(str.equals("ID_From")) {
                   return new String("ID_Remitente".getBytes("UTF-8"));
               } else if(str.equals("To")) {
                   return new String("Para".getBytes("UTF-8"));
               } else if(str.equals("See")) {
                   return new String("Ver".getBytes("UTF-8"));
               } else if(str.equals("Date")) {
                   return new String("Fecha".getBytes("UTF-8"));
               } else if(str.equals("Reply")) {
                   return new String("Responder".getBytes("UTF-8"));
               } else if(str.equals("ID_To")) {
                   return new String("ID_Receptor".getBytes("UTF-8"));
               } else if(str.equals("Outbox")) {
                   return new String("Buzón de Salida".getBytes("UTF-8"));
               } else if(str.equals("Restore")) {
                   return new String("Restaurar".getBytes("UTF-8"));
               } else if(str.equals("You don't have trash messages")) {
                   return new String("No tienes mensajes en la papelera".getBytes("UTF-8"));
               } else if(str.equals("Trash")) {
                   return new String("Papelera".getBytes("UTF-8"));
               } else if(str.equals("Edit Task")) {
                   return new String("Editar Tarea".getBytes("UTF-8"));
               } else if(str.equals("Select a Task:")) {
                   return new String("Selecciona una Tarea:".getBytes("UTF-8"));
               } else if(str.equals("Progress:")) {
                   return new String("Progreso:".getBytes("UTF-8"));
               } else if(str.equals("Users:")) {
                   return new String("Usuarios:".getBytes("UTF-8"));
               } else if(str.equals("Users Online")) {
                   return new String("Usuarios en línea".getBytes("UTF-8"));
               } else if(str.equals("Start_Date")) {
                   return new String("Fecha_Inicial".getBytes("UTF-8"));
               } else if(str.equals("New Password:")) {
                   return new String("Nueva contraseña:".getBytes("UTF-8"));
               } else if(str.equals("Edit Profile")) {
                   return new String("Editar Perfil".getBytes("UTF-8"));
               } else if(str.equals("(Repeat Password)")) {
                   return new String("(Repetir Contraseña)".getBytes("UTF-8"));
               } else if(str.equals("There are no projects, create a new one!")) {
                   return new String("¡No hay proyectos, crea uno nuevo!".getBytes("UTF-8"));
               } else if(str.equals("There are no tasks, create a new one!")) {
                   return new String("¡No hay tareas, crea una nueva!".getBytes("UTF-8"));
               } else if(str.equals("Send message")) {
                   return new String("Enviar mensaje".getBytes("UTF-8"));
               } else if(str.equals("Save User")) {
                   return new String("Guardar Usuario".getBytes("UTF-8"));
               } else if(str.equals("Password:")) {
                   return new String("Contraseña:".getBytes("UTF-8"));
               } else if(str.equals("Save Project")) {
                   return new String("Guardar Proyecto".getBytes("UTF-8"));
               } else if(str.equals("Save Task")) {
                   return new String("Guardar Tarea".getBytes("UTF-8"));
               } else if(str.equals("Select a user:")) {
                   return new String("Selecciona un Usuario:".getBytes("UTF-8"));
               } else if(str.equals("Subject:")) {
                   return new String("Asunto:".getBytes("UTF-8"));
               } else if(str.equals("Message:")) {
                   return new String("Mensaje:".getBytes("UTF-8"));
               } else if(str.equals("Send to Email")) {
                   return new String("Mandar al Correo".getBytes("UTF-8"));
               } else if(str.equals("You don't have inbox messages")) {
                   return new String("No tienes mensajes en el buzón de entrada".getBytes("UTF-8"));
               } else if(str.equals("You don't have outbox messages")) {
                   return new String("No tienes mensajes en el buzón de salida".getBytes("UTF-8"));
               } else if(str.equals("General Report")) {
                   return new String("Reporte General".getBytes("UTF-8"));
               } else if(str.equals("» Administrators:")) {
                   return new String("» Administradores:".getBytes("UTF-8"));
               } else if(str.equals("» Registered users:")) {
                   return new String("» Usuarios registrados:".getBytes("UTF-8"));
               } else if(str.equals("» Users")) {
                   return new String("» Usuarios".getBytes("UTF-8"));
               } else if(str.equals("» Normal users:")) {
                   return new String("» Usuarios normales:".getBytes("UTF-8"));
               } else if(str.equals("» Women:")) {
                   return new String("» Mujeres:".getBytes("UTF-8"));
               } else if(str.equals("» Inactive:")) {
                   return new String("» Inactivos:".getBytes("UTF-8"));
               } else if(str.equals("» Last login:")) {
                   return new String("» Último inicio:".getBytes("UTF-8"));
               } else if(str.equals("» Total projects:")) {
                   return new String("» Proyectos totales:".getBytes("UTF-8"));
               } else if(str.equals("» Projects")) {
                   return new String("» Proyectos".getBytes("UTF-8"));
               } else if(str.equals("» Active:")) {
                   return new String("» Activos:".getBytes("UTF-8"));
               } else if(str.equals("» Logins:")) {
                   return new String("» Inicios de sesión:".getBytes("UTF-8"));
               } else if(str.equals("» Men:")) {
                   return new String("» Hombres:".getBytes("UTF-8"));
               } else if(str.equals("» Last project:")) {
                   return new String("» Último proyecto:".getBytes("UTF-8"));
               } else if(str.equals("» Started:")) {
                   return new String("» Iniciadas:".getBytes("UTF-8"));
               } else if(str.equals("» Last task:")) {
                   return new String("» Última tarea:".getBytes("UTF-8"));
               } else if(str.equals("» Stopped:")) {
                   return new String("» Detenidas:".getBytes("UTF-8"));
               } else if(str.equals("» Urgent priority:")) {
                   return new String("» Prioridad urgente:".getBytes("UTF-8"));
               } else if(str.equals("» Tasks")) {
                   return new String("» Tareas".getBytes("UTF-8"));
               } else if(str.equals("» High priority:")) {
                   return new String("» Prioridad alta:".getBytes("UTF-8"));
               } else if(str.equals("» Total tasks:")) {
                   return new String("» Tareas totales:".getBytes("UTF-8"));
               } else if(str.equals("» Low priority:")) {
                   return new String("» Prioridad baja:".getBytes("UTF-8"));
               } else if(str.equals("» Medium priority:")) {
                   return new String("» Prioridad media:".getBytes("UTF-8"));
               } else if(str.equals("» Finished:")) {
                   return new String("» Finalizadas:".getBytes("UTF-8"));
               } else if(str.equals("» Paused:")) {
                   return new String("» Pausadas:".getBytes("UTF-8"));
               } else if(str.equals("Send Message")) {
                   return new String("Mandar Mensaje".getBytes("UTF-8"));
               } else if(str.equals("Close")) {
                   return new String("Salir".getBytes("UTF-8"));
               } else if(str.equals("Close")) {
                   return new String("Salir".getBytes("UTF-8"));
               } else if(str.equals("Help")) {
                   return new String("Ayuda".getBytes("UTF-8"));
               } else if(str.equals("About...")) {
                   return new String("Acerca de...".getBytes("UTF-8"));
               } else if(str.equals("Log out")) {
                   return new String("Cerrar sesión".getBytes("UTF-8"));
               } else if(str.equals("Unselect all")) {
                   return new String("Seleccionar nada".getBytes("UTF-8"));
               } else if(str.equals("Do you want to send to trash the project(s)?")) {
                   return new String("¿Quieres mandar a la papelera el/los proyecto(s)?".getBytes("UTF-8"));
               } else if(str.equals("Do you want to delete the project(s)?")) {
                   return new String("¿Quieres eliminar el/los proyecto(s)?".getBytes("UTF-8"));
               } else if(str.equals("Select all")) {
                   return new String("Seleccionar todo".getBytes("UTF-8"));
               } else if(str.equals("Do you want to send to trash the task(s)?")) {
                   return new String("¿Quieres mandar a la papelera la/las tarea(s)?".getBytes("UTF-8"));
               } else if(str.equals("Do you want to delete the message(s)?")) {
                   return new String("¿Quieres eliminar el/los mensaje(s)?".getBytes("UTF-8"));
               } else if(str.equals("Message(s) deleted correctly!")) {
                   return new String("¡Mensaje(s) eliminados correctamente!".getBytes("UTF-8"));
               } else if(str.equals("Do you want to send to trash the message(s)?")) {
                   return new String("¿Quieres mandar a la papelera el/los mensaje(s)?".getBytes("UTF-8"));
               } else if(str.equals("Project sent to trash correctly!")) {
                   return new String("¡Proyecto mandado a la papelera correctamente!".getBytes("UTF-8"));
               } else if(str.equals("Do you want to restore the project?")) {
                   return new String("¿Quieres restaurar el proyecto?".getBytes("UTF-8"));
               } else if(str.equals("Project restored correctly!")) {
                   return new String("¡Proyecto restaurado correctamente!".getBytes("UTF-8"));
               } else if(str.equals("There are no projects with that state")) {
                   return new String("No hay proyectos con ese estado".getBytes("UTF-8"));
               } else if(str.equals("User sent to trash correctly!")) {
                   return new String("¡Usuario mandado a la papelera correctamente!".getBytes("UTF-8"));
               } else if(str.equals("Do you want to restore the user?")) {
                   return new String("¿Quieres restaurar el usuario?".getBytes("UTF-8"));
               } else if(str.equals("User restored correctly!")) {
                   return new String("¡Usuario restaurado correctamente!".getBytes("UTF-8"));
               } else if(str.equals("There are no users with that state")) {
                   return new String("No hay usuarios con ese estado".getBytes("UTF-8"));
               } else if(str.equals("User deleted correctly!")) {
                   return new String("¡Usuario eliminado correctamente!".getBytes("UTF-8"));
               } else if(str.equals("Project deleted correctly!")) {
                   return new String("¡Proyecto eliminado correctamente!".getBytes("UTF-8"));
               } else if(str.equals("There are no projects with that name")) {
                   return new String("No hay proyectos con ese nombre".getBytes("UTF-8"));
               } else if(str.equals("Please write a name")) {
                   return new String("Escribe un nombre válido, por favor".getBytes("UTF-8"));
               } else if(str.equals("Update progress")) {
                   return new String("Actualizar progreso".getBytes("UTF-8"));
               } else if(str.equals("You don't have assigned tasks")) {
                   return new String("No tienes tareas asignadas".getBytes("UTF-8"));
               } else if(str.equals("Do you want to send to trash the task?")) {
                   return new String("¿Quieres mandar a la papelera el registro?".getBytes("UTF-8"));
               } else if(str.equals("Task sent to trash correctly!")) {
                   return new String("¡Tarea mandada a la papelera correctamente!".getBytes("UTF-8"));
               } else if(str.equals("You need to write a valid username")) {
                   return new String("Escribe un usuario válido, por favor".getBytes("UTF-8"));
               } else if(str.equals("You need to write a valid password")) {
                   return new String("Escribe una contraseña válida, por favor".getBytes("UTF-8"));
               } else if(str.equals("You need to write a valid name")) {
                   return new String("Escribe un nombre válido, por favor".getBytes("UTF-8"));
               } else if(str.equals("You need to write a valid email")) {
                   return new String("Escribe un correo electrónico válido, por favor".getBytes("UTF-8"));
               } else if(str.equals("The user has been saved correctly!")) {
                   return new String("¡El usuario ha sido guardado correctamente!".getBytes("UTF-8"));
               } else if(str.equals("You need to select a user")) {
                   return new String("Selecciona un usuario, por favor".getBytes("UTF-8"));
               } else if(str.equals("You need to write a valid description")) {
                   return new String("Escribe una descripción válida, por favor".getBytes("UTF-8"));
               } else if(str.equals("You need to select a valid start date")) {
                   return new String("Selecciona una fecha de inicio válida, por favor".getBytes("UTF-8"));
               } else if(str.equals("The project has been saved correctly!")) {
                   return new String("¡El proyecto ha sido guardado correctamente!".getBytes("UTF-8"));
               } else if(str.equals("The specified project already exists!")) {
                   return new String("¡Ya existe el proyecto!".getBytes("UTF-8"));
               } else if(str.equals("The specified email already exists!")) {
                   return new String("¡El correo electrónico ya está en uso! Ingresa otro, por favor".getBytes("UTF-8"));
               } else if(str.equals("The specified username already exists!")) {
                   return new String("¡El usuario ya existe!".getBytes("UTF-8"));
               } else if(str.equals("You need to select a project")) {
                   return new String("Selecciona un proyecto, por favor".getBytes("UTF-8"));
               } else if(str.equals("You need to select one user at least")) {
                   return new String("Selecciona al menos un usuario, por favor".getBytes("UTF-8"));
               } else if(str.equals("You need to write a valid title")) {
                   return new String("Selecciona un título válido, por favor".getBytes("UTF-8"));
               } else if(str.equals("An unexpected error has ocurred...")) {
                   return new String("Ha ocurrido un error inesperado...".getBytes("UTF-8"));
               } else if(str.equals("The task has been saved correctly!")) {
                   return new String("¡La tarea ha sido guardada correctamente!".getBytes("UTF-8"));
               } else if(str.equals("The specified task already exists!")) {
                   return new String("¡La tarea ya existe!".getBytes("UTF-8"));
               } else if(str.equals("The user has been edited correctly!")) {
                   return new String("¡El usuario ha sido editado correctamente!".getBytes("UTF-8"));
               } else if(str.equals("The passwords are different")) {
                   return new String("Las contraseñas no son iguales".getBytes("UTF-8"));
               } else if(str.equals("The project has been edited correctly!")) {
                   return new String("El proyeto ha sido editado correctamente".getBytes("UTF-8"));
               } else if(str.equals("There are no users with that email")) {
                   return new String("No hay usuarios con ese correo electrónico".getBytes("UTF-8"));
               } else if(str.equals("The message has been sent correctly!")) {
                   return new String("¡El mensaje se ha mandado correctamente!".getBytes("UTF-8"));
               } else if(str.equals("Please select a user")) {
                   return new String("Seleccione un usuario, por favor".getBytes("UTF-8"));
               } else if(str.equals("Please select a project")) {
                   return new String("Seleccione un proyecto, por favor".getBytes("UTF-8"));
               } else if(str.equals("There are no projects with that priority")) {
                   return new String("No hay proyectos con esa prioridad".getBytes("UTF-8"));
               } else if(str.equals("There are no projects with that user")) {
                   return new String("No hay proyectos con ese usuario".getBytes("UTF-8"));
               } else if(str.equals("There are no tasks for that user")) {
                   return new String("No hay tareas para ese usuario".getBytes("UTF-8"));
               } else if(str.equals("There are no tasks with that name")) {
                   return new String("No hay tareas con ese nombre".getBytes("UTF-8"));
               } else if(str.equals("The start date is bigger than the end date")) {
                   return new String("La fecha de inicio es mayor a la fecha de fin".getBytes("UTF-8"));
               } else if(str.equals("Gantt Report")) {
                   return new String("Reporte Gantt".getBytes("UTF-8"));
               } else if(str.equals("Scheduled")) {
                   return new String("Programado".getBytes("UTF-8"));
               } else if(str.equals("View Gantt chart")) {
                   return new String("Ver gráfica de Gantt".getBytes("UTF-8"));
               } else if(str.equals("Logins Proyection")) {
                   return new String("Proyección de inicios de sesión".getBytes("UTF-8"));
               } else if(str.equals("Logins")) {
                   return new String("Inicios de sesión".getBytes("UTF-8"));
               } else if(str.equals("Amount of Logins")) {
                   return new String("Cantidad de inicios de sesión".getBytes("UTF-8"));
               } else if(str.equals("Day")) {
                   return new String("Día".getBytes("UTF-8"));
               } else if(str.equals("Login")) {
                   return new String("Iniciar Sesión".getBytes("UTF-8"));
               } else if(str.equals("Configuration")) {
                   return new String("Configuración".getBytes("UTF-8"));
               } else if(str.equals("Language:")) {
                   return new String("Idioma:".getBytes("UTF-8"));
               } else if(str.equals("Save Configuration")) {
                   return new String("Guardar Configuración".getBytes("UTF-8"));
               } else if(str.equals("Theme:")) {
                   return new String("Tema:".getBytes("UTF-8"));
               } else if(str.equals("Close")) {
                   return new String("Salir".getBytes("UTF-8"));
               } else if(str.equals("There are no users, create a new one!")) {
                   return new String("¡No hay usuaros, crea uno nuevo!".getBytes("UTF-8"));
               } else if(str.equals("The configuration has been saved correctly, if you changed the theme, you need to restart Project.Me System to see the changes")) {
                   return new String("La configuración ha sido guardada correctamente, si cambiaste el tema, necesitas reiniciar el Sistema Project.Me para ver los cambios".getBytes("UTF-8"));
               } else if(str.equals("Something was wrong")) {
                   return new String("Algo ocurrió mal".getBytes("UTF-8"));
               } else if(str.equals("The specified project has no tasks, unable to create the Gantt chart")) {
                   return new String("El proyecto seleccionado no tiene tareas, es imposible crear el diagrama de Gantt".getBytes("UTF-8"));
               } else {
                   this.reportsController.addMissingTranslation(str);
                   return str;
               }
               
            } catch(Exception e) {
                System.out.println(e.getMessage());
                return str;
            }
        } else {
            return str;
        }
    }
    
}
