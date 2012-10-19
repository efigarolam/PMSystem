package PMSystem;


/**
* PMSystem/UserOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H59' CST
*/

public interface UserOperations 
{
  int setUser (String username, String password, String privilege, String name, String email, String gender, String birthday, String location, String state);
  int updateUser (int id, String username, String password, String privilege, String name, String email, String gender, String birthday, String location, String state);
  PMSystem.UsersBasicData[] getAllUsers ();
  PMSystem.UserData[] getUsers (String str);
  PMSystem.UserData getUser (int id);
  boolean login (String username, String password, String time);
  void logout (int id, String time);
  String[] getSessionData (String username);
  boolean trash (int id);
  boolean delete (int id);
  boolean restore (int id);
  PMSystem.UsersOnlineInfo[] getOnlineUsers ();
} // interface UserOperations
