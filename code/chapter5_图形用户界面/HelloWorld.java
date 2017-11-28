/**
   在（75，100）处显示文本"Hello world!"
*/

import javax.swing.*;
import java.awt.*;

public class HelloWorld
{
   public static void main(String[] args)
   {
      HelloWorldFrame frame = new HelloWorldFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame that contains a message panel
*/
class HelloWorldFrame extends JFrame
{
   public HelloWorldFrame()
   {
      setTitle("HelloWorld");
      setSize(300,200);

      // add panel to frame
      HelloWorldPanel panel = new HelloWorldPanel();
      add(panel);//jdk 5.0

   }
}

/**
   A panel that displays a message.
*/
class HelloWorldPanel extends JPanel
{
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);//确保父类完成自己的绘制工作

      g.drawString(" Hello, World",75,100);//(75,100)坐标，单位为像素
   }
}



