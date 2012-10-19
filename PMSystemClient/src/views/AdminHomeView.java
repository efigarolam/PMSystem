/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminHomeView.java
 *
 * Created on 09-nov-2011, 20:45:21
 */
package views;

import PMSystem.ProjectData;
import PMSystem.TaskData;
import PMSystem.UserData;
import controllers.MainController;
import controllers.ProjectsController;
import controllers.TasksController;
import controllers.UsersController;
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
public class AdminHomeView extends AbstractIFrameView{
    
    private DefaultTableModel tModel;
    private ProjectsController projectsController;
    private TasksController tasksController;
    private UsersController usersController;

    
    /** Creates new form AdminHomeView */
    public AdminHomeView(String args[]) {
        this.projectsController = new ProjectsController(args);
        this.tasksController    = new TasksController(args);
        this.usersController    = new UsersController(args);
        initComponents();
        
    }
    
    public void translate() {
        jLabel1.setText(__("Welcome, ")+MainController.userOnlineName);
        jLabel2.setText(__("Latest Projects"));
        jLabel3.setText(__("Latest Tasks"));
        jLabel4.setText(__("Latest Users"));
        jLabel5.setText(__("Home"));
        jLabel6.setText(__("Edit profile"));
        jLabel24.setText(__("View online users"));
        jLabel7.setText(__("Users"));
        jLabel8.setText(__("New"));
        jLabel9.setText(__("Edit"));
        jLabel10.setText(__("Find"));
        jLabel11.setText(__("Projects"));
        jLabel12.setText(__("New"));
        jLabel13.setText(__("Edit"));
        jLabel14.setText(__("Find"));
        jLabel15.setText(__("Tasks"));
        jLabel18.setText(__("New"));
        jLabel17.setText(__("Edit"));
        jLabel16.setText(__("Find"));
        jLabel19.setText(__("Reports"));
        jLabel20.setText(__("General"));
        jLabel21.setText(__("Messages"));
        jLabel22.setText(__("New"));
        jLabel23.setText(__("Inbox"));
    }
    
    public void configure() {
        
        this.translate();
        
        /*
         * Loading last 5 projects
         */
        jMenuItem1  = new JMenuItem();
        jMenuItem2  = new JMenuItem();
        jMenuItem3  = new JMenuItem();
        jMenuItem4  = new JMenuItem();
        jMenuItem13 = new JMenuItem();
        jMenuItem15 = new JMenuItem();
        
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
        
        jMenuItem13.setText(__("Send message to leader"));
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        
        jMenuItem15.setText(__("View Gantt chart"));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
                
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jMenuItem2);
        jPopupMenu1.add(jMenuItem3);
        jPopupMenu1.add(jMenuItem4);
        jPopupMenu1.add(jMenuItem13);
        jPopupMenu1.add(jMenuItem15);
        
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        ProjectData[] projects = this.projectsController.getProjects("ID > '0' AND State = 'Active' ORDER BY ID DESC LIMIT 5");
        if(projects[0].id == 0) {
            tModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };

            tModel.addColumn(__("Projects"));
            String[] message = new String[1];
            message[0] = __("There are no projects, create a new one!");
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
            tModel.addColumn(__("ID_Leader"));
            tModel.addColumn(__("Name"));
            tModel.addColumn(__("Leader"));
            tModel.addColumn(__("Description"));
            tModel.addColumn(__("Start Date"));
            tModel.addColumn(__("End_Date"));
            tModel.addColumn(__("State"));

            String[] row = new String[8];
            for(int i = 0; i < projects.length; i++) {
                row[0] = Integer.toString(projects[i].id);
                row[1] = Integer.toString(projects[i].id_user);
                row[2] = projects[i].name;
                row[3] = projects[i].user_name;
                row[4] = projects[i].description;
                row[5] = projects[i].start_date;
                row[6] = projects[i].end_date;
                row[7] = projects[i].state;
                tModel.addRow(row);
            }

            jTable1.setModel(tModel);
        }
        
        /*
         * Loading Tasks
         */
        jMenuItem5 = new JMenuItem();
        jMenuItem6 = new JMenuItem();
        jMenuItem7 = new JMenuItem();
        jMenuItem8 = new JMenuItem();
        
        jMenuItem5.setText(__("Add"));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        
        jMenuItem6.setText(__("Edit"));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
                
        jMenuItem7.setText(__("Send to trash"));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        
        jMenuItem8.setText(__("Delete"));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
                
        jPopupMenu2.add(jMenuItem5);
        jPopupMenu2.add(jMenuItem6);
        jPopupMenu2.add(jMenuItem7);
        jPopupMenu2.add(jMenuItem8);
        
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        TaskData[] tasks = this.tasksController.getTasks("ID > '0' AND State != 'Inactive' ORDER BY ID DESC LIMIT 5");
        if(tasks[0].id == 0) {
            tModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };

            tModel.addColumn(__("Tasks"));
            String[] message = new String[1];
            message[0] = __("There are no tasks, create a new one!");
            tModel.addRow(message);
            jTable2.setModel(tModel);
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
            for(int i = 0; i < tasks.length; i++) {
                row[0] = Integer.toString(tasks[i].id);
                row[1] = tasks[i].title;
                row[2] = tasks[i].description;
                row[3] = tasks[i].project;
                String usersC = "";
                for(int j = 0; j < tasks[i].users.length; j++) {
                    usersC += tasks[i].users[j] + ", ";
                }
                row[4] = usersC;
                row[5] = tasks[i].start_date;
                row[6] = tasks[i].end_date;
                row[7] = Integer.toString(tasks[i].progress);
                row[8] = tasks[i].priority;
                row[9] = tasks[i].state;

                tModel.addRow(row);
            }

            jTable2.setModel(tModel);
        }
        
        /*
         * Loading Users
         */
        jMenuItem9  = new JMenuItem();
        jMenuItem10 = new JMenuItem();
        jMenuItem11 = new JMenuItem();
        jMenuItem12 = new JMenuItem();
        jMenuItem14 = new JMenuItem();
        
        jMenuItem9.setText(__("Add"));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        
        jMenuItem10.setText(__("Edit"));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
                
        jMenuItem11.setText(__("Send to trash"));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        
        jMenuItem12.setText(__("Delete"));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        
        jMenuItem14.setText(__("Send message"));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
                
        jPopupMenu3.add(jMenuItem9);
        jPopupMenu3.add(jMenuItem10);
        jPopupMenu3.add(jMenuItem11);
        jPopupMenu3.add(jMenuItem12);
        jPopupMenu3.add(jMenuItem14);
        
        jTable3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        UserData[] users = this.usersController.getUsers("ID > '0' AND State = 'Active' ORDER BY ID DESC LIMIT 5");
        if(users[0].id == 0) {
            tModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };

            tModel.addColumn(__("Users"));
            String[] message = new String[1];
            message[0] = __("There are no users, create a new one!");
            tModel.addRow(message);
            jTable3.setModel(tModel);
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
            for(int i = 0; i < users.length; i++) {
                row[0] = Integer.toString(users[i].id);
                row[1] = users[i].username;
                row[2] = users[i].privilege;
                row[3] = users[i].name;
                row[4] = users[i].email;
                row[5] = users[i].gender;
                row[6] = users[i].birthday;
                row[7] = users[i].location;
                row[8] = users[i].state;
                tModel.addRow(row);
            }

            jTable3.setModel(tModel);
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
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        jPopupMenu1.setInvoker(jTable1);

        jPopupMenu2.setInvoker(jTable2);

        jPopupMenu3.setInvoker(jTable3);

        setMaximumSize(new java.awt.Dimension(1081, 630));
        setMinimumSize(new java.awt.Dimension(1081, 630));
        setPreferredSize(new java.awt.Dimension(1081, 630));

        jPanel1.setMaximumSize(new java.awt.Dimension(1081, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(1081, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1081, 630));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setText("jLabel1");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setComponentPopupMenu(jPopupMenu2);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setComponentPopupMenu(jPopupMenu3);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel2.setText("Latest Projects:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel3.setText("Latest Tasks");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel4.setText("Latest Users");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel5.setText("Home");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel6.setForeground(new java.awt.Color(14, 137, 254));
        jLabel6.setText("Edit profile");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel7.setText("Users");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel8.setForeground(new java.awt.Color(14, 137, 254));
        jLabel8.setText("New");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel9.setForeground(new java.awt.Color(14, 137, 254));
        jLabel9.setText("Edit");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel10.setForeground(new java.awt.Color(14, 137, 254));
        jLabel10.setText("Find");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel11.setText("Projects");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel12.setForeground(new java.awt.Color(14, 137, 254));
        jLabel12.setText("New");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel13.setForeground(new java.awt.Color(14, 137, 254));
        jLabel13.setText("Edit");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel14.setForeground(new java.awt.Color(14, 137, 254));
        jLabel14.setText("Find");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel15.setText("Tasks");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel16.setForeground(new java.awt.Color(14, 137, 254));
        jLabel16.setText("Find");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel17.setForeground(new java.awt.Color(14, 137, 254));
        jLabel17.setText("Edit");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel18.setForeground(new java.awt.Color(14, 137, 254));
        jLabel18.setText("New");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel19.setText("Reports");

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel20.setForeground(new java.awt.Color(14, 137, 254));
        jLabel20.setText("General");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel21.setText("Messages");

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel22.setForeground(new java.awt.Color(14, 137, 254));
        jLabel22.setText("New");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel23.setForeground(new java.awt.Color(14, 137, 254));
        jLabel23.setText("Inbox");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel24.setForeground(new java.awt.Color(14, 137, 254));
        jLabel24.setText("View online users");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
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
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)))
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)))
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel16)))
                            .addComponent(jLabel19)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel20))
                            .addComponent(jLabel21)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22))))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.editProfile();
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.saveUser();
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.editUser(0);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.findUsers();
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.saveProject();
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.editProject(0);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.findProjects();
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.saveTask();
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.editTask(0);
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.findTasks();
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.generalReport();
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.sendMessage(0);
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.myMessages();
        }
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        if(evt.getButton() == 1) {
            MainController.adminView.usersOnline();
        }
    }//GEN-LAST:event_jLabel24MouseClicked
    
    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        MainController.adminView.saveProject();     
    }
    
    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
            int id_project = Integer.parseInt(selectedRow.toString());
            MainController.adminView.editProject(id_project); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(this.alertsHelper.showConfirm(__("Do you want to send to trash the project?"), "question")) {
                Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
                int id_project = Integer.parseInt(selectedRow.toString());
                if(this.projectsController.trashProject(id_project)) {
                    this.alertsHelper.showAlert(__("Project sent to trash correctly!"), "information");
                    MainController.adminView.home();
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
            if(this.alertsHelper.showConfirm(__("Do you want to delete the project?"), "question")) {
                Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
                int id_project = Integer.parseInt(selectedRow.toString());
                if(this.projectsController.deleteProject(id_project)) {
                    this.alertsHelper.showAlert(__("Project deleted correctly!"), "information");
                    MainController.adminView.home();
                } else {
                    this.alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }        
    }
    
    private void jMenuItem13ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 1);
            int id_user = Integer.parseInt(selectedRow.toString());
            MainController.adminView.sendMessage(id_user); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem15ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable1.getValueAt(selectedRowIndex, 0);
            int id_project = Integer.parseInt(selectedRow.toString());
            MainController.adminView.getGanttReport(id_project); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem5ActionPerformed(ActionEvent evt) {
        MainController.adminView.saveTask();     
    }
    
    private void jMenuItem6ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable2.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable2.getValueAt(selectedRowIndex, 0);
            int id_task = Integer.parseInt(selectedRow.toString());
            MainController.adminView.editTask(id_task); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem7ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable2.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(this.alertsHelper.showConfirm(__("Do you want to send to trash the task?"), "question")) {
                Object selectedRow = jTable2.getValueAt(selectedRowIndex, 0);
                int id_task = Integer.parseInt(selectedRow.toString());
                if(this.tasksController.trashTask(id_task)) {
                    this.alertsHelper.showAlert(__("Task sent to trash correctly!"), "information");
                    MainController.adminView.home();
                } else {
                    this.alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem8ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable2.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(this.alertsHelper.showConfirm(__("Do you want to delete the task?"), "question")) {
                Object selectedRow = jTable2.getValueAt(selectedRowIndex, 0);
                int id_task = Integer.parseInt(selectedRow.toString());
                if(this.tasksController.deleteTask(id_task)) {
                    this.alertsHelper.showAlert(__("Task deleted correctly!"), "information");
                    MainController.adminView.home();
                } else {
                    this.alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }        
    }
    
    private void jMenuItem9ActionPerformed(ActionEvent evt) {
        MainController.adminView.saveUser();     
    }
    
    private void jMenuItem10ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable3.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable3.getValueAt(selectedRowIndex, 0);
            int id_user = Integer.parseInt(selectedRow.toString());
            MainController.adminView.editUser(id_user); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem11ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable3.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(this.alertsHelper.showConfirm(__("Do you want to send to trash the user?"), "question")) {
                Object selectedRow = jTable3.getValueAt(selectedRowIndex, 0);
                int id_user = Integer.parseInt(selectedRow.toString());
                if(this.usersController.trashUser(id_user)) {
                    this.alertsHelper.showAlert(__("User sent to trash correctly!"), "information");
                    MainController.adminView.home();
                } else {
                    this.alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
    
    private void jMenuItem12ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable3.getSelectedRow();
        if(selectedRowIndex >= 0) {
            if(this.alertsHelper.showConfirm(__("Do you want to delete the user?"), "question")) {
                Object selectedRow = jTable3.getValueAt(selectedRowIndex, 0);
                int id_user = Integer.parseInt(selectedRow.toString());
                if(this.usersController.deleteUser(id_user)) {
                    this.alertsHelper.showAlert(__("User deleted correctly!"), "information");
                    MainController.adminView.home();
                } else {
                    this.alertsHelper.showAlert(__("Ups! an unexpected error has ocurred"), "error");
                }
            }
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }        
    }
    
    private void jMenuItem14ActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable3.getSelectedRow();
        if(selectedRowIndex >= 0) {
            Object selectedRow = jTable3.getValueAt(selectedRowIndex, 0);
            int id_user = Integer.parseInt(selectedRow.toString());
            MainController.adminView.sendMessage(id_user); 
        } else {
            this.alertsHelper.showAlert(__("Please select a row"), "error");
        }       
    }
        
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}