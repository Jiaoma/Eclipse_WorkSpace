/**
   ����һ�����Σ��þ��ε�һ���ڽ���Բ���þ��ε�һ���Խ��ߣ��þ��ε�һ��ͬ��Բ
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


      //������һ�����Σ����Ͻ�����(100,100),���200���߶�150��Ȼ�󻭳��þ���
      Rectangle2D rect = new Rectangle2D.Double(100.0,100.0,200.0,150.0);
      g2.draw(rect);

      // ������һ����Բ��Ȼ�󻭳�����Բ
      //����һ
      Ellipse2D ellipse=new Ellipse2D.Double(100.0,100.0,200.0,150.0);//����Ϊ�߽���ε����Ͻ����꣬��ȣ��߶�

      /*//������
      Ellipse2D ellipse = new Ellipse2D.Double();
      ellipse.setFrameFromCenter(200,175,100,100);//����Ϊ���ĵ������һ����������
      */

      /*//������
      Ellipse2D ellipse = new Ellipse2D.Double();
      ellipse.setFrame(rect);
      */
      g2.draw(ellipse);


      //��һ����
      g2.draw(new Line2D.Double(100.0,100.0,300.0,250.0));//����Ϊ�����յ������


      // ��Բ
      double centerX = rect.getCenterX();
      double centerY = rect.getCenterY();
      double radius = 150;

      Ellipse2D circle = new Ellipse2D.Double();
      circle.setFrameFromCenter(centerX, centerY,centerX + radius, centerY + radius);
      g2.draw(circle);


   }
}
