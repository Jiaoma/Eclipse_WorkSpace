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
         FileWriter out = new FileWriter("filewriter.txt");//清空文件，然后写入 FileWriter out = new FileWriter("filewriter.txt",true);//追加
         out.write("李丽");
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

