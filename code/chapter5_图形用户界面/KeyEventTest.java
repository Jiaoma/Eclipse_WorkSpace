/**
  显示键盘事件的处理
*/

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyEventTest
{
   public static void main(String[] args)
   {
      KeyEventFrame frame = new KeyEventFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a panel
*/
class KeyEventFrame extends JFrame
{
   public KeyEventFrame()
   {
      setTitle("KeyEventTest");
      setSize(400,200);

      // add panel to frame
      KeyEventPanel panel = new KeyEventPanel();
      add(panel);
   }
}

/**
   A panel
*/
class KeyEventPanel extends JPanel
{
   char c=' ';
   String message="";
   public KeyEventPanel()
   {
	  setFocusable(true);//由于面板一般不接受键盘事件，因此调用setFocusable方法对默认情形进行修改
      KeyHandler listener = new KeyHandler();
      addKeyListener(listener);
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      Font font=new Font("ScansSerif",Font.BOLD,30);
      g2.setFont(font);
      g2.drawString(""+c,50,50);
      g2.drawString(message,50,100);
   }

   private class KeyHandler implements KeyListener
   {
      public void keyPressed(KeyEvent event)
      {
		  c=' ';
		  message=event.getKeyCode()+" key Pressed";
		  System.out.println(message);
		  repaint();
	  }

      public void keyReleased(KeyEvent event)
      {
		  message=event.getKeyCode()+" key Released";
		  System.out.println(message);
		  repaint();
	  }

      public void keyTyped(KeyEvent event)
      {
          c=event.getKeyChar( );
          System.out.println(c);
          repaint();
      }
   }
}



