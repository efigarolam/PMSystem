package PMSystem;


/**
* PMSystem/TaskPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PMSystem.idl
* domingo 27 de noviembre de 2011 08H25' CST
*/

public abstract class TaskPOA extends org.omg.PortableServer.Servant
 implements PMSystem.TaskOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("setTask", new java.lang.Integer (0));
    _methods.put ("updateTask", new java.lang.Integer (1));
    _methods.put ("updateProgress", new java.lang.Integer (2));
    _methods.put ("getAllTasks", new java.lang.Integer (3));
    _methods.put ("getTask", new java.lang.Integer (4));
    _methods.put ("getTasks", new java.lang.Integer (5));
    _methods.put ("getTasksByUser", new java.lang.Integer (6));
    _methods.put ("trash", new java.lang.Integer (7));
    _methods.put ("delete", new java.lang.Integer (8));
    _methods.put ("restore", new java.lang.Integer (9));
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
       case 0:  // PMSystem/Task/setTask
       {
         int id_project = in.read_long ();
         String users[] = PMSystem.usersnamesHelper.read (in);
         String title = in.read_string ();
         String description = in.read_string ();
         String start_date = in.read_string ();
         String end_date = in.read_string ();
         int progress = in.read_long ();
         String priority = in.read_string ();
         String state = in.read_string ();
         int $result = (int)0;
         $result = this.setTask (id_project, users, title, description, start_date, end_date, progress, priority, state);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // PMSystem/Task/updateTask
       {
         int id = in.read_long ();
         int id_project = in.read_long ();
         String users[] = PMSystem.usersnamesHelper.read (in);
         String title = in.read_string ();
         String description = in.read_string ();
         String start_date = in.read_string ();
         String end_date = in.read_string ();
         int progress = in.read_long ();
         String priority = in.read_string ();
         String state = in.read_string ();
         int $result = (int)0;
         $result = this.updateTask (id, id_project, users, title, description, start_date, end_date, progress, priority, state);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // PMSystem/Task/updateProgress
       {
         int id = in.read_long ();
         int progress = in.read_long ();
         String notes = in.read_string ();
         String state = in.read_string ();
         int $result = (int)0;
         $result = this.updateProgress (id, progress, notes, state);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 3:  // PMSystem/Task/getAllTasks
       {
         PMSystem.TasksBasicData $result[] = null;
         $result = this.getAllTasks ();
         out = $rh.createReply();
         PMSystem.TasksListHelper.write (out, $result);
         break;
       }

       case 4:  // PMSystem/Task/getTask
       {
         int id = in.read_long ();
         PMSystem.TaskData $result = null;
         $result = this.getTask (id);
         out = $rh.createReply();
         PMSystem.TaskDataHelper.write (out, $result);
         break;
       }

       case 5:  // PMSystem/Task/getTasks
       {
         String str = in.read_string ();
         PMSystem.TaskData $result[] = null;
         $result = this.getTasks (str);
         out = $rh.createReply();
         PMSystem.TasksInfoHelper.write (out, $result);
         break;
       }

       case 6:  // PMSystem/Task/getTasksByUser
       {
         int id = in.read_long ();
         PMSystem.TaskData $result[] = null;
         $result = this.getTasksByUser (id);
         out = $rh.createReply();
         PMSystem.TasksInfoHelper.write (out, $result);
         break;
       }

       case 7:  // PMSystem/Task/trash
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.trash (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 8:  // PMSystem/Task/delete
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.delete (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 9:  // PMSystem/Task/restore
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
    "IDL:PMSystem/Task:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Task _this() 
  {
    return TaskHelper.narrow(
    super._this_object());
  }

  public Task _this(org.omg.CORBA.ORB orb) 
  {
    return TaskHelper.narrow(
    super._this_object(orb));
  }


} // class TaskPOA
