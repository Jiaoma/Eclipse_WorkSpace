import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class SimpleFrameTest
{
   public static void main(String[] args)
   {
       JFrame frame=new JFrame( );

       //此处定义了用户关闭框架时的相应动作。默认情况下，当用户关闭一个框架时，该框架会隐藏起来，但程序不会中止
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //默认情况下，框架尺寸为0*0；单位为像素
       frame.setSize(300,200);


      //向框架上添加其他组件
      frame.setLayout(new FlowLayout());
      JButton button1=new JButton("按钮1");
      JButton button2=new JButton("按钮2");
      frame.add(button1);
      frame.add(button2);

      //显示窗口
      frame.setVisible(true);

   }
}

/*
//一个类用于定义框架类，另一个用来创建和显示一个框架对象
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
	  button1=new JButton("按钮1");
	  button2=new JButton("按钮2");
	  add(button1);
      add(button2);
   }

}
*/



/*//在有的程序中main方法放在框架类的中
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

