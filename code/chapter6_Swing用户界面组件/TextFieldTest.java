/**
  程序显示了一个时钟，并且有两个文本域分别用于输入小时和分钟。
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

public class TextFieldTest
{
   public static void main(String[] args)
   {
      TextTestFrame frame = new TextTestFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with two text fields to set a clock.
*/
class TextTestFrame extends JFrame
{
   private JTextField hourField;
   private JTextField minuteField;
   private ClockPanel clock;

   public TextTestFrame()
   {
      setTitle("TextTest");
      setSize(210,300);


      DocumentListener listener = new ClockFieldListener();

      // add a panel with text fields

      JPanel panel = new JPanel();
      hourField = new JTextField("12", 3);
      panel.add(hourField);
      hourField.getDocument().addDocumentListener(listener);//数据改变后，由文档给与通告

      minuteField = new JTextField("00", 3);
      panel.add(minuteField);
      minuteField.getDocument().addDocumentListener(listener);

      add(panel, BorderLayout.SOUTH);

      // add the clock

      clock = new ClockPanel();
      add(clock, BorderLayout.CENTER);
   }

   /**
      Set the clock to the values stored in the text fields.
   */
   public void setClock()
   {
     {
		try
	   {
	       int hours= Integer.parseInt(hourField.getText().trim());//取得文本域字符串，去掉首尾空格，转换为整数
	       int minutes= Integer.parseInt(minuteField.getText().trim());
	       clock.setTime(hours, minutes);
	    }
	    catch (NumberFormatException e1) {System.out.println(e1);}//当文本域输入非整数字符串或为空时
       }
   }
   private class ClockFieldListener implements DocumentListener
   {
      public void insertUpdate(DocumentEvent event){setClock();}//插入字符时调用
      public void removeUpdate(DocumentEvent event){setClock();}//删除字符时调用
      public void changedUpdate(DocumentEvent event){ }          //文本域不会调用该方法，用于复杂文档类型的一些内容发生改变（例如改变格式）
   }
}

/**
   A panel that draws a clock.
*/
class ClockPanel extends JPanel
{
   private double minutes = 0;
   private double RADIUS = 100;
   private double MINUTE_HAND_LENGTH = 0.8 * RADIUS;
   private double HOUR_HAND_LENGTH = 0.6 * RADIUS;


   public void paintComponent(Graphics g)
   {
      // draw the circular boundary

      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      Ellipse2D circle = new Ellipse2D.Double(0, 0, 2 * RADIUS, 2 * RADIUS);
      g2.draw(circle);

      // draw the hour hand

      double hourAngle= Math.toRadians(90-360*minutes/(12*60));//转化为弧度
      drawHand(g2, hourAngle, HOUR_HAND_LENGTH);//画时针

      // draw the minute hand

      double minuteAngle=Math.toRadians(90-360*minutes/60);
      drawHand(g2, minuteAngle, MINUTE_HAND_LENGTH);//画分针
   }

   public void drawHand(Graphics2D g2,double angle, double handLength)
   {
      Point2D end = new Point2D.Double( RADIUS + handLength * Math.cos(angle),
         RADIUS - handLength * Math.sin(angle));
      Point2D center = new Point2D.Double(RADIUS, RADIUS);//圆心
      g2.draw(new Line2D.Double(center, end));
   }


   public void setTime(int h, int m)
   {
      minutes=h*60+m;
      repaint();
    }

}//end clockpanel
