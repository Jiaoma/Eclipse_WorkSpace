import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.*;

public class SimpleDBConnector
{
   public static void main(String [] args) throws Exception
   {
     Connection conn = null;
     Statement statement = null;
     ResultSet result = null;

     try {

    	   /*//连接sql server 2000
           System.setProperty("jdbc.drivers", "com.microsoft.jdbc.sqlserver.SQLServerDriver");
           conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databasename=addressdb", "sa","***");
           */

    	   //连接sql server 2008
    	    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//注册方法1
    	    System.setProperty("jdbc.drivers", "com.microsoft.sqlserver.jdbc.SQLServerDriver");//注册方法2
    	    conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=addressdb", "sa", "***");//连接

    	   /*//连接my sql
           conn=DriverManager.getConnection("jdbc:mysql://localhost/addressdb", "root","***");
           */

    	    //查询数据库
    	    statement = conn.createStatement();
            result = statement.executeQuery("select * from person");//查询
            while(result.next())//显示查询结果
		   {
		   	 System.out.println("姓名："+result.getString("personName"));
		   	 System.out.println("邮箱："+result.getString("email"));
		   }

           //向数据库插入数据
           String sql="insert into person (personName) values('王鹏')";
           statement.executeUpdate(sql);//向表中插入一行数据
           result = statement.executeQuery("select * from person");//查询
           System.out.println("\n插入一条数据之后的结果：");
           while(result.next())
		   {
		   	 System.out.println("姓名："+result.getString("personName"));
		   	 System.out.println("邮箱："+result.getString("email"));
		   }

      }
      catch (SQLException e)
     {
            e.printStackTrace();
      }
      finally
     {
		 try{
		   if(conn!=null)
             conn.close();
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
      }//endfinally
    }
}
//连接mysql 和sql server 2000，sql server 2008.
//mysql的jdbc driver会进行自动注册。
//此处用的sql server的jdbc driver必须使用语句进行注册。
//通过JDBC，访问不同的数据库只是在注册驱动程序时有所不同，而访问数据库的代码是相同的。

