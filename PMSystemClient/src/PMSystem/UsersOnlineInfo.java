package PMSystem;


/**
* PMSystem/UsersOnlineInfo.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H59' CST
*/

public final class UsersOnlineInfo implements org.omg.CORBA.portable.IDLEntity
{
  public int id_user = (int)0;
  public String username = null;
  public String privilege = null;
  public String location = null;
  public String start_date = null;
  public String state = null;

  public UsersOnlineInfo ()
  {
  } // ctor

  public UsersOnlineInfo (int _id_user, String _username, String _privilege, String _location, String _start_date, String _state)
  {
    id_user = _id_user;
    username = _username;
    privilege = _privilege;
    location = _location;
    start_date = _start_date;
    state = _state;
  } // ctor

} // class UsersOnlineInfo