/**
  ������ʾ��һ����ǩ���ı����ñ�ǩ��ʶ�ı���
*/

import java.awt.*;
import javax.swing.*;


public class JLabelTest
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("label");
      frame.setSize(300,200);

      frame.setLayout(new FlowLayout());

      JLabel label=new JLabel("����",new ImageIcon("yellow-ball.gif"),JLabel.LEFT);
      frame.add(label);

      JTextField textField=new JTextField(12);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

