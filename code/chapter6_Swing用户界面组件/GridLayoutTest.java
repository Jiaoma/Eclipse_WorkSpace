import javax.swing.*;
import java.awt.*;

public class GridLayoutTest
{
   public static void main(String [] args)
   {
      JFrame frame=new JFrame("Grid Layout");
      frame.setSize(400,200);

      frame.setLayout(new GridLayout(2,3));//指定行数和列数：2行3列

      frame.add(new JButton("button1"));
      frame.add(new JButton("button2"));
      frame.add(new JButton("3"));
      frame.add(new JButton("button4"));
      //frame.add(new JTextArea(10,20));

      //frame.pack();//所有组件以最佳的高度和宽度显示
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}