package PMSystem;


/**
* PMSystem/UserPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H59' CST
*/

public abstract class UserPOA extends org.omg.PortableServer.Servant
 implements PMSystem.UserOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("setUser", new java.lang.Integer (0));
    _methods.put ("updateUser", new java.lang.Integer (1));
    _methods.put ("getAllUsers", new java.lang.Integer (2));
    _methods.put ("getUsers", new java.lang.Integer (3));
    _methods.put ("getUser", new java.lang.Integer (4));
    _methods.put ("login", new java.lang.Integer (5));
    _methods.put ("logout", new java.lang.Integer (6));
    _methods.put ("getSessionData", new java.lang.Integer (7));
    _methods.put ("trash", new java.lang.Integer (8));
    _methods.put ("delete", new java.lang.Integer (9));
    _methods.put ("restore", new java.lang.Integer (10));
    _methods.put ("getOnlineUsers", new java.lang.Integer (11));
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
       case 0:  // PMSystem/User/setUser
       {
         String username = in.read_string ();
         String password = in.read_string ();
         String privilege = in.read_string ();
         String name = in.read_string ();
         String email = in.read_string ();
         String gender = in.read_string ();
         String birthday = in.read_string ();
         String location = in.read_string ();
         String state = in.read_string ();
         int $result = (int)0;
         $result = this.setUser (username, password, privilege, name, email, gender, birthday, location, state);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // PMSystem/User/updateUser
       {
         int id = in.read_long ();
         String username = in.read_string ();
         String password = in.read_string ();
         String privilege = in.read_string ();
         String name = in.read_string ();
         String email = in.read_string ();
         String gender = in.read_string ();
         String birthday = in.read_string ();
         String location = in.read_string ();
         String state = in.read_string ();
         int $result = (int)0;
         $result = this.updateUser (id, username, password, privilege, name, email, gender, birthday, location, state);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // PMSystem/User/getAllUsers
       {
         PMSystem.UsersBasicData $result[] = null;
         $result = this.getAllUsers ();
         out = $rh.createReply();
         PMSystem.UsersListHelper.write (out, $result);
         break;
       }

       case 3:  // PMSystem/User/getUsers
       {
         String str = in.read_string ();
         PMSystem.UserData $result[] = null;
         $result = this.getUsers (str);
         out = $rh.createReply();
         PMSystem.UsersInfoHelper.write (out, $result);
         break;
       }

       case 4:  // PMSystem/User/getUser
       {
         int id = in.read_long ();
         PMSystem.UserData $result = null;
         $result = this.getUser (id);
         out = $rh.createReply();
         PMSystem.UserDataHelper.write (out, $result);
         break;
       }

       case 5:  // PMSystem/User/login
       {
         String username = in.read_string ();
         String password = in.read_string ();
         String time = in.read_string ();
         boolean $result = false;
         $result = this.login (username, password, time);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 6:  // PMSystem/User/logout
       {
         int id = in.read_long ();
         String time = in.read_string ();
         this.logout (id, time);
         out = $rh.createReply();
         break;
       }

       case 7:  // PMSystem/User/getSessionData
       {
         String username = in.read_string ();
         String $result[] = null;
         $result = this.getSessionData (username);
         out = $rh.createReply();
         PMSystem.SessionDataHelper.write (out, $result);
         break;
       }

       case 8:  // PMSystem/User/trash
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.trash (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 9:  // PMSystem/User/delete
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.delete (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 10:  // PMSystem/User/restore
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.restore (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 11:  // PMSystem/User/getOnlineUsers
       {
         PMSystem.UsersOnlineInfo $result[] = null;
         $result = this.getOnlineUsers ();
         out = $rh.createReply();
         PMSystem.OnlineUsersHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:PMSystem/User:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public User _this() 
  {
    return UserHelper.narrow(
    super._this_object());
  }

  public User _this(org.omg.CORBA.ORB orb) 
  {
    return UserHelper.narrow(
    super._this_object(orb));
  }


} // class UserPOA