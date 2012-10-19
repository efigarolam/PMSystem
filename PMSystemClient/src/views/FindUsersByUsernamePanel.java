/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FindUsersByUsernamePanel.java
 *
 * Created on 07-nov-2011, 14:50:39
 */
package views;

import PMSystem.UserData;
import controllers.UsersController;
import controllers.MainController;
import helpers.StringsHelper;
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
public class FindUsersByUsernamePanel extends AbstractPanelView {
    
    private UsersController usersController;
    private StringsHelper stringsHelper = new StringsHelper();
    private DefaultTableModel tModel;
    private boolean btnSelectBhvr = true;
    
    /** Creates new form FindUsersByUsernamePanel */
    public FindUsersByUsernamePanel(String args[]) {
        this.usersController = new UsersController(args);
        initComponents();
    }
    
    public void translate() {
        jButton1.setText(__("Find"));
        jButton2.setText(__("Select All"));
        jButton3.setText(__("Send to trash"));
        jButton4.setText(__("Delete")); 
        jLabel1.setText(__("Username:"));
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
        
        jMenuItem5.setText(__("Send message"));
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
    }
    
    public void refresh() {
        String username = this.stringsHelper.clean(jTextField1.getText());
        
        if(!username.equals("")) {
            UserData[] result = this.usersController.getUsers("Username LIKE '%"+username+"%' AND State = 'Active'");
            if(result[0].id == 0) {
                this.jPanel1.setVisible(false);
                this.alertsHelper.showAlert(__("There are no users with that username"), "information");
            } else {
                tModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int rowIndex, int mColIndex) {
                        return false;
                    }
                };
                
                tModel.addColumn(__("ID"));
                tModel.addColumn(__("Username"));
                tModel.addColumn(__("Privilege"));
                tModel.addColumn(__("Name"));
                tModel.addColumn(__("Email"));
                tModel.addColumn(__("Gender"));
                tModel.addColumn(__("Birthday"));
                tModel.addColumn(__("Location"));
                tModel.addColumn(__("State"));
                
                String[] row = new String[9];
                for(int i = 0; i < result.length; i++) {
                    row[0] = Integer.toString(result[i].id);
                    row[1] = result[i].username;
                    row[2] = result[i].privilege;
                    row[3] = result[i].name;
                    row[4] = result[i].email;
                    row[5] = result[i].gender;
                    row[6] = result[i].birthday;
                    row[7] = result[i].location;
                    row[8] = result[i].state;
                    tModel.addRow(row);
                }
                
                jTable1.setModel(tModel);
                jPanel1.setVisible(true);
            }
        } else {
            this.alertsHelper.showAlert(__("Please write a username"), "error");
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
        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPopupMenu1.setFont(new java.awt.Font("Verdana", 0, 17));
        jPopupMenu1.setInvoker(jTable1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(1000, 520));
        setMinimumSize(new java.awt.Dimension(1000, 520));
        setPreferredSize(new java.awt.Dimension(1000, 520));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setText("Username: ");

        jTextField1.setFont(new java.awt.Font("Verdana", 1, 14));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        MainController.adminView.saveUser();     
    }
    
    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
            int id_user = Integer.parseInt(selectedRow.toString());
            MainController.adminView.editUser(id_user); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(this.alertsHelper.showConfirm(__("Do you want to send to trash the user?"), "question")) {
                Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
                int id_user = Integer.parseInt(selectedRow.toString());
                if(this.usersController.trashUser(id_user)) {
                    this.alertsHelper.showAlert(__("User sent to trash correctly!"), "information");
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
            if(this.alertsHelper.showConfirm(__("Do you want to delete the user?"), "question")) {
                Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
                int id_user = Integer.parseInt(selectedRow.toString());
                if(this.usersController.deleteUser(id_user)) {
                    this.alertsHelper.showAlert(__("User deleted correctly!"), "information");
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
            int id_user = Integer.parseInt(selectedRow.toString());
            MainController.adminView.sendMessage(id_user); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.refresh();        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            if(this.alertsHelper.showConfirm(__("Do you want to send to trash the user(s)?"), "question")) {
                for(int i = 0; i < selectedRowsIndex.length; i++) {
                    Object selectedRow = jTable1.getValueAt(selectedRowsIndex[i], 0);
                    int id_user = Integer.parseInt(selectedRow.toString());
                    if(!this.usersController.trashUser(id_user)) {
                        errors++;
                    }                   
                }
                
                if(selectedRowsIndex.length == errors) {
                    this.alertsHelper.showAlert(__("Ups! and unexpected error has ocurred"), "error");
                } else if (errors == 0) {
                    this.alertsHelper.showAlert(__("User(s) sent to trash correctly!"), "information");
                } else if(selectedRowsIndex.length > errors) {
                    this.alertsHelper.showAlert(__("Some user(s) sent to trash correctly, but others failed!"), "information");
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
            if(this.alertsHelper.showConfirm(__("Do you want to delete the user(s)?"), "question")) {
                for(int i = 0; i < selectedRowsIndex.length; i++) {
                    Object selectedRow = jTable1.getValueAt(selectedRowsIndex[i], 0);
                    int id_user = Integer.parseInt(selectedRow.toString());
                    if(!this.usersController.deleteUser(id_user)) {
                        errors++;
                    }                   
                }
                
                if(selectedRowsIndex.length == errors) {
                    this.alertsHelper.showAlert(__("Ups! and unexpected error has ocurred"), "error");
                } else if (errors == 0) {
                    this.alertsHelper.showAlert(__("User(s) deleted correctly!"), "information");
                } else if(selectedRowsIndex.length > errors) {
                    this.alertsHelper.showAlert(__("Some user(s) deleted correctly, but others failed!"), "information");
                } 
                
                this.refresh();
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}