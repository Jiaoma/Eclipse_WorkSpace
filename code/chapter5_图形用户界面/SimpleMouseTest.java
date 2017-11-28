/**
   单击鼠标，在该位置显示一个小方块；
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;

public class SimpleMouseTest
{
   public static void main(String[] args)
   {
      MouseFrame frame = new MouseFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame containing a panel for testing mouse operations
*/
class MouseFrame extends JFrame
{
   public MouseFrame()
   {
      setTitle("MouseTest");
      setSize(300, 200);

      // add panel to frame

      MousePanel panel = new MousePanel();
      add(panel);
   }
}

/**
   A panel with mouse operations for adding and removing squares.
*/
class MousePanel extends JPanel
{
   private Rectangle2D current;
   public MousePanel()
   {
      current = null;
      addMouseListener(new MouseHandler());
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;

      if(current!=null)
         g2.draw(current);
   }

   private class MouseHandler extends MouseAdapter
   {
	  //按下鼠标，在该处显示一个方块
      public void mousePressed(MouseEvent event)
      {
         current = new Rectangle2D.Double(event.getX(),event.getY(),10,10);
         repaint();
      }
   }
}