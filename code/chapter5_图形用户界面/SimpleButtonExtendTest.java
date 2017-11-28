/**
   处理点击按钮事件
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class SimpleButtonExtendTest
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
   AudioClip audio;

   public ButtonFrame()
   {
	  ClassLoader classLoader=this.getClass().getClassLoader();
	  audio=JApplet.newAudioClip(classLoader.getResource("1.mid"));

      setTitle("SimpleButtonTest");
      setSize(300,200);

      JButton playButton=new JButton("  play  ");//事件源
      PlayListener listener1=new PlayListener();//事件监听器
      playButton.addActionListener(listener1);//注册

      JButton stopButton=new JButton("  stop  ");
      StopListener listener2=new StopListener();
      stopButton.addActionListener(listener2);


      setLayout(new FlowLayout());
      add(playButton);
      add(stopButton);
   }


   //处理按钮的点击的事件监听器类,定义为内部类
   class PlayListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {
          audio.play();
       }
    }

    class StopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           audio.stop();
        }
    }

}





