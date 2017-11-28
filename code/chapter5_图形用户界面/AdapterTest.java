//ͨ���������¼����رտ��ʱ����ֹ���򣩣���ʾ������������
import javax.swing.*;
import java.awt.event.*;

class AdapterTest
{
    public static void main(String [] args)
    {
        JFrame frame=new JFrame();
        WindowListener listener=new Terminator();
        frame.addWindowListener(listener);
        frame.setSize(200,300);
        frame.setVisible(true);
    }
}

//����һ  ͨ��ʵ���¼��������ӿ��������¼��������ࡣ
//WindowListener�ӿ���7���������ֱ��Ӧ7�������TerminatorҪʵ�ָýӿڵ����з�������������ֻ��
//����windowClosing����Ȥ��
class Terminator implements WindowListener
{
   public void windowOpened(WindowEvent e){}
   public void windowClosing(WindowEvent e)
   {  System.exit(0);}
   public void windowClosed(WindowEvent e){}
   public void windowIconified(WindowEvent e){}
   public void windowDeiconified(WindowEvent e){}
   public void windowActivated(WindowEvent e){}
   public void windowDeactivated(WindowEvent e){}
}

/*
//������  ͨ����չ���������������¼���������
//ÿ�����в�ֹһ��������AWT�������ӿڶ���һ��ʵ�������з���������ȴ�����κι������������ࡣ
class Terminator extends WindowAdapter
{
   public void windowClosing(WindowEvent e)
   {System.exit(0);}

}*/


//WindowEvent�¼���WindowListener�ӿڣ�Terminator�������࣬JFrame�������¼�Դ