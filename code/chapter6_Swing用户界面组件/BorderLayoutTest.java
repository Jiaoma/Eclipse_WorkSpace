import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest
{
   public static void main(String [] args)
   {
      JFrame frame=new JFrame("Border Layout����");//JFrame��Ĭ�ϲ��ֹ�����ΪBorderLayout
      frame.setSize(400,200);

      //frame.add(new JButton("��"),"North");//���ð�ť������North��λ��
      //frame.add(new JButton("North"),BorderLayout.NORTH);//Ҳ��д��������ʽ

      frame.add(new JButton("��"),"West");
      frame.add(new JButton("��"),"East");
      frame.add(new JButton("��"),"South");
      frame.add(new JButton("��"),"Center");

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

//�߽粼�ֹ�������������������ĳߴ��������ÿռ�
//�����ϸ߶Ȳ���
//���Ͷ���Ȳ���