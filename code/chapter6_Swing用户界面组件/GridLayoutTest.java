import javax.swing.*;
import java.awt.*;

public class GridLayoutTest
{
   public static void main(String [] args)
   {
      JFrame frame=new JFrame("Grid Layout");
      frame.setSize(400,200);

      frame.setLayout(new GridLayout(2,3));//ָ��������������2��3��

      frame.add(new JButton("button1"));
      frame.add(new JButton("button2"));
      frame.add(new JButton("3"));
      frame.add(new JButton("button4"));
      //frame.add(new JTextArea(10,20));

      //frame.pack();//�����������ѵĸ߶ȺͿ����ʾ
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}