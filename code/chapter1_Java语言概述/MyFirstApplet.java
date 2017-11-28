import java.awt.Graphics;
import java.applet.Applet;
//在进行显示输出时，需要用到类Graphics的对象；
//Applet类是所有的java applet的父类；

public class MyFirstApplet extends Applet//所有的applet程序都是Applet类的子类
{
	public String s;
	public void init()
	{
	  s=new String("Welcome to java world!");//生成一个字符串对象
	}
	public void paint(Graphics g)
	{
	  g.drawString(s,25,25);//在浏览器中坐标为（25，25）的位置显示字符串s
  	}
}



//applet程序是从方法init( )开始执行的，
//在该方法中完成了对字符串s的初始化工作，
//而显示功能是在方法paint( )中执行的。
//paint( )方法是类Applet的一个成员方法，
//其参数是图形对象Graphics g，
//通过调用对象g的drawString( )方法就可以显示输出。




