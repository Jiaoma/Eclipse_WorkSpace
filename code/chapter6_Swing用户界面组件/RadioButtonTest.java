/**
   һ�鵥ѡ��ť���������������С
   */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RadioButtonTest
{
   public static void main(String[] args)
   {
      RadioButtonFrame frame = new RadioButtonFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   RadioButtonFrame��һ����ܣ�����һ����ǩ��һ����壨����ϰ���һ�鵥ѡ��ť����
   ��ѡ��ť�������Ʊ�ǩ���ı��������С��

*/
class RadioButtonFrame extends JFrame
{
   private JPanel panel;
   private ButtonGroup group;
   private JLabel label;
   private static final int DEFAULT_SIZE = 16;

   public RadioButtonFrame()
   {
      setTitle("RadioButtonTest");
      setSize(400,200);

      // �����ǩ
      label = new JLabel("Welcome to Beijing!");
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, "Center");

      // ����һ�鵥ѡ��ť
      panel = new JPanel();
      group = new ButtonGroup();

      addRadioButton("Small", 16);
      addRadioButton("Medium", 20);
      addRadioButton("Large", 30);
      addRadioButton("Extra large", 40);

      Border border = BorderFactory.createEtchedBorder();
      panel.setBorder(border);//�������ı߽�

      add(panel, "South");
   }

   /**
      ����һ����ѡ��ť�����밴ť���У���ӵ���壬ע���¼�������
   */
   public void addRadioButton(String name, final int size)
   {
      boolean selected = size == DEFAULT_SIZE;
      JRadioButton button = new JRadioButton(name, selected);
      group.add(button);
      panel.add(button);

      //�¼�������listener�������������С
      ActionListener listener = new
         ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               label.setFont(new Font("Serif", Font.PLAIN, size));
            }
         };
      button.addActionListener(listener);
   }
}


/*
      Border border = BorderFactory.createEtchedBorder();
      panel.setBorder(border);//�������ı߽�
*/
