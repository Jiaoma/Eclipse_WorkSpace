/**
  ����Ϊһ����ǩ��һ���ı���һ����ť���ı�����append��ť�������һ�����ֵ��ı�����
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

      JLabel label=new JLabel("����",new ImageIcon("yellow-ball.gif"),JLabel.LEFT);
      panel.add(label);//����ǩ���뵽�����

      textField=new JTextField(30);
      panel.add(textField);//���ı�����뵽�����

      JButton appendButton = new JButton("append");
      appendButton.addActionListener(new  ActionListener()
	  	  	           {
	  	  	              public void actionPerformed(ActionEvent event)
	  	  	              {
	  	  	                 textArea.append(textField.getText());
	  	  	              }
	  	                });//����¼�������
	  panel.add(appendButton);//����ť���뵽�����

      add(panel,"North");//�������뵽�����

	  textArea = new JTextArea(8,40);
	  textArea.setLineWrap(true);//�����Ƿ��Զ�����
	  JScrollPane scrollPane = new JScrollPane(textArea);//��ӹ�����
      add(scrollPane, "Center");//������������ӵ������
     }
}
