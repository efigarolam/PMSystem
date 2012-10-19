package PMSystem;


/**
* PMSystem/ProjectPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H25' CST
*/

public abstract class ProjectPOA extends org.omg.PortableServer.Servant
 implements PMSystem.ProjectOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("setProject", new java.lang.Integer (0));
    _methods.put ("updateProject", new java.lang.Integer (1));
    _methods.put ("getAllProjects", new java.lang.Integer (2));
    _methods.put ("getProject", new java.lang.Integer (3));
    _methods.put ("getProjects", new java.lang.Integer (4));
    _methods.put ("trash", new java.lang.Integer (5));
    _methods.put ("delete", new java.lang.Integer (6));
    _methods.put ("restore", new java.lang.Integer (7));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // PMSystem/Project/setProject
       {
         int id_user = in.read_long ();
         String name = in.read_string ();
         String description = in.read_string ();
         String start_date = in.read_string ();
         String end_date = in.read_string ();
         String state = in.read_string ();
         int $result = (int)0;
         $result = this.setProject (id_user, name, description, start_date, end_date, state);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // PMSystem/Project/updateProject
       {
         int id = in.read_long ();
         int id_user = in.read_long ();
         String name = in.read_string ();
         String description = in.read_string ();
         String start_date = in.read_string ();
         String end_date = in.read_string ();
         String state = in.read_string ();
         int $result = (int)0;
         $result = this.updateProject (id, id_user, name, description, start_date, end_date, state);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // PMSystem/Project/getAllProjects
       {
         PMSystem.ProjectsBasicData $result[] = null;
         $result = this.getAllProjects ();
         out = $rh.createReply();
         PMSystem.ProjectsListHelper.write (out, $result);
         break;
       }

       case 3:  // PMSystem/Project/getProject
       {
         int id = in.read_long ();
         PMSystem.ProjectData $result = null;
         $result = this.getProject (id);
         out = $rh.createReply();
         PMSystem.ProjectDataHelper.write (out, $result);
         break;
       }

       case 4:  // PMSystem/Project/getProjects
       {
         String str = in.read_string ();
         PMSystem.ProjectData $result[] = null;
         $result = this.getProjects (str);
         out = $rh.createReply();
         PMSystem.ProjectsInfoHelper.write (out, $result);
         break;
       }

       case 5:  // PMSystem/Project/trash
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.trash (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 6:  // PMSystem/Project/delete
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.delete (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 7:  // PMSystem/Project/restore
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.restore (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:PMSystem/Project:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Project _this() 
  {
    return ProjectHelper.narrow(
    super._this_object());
  }

  public Project _this(org.omg.CORBA.ORB orb) 
  {
    return ProjectHelper.narrow(
    super._this_object(orb));
  }


} // class ProjectPOA
