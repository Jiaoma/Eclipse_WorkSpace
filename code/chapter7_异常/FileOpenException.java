//����һ���ļ�,���ܲ���IOExcetpion,����checked exceptions,���봦��

import java.io.*;
import javax.swing.*;

public class FileOpenException
{
   public static void main(String [] args)
   {
     try
     {
         createFile();
         System.out.println("�ļ������ɹ���");
     }
     catch(IOException e)
     {
	     System.out.println("�����쳣");
	     e.printStackTrace();
	     System.out.println("�쳣��Ϣ�������");
	 }

	 System.out.println("\n�������");
   }

   public static  void createFile() throws IOException
   {
      String filename=JOptionPane.showInputDialog("�����ļ�����");
      File f=new File(filename);
      f.createNewFile();
   }

}

//�������ļ���ʱ���п���������ļ���������Ҫ�󣬴Ӷ����³����޷������ļ��������������
//������checked�쳣��������д������������򲶻����ȥ��throws IOException�������ֱ������
//����c:\\1.txt������ȷ����
//����cc:\\\\1.txt��������쳣����������쳣��Ϣ֮�󣬼�������ִ�С�

