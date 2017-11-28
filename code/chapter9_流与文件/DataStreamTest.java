import java.io.*;
import java.util.*;

public class DataStreamTest
{
   public static void main(String[] args)throws Exception
   {
      DataOutputStream out=null;
      DataInputStream in=null;

      try
      {
         out=new DataOutputStream(new FileOutputStream("1.dat"));
         out.writeChar('a');//��һ�� char ֵ�� 2-byte ֵ��ʽд��������У�ʮ����97��������61
         out.writeInt(12);//�� 4-byte ֵ��ʽд������������
         out.writeDouble(12.3);//�� 8-byte ֵ��ʽд������������


		 in=new DataInputStream(new FileInputStream("1.dat"));
		 char c=in.readChar();
		 int i=in.readInt();
		 double d=in.readDouble();


         System.out.println(" c:"+c+"\n i:"+i+"\n d:"+d);
      }
      catch(FileNotFoundException e)
	  {
	  	 e.printStackTrace();
	  }
	  catch(IOException e)
	  {
	  	  e.printStackTrace();
	  }
	  finally
	  {
	  	  try
	  	  {
	  		 if(in!=null)    in.close();
	  		 if(out!=null)   out.close();
	       }
	       catch(IOException e)
	       {
	  		  e.printStackTrace();
	  	   }
	   }

   }
}//ʹ��ultraedit,1.datһ��14�ֽڣ�ʹ��textpad��Ϊ����

