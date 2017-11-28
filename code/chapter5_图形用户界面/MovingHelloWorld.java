/**
   用来演示如何加入鼠标事件处理
*/
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingHelloWorld
{
   public static void main(String[] args)
   {
      HelloWorldFrame frame = new  HelloWorldFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class HelloWorldFrame extends JFrame
{
   public HelloWorldFrame()
   {
      setTitle("HelloWorld");
      setSize(800,600);

      HelloWorldPanel panel = new HelloWorldPanel();
      add(panel);
   }
}

/**
   A panel that displays a message.
*/
class HelloWorldPanel extends JPanel
{
   private int x=80;
   private int y=80;

   public HelloWorldPanel()
   {
   	 //MouseHandler handler=new MouseHandler();
   	 //addMouseListener(handler);//鼠标点击
   	  MouseHandler handler=new MouseHandler();
	  addMouseMotionListener(handler);//鼠标移动
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);//确保父类完成自己的绘制工作
	  Graphics2D g2 = (Graphics2D)g;
	  Font font=new Font("ScansSerif",Font.BOLD,50);
      g2.setFont(font);

      g.drawString(" Hello, World",x,y);
   }



 class MouseHandler extends MouseMotionAdapter
    {
    	public void mouseMoved(MouseEvent event)
    	{
    		x=event.getX();
    		y=event.getY();
    		repaint();
    	}
   }

}



/*
//鼠标移动
 class MouseHandler extends MouseMotionAdapter
    {
    	public void mouseMoved(MouseEvent event)
    	{
    		x=event.getX();
    		y=event.getY();
    		repaint();
    	}
   }

 class MouseHandler extends MouseAdapter
   {
   	public void mousePressed(MouseEvent event)
   	{
   		x=event.getX();
   		y=event.getY();
   		repaint();
   	}
}
 */



