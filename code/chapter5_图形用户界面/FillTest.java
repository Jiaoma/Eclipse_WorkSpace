/**
   用红色填充一个矩形，用暗绿色填充该矩形的内接椭圆
*/

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class FillTest
{
   public static void main(String[] args)
   {
      FillFrame frame = new FillFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame that contains a panel with drawings
*/
class FillFrame extends JFrame
{
   public FillFrame()
   {
      setTitle("FillTest");
      setSize(400,400);

      // add panel to frame

      FillPanel panel = new FillPanel();
      add(panel);
   }
}

/**
   A panel that displays filled rectangles and ellipses
*/
class FillPanel extends JPanel
{
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;

      // draw a rectangle
      Rectangle2D rect = new Rectangle2D.Double(100,100,200,150);//左上角（100，100），大小200*150像素
      g2.setPaint(Color.RED);
      g2.fill(rect);

      // draw the enclosed ellipse
      Ellipse2D ellipse = new Ellipse2D.Double();
      ellipse.setFrame(rect);
      g2.setPaint(new Color(0,  128, 128)); // a dull blue-green
      g2.fill(ellipse);
   }
}

