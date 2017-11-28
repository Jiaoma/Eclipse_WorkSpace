import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class TimerTest
{
   public static void main(String[] args)
   {
      TimerFrame frame = new TimerFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class TimerFrame extends JFrame
{
   public TimerFrame()
   {
      setTitle("ButtonTest");
      setSize(200,150);

      // add panel to frame
      TimerPanel panel = new TimerPanel();
      add(panel);
   }
}

// ButtonPanel类
class TimerPanel extends JPanel
{
   public TimerPanel()
   {
	   Timer timer=new Timer(1000,new MyListener());//1000毫秒触发一次
       timer.start();
   }
   public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);
	   g.setFont(new Font("Serif", Font.BOLD, 24));
	   g.drawString(String.format("%tT",new Date()),30,50);
   }

   class MyListener implements ActionListener
   {
         public void actionPerformed(ActionEvent event)
       {
           Toolkit.getDefaultToolkit( ).beep( );
           repaint();
       }
   }
}





