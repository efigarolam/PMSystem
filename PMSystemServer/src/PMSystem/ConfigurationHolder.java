package PMSystem;

/**
* PMSystem/ConfigurationHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H25' CST
*/

public final class ConfigurationHolder implements org.omg.CORBA.portable.Streamable
{
  public PMSystem.Configuration value = null;

  public ConfigurationHolder ()
  {
  }

  public ConfigurationHolder (PMSystem.Configuration initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PMSystem.ConfigurationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PMSystem.ConfigurationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PMSystem.ConfigurationHelper.type ();
  }

}
