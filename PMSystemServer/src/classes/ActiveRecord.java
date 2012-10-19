package classes;

import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;

/*
 * ActiveRecord Class
 *
 * This class allow us to manage the db operations.
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 */

public class ActiveRecord {
    
    private Connection connection;
    private Statement query;
    private CallableStatement proc;
    private String host;
    private String user;
    private String password = "";
    private String prefix;
    private String table;
    private String fields;
    private String values;
    private String sql;
    private boolean result;
    private int count;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private HashMap row     = null;
    private ArrayList data  = null;
	
    public ActiveRecord(String host, String user, String password, String prefix) {
        this.host     = host;
        this.user     = user;
        this.password = password;
        this.prefix   = prefix;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.host,this.user, this.password);
            this.query = this.connection.createStatement();  
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setTable(String table, String fields) { 
        this.table = this.prefix + "_" + table;
        this.fields = fields;
    }

    public void setValues(String values) {
        this.values = values;
    }
	
    public boolean doInsert() {
        this.sql = "INSERT INTO " + this.table + " (" + this.fields + ") VALUES (" + this.values + ")";
        
        try {
            this.result = this.query.execute(this.sql);
            
            if(this.result) {
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
	
    public boolean doDelete(int ID) {
        this.sql = "DELETE FROM " + this.table + " WHERE ID = " + ID + "";

        try {
            this.result = this.query.execute(this.sql);
            
            if(result) {
                return false;
            } else {
                return true;
            } 
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }	
    }
	
    public boolean deleteBy(String field, String value) {
        this.sql = "DELETE FROM " + this.table + " WHERE " + field + " = " + value + "";

        try {
            this.result = this.query.execute(this.sql);

            if(result) {
                return true;
            } else {
                return false;
            } 
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean deleteBySQL(String sql) {
        this.sql = "DELETE FROM " + this.table + " WHERE " + sql + "";

        try {
            this.result = this.query.execute(this.sql);

            if(result) {
                return true;
            } else {
                return false;
            } 
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
	
    public boolean doUpdate(int ID) {
        this.sql = "UPDATE " + this.table + " SET " + this.values + " WHERE ID = " + ID + "";

        try {
            this.result = this.query.execute(this.sql);

            if(result) {
                return true;
            } else {
                return false;
            } 
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateBySQL(String sql) {
        this.sql = "UPDATE " + this.table + " SET " + this.values + " WHERE " + sql + "";

        try {
            this.result = this.query.execute(this.sql);

            if(result) {
                return true;
            } else {
                return false;
            } 
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
	
    public int countAll() {
        this.sql = "SELECT COUNT(*) FROM " + this.table + "";

        try {
            this.rs = this.query.executeQuery(this.sql);

            if(this.rs.next()) {
                return this.rs.getInt(1);
            } else {
                return 0;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int countBySQL(String sql) {
        this.sql = "SELECT COUNT(*) FROM " + this.table + " WHERE " + sql + "";

        try {
            this.rs = this.query.executeQuery(this.sql);

            if(this.rs.next()) {
                return this.rs.getInt(1);
            } else {
                return 0;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }		
    }
	
    public ArrayList find(int ID) {
        this.sql = "SELECT " + this.fields + " FROM " + this.table + " WHERE ID = " + ID + "";

        try {
            this.rs = this.query.executeQuery(this.sql);

            if(this.rs.next()) {
                this.rs.beforeFirst();
                this.rsmd = this.rs.getMetaData();

                this.data = new ArrayList();
                
                while(this.rs.next()) {
                    this.row = new HashMap();
                    for(int i = 1; i <= this.rsmd.getColumnCount(); i++) {
                        this.row.put(this.rsmd.getColumnLabel(i), this.rs.getObject(i));
                    }

                    this.data.add(this.row);
                }

                return this.data;
            } else {
                return null;
            }
        } catch(Exception e) {
                System.out.println(e.getMessage());
                return null;
        }
    }
	
    public ArrayList findBySQL(String sql) {
        this.sql = "SELECT " + this.fields + " FROM " + this.table + " WHERE " + sql + "";

        try {
            this.rs = this.query.executeQuery(this.sql);

            if(this.rs.next()) {
                this.rs.beforeFirst();
                this.rsmd = this.rs.getMetaData();

                this.data = new ArrayList();

                while(this.rs.next()) {
                    this.row = new HashMap();
                    for(int i = 1; i <= this.rsmd.getColumnCount(); i++) {
                        this.row.put(this.rsmd.getColumnLabel(i), this.rs.getObject(i));
                    }

                    this.data.add(this.row);
                }   
                
                return this.data;
            } else {
                return null;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
	
    public ArrayList findAll() {
        this.sql = "SELECT " + this.fields + " FROM " + this.table + "";

        try {
            this.rs = this.query.executeQuery(this.sql);

            if(this.rs.next()) {
                this.rs.beforeFirst();
                this.rsmd = this.rs.getMetaData();

                this.data = new ArrayList();

                while(this.rs.next()) {
                    this.row = new HashMap();
                    for(int i = 1; i <= this.rsmd.getColumnCount(); i++) {
                        this.row.put(this.rsmd.getColumnLabel(i), this.rs.getObject(i));
                    }

                    this.data.add(this.row);
                }

                return this.data;
            } else {
                return null;
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
	
    public ArrayList call(String procedure, String params) {
        try {
            String strCall = "{call "+procedure+"("+params+")}";

            this.proc = this.connection.prepareCall(strCall);
            this.proc.execute();
            this.rs = this.proc.getResultSet();

            if(this.rs.next()) {
                this.rs.beforeFirst();
                this.rsmd = this.rs.getMetaData();

                this.data = new ArrayList();

                while(this.rs.next()) {
                    this.row = new HashMap();
                    for(int i = 1; i <= this.rsmd.getColumnCount(); i++) {
                        this.row.put(this.rsmd.getColumnLabel(i), this.rs.getObject(i));
                    }

                    this.data.add(this.row);
                }

                return this.data;
            } else {
                return null;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public int getIDBy(String field, String value) {
        this.sql = "SELECT ID FROM " + this.table + " WHERE " + field + " = '"+ value +"'";
        
        try {
            this.rs = this.query.executeQuery(this.sql);

            if(this.rs.next()) {
                return this.rs.getInt(1);
            } else {
                return 0;
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int getLastID() {
        this.sql = "SELECT ID FROM " + this.table + " ORDER BY ID DESC LIMIT 1";
        
        try {
            this.rs = this.query.executeQuery(this.sql);

            if(this.rs.next()) {
                return this.rs.getInt(1);
            } else {
                return 0;
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
	
    public int save(int ID) {
        if(ID == 0) {
            this.doInsert();
            return this.getLastID();
        } else {
            this.doUpdate(ID);
            return ID;
        }
    }
    
}