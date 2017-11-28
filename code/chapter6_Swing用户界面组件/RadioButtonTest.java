/**
   一组单选按钮，用来控制字体大小
   */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RadioButtonTest
{
   public static void main(String[] args)
   {
      RadioButtonFrame frame = new RadioButtonFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   RadioButtonFrame是一个框架，包含一个标签和一个面板（面板上包括一组单选按钮）。
   单选按钮用来控制标签上文本的字体大小。

*/
class RadioButtonFrame extends JFrame
{
   private JPanel panel;
   private ButtonGroup group;
   private JLabel label;
   private static final int DEFAULT_SIZE = 16;

   public RadioButtonFrame()
   {
      setTitle("RadioButtonTest");
      setSize(400,200);

      // 加入标签
      label = new JLabel("Welcome to Beijing!");
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, "Center");

      // 加入一组单选按钮
      panel = new JPanel();
      group = new ButtonGroup();

      addRadioButton("Small", 16);
      addRadioButton("Medium", 20);
      addRadioButton("Large", 30);
      addRadioButton("Extra large", 40);

      Border border = BorderFactory.createEtchedBorder();
      panel.setBorder(border);//设置面板的边界

      add(panel, "South");
   }

   /**
      创建一个单选按钮，加入按钮组中，添加到面板，注册事件监听。
   */
   public void addRadioButton(String name, final int size)
   {
      boolean selected = size == DEFAULT_SIZE;
      JRadioButton button = new JRadioButton(name, selected);
      group.add(button);
      panel.add(button);

      //事件监听器listener用来设置字体大小
      ActionListener listener = new
         ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               label.setFont(new Font("Serif", Font.PLAIN, size));
            }
         };
      button.addActionListener(listener);
   }
}


/*
      Border border = BorderFactory.createEtchedBorder();
      panel.setBorder(border);//设置面板的边界
*/
