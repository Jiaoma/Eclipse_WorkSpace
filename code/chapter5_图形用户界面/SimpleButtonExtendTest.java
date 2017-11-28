/**
   ��������ť�¼�
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

//   ����һ����ť���Զ�������
class ButtonFrame extends JFrame
{
   AudioClip audio;

   public ButtonFrame()
   {
	  ClassLoader classLoader=this.getClass().getClassLoader();
	  audio=JApplet.newAudioClip(classLoader.getResource("1.mid"));

      setTitle("SimpleButtonTest");
      setSize(300,200);

      JButton playButton=new JButton("  play  ");//�¼�Դ
      PlayListener listener1=new PlayListener();//�¼�������
      playButton.addActionListener(listener1);//ע��

      JButton stopButton=new JButton("  stop  ");
      StopListener listener2=new StopListener();
      stopButton.addActionListener(listener2);


      setLayout(new FlowLayout());
      add(playButton);
      add(stopButton);
   }


   //����ť�ĵ�����¼���������,����Ϊ�ڲ���
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





