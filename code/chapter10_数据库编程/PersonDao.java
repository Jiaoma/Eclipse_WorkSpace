import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class PersonDao
{
    private static Connection conn=null;

    /**在数据库中添加一条记录 */
    public static void savePerson(final Person person) throws SQLException,IOException
    {
       	try
		{
			conn=getConnection();
			Statement stat = conn.createStatement();
			String sql="insert into person(personName,nickName,email,mobilePhone) values ('"+person.getPersonName()+"','"+person.getNickName()+"','"+person.getEmail()+"','"+person.getMobilePhone()+"')";
			stat.executeUpdate(sql);
		}
		finally
	    {
			conn.close();
	    }
	}

	/**获取数据库中的所有联系人信息 */
	public static ArrayList<Person> getAllPerson() throws SQLException,IOException
    {
         ArrayList<Person> array=new ArrayList<Person>();
		 try
		 {
			conn=getConnection();
			Statement stat = conn.createStatement();
			String sql="select personId,personName,nickName,email,mobilePhone from person";
			ResultSet result=stat.executeQuery(sql);

			while(result.next())
			{
			    Person person=new Person();
				person.setPersonName(result.getString("personName"));
				person.setNickName(result.getString("nickName"));
				person.setMobilePhone(result.getString("mobilePhone"));
				person.setEmail(result.getString("email"));
				person.setPersonId(result.getInt("personId"));
				array.add(person);
			}
    	 }
		 finally
	     {
			 conn.close();
	     }
	     return array;
	}

   /*更新数据库中的联系人信息*/
	public static void updatePerson(Person person) throws SQLException,IOException
	{
		try
		{
			 conn=getConnection();
			 Statement stat = conn.createStatement();
             String sql="update person set personName='"+person.getPersonName()+"',nickName='"+person.getNickName()+"',email='"+person.getEmail()+"',mobilePhone='"+person.getMobilePhone()+"'  where personId='"+person.getPersonId()+"'";
			 stat.executeUpdate(sql);
	    }
	    finally
	   {
		   conn.close();
	    }
	}

	/**删除数据库中的联系人*/
	public static void deleteById(final int personId) throws SQLException,IOException
	{
		try
		{	  conn=getConnection();
			  Statement stat = conn.createStatement();
		      String sql="delete from person where personId= "+personId;
			  stat.executeUpdate(sql);
		 }
		finally
		{
			conn.close();
	    }
	}

	/**建立与数据库的连接*/
	public static Connection getConnection()
	      throws SQLException, IOException
	{
	      Properties props = new Properties();
	      FileInputStream in = new FileInputStream("database.properties");
	      props.load(in);
	      in.close();

	      String url = props.getProperty("jdbc.url");
	      String username = props.getProperty("jdbc.username");
	      String password = props.getProperty("jdbc.password");
	      return DriverManager.getConnection(url, username, password);
    }

    /**根据姓名获取一个person*/
    public static Person getPersonByName(String name) throws SQLException,IOException
	{
		Person person=new Person();
	    try
		{
		   conn=getConnection();
		   Statement stat = conn.createStatement();
		   String sql="select personId,personName,nickName,email,mobilePhone from person where personName='"+name+"'";
		   ResultSet result=stat.executeQuery(sql);
		   result.next();

		   person.setPersonName(result.getString("personName"));
		   person.setNickName(result.getString("nickName"));
		   person.setMobilePhone(result.getString("mobilePhone"));
		   person.setEmail(result.getString("email"));
		   person.setPersonId(result.getInt("personId"));
	    }
		finally
		{
			conn.close();
		}
		return person;
     }
}