/**
  程序显示了一个标签和文本域，用标签标识文本域
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

      JLabel label=new JLabel("输入",new ImageIcon("yellow-ball.gif"),JLabel.LEFT);
      frame.add(label);

      JTextField textField=new JTextField(12);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

