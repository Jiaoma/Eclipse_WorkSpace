/**
   ���ļ��Ի�����ѡ��һ���ļ�����ʾ�ļ�����
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class FileChooserTest
{
   public static void main(String[] args)
   {
      TextViewerFrame frame = new TextViewerFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   һ����ܣ�����һ���ı����Ͳ˵�
*/
class TextViewerFrame extends JFrame
{
   private JTextArea  textArea;
   private JFileChooser chooser;

   public TextViewerFrame()
   {
      setTitle("FileChooserTest");
      setSize(800,600);

      // �����˵����˵�������һ���˵�File,File���������˵���Open��Exit
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu menu = new JMenu("File");
      menuBar.add(menu);

      JMenuItem openItem = new JMenuItem("Open");
      menu.add(openItem);
      openItem.addActionListener(new FileOpenListener());

      JMenuItem exitItem = new JMenuItem("Exit");
      menu.add(exitItem);

      //Ϊ�˵���ע���¼������������ʱ�����˳�
      exitItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });

      // ʹ�þ��й������� JTextArea��ʾ�ļ�����
      textArea = new JTextArea(30,40);
      JScrollPane scrollPane=new JScrollPane(textArea);
      add(scrollPane);

      chooser = new JFileChooser();//����JFileChooser����
   }

   /**
      ����Ϊ File->Open �˵�����¼���������.
   */
   private class FileOpenListener implements ActionListener
   {
      public void actionPerformed(ActionEvent evt)
      {
         //���õ�ǰ����Ŀ¼
         chooser.setCurrentDirectory(new File("."));

         //�����ļ�����������ʾ��׺Ϊ .txt�� .java���ļ�
         TextFileFilter filter= new TextFileFilter();
         chooser.setFileFilter(filter);

         // ��ʾѡ��Ի���
         chooser.showOpenDialog(null);

        //��ȡ��ѡ����ļ���
        String filename=chooser.getSelectedFile().getPath();

        //���ı�����ʾ���򿪵��ļ�������
        textArea.setText("");
        textArea.append("���ļ�"+filename+"\n");

        //���ı�����ʾ�ļ�����
         File file=chooser.getSelectedFile();
         FileReader fileReader=null;
         try
         {
			try
			{
                fileReader=new FileReader(file);
                char [] buf=new char[10000];
                int len=fileReader.read(buf);
                textArea.append(new String(buf,0,len));
			}
			finally
			{
				fileReader.close();
			}
		 }
		 catch(IOException e)
		 {
		     e.printStackTrace();
		 }
      }
   }


}

/**
   ������һ���ļ����������������� .txt��.java�ļ�
*/
class TextFileFilter extends FileFilter
{
   //���ظ����͵�˵����Ϣ
   public String getDescription()
   {
      return "�ı��ļ�";
   }

   //�����ļ��Ƿ���Խ���
   public boolean accept(File f)
   {
      if (f.isDirectory()) return true;
      String name = f.getName().toLowerCase();
      if( name.endsWith(".java")||name.endsWith(".txt"))
         return true;
      else return false;
   }
}

