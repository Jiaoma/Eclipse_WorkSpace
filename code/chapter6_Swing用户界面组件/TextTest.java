/**
  界面为一个标签、一个文本域、一个按钮和文本区。append按钮用来添加一行文字到文本区。
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextTest
{
   public static void main(String[] args)
   {
      TextFrame frame = new TextFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a text area and buttons for text editing
*/
class TextFrame extends JFrame
{
   private JTextArea textArea;
   private JTextField textField;

   public TextFrame()
   {
      setTitle("TextTest");
      setSize(600,400);

      JPanel panel=new JPanel();

      JLabel label=new JLabel("输入",new ImageIcon("yellow-ball.gif"),JLabel.LEFT);
      panel.add(label);//将标签加入到面板上

      textField=new JTextField(30);
      panel.add(textField);//将文本域加入到面板上

      JButton appendButton = new JButton("append");
      appendButton.addActionListener(new  ActionListener()
	  	  	           {
	  	  	              public void actionPerformed(ActionEvent event)
	  	  	              {
	  	  	                 textArea.append(textField.getText());
	  	  	              }
	  	                });//添加事件监听器
	  panel.add(appendButton);//将按钮加入到面板上

      add(panel,"North");//将面板加入到框架中

	  textArea = new JTextArea(8,40);
	  textArea.setLineWrap(true);//设置是否自动换行
	  JScrollPane scrollPane = new JScrollPane(textArea);//添加滚动条
      add(scrollPane, "Center");//将滚动窗格添加到框架中
     }
}
