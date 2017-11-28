package DrawPatterns;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
public class DrawPatterns {
	public static void main(String[] args)
	{
		DrawFrame frame = new DrawFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
}
class DrawFrame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public DrawFrame()
   {
      setTitle("DrawTest");
      setSize(1200,800);

      // add panel to frame

      DrawPanel panel = new DrawPanel();
      add(panel);
   }
}
class DrawPanel extends JPanel
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      int line_num=5;
      int Rec_num=10;
      int Oval_num=5;
      int i=0;
      Random random=new Random();
      int x1_rand;
      int y1_rand;
      int x2_rand;
      int y2_rand;
      for(i=0;i<line_num;i++)
      {
    	  x1_rand=random.nextInt(1200)%1201;
          y1_rand=random.nextInt(800)%801;
          x2_rand=random.nextInt(1200)%1201;
          y2_rand=random.nextInt(800)%801;
    	  MyLine line=new MyLine(x1_rand,y1_rand,x2_rand,y2_rand);
    	  line.draw(g);
      }
      for(i=0;i<Rec_num;i++)
      {
    	  x1_rand=random.nextInt(1200)%1201;
          y1_rand=random.nextInt(800)%801;
          x2_rand=random.nextInt(1200)%1201;
          y2_rand=random.nextInt(800)%801;
    	  MyRectangle rec=new MyRectangle(x1_rand,y1_rand,x2_rand,y2_rand);
    	  rec.draw(g);
      }
      for(i=0;i<Oval_num;i++)
      {
    	  x1_rand=random.nextInt(1200)%1201;
          y1_rand=random.nextInt(800)%801;
          x2_rand=random.nextInt(1200)%1201;
          y2_rand=random.nextInt(800)%801;
    	  MyOval ov=new MyOval(x1_rand,y1_rand,x2_rand,y2_rand);
    	  ov.draw(g);
      }
   }
}
abstract class MyShape
{
	public int x1,y1,x2,y2;
	public MyShape()
	{
		x1=x2=y1=y2=0;
	}
	public MyShape(int _x1,int _y1,int _x2,int _y2)
	{
		x1=_x1;
		x2=_x2;
		y1=_y1;
		y2=_y2;
	}
	abstract void draw(Graphics g);
}

class MyLine extends MyShape
{
	public MyLine()
	{
		super();
	}
	public MyLine(int _x1,int _y1,int _x2,int _y2)
	{
		super(_x1,_y1,_x2,_y2);
	}
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(new Line2D.Double(x1,y1,x2,y2));
	}
}
class MyRectangle extends MyShape
{
	public MyRectangle()
	{
		super();
	}
	public MyRectangle(int _x1,int _y1,int _x2,int _y2)
	{
		super(_x1,_y1,_x2,_y2);
	}
	public void draw(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		Rectangle2D rect = new Rectangle2D.Double(x1,y1,x2,y2);
		g2.draw(rect);
	}
}
class MyOval extends MyShape
{
	public MyOval()
	{
		super();
	}
	public MyOval(int _x1,int _y1,int _x2,int _y2)
	{
		super(_x1,_y1,_x2,_y2);
	}
	public void draw(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		Ellipse2D ellipse=new Ellipse2D.Double(x1,y1,x2,y2);//参数为边界矩形的左上角坐标，宽度，高度
		g2.draw(ellipse);
	}
}