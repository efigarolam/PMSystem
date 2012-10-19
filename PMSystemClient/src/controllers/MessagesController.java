/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import PMSystem.MessageData;
import models.MessagesModel;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 * @author Ana Alicia González Mendieta <anaglezmta@gmail.com>
 * @author Joel Hernández Gutiérrez <joel.hernandezg@gmail.com>
 */
public class MessagesController extends AbstractController {
    
    private MessagesModel model;
    
    public MessagesController(String args[]) {
        this.model = new MessagesModel(args, "Message");
    }
    
    public String[] sendMessage(int sender, int receiver, String subject, String msg, String date, String state, boolean email) {
        return this.model.sendMessage(sender, receiver, subject, msg, date, state, email);
    }
    
    public MessageData[] getInboxMessages(int id_user) {
        return this.model.getInboxMessages(id_user);
    }
    
    public MessageData[] getOutboxMessages(int id_user) {
        return this.model.getOutboxMessages(id_user);
    }
    
    public MessageData[] getTrashMessages(int id_user) {
        return this.model.getTrashMessages(id_user);
    }
    
    public MessageData getMessage(int id) {
        return this.model.getMessage(id);
    }
    
    public boolean updateMessageState(int id, String state) {
        return this.model.updateMessageState(id, state);
    }
    
    public boolean sendToTrash(int id) {
        return this.model.sendToTrash(id);
    }
    
    public boolean deleteMessage(int id) {
        return this.model.deleteMessage(id);
    }
    
    public boolean restoreMessage(int id) {
        return this.model.restoreMessage(id);
    }
    
    public int countNewMessages(int receiver) {
        return this.model.countNewMessages(receiver);
    }
}