/**
   在文件对话框中选择一个文件，显示文件内容
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
   一个框架，包括一个文本区和菜单
*/
class TextViewerFrame extends JFrame
{
   private JTextArea  textArea;
   private JFileChooser chooser;

   public TextViewerFrame()
   {
      setTitle("FileChooserTest");
      setSize(800,600);

      // 创建菜单，菜单条包括一个菜单File,File包含两个菜单项Open和Exit
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu menu = new JMenu("File");
      menuBar.add(menu);

      JMenuItem openItem = new JMenuItem("Open");
      menu.add(openItem);
      openItem.addActionListener(new FileOpenListener());

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
      add(scrollPane);

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

         // 显示选择对话框
         chooser.showOpenDialog(null);

        //获取被选择的文件名
        String filename=chooser.getSelectedFile().getPath();

        //在文本区显示被打开的文件的名字
        textArea.setText("");
        textArea.append("打开文件"+filename+"\n");

        //在文本区显示文件内容
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

