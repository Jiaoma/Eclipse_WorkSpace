/**
   一个组合框，用来控制字体大小
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
   ComboBoxFrame是一个框架，包含一个标签和一个组合框。
   组合框用来控制标签上文本的字体大小。
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


      // 添加一个标签
      label = new JLabel("Welcome to Beijing!");
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, "Center");

      //添加一个组合框
      sizeCombo = new JComboBox();
      sizeCombo.setEditable(true);//设置为可编辑
      sizeCombo.addItem("16");//增加选项
      sizeCombo.addItem("20");
      sizeCombo.addItem("24");
      sizeCombo.addItem("28");
      sizeCombo.addItem("32");

      // 注册事件监听器，用来设置字体的大小
      sizeCombo.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int size=Integer.parseInt((String)(sizeCombo.getSelectedItem()));//获取被选择的项,并转化为int
               label.setFont(new Font("Serif",Font.PLAIN,size));
            }
         });

      add(sizeCombo, "South");
   }


}


/*添加监听器采用下面的方式也可
sizeCombo.addItemListener(new
         ItemListener()
         {
            public void itemStateChanged(ItemEvent event)
            {
               label.setFont(new Font("Serif",Font.PLAIN,Integer.parseInt((String)(event.getItem()))));

            }
         });
*/