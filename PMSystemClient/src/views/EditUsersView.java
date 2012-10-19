/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UsersView.java
 *
 * Created on 22-oct-2011, 20:43:15
 */
package views;

import PMSystem.UserData;
import PMSystem.UsersBasicData;
import controllers.UsersController;
import helpers.ComboBoxHelper;
import controllers.MainController;
import helpers.TimeHelper;
import java.sql.Date;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class EditUsersView extends AbstractIFrameView {
    
    private UsersController usersController;
    private TimeHelper timeHelper = new TimeHelper();
    private int ID_User = 0;
    private boolean preventDefault = false;
        
    /** Creates new form UsersView */
    public EditUsersView(String args[]) {
        this.usersController = new UsersController(args);
        initComponents();
    }
    
    public void translate() {
        jLabel1.setText(__("Username:"));
        jLabel4.setText(__("Privilege:"));
        jLabel5.setText(__("Name:"));
        jLabel6.setText(__("Email:"));
        jLabel8.setText(__("Birthday:"));
        jLabel7.setText(__("Gender:"));
        jLabel9.setText(__("Location:"));
        jLabel10.setText(__("State:"));
        jLabel11.setText(__("Edit User"));
        jLabel12.setText(__("Select a User:"));
        jLabel13.setText(__("Return to home"));
        jButton1.setText(__("Edit User"));
        jButton2.setText(__("Cancel"));        
    }
    
    public void configure(int id_user) {
        this.translate();
        
        UsersBasicData[] users = this.usersController.getAllUsers();
        if(id_user == 0) {
            this.preventDefault = true;
        } else {
            this.preventDefault = false;
        }
        
        jComboBox4.removeAllItems();
        if(users != null) {
            for(int i = 0; i < users.length; i++) {
                ComboBoxHelper cbbh = new ComboBoxHelper(users[i].id, users[i].username);
                jComboBox4.addItem(cbbh);
                if(id_user > 0) {
                    if(id_user == users[i].id) {
                        jComboBox4.setSelectedIndex(i);
                    }
                } else {
                    jComboBox4.setSelectedIndex(-1);
                }               
            }            
        }
        
        this.preventDefault = false;
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jTextField5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        jLabel2.setText("Username:");

        jTextField2.setMinimumSize(new java.awt.Dimension(50, 28));
        jTextField2.setPreferredSize(new java.awt.Dimension(150, 28));

        setMaximumSize(new java.awt.Dimension(1081, 630));
        setMinimumSize(new java.awt.Dimension(1081, 630));
        setPreferredSize(new java.awt.Dimension(1081, 630));

        jPanel1.setMaximumSize(new java.awt.Dimension(1081, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(1081, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1081, 630));

        jTextField4.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField4.setMinimumSize(new java.awt.Dimension(50, 28));
        jTextField4.setPreferredSize(new java.awt.Dimension(150, 28));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel4.setText("Privilege:");

        jComboBox4.setFont(new java.awt.Font("Verdana", 1, 14));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Verdana", 1, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "User" }));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setText("Select a User:");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel5.setText("Name:");

        jComboBox3.setFont(new java.awt.Font("Verdana", 1, 14));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Inactive" }));

        jTextField5.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField5.setMinimumSize(new java.awt.Dimension(50, 28));
        jTextField5.setPreferredSize(new java.awt.Dimension(150, 28));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel11.setText("Edit User");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Email:");

        jTextField7.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField7.setMinimumSize(new java.awt.Dimension(50, 28));
        jTextField7.setPreferredSize(new java.awt.Dimension(150, 28));

        jComboBox2.setFont(new java.awt.Font("Verdana", 1, 14));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("Edit User");
        jButton1.setMaximumSize(new java.awt.Dimension(115, 38));
        jButton1.setMinimumSize(new java.awt.Dimension(115, 38));
        jButton1.setPreferredSize(new java.awt.Dimension(115, 38));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel10.setText("State:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel7.setText("Gender:");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel8.setText("Birthday:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Location:");

        jTextField1.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextField1.setMinimumSize(new java.awt.Dimension(50, 28));
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 28));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Username:");

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton2.setText("Cancel");
        jButton2.setMaximumSize(new java.awt.Dimension(115, 38));
        jButton2.setMinimumSize(new java.awt.Dimension(115, 38));
        jButton2.setPreferredSize(new java.awt.Dimension(115, 38));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel13.setForeground(new java.awt.Color(14, 137, 254));
        jLabel13.setText("Return to home");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jDateChooser1.setFont(new java.awt.Font("Verdana", 0, 17));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 864, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(288, 288, 288))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username  = jTextField1.getText();
        String password  = "";
        String privilege = jComboBox1.getSelectedItem().toString();
        String name      = jTextField4.getText();
        String email     = jTextField5.getText();
        String gender    = jComboBox2.getSelectedItem().toString();
        String birthday  = this.timeHelper.getDateString(jDateChooser1.getDate());
        String location  = jTextField7.getText();
        String state     = jComboBox3.getSelectedItem().toString();
        
        String[] result = this.usersController.editUser(this.ID_User, username, password, "", privilege, name, email, gender, birthday, location, state);
        
        this.alertsHelper.showAlert(__(result[0]), result[1]); 
        
        this.preventDefault = true;
        UsersBasicData[] users = this.usersController.getAllUsers();
        jComboBox4.removeAllItems();
        for(int i = 0; i < users.length; i++) {
            ComboBoxHelper cbbh = new ComboBoxHelper(users[i].id, users[i].username);
            jComboBox4.addItem(cbbh);
            jComboBox4.setSelectedIndex(-1);
        }
        this.preventDefault = false;
        jTextField1.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jDateChooser1.setDate(null);
        jTextField7.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
       if(evt.getSource() == jComboBox4 && !this.preventDefault) {
           ComboBoxHelper dataUser = (ComboBoxHelper) jComboBox4.getSelectedItem();
           UserData user = this.usersController.getUser(dataUser.getID());
         
           this.ID_User = user.id;
           jTextField1.setText(user.username);
           jComboBox1.setSelectedItem(user.privilege);
           jTextField4.setText(user.name);
           jTextField5.setText(user.email);
           jComboBox2.setSelectedItem(user.gender);
           jDateChooser1.setDate(Date.valueOf(user.birthday));
           jTextField7.setText(user.location);
           jComboBox3.setSelectedItem(user.state);
       }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jDateChooser1.setDate(null);
        jTextField7.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        this.preventDefault = true;
        jComboBox4.setSelectedIndex(-1);
        this.preventDefault = false;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.home();
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}