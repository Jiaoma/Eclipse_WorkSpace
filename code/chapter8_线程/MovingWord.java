//使用线程实现的移动的文字
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class MovingWord
{
   public static void main(String[] args)
   {
      MyFrame frame = new MyFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class MyFrame extends JFrame
{
   public MyFrame()
   {
      setTitle("Moving word");
      setSize(400,150);

      // add panel to frame
      MovingWordPanel panel1=new MovingWordPanel("Hello!");
      add(panel1);

   }
}


class MovingWordPanel extends JPanel implements Runnable
{
   Thread myThread;
   private String word;
   private int x;
   private int increment=10;
   public MovingWordPanel(String word)
   {
	   this.word=word;
	   x=10;
	   myThread=new Thread(this);
       myThread.start();
   }
   public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);
	   g.setFont(new Font("Serif", Font.BOLD, 24));
	   g.drawString(word,x,50);
   }

   public void run()
   {
	   while(myThread!=null)
	   {
	       if((x+increment)>300&&increment>0)
	        {
				increment=-10;
		     }
	       else if((x+increment)<10&&increment<0)
	       {
			   increment=10;
		   }
		   x=x+increment;

	       repaint();
	       try
	       {
		       myThread.sleep(100);
	       }
	       catch(InterruptedException e)
	       {
		       e.printStackTrace();
	       }
       }
   }
}





