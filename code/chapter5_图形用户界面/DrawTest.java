/**
   绘制一个矩形，该矩形的一个内接椭圆，该矩形的一条对角线，该矩形的一个同心圆
*/

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawTest
{
   public static void main(String[] args)
   {
      DrawFrame frame = new DrawFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame that contains a panel with drawings
*/
class DrawFrame extends JFrame
{
   public DrawFrame()
   {
      setTitle("DrawTest");
      setSize(400,400);

      // add panel to frame

      DrawPanel panel = new DrawPanel();
      add(panel);
   }
}

/**
   A panel that displays rectangles and ellipses.
*/
class DrawPanel extends JPanel
{
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;


      //构造了一个矩形，左上角坐标(100,100),宽度200，高度150；然后画出该矩形
      Rectangle2D rect = new Rectangle2D.Double(100.0,100.0,200.0,150.0);
      g2.draw(rect);

      // 构造了一个椭圆，然后画出该椭圆
      //方法一
      Ellipse2D ellipse=new Ellipse2D.Double(100.0,100.0,200.0,150.0);//参数为边界矩形的左上角坐标，宽度，高度

      /*//方法二
      Ellipse2D ellipse = new Ellipse2D.Double();
      ellipse.setFrameFromCenter(200,175,100,100);//参数为中心点坐标和一个顶点坐标
      */

      /*//方法三
      Ellipse2D ellipse = new Ellipse2D.Double();
      ellipse.setFrame(rect);
      */
      g2.draw(ellipse);


      //画一条线
      g2.draw(new Line2D.Double(100.0,100.0,300.0,250.0));//参数为起点和终点的坐标


      // 画圆
      double centerX = rect.getCenterX();
      double centerY = rect.getCenterY();
      double radius = 150;

      Ellipse2D circle = new Ellipse2D.Double();
      circle.setFrameFromCenter(centerX, centerY,centerX + radius, centerY + radius);
      g2.draw(circle);


   }
}
