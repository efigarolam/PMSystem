package PMSystem;

/**
* PMSystem/ProjectsBasicDataHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H25' CST
*/

public final class ProjectsBasicDataHolder implements org.omg.CORBA.portable.Streamable
{
  public PMSystem.ProjectsBasicData value = null;

  public ProjectsBasicDataHolder ()
  {
  }

  public ProjectsBasicDataHolder (PMSystem.ProjectsBasicData initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PMSystem.ProjectsBasicDataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PMSystem.ProjectsBasicDataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PMSystem.ProjectsBasicDataHelper.type ();
  }

}
