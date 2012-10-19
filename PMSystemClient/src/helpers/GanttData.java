/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import PMSystem.ProjectData;
import PMSystem.TaskData;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class GanttData {
    public ProjectData project;
    public TaskData[] tasks;

    public GanttData(ProjectData project, TaskData[] tasks) {
        this.project = project;
        this.tasks = tasks;
    }
}
