import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest
{
	public static void main(String[] args)
	{
		ActionListener listener=new TimerPrinter();
		Timer t=new Timer(1000,listener);//参数分别为间隔时间，实现了ActionListener的对象
		t.start();                       //启动

		JOptionPane.showMessageDialog(null,"Quit program?");
		System.exit(0);
	}
}

class TimerPrinter implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		Date now=new Date();
		System.out.println("At the tone,the time is "+now);
		Toolkit.getDefaultToolkit().beep();
	}
}

//timer启动后，每隔一秒调用一次actionPerformed方法


