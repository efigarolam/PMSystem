/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
    
/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class EmailHelper implements Runnable {
    
    private Session session;
    private Properties config;
    private String to, from, subject, message;
    
    public EmailHelper() {
        this.config = new Properties();
        
        this.config.setProperty("mail.smtp.host", "smtp.gmail.com");
        this.config.setProperty("mail.smtp.starttls.enable", "true");
        this.config.setProperty("mail.smtp.port","587");
        this.config.setProperty("mail.smtp.user", "projectme.notifier.system@gmail.com");
        this.config.setProperty("mail.smtp.auth", "true");
            
        this.session = Session.getDefaultInstance(this.config);
    }
    
    @Override
    public void run() {
        this.sendEmail();
    }
    
    public void setEmail(String to, String from, String subject, String message) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.message = message;
    }
    
    public void sendEmail() {
        try {
            MimeMessage email = new MimeMessage(this.session);

            email.setFrom(new InternetAddress("projectme.notifier.system@gmail.com"));
            email.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
            email.setSubject(this.subject);
            email.setText(this.from + " send you this message: \n\n" + this.message + "\n\n\n----------\n\nDo not respond this email, is an automatic email.");
            
            Transport t = this.session.getTransport("smtp");

            t.connect("projectme.notifier.system@gmail.com","pmsystem2011");
            t.sendMessage(email, email.getAllRecipients());
            
            t.close();
        } catch(MessagingException e) {
            System.out.println(e.getMessage());
        }       
   }
}