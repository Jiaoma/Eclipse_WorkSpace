import java.awt.Graphics;
import java.applet.Applet;
//�ڽ�����ʾ���ʱ����Ҫ�õ���Graphics�Ķ���
//Applet�������е�java applet�ĸ��ࣻ

public class MyFirstApplet extends Applet//���е�applet������Applet�������
{
	public String s;
	public void init()
	{
	  s=new String("Welcome to java world!");//����һ���ַ�������
	}
	public void paint(Graphics g)
	{
	  g.drawString(s,25,25);//�������������Ϊ��25��25����λ����ʾ�ַ���s
  	}
}



//applet�����Ǵӷ���init( )��ʼִ�еģ�
//�ڸ÷���������˶��ַ���s�ĳ�ʼ��������
//����ʾ�������ڷ���paint( )��ִ�еġ�
//paint( )��������Applet��һ����Ա������
//�������ͼ�ζ���Graphics g��
//ͨ�����ö���g��drawString( )�����Ϳ�����ʾ�����




