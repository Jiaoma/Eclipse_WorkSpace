import java.io.*;
import java.util.*;

public class FileReaderTest
{
   public static void main(String[] args)
   {
      try
      {
         FileReader in = new FileReader("old.txt");

         int ch=in.read();//每次读一个字符
         while(ch!=-1)
        {
			 System.out.println((char)ch);
			 ch=in.read();
		 }
      	 in.close();
      }
      catch(IOException exception)
      {
         exception.printStackTrace();
      }
   }
}
