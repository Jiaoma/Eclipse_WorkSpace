/**

*/

import java.io.*;
import java.util.*;

public class FileWriterTest
{
   public static void main(String[] args)
   {
      try
      {
         FileWriter out = new FileWriter("filewriter.txt");//����ļ���Ȼ��д�� FileWriter out = new FileWriter("filewriter.txt",true);//׷��
         out.write("����");
         out.write("\n");
         out.write("200700000");
		 out.close();
      }
      catch(IOException exception)
      {
         exception.printStackTrace();
      }
   }
}

