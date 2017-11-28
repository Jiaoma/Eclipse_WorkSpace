/**
   ���ļ��Ի�����ѡ��һ���ļ�����ʾ�ļ�����
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class FileIOStreamTest
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
   private File file;

   public TextViewerFrame()
   {
      setTitle("FileIOTest");
      setSize(400,300);

      // �����˵����˵�������һ���˵�File,File���������˵���Open��Exit
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu menu = new JMenu("File");
      menuBar.add(menu);

      JMenuItem openItem = new JMenuItem("Open");
      menu.add(openItem);
      openItem.addActionListener(new FileOpenListener());

      JMenuItem newItem=new JMenuItem("new");
      menu.add(newItem);
      newItem.addActionListener(new
        ActionListener()
        {
			public void actionPerformed(ActionEvent event)
			{
				textArea.setText("");
			    file=null;
	    	 }
	    });

      JMenuItem saveItem=new JMenuItem("Save");
      menu.add(saveItem);
      saveItem.addActionListener(new FileSaveListener());

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
      Container contentPane = getContentPane();
      contentPane.add(scrollPane);

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

         textArea.setText("");
         // ��ʾѡ��Ի���
         chooser.showOpenDialog(null);


        //���ı�����ʾ�ļ�����
         file=chooser.getSelectedFile();
         try
         {
            FileInputStream  fileIS=new FileInputStream(file);
            byte [] buf=new byte[10000];
            int len=fileIS.read(buf);
            textArea.append(new String(buf,0,len));
            fileIS.close();
		 }
		 catch(IOException e)
		 {
		     e.printStackTrace();
		 }
      }

   }

   /**
         ����Ϊ File->Save �˵�����¼���������.
      */
      private class FileSaveListener implements ActionListener
      {
         public void actionPerformed(ActionEvent evt)
         {
            //���õ�ǰ����Ŀ¼
            chooser.setCurrentDirectory(new File("."));

            //�����ļ�����������ʾ��׺Ϊ .txt�� .java���ļ�
            TextFileFilter filter= new TextFileFilter();
            chooser.setFileFilter(filter);
            try
            {
               // ��ʾѡ��Ի���
              chooser.showSaveDialog(null);

                //��ȡ��ѡ����ļ���
              file=chooser.getSelectedFile();

              if(!file.exists())
                file.createNewFile();
              FileOutputStream fileos=new FileOutputStream(file);
              fileos.write(textArea.getText().trim().getBytes());
              fileos.close();
		    }
		    catch(Exception e)
		    {
				e.printStackTrace();
		     }

   		   }//end actionperformed
       }//end filesavelistener




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

