//��: ��ȡ��ǰĿ¼�������ļ������ļ��ĳߴ�:

import java.io.*;

public class FileTest
{
  public static void main(String args[])
  {
	 File direct=new File(".");//��������ǰĿ¼���ļ�����

     String fileList[]=direct.list();//����Ŀ¼�µ������ļ�����Ŀ¼��

     for(String name:fileList)
       System.out.println("name:"+name);

    //�г�Ŀ¼�е��ļ����ͳߴ�
    for(int i=0;i<fileList.length;i++)
    {
	   File currentFile=new File(fileList[i]);
       System.out.println(currentFile.getAbsolutePath()+"  "+currentFile.length()+"�ֽ�");
    }
  }//end main
}






