/**
   ��������ť�¼�
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

//   ����һ����ť���Զ�������
class ButtonFrame extends JFrame
{
   public ButtonFrame()
   {
      setTitle("SimpleButtonTest");
      setSize(300,200);

      JButton button=new JButton("  play  ");//�¼�Դ
      PlayListener listener=new PlayListener();//�¼�������
      button.addActionListener(listener);//ע��
      //button.addActionListener(new PlayListener());//��д

      setLayout(new FlowLayout());
      add(button);
   }
}


//����ť�ĵ�����¼���������
class PlayListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
	   ClassLoader classLoader=this.getClass().getClassLoader();
	   AudioClip audio=JApplet.newAudioClip(classLoader.getResource("1.mid"));
       audio.play();
    }
 }

