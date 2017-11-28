import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class ClockTest
{
   public static void main(String[] args)
   {
      ClockFrame frame = new ClockFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class ClockFrame extends JFrame
{
   public ClockFrame()
   {
      setTitle("ClockTest");
      setSize(200,150);

      // add panel to frame
      ClockPanel panel = new ClockPanel();
      add(panel);
   }
}


class ClockPanel extends JPanel implements Runnable
{
   private Thread clockThread;
   public ClockPanel()
   {
	   clockThread=new Thread(this);
       clockThread.start();
   }
   public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);
	   g.setFont(new Font("Serif", Font.BOLD, 24));
	   g.drawString(String.format("%tT",new Date()),30,50);
   }

   public void run()
   {
	   while(clockThread!=null)
	   {
	       repaint();
	       try
	       {
		       clockThread.sleep(1000);//1000∫¡√Î
	       }
	       catch(InterruptedException e)
	       {
		       e.printStackTrace();
	       }
       }
   }
}







