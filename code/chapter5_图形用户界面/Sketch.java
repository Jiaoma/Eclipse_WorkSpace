/**
   可以使用上下左右键来改变画线的方向。如果按下shift键，则画线移动增量加大。也可使用小写的h,j,k,l来
   代替上下左右键，而大写h,j,k,k则会使用更大增量画线。

*/

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Sketch
{
   public static void main(String[] args)
   {
      SketchFrame frame = new SketchFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a panel for sketching a figure
*/
class SketchFrame extends JFrame
{
   public SketchFrame()
   {
      setTitle("Sketch");
      setSize(300,200);

      // add panel to frame

      SketchPanel panel = new SketchPanel();
      add(panel);
   }
}

/**
   A panel for sketching with the keyboard.
*/
class SketchPanel extends JPanel
{
   private Point2D last;
   private ArrayList<Line2D> lines;
   private static final int SMALL_INCREMENT = 1;
   private static final int LARGE_INCREMENT = 5;
   public SketchPanel()
   {
      last = new Point2D.Double(100, 100);//画线的起始位置为100，100
      lines = new ArrayList<Line2D>();
      KeyHandler listener = new KeyHandler();
      addKeyListener(listener);
      setFocusable(true);//正常情况下，面板不能得到键盘输入，也就是说它不能接受键盘事件，此句为了让它能够接受焦点，
   }


   /**
      Add a new line segment to the sketch.
      @param dx the movement in x direction
      @param dy the movement in y direction
   */
   public void add(int dx, int dy)
   {
      // compute new end point
      Point2D end = new Point2D.Double(last.getX() + dx,
         last.getY() + dy);

      // add line segment
      Line2D line = new Line2D.Double(last, end);
      lines.add(line);
      repaint();

      // remember new end point
      last = end;
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;

      // draw all lines
      for (int i = 0; i < lines.size(); i++)
         g2.draw((Line2D)lines.get(i));
   }



   private class KeyHandler implements KeyListener
   {
      public void keyPressed(KeyEvent event)
      {
         int keyCode = event.getKeyCode();

         // set distance
         int d;
         if (event.isShiftDown())
            d = LARGE_INCREMENT;
         else
            d = SMALL_INCREMENT;

         // add line segment
         if (keyCode == KeyEvent.VK_LEFT) add(-d, 0);
         else if (keyCode == KeyEvent.VK_RIGHT) add(d, 0);
         else if (keyCode == KeyEvent.VK_UP) add(0, -d);
         else if (keyCode == KeyEvent.VK_DOWN) add(0, d);
      }

      public void keyReleased(KeyEvent event) {}

      public void keyTyped(KeyEvent event)
      {
         char keyChar = event.getKeyChar();

         // set distance
         int d;
         if (Character.isUpperCase(keyChar))
         {
            d = LARGE_INCREMENT;
            keyChar = Character.toLowerCase(keyChar);
         }
         else
            d = SMALL_INCREMENT;

         // add line segment
         if (keyChar == 'h') add(-d, 0);
         else if (keyChar == 'l') add(d, 0);
         else if (keyChar == 'k') add(0, -d);
         else if (keyChar == 'j') add(0, d);
      }
   }
}

