/**
  �ó��������ʾ��ͬ���ı߽�
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderTest
{
   public static void main(String[] args)
   {
      BorderFrame frame = new BorderFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

   }
}

/**
   BorderFrame��һ����ܣ�����������塣
   �������buttonPanel�ϰ���һ�鵥ѡ��ť������demoPanel�ϱ߽�ķ��
   ���demoPanel������ʾ��ͬ�ķ��ı߽硣
*/
class BorderFrame extends JFrame
{
   private JPanel demoPanel;
   private JPanel buttonPanel;
   private ButtonGroup group;

   public BorderFrame()
   {
      setTitle("BorderTest");
      setSize(600,200);

      demoPanel = new JPanel();
      buttonPanel = new JPanel();
      group = new ButtonGroup();

      //����һ��ʴ�̱߽�
      Border etched = BorderFactory.createEtchedBorder();
      //�߽�ӱ���
      Border titled = BorderFactory.createTitledBorder(etched, "�߽�����");
      //�������ı߽�
      buttonPanel.setBorder(titled);

       //��һ�������ǵ�ѡ��ť��ʾ���ı�����Ӧ�߽�ķ�񣺵�б�棬͹б�棬ʴ�̣�ֱ�ߣ����⻬���ա�
	   //�ڶ���������һ���������ı߽�
	   //��buttonPanel�����һ����ѡ��ť��ע���¼�����������ӵ���ť�飬��ӵ���塣
	  addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
	  addRadioButton("Raised bevel",  BorderFactory.createRaisedBevelBorder());
	  addRadioButton("Etched", BorderFactory.createEtchedBorder());
	  addRadioButton("Line",  BorderFactory.createLineBorder(Color.blue));
	  addRadioButton("Matte", BorderFactory.createMatteBorder(20, 10, 20, 10, Color.blue));//top���߿��,left,bottom,right,color
	  addRadioButton("Empty", BorderFactory.createEmptyBorder());

      setLayout(new GridLayout(2, 1));
      add(buttonPanel);
      add(demoPanel);
   }

   //����һ����ѡ��ť��ע���¼������������밴ť���У��������buttonPanel.
   //ÿһ����ѡ��ť��Ӧһ���¼���������
   public void addRadioButton(String buttonName, final Border b)
   {
      JRadioButton button = new JRadioButton(buttonName);
      button.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               demoPanel.setBorder(b);//���ñ߽�
            }
         });
      group.add(button);//��ӵ���ť��
      buttonPanel.add(button);//��ӵ����
   }
}
