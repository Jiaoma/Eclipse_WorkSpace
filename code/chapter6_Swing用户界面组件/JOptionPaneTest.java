//窗口中包含4个按钮，点击生成不同的对话框

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JOptionPaneTest
{
   public static void main(String [] args)
   {
      DialogFrame  frame=new DialogFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}


class  DialogFrame extends JFrame
{
	JButton  button1=new JButton("Message Dialog");
	JButton  button2=new JButton("Confirm Dialog");
	JButton  button3=new JButton("Option Dialog");
	JButton  button4=new JButton("Input Dialog");

    public DialogFrame()
    {
	   setSize(400,200);
	   setTitle("Dialog test");

	   setLayout(new FlowLayout());

	   add(button1);
	   add(button2);
	   add(button3);
	   add(button4);

      //四个按钮共用一个事件监听器
	   ActionListener listener=new MyActionListener();
	   button1.addActionListener(listener);
	   button2.addActionListener(listener);
	   button3.addActionListener(listener);
	   button4.addActionListener(listener);
	}

	class MyActionListener implements ActionListener
	{

	   public void actionPerformed(ActionEvent event)
	   {
          //showMessageDialog(Component parentComponent, Object message,
          //String title, int messageType)
	      if (event.getSource()==button1)
	         JOptionPane.showMessageDialog(DialogFrame.this,
	         "This is a Message Dialog",
	         "Message",JOptionPane.WARNING_MESSAGE);

	      //showConfirmDialog(Component parentComponent, Object message,
	      //String title, int optionType, int messageType)
	      if (event.getSource()==button2)
	         JOptionPane.showConfirmDialog(null,
	         "This is a Confirm Dialog",
	         "Confirm",JOptionPane.OK_CANCEL_OPTION,
	         JOptionPane.INFORMATION_MESSAGE);

         //showOptionDialog(Component parentComponent, Object message,
         //String title, int optionType, int messageType, Icon icon,
         //Object[] options, Object initialValue)
          Object[] options = { new JTextField(5),
                               new ImageIcon("cut.gif") ,
                               "yes","no","cancel"};//底部按钮行
	      if (event.getSource()==button3)
	      	 JOptionPane.showOptionDialog(null, "Click OK to continue",
	       "Option", JOptionPane.DEFAULT_OPTION,
	       JOptionPane.WARNING_MESSAGE, null,
	        options,options[0]);



         //showInputDialog(Component parentComponent, Object message,
	    //String title, int messageType)
	      if (event.getSource()==button4)
	         JOptionPane.showInputDialog(null,"pleas input:",
	         "Input",JOptionPane.QUESTION_MESSAGE);
	   }
	}
}