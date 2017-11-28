//File不仅可以代表已经存在的文件和目录；还可以用它创建文件，目录，查看文件的属性等。

//创建一个文件，显示属性

import java.io.*;
import java.util.*;

public class CreateFile
{

  public static void main(String[] args)
  {
      File f=new File("c:\\test\\1.txt");//如果文件不存在，使用该语句不会创建文件
      if(!f.exists())//如果该文件不存在则创建它
      {
	    System.out.println("creating...");
        try
        {
           f.createNewFile();
	    }
	    catch(IOException e)
	    {
	       e.printStackTrace();
	    }
      }
      System.out.println(
	      "Absolute path: " + f.getAbsolutePath() +
	      "\n Can read: " + f.canRead() +
	      "\n Can write: " + f.canWrite() +
	      "\n getName: " + f.getName() +
	      "\n getParent: " + f.getParent() +
	      "\n getPath: " + f.getPath() +
	      "\n length: " + f.length()+
	      "\n is hidden?"+f.isHidden()+
	      "\n last modified?"+new Date(f.lastModified()));
	  if(f.isFile())
	     System.out.println("It's a file");
	  else if(f.isDirectory())
        System.out.println("It's a directory");
  }
}
