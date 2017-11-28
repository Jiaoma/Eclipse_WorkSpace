/**
   在文件对话框中选择一个文件，显示文件内容
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
   一个框架，包括一个文本区和菜单
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

      // 创建菜单，菜单条包括一个菜单File,File包含两个菜单项Open和Exit
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

      //为菜单项注册事件监听器，点击时程序退出
      exitItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });

      // 使用具有滚动条的 JTextArea显示文件内容
      textArea = new JTextArea(30,40);
      JScrollPane scrollPane=new JScrollPane(textArea);
      Container contentPane = getContentPane();
      contentPane.add(scrollPane);

      chooser = new JFileChooser();//创建JFileChooser对象
   }

   /**
      下面为 File->Open 菜单项的事件监听器类.
   */
   private class FileOpenListener implements ActionListener
   {
      public void actionPerformed(ActionEvent evt)
      {
         //设置当前工作目录
         chooser.setCurrentDirectory(new File("."));

         //设置文件过滤器，显示后缀为 .txt和 .java的文件
         TextFileFilter filter= new TextFileFilter();
         chooser.setFileFilter(filter);

         textArea.setText("");
         // 显示选择对话框
         chooser.showOpenDialog(null);


        //在文本区显示文件内容
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
         下面为 File->Save 菜单项的事件监听器类.
      */
      private class FileSaveListener implements ActionListener
      {
         public void actionPerformed(ActionEvent evt)
         {
            //设置当前工作目录
            chooser.setCurrentDirectory(new File("."));

            //设置文件过滤器，显示后缀为 .txt和 .java的文件
            TextFileFilter filter= new TextFileFilter();
            chooser.setFileFilter(filter);
            try
            {
               // 显示选择对话框
              chooser.showSaveDialog(null);

                //获取被选择的文件名
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
   下面是一个文件过滤器，接受所有 .txt和.java文件
*/
class TextFileFilter extends FileFilter
{
   //返回该类型的说明信息
   public String getDescription()
   {
      return "文本文件";
   }

   //测试文件是否可以接受
   public boolean accept(File f)
   {
      if (f.isDirectory()) return true;
      String name = f.getName().toLowerCase();
      if( name.endsWith(".java")||name.endsWith(".txt"))
         return true;
      else return false;
   }
}

