/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FindUsersByUsername.java
 *
 * Created on 07-nov-2011, 14:50:39
 */
package views;

import PMSystem.TaskData;
import PMSystem.ProjectsBasicData;
import controllers.MainController;
import controllers.ProjectsController;
import controllers.TasksController;
import helpers.ComboBoxHelper;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class FindTasksByProjectPanel extends AbstractPanelView {
    
    private ProjectsController projectsController;
    private TasksController tasksController;
    private DefaultTableModel tModel;
    private boolean btnSelectBhvr = true;
    private boolean preventDefault;
    
    /** Creates new form FindUsersByUsername */
    public FindTasksByProjectPanel(String args[]) {
        this.projectsController = new ProjectsController(args);
        this.tasksController = new TasksController(args);
        initComponents();
    }
    
    public void translate() {
        jButton2.setText(__("Select All"));
        jButton3.setText(__("Send to trash"));
        jButton4.setText(__("Delete")); 
        jLabel1.setText(__("Project:"));
    }
    
    public void configure() {
        this.translate();
        
        jPanel1.setVisible(false);
        jTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenuItem4 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        
        jMenuItem1.setText(__("Add"));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        
        jMenuItem2.setText(__("Edit"));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
                
        jMenuItem3.setText(__("Send to trash"));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        
        jMenuItem4.setText(__("Delete"));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        
        jMenuItem5.setText(__("Update Progress"));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
                
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jMenuItem2);
        jPopupMenu1.add(jMenuItem3);
        jPopupMenu1.add(jMenuItem4);       
        jPopupMenu1.add(jMenuItem5);  
        
        this.preventDefault = true;
        ProjectsBasicData[] users = this.projectsController.getAllProjects();
        jComboBox1.removeAllItems();
        if(users != null) {
            for(int i = 0; i < users.length; i++) {
                ComboBoxHelper cbbh = new ComboBoxHelper(users[i].id, users[i].name);
                jComboBox1.addItem(cbbh);               
            }
            jComboBox1.setSelectedIndex(-1);
        }
        this.preventDefault = false;
    }
    
    public void refresh() {
        int ID_Project;
        try {
            ComboBoxHelper dataUser = (ComboBoxHelper) jComboBox1.getSelectedItem();
            ID_Project = dataUser.getID();
        } catch(Exception e) {
            ID_Project = 0;
        }
        
        if(ID_Project > 0) {
            TaskData[] result = this.tasksController.getTasks("ID_Project = '"+ID_Project+"' AND State != 'Inactive'");
            if(result[0].id == 0) {
                this.jPanel1.setVisible(false);
                this.alertsHelper.showAlert(__("There are no tasks of that project"), "information");
            } else {
                tModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int rowIndex, int mColIndex) {
                        return false;
                    }
                };
                
                tModel.addColumn(__("ID"));
                tModel.addColumn(__("Title"));
                tModel.addColumn(__("Description"));
                tModel.addColumn(__("Project"));
                tModel.addColumn(__("Users"));
                tModel.addColumn(__("Start Date"));
                tModel.addColumn(__("End Date"));
                tModel.addColumn(__("Progress"));
                tModel.addColumn(__("Priority"));
                tModel.addColumn(__("State"));
                
                String[] row = new String[10];
                for(int i = 0; i < result.length; i++) {
                    row[0] = Integer.toString(result[i].id);
                    row[1] = result[i].title;
                    row[2] = result[i].description;
                    row[3] = result[i].project;
                    String users = "";
                    for(int j = 0; j < result[i].users.length; j++) {
                        users += result[i].users[j] + ", ";
                    }
                    row[4] = users;
                    row[5] = result[i].start_date;
                    row[6] = result[i].end_date;
                    row[7] = Integer.toString(result[i].progress);
                    row[8] = result[i].priority;
                    row[9] = result[i].state;
                    
                    tModel.addRow(row);
                }
                
                jTable1.setModel(tModel);
                jPanel1.setVisible(true);
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a project"), "error");
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        jPopupMenu1.setInvoker(jTable1);

        setMaximumSize(new java.awt.Dimension(1000, 520));
        setMinimumSize(new java.awt.Dimension(1000, 520));
        setPreferredSize(new java.awt.Dimension(1000, 520));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setText("Project:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton2.setText("Select All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton3.setText("Send to trash");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jComboBox1.setFont(new java.awt.Font("Verdana", 1, 14));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        MainController.adminView.saveTask();     
    }
    
    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
            int id_task = Integer.parseInt(selectedRow.toString());
            MainController.adminView.editTask(id_task); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(this.alertsHelper.showConfirm(__("Do you want to send to trash the task?"), "question")) {
                Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
                int id_task = Integer.parseInt(selectedRow.toString());
                if(this.tasksController.trashTask(id_task)) {
                    this.alertsHelper.showAlert(__("Task sent to trash correctly!"), "information");
                    this.refresh();
                } else {
                    this.alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem4ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(this.alertsHelper.showConfirm(__("Do you want to delete the task?"), "question")) {
                Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
                int id_task = Integer.parseInt(selectedRow.toString());
                if(this.tasksController.deleteTask(id_task)) {
                    this.alertsHelper.showAlert(__("Task deleted correctly!"), "information");
                    this.refresh();
                } else {
                    this.alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }        
    }
    
    private void jMenuItem5ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
            int id_task = Integer.parseInt(selectedRow.toString());
            MainController.adminView.updateTaskProgress(id_task); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.btnSelectBhvr) {
            jButton2.setText(__("Unselect all"));
            jTable1.selectAll();
            this.btnSelectBhvr = false;
        } else {
            jButton2.setText(__("Select all"));
            jTable1.clearSelection();
            this.btnSelectBhvr = true;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTable1.getSelectedRowCount() > 0) {
            int[] selectedRowsIndex = jTable1.getSelectedRows();
            int errors = 0;
            if(this.alertsHelper.showConfirm(__("Do you want to send to trash the task(s)?"), "question")) {
                for(int i = 0; i < selectedRowsIndex.length; i++) {
                    Object selectedRow = jTable1.getValueAt(selectedRowsIndex[i], 0);
                    int id_user = Integer.parseInt(selectedRow.toString());
                    if(!this.tasksController.trashTask(id_user)) {
                        errors++;
                    }                   
                }
                
                if(selectedRowsIndex.length == errors) {
                    this.alertsHelper.showAlert(__("Ups! and unexpected error has ocurred"), "error");
                } else if (errors == 0) {
                    this.alertsHelper.showAlert(__("Task(s) sent to trash correctly!"), "information");
                } else if(selectedRowsIndex.length > errors) {
                    this.alertsHelper.showAlert(__("Some task(s) sent to trash correctly, but others failed!"), "information");
                } 
                
                this.refresh();
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(jTable1.getSelectedRowCount() > 0) {
            int[] selectedRowsIndex = jTable1.getSelectedRows();
            int errors = 0;
            if(this.alertsHelper.showConfirm(__("Do you want to delete the task(s)?"), "question")) {
                for(int i = 0; i < selectedRowsIndex.length; i++) {
                    Object selectedRow = jTable1.getValueAt(selectedRowsIndex[i], 0);
                    int id_user = Integer.parseInt(selectedRow.toString());
                    if(!this.tasksController.deleteTask(id_user)) {
                        errors++;
                    }                   
                }
                
                if(selectedRowsIndex.length == errors) {
                    this.alertsHelper.showAlert(__("Ups! and unexpected error has ocurred"), "error");
                } else if (errors == 0) {
                    this.alertsHelper.showAlert(__("Task(s) deleted correctly!"), "information");
                } else if(selectedRowsIndex.length > errors) {
                    this.alertsHelper.showAlert(__("Some task(s) deleted correctly, but others failed!"), "information");
                } 
                
                this.refresh();
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(!this.preventDefault) {
            this.refresh();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}