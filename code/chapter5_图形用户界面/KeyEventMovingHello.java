/**
  显示键盘事件的处理
*/

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyEventMovingHello
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
      setSize(800,600);

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
   private int x=80;
   private int y=80;
   public KeyEventPanel()
   {
	  setFocusable(true);//调用setFocusable方法将面板设为焦点组件接收键盘事件
      KeyHandler listener = new KeyHandler();
      addKeyListener(listener);
   }

   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);//确保父类完成自己的绘制工作
   	   Graphics2D g2 = (Graphics2D)g;
   	   Font font=new Font("ScansSerif",Font.BOLD,50);
       g2.setFont(font);

       g.drawString(" Hello, World",x,y);
   }

   private class KeyHandler implements KeyListener
   {
      public void keyPressed(KeyEvent event)
      {
		 switch(event.getKeyCode())
		 {
		    case KeyEvent.VK_DOWN:y+=10;break;
		    case KeyEvent.VK_UP:y-=10;break;
		    case KeyEvent.VK_LEFT:x-=10;break;
		    case KeyEvent.VK_RIGHT:x+=10;break;
		 }
		 repaint();
	  }

      public void keyReleased(KeyEvent event)
      {
	  }

      public void keyTyped(KeyEvent event)
      {
      }
   }
}

