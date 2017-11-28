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

    	   /*//����sql server 2000
           System.setProperty("jdbc.drivers", "com.microsoft.jdbc.sqlserver.SQLServerDriver");
           conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databasename=addressdb", "sa","***");
           */

    	   //����sql server 2008
    	    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//ע�᷽��1
    	    System.setProperty("jdbc.drivers", "com.microsoft.sqlserver.jdbc.SQLServerDriver");//ע�᷽��2
    	    conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=addressdb", "sa", "***");//����

    	   /*//����my sql
           conn=DriverManager.getConnection("jdbc:mysql://localhost/addressdb", "root","***");
           */

    	    //��ѯ���ݿ�
    	    statement = conn.createStatement();
            result = statement.executeQuery("select * from person");//��ѯ
            while(result.next())//��ʾ��ѯ���
		   {
		   	 System.out.println("������"+result.getString("personName"));
		   	 System.out.println("���䣺"+result.getString("email"));
		   }

           //�����ݿ��������
           String sql="insert into person (personName) values('����')";
           statement.executeUpdate(sql);//����в���һ������
           result = statement.executeQuery("select * from person");//��ѯ
           System.out.println("\n����һ������֮��Ľ����");
           while(result.next())
		   {
		   	 System.out.println("������"+result.getString("personName"));
		   	 System.out.println("���䣺"+result.getString("email"));
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
//����mysql ��sql server 2000��sql server 2008.
//mysql��jdbc driver������Զ�ע�ᡣ
//�˴��õ�sql server��jdbc driver����ʹ��������ע�ᡣ
//ͨ��JDBC�����ʲ�ͬ�����ݿ�ֻ����ע����������ʱ������ͬ�����������ݿ�Ĵ�������ͬ�ġ�

