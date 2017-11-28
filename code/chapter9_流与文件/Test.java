import java.io.*;
import java.util.*;

public class Test
{
   public static void main(String[] args)
   {
      String s="abc";
      int num=12;

      //字节，二进制
      try
      {
         DataOutputStream out = new DataOutputStream(new FileOutputStream("test1.dat"));
         for(int i=0;i<s.length();i++)
            out.writeChar(s.charAt(i));
         out.writeInt(num);
         out.close();


         DataInputStream in= new DataInputStream( new FileInputStream("test1.dat"));
         StringBuffer b=new StringBuffer(s.length());
         int tempNum;
         for(int i=0;i<s.length();i++)
           b.append(in.readChar());
         tempNum=in.readInt();
         in.close();

         System.out.println(b.toString());
         System.out.println(tempNum);
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }


      //字符，文本
       try
	   {
	      PrintWriter out = new PrintWriter(new FileWriter("test2.dat"));
	      out.println(s);
	      out.println(num);
	      out.close();

	      BufferedReader in = new BufferedReader(new  FileReader("test2.dat"));
	      String tempStr = in.readLine();
          int tempNum = Integer.parseInt(in.readLine());
	      in.close();

	      System.out.println(tempStr);
          System.out.println(tempNum);
	    }
	    catch(IOException e)
	    {
	       e.printStackTrace();
	    }

   }
}

