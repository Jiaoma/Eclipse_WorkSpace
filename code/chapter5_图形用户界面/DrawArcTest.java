import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawArcTest
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
      add(panel);
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


      double xCenter=getWidth()/2;//中心点x
      double yCenter=getHeight()/2;//中心点y
      double radius=(int)(getWidth()*0.4);//半径

      double x=xCenter-radius;//左上角x
      double y=yCenter-radius;//左上角y

      Arc2D arc1=new Arc2D.Double(x,y,2*radius,2*radius,0,30,Arc2D.CHORD);
      g2.draw(arc1);

       Arc2D arc2=new Arc2D.Double(x,y,2*radius,2*radius,90,30,Arc2D.PIE);
       g2.draw(arc2);

       Arc2D arc3=new Arc2D.Double(x,y,2*radius,2*radius,180,30,Arc2D.OPEN);
       g2.draw(arc3);

       Arc2D arc4=new Arc2D.Double(x,y,2*radius,2*radius,270,30,Arc2D.PIE);
       g2.draw(arc4);
   }
}
