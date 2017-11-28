/**
   单击鼠标，如果位置不在一个小方块内部，则在该位置显示一个小方块；
   在某个小方块上双击鼠标，则该位置小方块消失；
   在某个小方块上拖动鼠标，则该位置小方块随鼠标移动。
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;

public class MouseTest
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
   private static final int SIDELENGTH = 10;
   private ArrayList<Rectangle2D> squares;
   private Rectangle2D current;
   public MousePanel()
   {
      squares = new ArrayList<Rectangle2D>();
      current = null;
      addMouseListener(new MouseHandler());
      addMouseMotionListener(new MouseMotionHandler());
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;

      // draw all squares
      for (Rectangle2D r:squares)
         g2.draw(r);
   }

   /**
      Finds the first square containing a point.
      @param p a point
      @return the index of the first square that contains p
   */
   public Rectangle2D find(Point2D p)
   {
      for (int i = 0; i < squares.size(); i++)
      {
         Rectangle2D r = (Rectangle2D)squares.get(i);
         if (r.contains(p)) return r;
      }
      return null;
   }

   private class MouseHandler extends MouseAdapter
   {
	  //按下鼠标，如果它的位置不在某一个方块内部，则在该处显示一个方块
      public void mousePressed(MouseEvent event)
      {
         // add a new square if the cursor isn't inside a square
         current = find(event.getPoint());//判定鼠标位置是否在某个方块内部
         if (current == null)
         {
             double x = event.getX();
		     double y = event.getY();
		     current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH,
		          SIDELENGTH);
		     squares.add(current);
             repaint();
	      }
      }

      //双击鼠标，如果它的位置在某个方块内部，则该方块消失
      public void mouseClicked(MouseEvent event)
      {
         // remove the current square if double clicked
         current = find(event.getPoint());
         if (current != null && event.getClickCount() >= 2)//判断击键次数
         {
			 squares.remove(current);
			 current = null;
             repaint();
	     }
      }
   }

   private class MouseMotionHandler   implements MouseMotionListener
   {
	   //当鼠标移动到某个方块上，鼠标形状改变
      public void mouseMoved(MouseEvent event)
      {
         if (find(event.getPoint()) == null)
            setCursor(Cursor.getDefaultCursor());//设置光标
         else
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置光标
      }

      //在某个方块上拖动鼠标，则方块随之移动
      public void mouseDragged(MouseEvent event)
      {
         if (current != null)
         {
            int x = event.getX();
            int y = event.getY();
            // drag the current rectangle to center it at (x, y)
            current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
            repaint();
         }
      }
   }
}
