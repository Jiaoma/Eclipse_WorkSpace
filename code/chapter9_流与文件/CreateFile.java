//File�������Դ����Ѿ����ڵ��ļ���Ŀ¼�����������������ļ���Ŀ¼���鿴�ļ������Եȡ�

//����һ���ļ�����ʾ����

import java.io.*;
import java.util.*;

public class CreateFile
{

  public static void main(String[] args)
  {
      File f=new File("c:\\test\\1.txt");//����ļ������ڣ�ʹ�ø���䲻�ᴴ���ļ�
      if(!f.exists())//������ļ��������򴴽���
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
