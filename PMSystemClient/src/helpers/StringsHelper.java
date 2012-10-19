/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.regex.*;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class StringsHelper {
    
    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{1,9}.)+[a-zA-Z]{2,3})$");
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()) {
            return true;
        } else {
            return false;
        }
    } 
    
    public boolean isEmpty(String str, int minLength) {
        if("".equals(str) || str.length() < minLength) {
            return false;
        } else {
            return true;
        }
    }
    
    public String clean(String str) {
        return str.replace("\\", "\\\\").replace("'", "\\'");
    }
    
    public String encrypt(String str, int force) {
        if(force == 0) {
            SecurityHelper sh = new SecurityHelper();
            return sh.getMD5(str);
        } else if(force == 1) {
            SecurityHelper sh = new SecurityHelper();
            return sh.getSHA1(sh.getMD5(str));
        } else if(force == 2) {
            SecurityHelper sh = new SecurityHelper();
            return sh.getSHA1(sh.getMD5(sh.getSHA1(sh.getMD5(str))));
        } else {
            return null;
        }
    }
}