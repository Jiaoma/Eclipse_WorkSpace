/**
   在窗口中显示字符串"Hello,world!",字体为Serif,标准36号加粗
*/

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class FontTest
{
   public static void main(String[] args)
   {
      FontFrame frame = new FontFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a text message panel
*/
class FontFrame extends JFrame
{
   public FontFrame()
   {
      setTitle("FontTest");
      setSize(400,400);

      // add panel to frame

      FontPanel panel = new FontPanel();
      add(panel);
   }
}

/**
   A panel that shows a centered message in a box.
*/
class FontPanel extends JPanel
{
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;


      Font f = new Font("Serif", Font.BOLD, 30);//逻辑字体
      g2.setFont(f);
      g2.setColor(Color.BLUE);
      g2.drawString("北京欢迎你!",10,50);

      f=new Font("华文行楷",Font.PLAIN,70);//实际字体名
      g2.setFont(f);
	  g2.drawString("北京欢迎你!",10,200);
   }
}
