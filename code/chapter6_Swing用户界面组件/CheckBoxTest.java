/**
   ������ѡ������������ʾ������;������ѡ����һ��������������
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxTest
{
   public static void main(String[] args)
   {
      CheckBoxFrame frame = new CheckBoxFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   CheckBoxFrame��һ����ܣ�����һ����ǩ��������ѡ��������ѡ���������Ʊ�ǩ���ı���������
*/
class CheckBoxFrame extends JFrame
{
   private JLabel label;
   private JCheckBox bold;
   private JCheckBox italic;

   public CheckBoxFrame()
   {
      setTitle("CheckBoxTest");
      setSize(400, 200);

      //����һ����ǩ����������ΪSerif,��ʾ���Ϊ��ͨ���ֺ�Ϊ18�š�
      label = new JLabel( "Welcome to Beijing!");
      label.setFont(new Font("Serif", Font.PLAIN, 40));
      add(label, "Center");

      // �¼�������listener�����������ı��������񡣸ü���������ѯbold��italic��ѡ���״̬��
      //������Ӧ����ǩ�ϵ���������Ϊ��ͨ���Ӵ֡���б�Լ������ֵ���ϡ�
      ActionListener listener = new
        ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int mode = 0;
               if (bold.isSelected()) mode += Font.BOLD;
               if (italic.isSelected()) mode += Font.ITALIC;
               label.setFont(new Font("Serif", mode, 40));
            }
         };


     //�����ҪΪ�˵��������λ��
      JPanel panel = new JPanel();

     //���븴ѡ��ע���¼�������
      bold = new JCheckBox("Bold");
      bold.addActionListener(listener);
      panel.add(bold);


      italic = new JCheckBox("Italic");
      italic.addActionListener(listener);
      panel.add(italic);

      add(panel, "South");
   }


}

