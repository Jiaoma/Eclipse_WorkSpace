import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest
{
   public static void main(String [] args)
   {
      JFrame frame=new JFrame("Flow Layout");
      frame.setSize(400,200);

      frame.setLayout(new FlowLayout());//改变布局管理器，默认对齐方式为居中对齐
      //frame.setLayout(new FlowLayout(FlowLayout.LEFT));//指定对齐方式，LEFT,CENTER,RIGHT
      //frame.setLayout(new FlowLayout(FlowLayout.LEFT,40,20));//指定对齐方式，水平间距，垂直间距

      frame.add(new JButton("button1"));
      frame.add(new JButton("button2"));
      frame.add(new JButton("3"));
      frame.add(new JButton("button4"));
      frame.add(new JButton("button5"));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}