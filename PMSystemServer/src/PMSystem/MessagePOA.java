package PMSystem;


/**
* PMSystem/MessagePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H25' CST
*/

public abstract class MessagePOA extends org.omg.PortableServer.Servant
 implements PMSystem.MessageOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("sendMessage", new java.lang.Integer (0));
    _methods.put ("updateState", new java.lang.Integer (1));
    _methods.put ("trash", new java.lang.Integer (2));
    _methods.put ("restore", new java.lang.Integer (3));
    _methods.put ("delete", new java.lang.Integer (4));
    _methods.put ("areNewMessages", new java.lang.Integer (5));
    _methods.put ("getMessage", new java.lang.Integer (6));
    _methods.put ("getTrashMessages", new java.lang.Integer (7));
    _methods.put ("getInboxMessages", new java.lang.Integer (8));
    _methods.put ("getOutboxMessages", new java.lang.Integer (9));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // PMSystem/Message/sendMessage
       {
         int sender = in.read_long ();
         int receiver = in.read_long ();
         String subject = in.read_string ();
         String message = in.read_string ();
         String date = in.read_string ();
         String state = in.read_string ();
         boolean $result = false;
         $result = this.sendMessage (sender, receiver, subject, message, date, state);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // PMSystem/Message/updateState
       {
         int id = in.read_long ();
         String state = in.read_string ();
         boolean $result = false;
         $result = this.updateState (id, state);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // PMSystem/Message/trash
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.trash (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // PMSystem/Message/restore
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.restore (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // PMSystem/Message/delete
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.delete (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 5:  // PMSystem/Message/areNewMessages
       {
         int receiver = in.read_long ();
         int $result = (int)0;
         $result = this.areNewMessages (receiver);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 6:  // PMSystem/Message/getMessage
       {
         int id = in.read_long ();
         PMSystem.MessageData $result = null;
         $result = this.getMessage (id);
         out = $rh.createReply();
         PMSystem.MessageDataHelper.write (out, $result);
         break;
       }

       case 7:  // PMSystem/Message/getTrashMessages
       {
         int id_user = in.read_long ();
         PMSystem.MessageData $result[] = null;
         $result = this.getTrashMessages (id_user);
         out = $rh.createReply();
         PMSystem.MessagesHelper.write (out, $result);
         break;
       }

       case 8:  // PMSystem/Message/getInboxMessages
       {
         int id_user = in.read_long ();
         PMSystem.MessageData $result[] = null;
         $result = this.getInboxMessages (id_user);
         out = $rh.createReply();
         PMSystem.MessagesHelper.write (out, $result);
         break;
       }

       case 9:  // PMSystem/Message/getOutboxMessages
       {
         int id_user = in.read_long ();
         PMSystem.MessageData $result[] = null;
         $result = this.getOutboxMessages (id_user);
         out = $rh.createReply();
         PMSystem.MessagesHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:PMSystem/Message:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Message _this() 
  {
    return MessageHelper.narrow(
    super._this_object());
  }

  public Message _this(org.omg.CORBA.ORB orb) 
  {
    return MessageHelper.narrow(
    super._this_object(orb));
  }


} // class MessagePOA
