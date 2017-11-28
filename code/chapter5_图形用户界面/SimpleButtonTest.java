/**
   处理点击按钮事件
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class SimpleButtonTest
{
   public static void main(String[] args)
   {
      ButtonFrame frame = new ButtonFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

//   包含一个按钮的自定义框架类
class ButtonFrame extends JFrame
{
   public ButtonFrame()
   {
      setTitle("SimpleButtonTest");
      setSize(300,200);

      JButton button=new JButton("  play  ");//事件源
      PlayListener listener=new PlayListener();//事件监听器
      button.addActionListener(listener);//注册
      //button.addActionListener(new PlayListener());//简写

      setLayout(new FlowLayout());
      add(button);
   }
}


//处理按钮的点击的事件监听器类
class PlayListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
	   ClassLoader classLoader=this.getClass().getClassLoader();
	   AudioClip audio=JApplet.newAudioClip(classLoader.getResource("1.mid"));
       audio.play();
    }
 }

