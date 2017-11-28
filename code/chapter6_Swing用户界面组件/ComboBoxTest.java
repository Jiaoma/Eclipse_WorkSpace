/**
   һ����Ͽ��������������С
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxTest
{
   public static void main(String[] args)
   {
      ComboBoxFrame frame = new ComboBoxFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   ComboBoxFrame��һ����ܣ�����һ����ǩ��һ����Ͽ�
   ��Ͽ��������Ʊ�ǩ���ı��������С��
*/
class ComboBoxFrame extends JFrame
{
   private JComboBox sizeCombo;
   private JLabel label;
   private static final int DEFAULT_SIZE = 16;

   public ComboBoxFrame()
   {
      setTitle("ComboBoxTest");
      setSize(600,200);


      // ���һ����ǩ
      label = new JLabel("Welcome to Beijing!");
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, "Center");

      //���һ����Ͽ�
      sizeCombo = new JComboBox();
      sizeCombo.setEditable(true);//����Ϊ�ɱ༭
      sizeCombo.addItem("16");//����ѡ��
      sizeCombo.addItem("20");
      sizeCombo.addItem("24");
      sizeCombo.addItem("28");
      sizeCombo.addItem("32");

      // ע���¼���������������������Ĵ�С
      sizeCombo.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int size=Integer.parseInt((String)(sizeCombo.getSelectedItem()));//��ȡ��ѡ�����,��ת��Ϊint
               label.setFont(new Font("Serif",Font.PLAIN,size));
            }
         });

      add(sizeCombo, "South");
   }


}


/*��Ӽ�������������ķ�ʽҲ��
sizeCombo.addItemListener(new
         ItemListener()
         {
            public void itemStateChanged(ItemEvent event)
            {
               label.setFont(new Font("Serif",Font.PLAIN,Integer.parseInt((String)(event.getItem()))));

            }
         });
*/