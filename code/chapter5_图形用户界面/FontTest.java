/**
   �ڴ�������ʾ�ַ���"Hello,world!",����ΪSerif,��׼36�żӴ�
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


      Font f = new Font("Serif", Font.BOLD, 30);//�߼�����
      g2.setFont(f);
      g2.setColor(Color.BLUE);
      g2.drawString("������ӭ��!",10,50);

      f=new Font("�����п�",Font.PLAIN,70);//ʵ��������
      g2.setFont(f);
	  g2.drawString("������ӭ��!",10,200);
   }
}
