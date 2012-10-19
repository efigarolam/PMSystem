/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class SecurityHelper {
    
    private MessageDigest encrypter;
    private byte[] buffer;
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String getSHA1(String str) {
        try {
            encrypter = MessageDigest.getInstance("SHA1");
            buffer = encrypter.digest(str.getBytes());
            StringBuilder sb = new StringBuilder(2 * buffer.length);
            for (int i = 0; i < buffer.length; i++) {
                int low = (int)(buffer[i] & 0x0f);
                int high = (int)((buffer[i] & 0xf0) >> 4);
                sb.append(hex[high]);
                sb.append(hex[low]);
            }
            return sb.toString();
        } catch(NoSuchAlgorithmException e) {
            return null;
        }        
    }
    
    public String getMD5(String str) {
        try {
            encrypter = MessageDigest.getInstance("MD5");
            buffer = encrypter.digest(str.getBytes());
            StringBuilder sb = new StringBuilder(2 * buffer.length);
            for (int i = 0; i < buffer.length; i++) {
                int low = (int)(buffer[i] & 0x0f);
                int high = (int)((buffer[i] & 0xf0) >> 4);
                sb.append(hex[high]);
                sb.append(hex[low]);
            }
            return sb.toString();
        } catch(NoSuchAlgorithmException e) {
            return null;
        }
    }
    
}