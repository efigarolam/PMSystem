package PMSystem;

/**
* PMSystem/UserDataHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H25' CST
*/

public final class UserDataHolder implements org.omg.CORBA.portable.Streamable
{
  public PMSystem.UserData value = null;

  public UserDataHolder ()
  {
  }

  public UserDataHolder (PMSystem.UserData initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PMSystem.UserDataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PMSystem.UserDataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PMSystem.UserDataHelper.type ();
  }

}