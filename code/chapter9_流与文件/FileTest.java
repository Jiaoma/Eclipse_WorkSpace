//例: 获取当前目录下所有文件名和文件的尺寸:

import java.io.*;

public class FileTest
{
  public static void main(String args[])
  {
	 File direct=new File(".");//创建代表当前目录的文件对象

     String fileList[]=direct.list();//返回目录下的所有文件名和目录名

     for(String name:fileList)
       System.out.println("name:"+name);

    //列出目录中的文件名和尺寸
    for(int i=0;i<fileList.length;i++)
    {
	   File currentFile=new File(fileList[i]);
       System.out.println(currentFile.getAbsolutePath()+"  "+currentFile.length()+"字节");
    }
  }//end main
}






