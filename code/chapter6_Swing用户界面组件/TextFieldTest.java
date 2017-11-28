/**
  ������ʾ��һ��ʱ�ӣ������������ı���ֱ���������Сʱ�ͷ��ӡ�
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
      hourField.getDocument().addDocumentListener(listener);//���ݸı�����ĵ�����ͨ��

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
	       int hours= Integer.parseInt(hourField.getText().trim());//ȡ���ı����ַ�����ȥ����β�ո�ת��Ϊ����
	       int minutes= Integer.parseInt(minuteField.getText().trim());
	       clock.setTime(hours, minutes);
	    }
	    catch (NumberFormatException e1) {System.out.println(e1);}//���ı�������������ַ�����Ϊ��ʱ
       }
   }
   private class ClockFieldListener implements DocumentListener
   {
      public void insertUpdate(DocumentEvent event){setClock();}//�����ַ�ʱ����
      public void removeUpdate(DocumentEvent event){setClock();}//ɾ���ַ�ʱ����
      public void changedUpdate(DocumentEvent event){ }          //�ı��򲻻���ø÷��������ڸ����ĵ����͵�һЩ���ݷ����ı䣨����ı��ʽ��
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

      double hourAngle= Math.toRadians(90-360*minutes/(12*60));//ת��Ϊ����
      drawHand(g2, hourAngle, HOUR_HAND_LENGTH);//��ʱ��

      // draw the minute hand

      double minuteAngle=Math.toRadians(90-360*minutes/60);
      drawHand(g2, minuteAngle, MINUTE_HAND_LENGTH);//������
   }

   public void drawHand(Graphics2D g2,double angle, double handLength)
   {
      Point2D end = new Point2D.Double( RADIUS + handLength * Math.cos(angle),
         RADIUS - handLength * Math.sin(angle));
      Point2D center = new Point2D.Double(RADIUS, RADIUS);//Բ��
      g2.draw(new Line2D.Double(center, end));
   }


   public void setTime(int h, int m)
   {
      minutes=h*60+m;
      repaint();
    }

}//end clockpanel
