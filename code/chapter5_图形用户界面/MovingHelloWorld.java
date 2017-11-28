/**
   ������ʾ��μ�������¼�����
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
   	 //addMouseListener(handler);//�����
   	  MouseHandler handler=new MouseHandler();
	  addMouseMotionListener(handler);//����ƶ�
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);//ȷ����������Լ��Ļ��ƹ���
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
//����ƶ�
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



