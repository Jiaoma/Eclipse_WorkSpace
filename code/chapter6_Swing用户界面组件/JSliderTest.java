/**
   一个滑块，用来控制字体大小
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
   JSliderFrame是一个框架，包含一个标签和一个滑块。
   滑块用来控制标签上文本的字体大小。
*/
class JSliderFrame extends JFrame
{
   private JSlider sizeSlider;
   private JLabel label;

   public JSliderFrame()
   {
      setTitle("JSliderTest");
      setSize(600,200);


      // 添加一个标签
      label = new JLabel("Welcome to Beijing!");
      label.setFont(new Font("Serif", Font.PLAIN, 20));
      add(label, "Center");

      //添加一个滑块
      sizeSlider = new JSlider(10,50,30);//最小值10,最大值50,初始值30
      sizeSlider.setMajorTickSpacing(10);//设置大标尺
      sizeSlider.setMinorTickSpacing(2);//设置小标尺
      sizeSlider.setPaintTicks(true);//显示标尺
      sizeSlider.setPaintLabels(true);//显示大标尺标签


      // 注册事件监听器，用来设置字体的大小
      sizeSlider.addChangeListener(new
         ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               int size=sizeSlider.getValue();//获取当前值
               label.setFont(new Font("Serif",Font.PLAIN,size));
            }
         });

      add(sizeSlider, "South");
   }


}

