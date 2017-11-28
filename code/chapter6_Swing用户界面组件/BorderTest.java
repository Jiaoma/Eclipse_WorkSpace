/**
  该程序可以显示不同风格的边界
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
   BorderFrame是一个框架，包含两个面板。
   其中面板buttonPanel上包括一组单选按钮，控制demoPanel上边界的风格。
   面板demoPanel用来显示不同的风格的边界。
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

      //创建一个蚀刻边界
      Border etched = BorderFactory.createEtchedBorder();
      //边界加标题
      Border titled = BorderFactory.createTitledBorder(etched, "边界类型");
      //设置面板的边界
      buttonPanel.setBorder(titled);

       //第一个参数是单选按钮显示的文本，对应边界的风格：低斜面，凸斜面，蚀刻，直线，不光滑，空。
	   //第二个参数是一个被创建的边界
	   //在buttonPanel上添加一个单选按钮，注册事件监听器，添加到按钮组，添加到面板。
	  addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
	  addRadioButton("Raised bevel",  BorderFactory.createRaisedBevelBorder());
	  addRadioButton("Etched", BorderFactory.createEtchedBorder());
	  addRadioButton("Line",  BorderFactory.createLineBorder(Color.blue));
	  addRadioButton("Matte", BorderFactory.createMatteBorder(20, 10, 20, 10, Color.blue));//top顶线宽度,left,bottom,right,color
	  addRadioButton("Empty", BorderFactory.createEmptyBorder());

      setLayout(new GridLayout(2, 1));
      add(buttonPanel);
      add(demoPanel);
   }

   //生成一个单选按钮，注册事件监听器，加入按钮组中，加入面板buttonPanel.
   //每一个单选按钮对应一个事件监听器。
   public void addRadioButton(String buttonName, final Border b)
   {
      JRadioButton button = new JRadioButton(buttonName);
      button.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               demoPanel.setBorder(b);//设置边界
            }
         });
      group.add(button);//添加到按钮组
      buttonPanel.add(button);//添加到面板
   }
}
