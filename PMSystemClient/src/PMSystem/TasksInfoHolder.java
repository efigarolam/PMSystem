package PMSystem;


/**
* PMSystem/TasksInfoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H59' CST
*/

public final class TasksInfoHolder implements org.omg.CORBA.portable.Streamable
{
  public PMSystem.TaskData value[] = null;

  public TasksInfoHolder ()
  {
  }

  public TasksInfoHolder (PMSystem.TaskData[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PMSystem.TasksInfoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PMSystem.TasksInfoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PMSystem.TasksInfoHelper.type ();
  }

}
