package PMSystem;


/**
* PMSystem/OnlineUsersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H59' CST
*/

public final class OnlineUsersHolder implements org.omg.CORBA.portable.Streamable
{
  public PMSystem.UsersOnlineInfo value[] = null;

  public OnlineUsersHolder ()
  {
  }

  public OnlineUsersHolder (PMSystem.UsersOnlineInfo[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PMSystem.OnlineUsersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PMSystem.OnlineUsersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PMSystem.OnlineUsersHelper.type ();
  }

}
