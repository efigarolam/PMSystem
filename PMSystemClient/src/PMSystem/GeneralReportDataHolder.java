package PMSystem;

/**
* PMSystem/GeneralReportDataHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H59' CST
*/

public final class GeneralReportDataHolder implements org.omg.CORBA.portable.Streamable
{
  public PMSystem.GeneralReportData value = null;

  public GeneralReportDataHolder ()
  {
  }

  public GeneralReportDataHolder (PMSystem.GeneralReportData initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PMSystem.GeneralReportDataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PMSystem.GeneralReportDataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PMSystem.GeneralReportDataHelper.type ();
  }

}
