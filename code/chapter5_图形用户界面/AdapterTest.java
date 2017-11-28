//通过处理窗口事件（关闭框架时，中止程序），显示适配器的作用
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

//方法一  通过实现事件监听器接口来定义事件监听器类。
//WindowListener接口有7个方法，分别对应7种情况；Terminator要实现该接口的所有方法，尽管我们只对
//方法windowClosing感兴趣。
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
//方法二  通过扩展适配器类来定义事件监听器类
//每个具有不止一个方法的AWT监听器接口都有一个实现了所有方法，但是却不做任何工作的适配器类。
class Terminator extends WindowAdapter
{
   public void windowClosing(WindowEvent e)
   {System.exit(0);}

}*/


//WindowEvent事件，WindowListener接口，Terminator监听器类，JFrame对象是事件源