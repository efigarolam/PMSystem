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

import PMSystem.MessageData;
import controllers.MainController;
import controllers.MessagesController;
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
public class FindInboxMessagesPanel extends AbstractPanelView {
    
    private MessagesController messagesController;
    private DefaultTableModel tModel;
    private boolean btnSelectBhvr = true;
    
    /** Creates new form FindUsersByUsername */
    public FindInboxMessagesPanel(String args[]) {
        this.messagesController = new MessagesController(args);
        initComponents();
    }
    
    public void translate() {
        jButton5.setText(__("Refresh"));
        jButton2.setText(__("Select All"));
        jButton3.setText(__("Send to trash"));
        jButton4.setText(__("Delete")); 
        jButton6.setText(__("Mark as read")); 
    }
    
    public void configure() {
        this.translate();
        
        jPanel1.setVisible(true);
        jTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        this.refresh();
            
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenuItem4 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        
        jMenuItem1.setText(__("See"));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        
        jMenuItem2.setText(__("Reply"));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
                
        jMenuItem3.setText(__("Mark as read"));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        
        jMenuItem4.setText(__("Send to trash"));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        
        jMenuItem5.setText(__("Delete"));
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
    
    private void refresh() {
        MessageData[] result = this.messagesController.getInboxMessages(MainController.userOnlineID);
        if(result[0].id == 0) {
            tModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };

            tModel.addColumn(__("Inbox"));
            String[] message = new String[1];
            message[0] = __("You don't have inbox messages");
            tModel.addRow(message);
            jTable1.setModel(tModel);
        } else {
            tModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };
               
            tModel.addColumn(__("ID"));
            tModel.addColumn(__("Subject"));
            tModel.addColumn(__("Message"));
            tModel.addColumn(__("From"));
            tModel.addColumn(__("To"));
            tModel.addColumn(__("ID_From"));
            tModel.addColumn(__("Date"));
            tModel.addColumn(__("State"));

            String[] row = new String[8];
            for(int i = 0; i < result.length; i++) {
                row[0] = Integer.toString(result[i].id);
                row[1] = result[i].subject;
                row[2] = result[i].message;
                row[3] = result[i].sender;
                row[4] = result[i].receiver;
                row[5] = Integer.toString(result[i].id_sender);
                row[6] = result[i].date;
                row[7] = result[i].state;
                tModel.addRow(row);
            }

            jTable1.setModel(tModel);
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPopupMenu1.setInvoker(jTable1);

        setMaximumSize(new java.awt.Dimension(1000, 520));
        setMinimumSize(new java.awt.Dimension(1000, 520));
        setPreferredSize(new java.awt.Dimension(1000, 520));

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

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setText("Select All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setText("Send to trash");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton6.setText("Mark as read");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(422, 422, 422))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
            int id_message = Integer.parseInt(selectedRow.toString());
            try {
                MainController.adminView.readMessage(id_message);
            } catch(Exception e) {
                MainController.userView.readMessage(id_message);
            } 
        } else {
            alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 5);
            int id_user = Integer.parseInt(selectedRow.toString());
            try {
                MainController.adminView.sendMessage(id_user); 
            } catch(Exception e) {
                MainController.userView.sendMessage(id_user); 
            }
        } else {
            alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
            int id_message = Integer.parseInt(selectedRow.toString());
            this.messagesController.updateMessageState(id_message, "Read");
            this.refresh();
        } else {
            alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem4ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(alertsHelper.showConfirm(__("Do you want to send to trash the message?"), "question")) {
                Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
                int id_message = Integer.parseInt(selectedRow.toString());
                if(this.messagesController.sendToTrash(id_message)) {
                    alertsHelper.showAlert(__("Message sent to trash correctly!"), "information");
                    this.refresh();
                } else {
                    alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            alertsHelper.showAlert(__("Please select a row"), "error");
        }        
    }
    
    private void jMenuItem5ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(alertsHelper.showConfirm(__("Do you want to delete the message?"), "question")) {
                Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
                int id_message = Integer.parseInt(selectedRow.toString());
                if(this.messagesController.deleteMessage(id_message)) {
                    alertsHelper.showAlert(__("Messages deleted correctly!"), "information");
                    this.refresh(); 
                } else {
                    alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            alertsHelper.showAlert(__("Please select a row"), "error");
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
            if(alertsHelper.showConfirm(__("Do you want to send to trash the message(s)?"), "question")) {
                for(int i = 0; i < selectedRowsIndex.length; i++) {
                    Object selectedRow = jTable1.getValueAt(selectedRowsIndex[i], 0);
                    int id_message = Integer.parseInt(selectedRow.toString());
                    if(!this.messagesController.sendToTrash(id_message)) {
                        errors++;
                    }                   
                }
                
                if(selectedRowsIndex.length == errors) {
                    alertsHelper.showAlert(__("Ups! and unexpected error has ocurred"), "error");
                } else if (errors == 0) {
                    alertsHelper.showAlert(__("Message(s) sent to trash correctly!"), "information");
                } else if(selectedRowsIndex.length > errors) {
                    alertsHelper.showAlert(__("Some message(s) sent to trash correctly, but others failed!"), "information");
                } 
                
                this.refresh();
            }
        } else {
            alertsHelper.showAlert(__("Please select a row"), "error");
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(jTable1.getSelectedRowCount() > 0) {
            int[] selectedRowsIndex = jTable1.getSelectedRows();
            int errors = 0;
            if(alertsHelper.showConfirm(__("Do you want to delete the message(s)?"), "question")) {
                for(int i = 0; i < selectedRowsIndex.length; i++) {
                    Object selectedRow = jTable1.getValueAt(selectedRowsIndex[i], 0);
                    int id_message = Integer.parseInt(selectedRow.toString());
                    if(!this.messagesController.deleteMessage(id_message)) {
                        errors++;
                    }                   
                }
                
                if(selectedRowsIndex.length == errors) {
                    alertsHelper.showAlert(__("Ups! and unexpected error has ocurred"), "error");
                } else if (errors == 0) {
                    alertsHelper.showAlert(__("Message(s) deleted correctly!"), "information");
                } else if(selectedRowsIndex.length > errors) {
                    alertsHelper.showAlert(__("Some message(s) deleted correctly, but others failed!"), "information");
                } 
                
                this.refresh();
            }
        } else {
            alertsHelper.showAlert(__("Please select a row"), "error");
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.refresh();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(jTable1.getSelectedRowCount() > 0) {
            int[] selectedRowsIndex = jTable1.getSelectedRows();
            int errors = 0;
            for(int i = 0; i < selectedRowsIndex.length; i++) {
                    Object selectedRow = jTable1.getValueAt(selectedRowsIndex[i], 0);
                    int id_message = Integer.parseInt(selectedRow.toString());
                    if(!this.messagesController.updateMessageState(id_message, "Read")) {
                        errors++;
                    }                   
                }
                if(selectedRowsIndex.length == errors) {
                    alertsHelper.showAlert(__("Ups! and unexpected error has ocurred"), "error");
                } else {
                    this.refresh();
                } 

        } else {
            alertsHelper.showAlert(__("Please select a row"), "error");
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}