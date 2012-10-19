/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class TimeHelper {
    private Calendar date;
    private SimpleDateFormat dateFormat;
    
    public String getActualTime() {
        this.date = GregorianCalendar.getInstance();        
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        return this.dateFormat.format(this.date.getTime());       
    }
    
    public String getPastTime(int days) {
        this.date = GregorianCalendar.getInstance();
        this.date.add(Calendar.DAY_OF_MONTH, days);
        this.date.set(Calendar.HOUR_OF_DAY, 24);
        this.date.set(Calendar.MINUTE, 0);
        this.date.set(Calendar.SECOND, 0);
        
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        return this.dateFormat.format(this.date.getTime());
    }
    
    public String getDateString(Date date) {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        if(date != null) {
           return this.dateFormat.format(date);  
        } else {
            return "";
        }
        
    }
    
    public boolean validateStartEnd(Date start, Date end) {
        if(start.compareTo(end) > 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public Date toDate(String date) {
        try {
            this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            return this.dateFormat.parse(date); 
        } catch(java.text.ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }        
    }
    
}