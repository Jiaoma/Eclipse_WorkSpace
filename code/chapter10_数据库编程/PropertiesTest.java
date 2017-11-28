import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest
{
   public static void main(String [] args)
   {
     Connection conn = null;
     Statement statement = null;
     ResultSet result = null;

     try
     {
		 conn=getConnection();
         statement = conn.createStatement();
         result = statement.executeQuery("select * from person");
         while(result.next())
		 {
		   	 System.out.println(result.getString("personName"));
		   	 System.out.println(result.getString("email"));
		 }
      }catch (SQLException e)
     {
          e.printStackTrace();
      }catch(IOException e)
      {
	      e.printStackTrace();
      }
      finally
     {
		 try{
			 if(conn!=null)
			    conn.close();
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }

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
}

//采用配置文件的方式有利于程序的可修改性