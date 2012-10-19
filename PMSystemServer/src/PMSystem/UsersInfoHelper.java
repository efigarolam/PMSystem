package PMSystem;


/**
* PMSystem/UsersInfoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H25' CST
*/

abstract public class UsersInfoHelper
{
  private static String  _id = "IDL:PMSystem/UsersInfo:1.0";

  public static void insert (org.omg.CORBA.Any a, PMSystem.UserData[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static PMSystem.UserData[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = PMSystem.UserDataHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (PMSystem.UsersInfoHelper.id (), "UsersInfo", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static PMSystem.UserData[] read (org.omg.CORBA.portable.InputStream istream)
  {
    PMSystem.UserData value[] = null;
    int _len0 = istream.read_long ();
    value = new PMSystem.UserData[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = PMSystem.UserDataHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, PMSystem.UserData[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      PMSystem.UserDataHelper.write (ostream, value[_i0]);
  }

}
