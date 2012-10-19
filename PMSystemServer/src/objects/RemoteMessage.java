/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import PMSystem.*;
import org.omg.CORBA.*;

/**
 *
 * @author Eduardo Figarola Mota <eduardofigarola@gmail.com>
 * @author Eneida Montserrat Sánchez Larios <eneida430@gmail.com>
 */
public class RemoteMessage extends MessagePOA {
    private ORB orb;
	
    public void setORB(ORB orb_val) {
        this.orb = orb_val;
    }

    @Override
    public boolean sendMessage(int sender, int receiver, String subject, String message, String date, String state) {
        AbstractMessage msg = new AbstractMessage();
        
        msg.setID_Sender(sender);
        msg.setID_Receiver(receiver);
        msg.setSubject(subject);
        msg.setMessage(message);
        msg.setDate(date);
        msg.setState(state);
        
        msg.sendMessage();
        
        if(msg.getID() > 0) {
            return true;
        } else {
            return false;
        }        
    }

    @Override
    public MessageData[] getInboxMessages(int id_user) {
        MessageData[] messages;
        
        AbstractMessage msg = new AbstractMessage();
        AbstractMessage list[];
        
        msg.setID_Receiver(id_user);
        list = msg.getInboxMessages();
        
        if(list != null) {
            messages = new MessageData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                messages[i] = new MessageData();
                messages[i].id          = list[i].getID();
                messages[i].id_sender   = list[i].getID_Sender();
                messages[i].id_receiver = list[i].getID_Receiver();
                messages[i].sender      = list[i].getSender();
                messages[i].receiver    = list[i].getReceiver();
                messages[i].subject     = list[i].getSubject();
                messages[i].message     = list[i].getMessage();
                messages[i].date        = list[i].getDate();
                messages[i].state       = list[i].getState();
            }
        } else {
            messages   = new MessageData[1];
            messages[0] = new MessageData();
            messages[0].id          = 0;
            messages[0].id_sender   = 0;
            messages[0].id_receiver = 0;
            messages[0].sender      = "";
            messages[0].receiver    = "";
            messages[0].subject     = "";
            messages[0].message     = "";
            messages[0].date        = "";
            messages[0].state       = "";
        }
        
        return messages;
    }

    @Override
    public MessageData[] getOutboxMessages(int id_user) {
        MessageData[] messages;
        
        AbstractMessage msg = new AbstractMessage();
        AbstractMessage list[];
        
        msg.setID_Sender(id_user);
        list = msg.getOutboxMessages();
        
        if(list != null) {
            messages = new MessageData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                messages[i] = new MessageData();
                messages[i].id          = list[i].getID();
                messages[i].id_sender   = list[i].getID_Sender();
                messages[i].id_receiver = list[i].getID_Receiver();
                messages[i].sender      = list[i].getSender();
                messages[i].receiver    = list[i].getReceiver();
                messages[i].subject     = list[i].getSubject();
                messages[i].message     = list[i].getMessage();
                messages[i].date        = list[i].getDate();
                messages[i].state       = list[i].getState();
            }
        } else {
            messages   = new MessageData[1];
            messages[0] = new MessageData();
            messages[0].id          = 0;
            messages[0].id_sender   = 0;
            messages[0].id_receiver = 0;
            messages[0].sender      = "";
            messages[0].receiver    = "";
            messages[0].subject     = "";
            messages[0].message     = "";
            messages[0].date        = "";
            messages[0].state       = "";
        }
        
        return messages;
    }

    @Override
    public boolean updateState(int id, String state) {
        AbstractMessage message = new AbstractMessage();
        
        message.setID(id);
        message.setState(state);
        
        return message.updateState();
    }

    @Override
    public boolean trash(int id) {
        AbstractMessage message = new AbstractMessage();
        message.setID(id);
        
        return message.trash();
    }

    @Override
    public boolean delete(int id) {
        AbstractMessage message = new AbstractMessage();
        message.setID(id);
        
        return message.delete();
    }

    @Override
    public MessageData getMessage(int id) {
        AbstractMessage message = new AbstractMessage();
        message.getByID(id);
        
        MessageData msg = new MessageData();
        
        msg.id = message.getID();
        msg.id_sender = message.getID_Sender();
        msg.id_receiver = message.getID_Receiver();
        msg.sender = message.getSender();
        msg.receiver = message.getReceiver();
        msg.subject = message.getSubject();
        msg.message = message.getMessage();
        msg.date = message.getDate();
        msg.state = message.getState();
        
        return msg;
    }

    @Override
    public boolean restore(int id) {
        AbstractMessage message = new AbstractMessage();
        message.setID(id);
        
        return message.restore();
    }

    @Override
    public MessageData[] getTrashMessages(int id_user) {
        MessageData[] messages;
        
        AbstractMessage msg = new AbstractMessage();
        AbstractMessage list[];
        
        msg.setID_Sender(id_user);
        list = msg.getTrashMessages();
        
        if(list != null) {
            messages = new MessageData[list.length];
        
            for(int i = 0; i < list.length; i++) {
                messages[i] = new MessageData();
                messages[i].id          = list[i].getID();
                messages[i].id_sender   = list[i].getID_Sender();
                messages[i].id_receiver = list[i].getID_Receiver();
                messages[i].sender      = list[i].getSender();
                messages[i].receiver    = list[i].getReceiver();
                messages[i].subject     = list[i].getSubject();
                messages[i].message     = list[i].getMessage();
                messages[i].date        = list[i].getDate();
                messages[i].state       = list[i].getState();
            }
        } else {
            messages   = new MessageData[1];
            messages[0] = new MessageData();
            messages[0].id          = 0;
            messages[0].id_sender   = 0;
            messages[0].id_receiver = 0;
            messages[0].sender      = "";
            messages[0].receiver    = "";
            messages[0].subject     = "";
            messages[0].message     = "";
            messages[0].date        = "";
            messages[0].state       = "";
        }
        
        return messages;
    }

    @Override
    public int areNewMessages(int receiver) {
        AbstractMessage result = new AbstractMessage();
        result.setID_Receiver(receiver);
        return result.countUnread();
    }
    
}