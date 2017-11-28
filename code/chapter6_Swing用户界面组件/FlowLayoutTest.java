import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest
{
   public static void main(String [] args)
   {
      JFrame frame=new JFrame("Flow Layout");
      frame.setSize(400,200);

      frame.setLayout(new FlowLayout());//�ı䲼�ֹ�������Ĭ�϶��뷽ʽΪ���ж���
      //frame.setLayout(new FlowLayout(FlowLayout.LEFT));//ָ�����뷽ʽ��LEFT,CENTER,RIGHT
      //frame.setLayout(new FlowLayout(FlowLayout.LEFT,40,20));//ָ�����뷽ʽ��ˮƽ��࣬��ֱ���

      frame.add(new JButton("button1"));
      frame.add(new JButton("button2"));
      frame.add(new JButton("3"));
      frame.add(new JButton("button4"));
      frame.add(new JButton("button5"));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}