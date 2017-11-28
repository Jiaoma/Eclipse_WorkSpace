import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest
{
   public static void main(String [] args)
   {
      JFrame frame=new JFrame("Border Layout布局");//JFrame的默认布局管理器为BorderLayout
      frame.setSize(400,200);

      //frame.add(new JButton("北"),"North");//将该按钮放置在North的位置
      //frame.add(new JButton("North"),BorderLayout.NORTH);//也可写成这种形式

      frame.add(new JButton("西"),"West");
      frame.add(new JButton("东"),"East");
      frame.add(new JButton("南"),"South");
      frame.add(new JButton("中"),"Center");

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

//边界布局管理器会扩大所有组件的尺寸以填充可用空间
//北和南高度不变
//西和东宽度不变