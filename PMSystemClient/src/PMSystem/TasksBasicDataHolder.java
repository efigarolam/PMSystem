package PMSystem;

/**
* PMSystem/TasksBasicDataHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H59' CST
*/

public final class TasksBasicDataHolder implements org.omg.CORBA.portable.Streamable
{
  public PMSystem.TasksBasicData value = null;

  public TasksBasicDataHolder ()
  {
  }

  public TasksBasicDataHolder (PMSystem.TasksBasicData initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PMSystem.TasksBasicDataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PMSystem.TasksBasicDataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PMSystem.TasksBasicDataHelper.type ();
  }

}
