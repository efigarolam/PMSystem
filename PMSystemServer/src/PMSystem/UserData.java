package PMSystem;


/**
* PMSystem/UserData.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H25' CST
*/

public final class UserData implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public String username = null;
  public String password = null;
  public String privilege = null;
  public String name = null;
  public String email = null;
  public String gender = null;
  public String birthday = null;
  public String location = null;
  public String state = null;

  public UserData ()
  {
  } // ctor

  public UserData (int _id, String _username, String _password, String _privilege, String _name, String _email, String _gender, String _birthday, String _location, String _state)
  {
    id = _id;
    username = _username;
    password = _password;
    privilege = _privilege;
    name = _name;
    email = _email;
    gender = _gender;
    birthday = _birthday;
    location = _location;
    state = _state;
  } // ctor

} // class UserData
