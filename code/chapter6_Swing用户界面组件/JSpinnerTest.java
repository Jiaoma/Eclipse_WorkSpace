/**
   一个微调控制器，用来控制字体大小
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
   框架，包含一个标签和一个微调控制器。
   微调控制器用来控制标签上文本的字体大小。
*/
class JSpinnerFrame extends JFrame
{
   private JSpinner sizeSpinner;
   private JLabel label;

   public JSpinnerFrame()
   {
      setTitle("JSpinnerTest");
      setSize(600,200);


      // 添加一个标签
      label = new JLabel("The quick brown fox jumps over the lazy dog.");
      label.setFont(new Font("Serif", Font.PLAIN, 20));
      add(label, "Center");

      //添加一个微调控制器
      sizeSpinner = new JSpinner();

      // 注册事件监听器，用来设置字体的大小
      sizeSpinner.addChangeListener(new
         ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               int size=(Integer)sizeSpinner.getValue();//获取当前值
               label.setFont(new Font("Serif",Font.PLAIN,size));
            }
         });

      add(sizeSpinner, "South");
   }


}

