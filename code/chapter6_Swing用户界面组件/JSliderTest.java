/**
   һ�����飬�������������С
*/

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;


public class JSliderTest
{
   public static void main(String[] args)
   {
      JSliderFrame frame = new JSliderFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   JSliderFrame��һ����ܣ�����һ����ǩ��һ�����顣
   �����������Ʊ�ǩ���ı��������С��
*/
class JSliderFrame extends JFrame
{
   private JSlider sizeSlider;
   private JLabel label;

   public JSliderFrame()
   {
      setTitle("JSliderTest");
      setSize(600,200);


      // ���һ����ǩ
      label = new JLabel("Welcome to Beijing!");
      label.setFont(new Font("Serif", Font.PLAIN, 20));
      add(label, "Center");

      //���һ������
      sizeSlider = new JSlider(10,50,30);//��Сֵ10,���ֵ50,��ʼֵ30
      sizeSlider.setMajorTickSpacing(10);//���ô���
      sizeSlider.setMinorTickSpacing(2);//����С���
      sizeSlider.setPaintTicks(true);//��ʾ���
      sizeSlider.setPaintLabels(true);//��ʾ���߱�ǩ


      // ע���¼���������������������Ĵ�С
      sizeSlider.addChangeListener(new
         ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               int size=sizeSlider.getValue();//��ȡ��ǰֵ
               label.setFont(new Font("Serif",Font.PLAIN,size));
            }
         });

      add(sizeSlider, "South");
   }


}

