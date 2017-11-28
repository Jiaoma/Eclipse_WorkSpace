/**
   ����һ�����Σ��þ��ε�һ���ڽ���Բ���þ��ε�һ���Խ��ߣ��þ��ε�һ��ͬ��Բ
*/

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ColorTest
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
      Container contentPane = getContentPane();
      contentPane.add(panel);
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
      g2.setPaint(Color.red);
      g2.setPaint(new Color(112,112,112));
      g2.setPaint(SystemColor.window);
      g.setColor(Color.red);
      Rectangle2D rect = new Rectangle2D.Double(100.0,100.0,200.0,150.0);
      g2.draw(rect);


   }
}
