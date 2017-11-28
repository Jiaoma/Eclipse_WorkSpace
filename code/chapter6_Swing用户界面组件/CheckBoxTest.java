/**
   两个复选框，用来控制显示的字体;两个复选框共用一个动作监听器。
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
   CheckBoxFrame是一个框架，包含一个标签和两个复选框。两个复选框用来控制标签上文本的字体风格。
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

      //生成一个标签，设置字体为Serif,显示风格为普通，字号为18号。
      label = new JLabel( "Welcome to Beijing!");
      label.setFont(new Font("Serif", Font.PLAIN, 40));
      add(label, "Center");

      // 事件监听器listener，用来设置文本的字体风格。该监听器将查询bold和italic复选框的状态，
      //并且相应将标签上的字体风格设为普通、加粗、倾斜以及后两种的组合。
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


     //面板主要为了调整组件的位置
      JPanel panel = new JPanel();

     //加入复选框，注册事件监听器
      bold = new JCheckBox("Bold");
      bold.addActionListener(listener);
      panel.add(bold);


      italic = new JCheckBox("Italic");
      italic.addActionListener(listener);
      panel.add(italic);

      add(panel, "South");
   }


}

