//����ע�� This is a sample program in chapter 2.

//package wanj.chapter2;          //��������

import javax.swing.JOptionPane; //�������

public 	class	FormatTest      //��Ķ���
{
	public static void main(String[] args)
  {
     String  name=JOptionPane.showInputDialog("What is your pet's name?");
	 String stringage=JOptionPane.showInputDialog("How old is it?");

	 int intage=Integer.parseInt(stringage);

	 JOptionPane.showMessageDialog(null,"next year,"+name+" will be "+(intage+1));//ʹ����Ϣ�Ի������
     //System.out.println("next year,"+name+" will be "+(intage+1));               //ʹ�ñ�׼�����ʽ

	 System.exit(0);
  }
}
class T{}
class S{}


/*  ����ע��
Java�ϸ����ִ�Сд
Java��һ�����ɸ�ʽ���ԣ����õ���д��ʽ
ע����Ӣ�ı��
��ʹ�ð�����ʹ��javac -d . FormatTest.java���룬������ȷ��·��
����������������:��1.5��Scanner�������ݣ�println�����趨�����ʽ
*/