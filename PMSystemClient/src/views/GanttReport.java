/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GeneralReportView.java
 *
 * Created on 11-nov-2011, 0:12:11
 */
package views;

import PMSystem.ProjectsBasicData;
import controllers.ReportsController;
import controllers.MainController;
import controllers.ProjectsController;
import helpers.ComboBoxHelper;
import helpers.TimeHelper;
import helpers.GanttData;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class GanttReport extends AbstractIFrameView {
    
    private ReportsController reportsController;
    private ProjectsController projectsController;
    public TimeHelper timeHelper = new TimeHelper();
    public boolean preventDefault;
    
    /** Creates new form GeneralReportView */
    public GanttReport(String args[]) {
        this.reportsController = new ReportsController(args);
        this.projectsController = new ProjectsController(args);
        initComponents();
    }
    
    public void translate() {
        jLabel1.setText(__("Gantt Report"));
        jLabel29.setText(__("Return to home"));
        jLabel2.setText(__("Select a Project:"));  
    }
    
    public void configure(int id_project) {
        this.translate();
        
        jInternalFrame1.setVisible(false);
        jInternalFrame1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
            setLocation(0,0);
            }
        });
        
        ProjectsBasicData[] projects = this.projectsController.getAllProjects();
        if(id_project == 0) {
            this.preventDefault = true;
        } else {
            this.preventDefault = false;
        }
        
        jComboBox1.removeAllItems();
        if(projects != null) {
            for(int i = 0; i < projects.length; i++) {
                ComboBoxHelper cbbh = new ComboBoxHelper(projects[i].id, projects[i].name);
                jComboBox1.addItem(cbbh);
                if(id_project > 0) {
                    if(id_project == projects[i].id) {
                        jComboBox1.setSelectedIndex(i);
                    }
                } else {
                    jComboBox1.setSelectedIndex(-1);
                } 
            }
        }
        
        this.preventDefault = false;
    }
    
    public void showGantt(int id_project) {
        GanttData ganttData = this.reportsController.getGanttData(id_project);
        if(ganttData.tasks[0].id > 0) {
            IntervalCategoryDataset dataset = createDataset(ganttData);
            JFreeChart chart = createChart(dataset, ganttData);

            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            CategoryItemRenderer renderer = plot.getRenderer();
            renderer.setSeriesPaint(0, Color.blue);

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 475));

            jInternalFrame1.setContentPane(chartPanel);
            jInternalFrame1.pack();
            jInternalFrame1.setVisible(true);
        } else {
            alertsHelper.showAlert(__("The specified project has no tasks, unable to create the gantt chart"), "error");
        }
        
    }
    
    public IntervalCategoryDataset createDataset(GanttData ganttData) {
        TaskSeries serie = new TaskSeries(__("Scheduled"));
        
        for(int i = 0; i < ganttData.tasks.length; i++) {
            Task task = new Task(ganttData.tasks[i].title, this.timeHelper.toDate(ganttData.tasks[i].start_date), this.timeHelper.toDate(ganttData.tasks[i].end_date));
            double progress = (double) ganttData.tasks[i].progress / 100;
            task.setPercentComplete(progress);
            serie.add(task);            
        }
        
        TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(serie);
        
        return collection;
    }
    
    public JFreeChart createChart(IntervalCategoryDataset dataset, GanttData ganttData) {
        JFreeChart chart = ChartFactory.createGanttChart(ganttData.project.name, __("Tasks"), __("Date"), dataset, true, true, false);
              
        return chart;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setMaximumSize(new java.awt.Dimension(1081, 630));
        setMinimumSize(new java.awt.Dimension(1081, 630));
        setPreferredSize(new java.awt.Dimension(1081, 630));

        jPanel1.setMaximumSize(new java.awt.Dimension(1081, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(1081, 630));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setText("Gantt Report");

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel29.setForeground(new java.awt.Color(14, 137, 254));
        jLabel29.setText("Return to home");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Select a Project:");

        jComboBox1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 817, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jInternalFrame1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.home();
        }
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(evt.getSource() == jComboBox1 && !this.preventDefault) {
            ComboBoxHelper dataProject = (ComboBoxHelper) jComboBox1.getSelectedItem();
            if(!dataProject.getTitle().equals("")) {
                this.showGantt(dataProject.getID());
            } else {
                alertsHelper.showAlert(__("Please select a project"), "error");
            }            
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}