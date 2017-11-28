/**
   һ��΢�����������������������С
*/

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;


public class JSpinnerTest
{
   public static void main(String[] args)
   {
      JSpinnerFrame frame = new JSpinnerFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   ��ܣ�����һ����ǩ��һ��΢����������
   ΢���������������Ʊ�ǩ���ı��������С��
*/
class JSpinnerFrame extends JFrame
{
   private JSpinner sizeSpinner;
   private JLabel label;

   public JSpinnerFrame()
   {
      setTitle("JSpinnerTest");
      setSize(600,200);


      // ���һ����ǩ
      label = new JLabel("The quick brown fox jumps over the lazy dog.");
      label.setFont(new Font("Serif", Font.PLAIN, 20));
      add(label, "Center");

      //���һ��΢��������
      sizeSpinner = new JSpinner();

      // ע���¼���������������������Ĵ�С
      sizeSpinner.addChangeListener(new
         ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               int size=(Integer)sizeSpinner.getValue();//��ȡ��ǰֵ
               label.setFont(new Font("Serif",Font.PLAIN,size));
            }
         });

      add(sizeSpinner, "South");
   }


}

