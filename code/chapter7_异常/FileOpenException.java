//创建一个文件,可能产生IOExcetpion,属于checked exceptions,必须处理

import java.io.*;
import javax.swing.*;

public class FileOpenException
{
   public static void main(String [] args)
   {
     try
     {
         createFile();
         System.out.println("文件创建成功！");
     }
     catch(IOException e)
     {
	     System.out.println("出现异常");
	     e.printStackTrace();
	     System.out.println("异常信息输出结束");
	 }

	 System.out.println("\n程序结束");
   }

   public static  void createFile() throws IOException
   {
      String filename=JOptionPane.showInputDialog("输入文件名：");
      File f=new File(filename);
      f.createNewFile();
   }

}

//在输入文件名时，有可能输入的文件名不符合要求，从而导致出现无法创建文件的输入输出错误。
//它属于checked异常，必须进行处理，进行申明或捕获。如果去掉throws IOException，则会出现编译错误。
//输入c:\\1.txt，则正确处理
//输入cc:\\\\1.txt，则出现异常，程序输出异常信息之后，继续正常执行。

