/**
   ������꣬���λ�ò���һ��С�����ڲ������ڸ�λ����ʾһ��С���飻
   ��ĳ��С������˫����꣬���λ��С������ʧ��
   ��ĳ��С�������϶���꣬���λ��С����������ƶ���
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
	  //������꣬�������λ�ò���ĳһ�������ڲ������ڸô���ʾһ������
      public void mousePressed(MouseEvent event)
      {
         // add a new square if the cursor isn't inside a square
         current = find(event.getPoint());//�ж����λ���Ƿ���ĳ�������ڲ�
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

      //˫����꣬�������λ����ĳ�������ڲ�����÷�����ʧ
      public void mouseClicked(MouseEvent event)
      {
         // remove the current square if double clicked
         current = find(event.getPoint());
         if (current != null && event.getClickCount() >= 2)//�жϻ�������
         {
			 squares.remove(current);
			 current = null;
             repaint();
	     }
      }
   }

   private class MouseMotionHandler   implements MouseMotionListener
   {
	   //������ƶ���ĳ�������ϣ������״�ı�
      public void mouseMoved(MouseEvent event)
      {
         if (find(event.getPoint()) == null)
            setCursor(Cursor.getDefaultCursor());//���ù��
         else
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//���ù��
      }

      //��ĳ���������϶���꣬�򷽿���֮�ƶ�
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
