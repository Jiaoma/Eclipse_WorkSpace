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
         out.writeChar('a');//将一个 char 值以 2-byte 值形式写入输出流中，十进制97，二进制61
         out.writeInt(12);//以 4-byte 值形式写入基础输出流中
         out.writeDouble(12.3);//以 8-byte 值形式写入基础输出流中


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
}//使用ultraedit,1.dat一共14字节，使用textpad打开为乱码

