import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class SimpleFrameTest
{
   public static void main(String[] args)
   {
       JFrame frame=new JFrame( );

       //�˴��������û��رտ��ʱ����Ӧ������Ĭ������£����û��ر�һ�����ʱ���ÿ�ܻ����������������򲻻���ֹ
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //Ĭ������£���ܳߴ�Ϊ0*0����λΪ����
       frame.setSize(300,200);


      //����������������
      frame.setLayout(new FlowLayout());
      JButton button1=new JButton("��ť1");
      JButton button2=new JButton("��ť2");
      frame.add(button1);
      frame.add(button2);

      //��ʾ����
      frame.setVisible(true);

   }
}

/*
//һ�������ڶ������࣬��һ��������������ʾһ����ܶ���
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class SimpleFrameTest
{
   public static void main(String[] args)
   {
      SimpleFrame frame = new SimpleFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class SimpleFrame extends JFrame
{
   private JButton button1;
   private JButton button2;
   public SimpleFrame()
   {
      setSize(300,200);
      setLayout(new FlowLayout());
	  button1=new JButton("��ť1");
	  button2=new JButton("��ť2");
	  add(button1);
      add(button2);
   }

}
*/



/*//���еĳ�����main�������ڿ�������
import javax.swing.*;

public class SimpleFrame  extends JFrame
{

   public SimpleFrame()
   {
	 setSize(300,200);
   }
   public static void main(String[] args)
   {
      SimpleFrame frame = new SimpleFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}


*/

