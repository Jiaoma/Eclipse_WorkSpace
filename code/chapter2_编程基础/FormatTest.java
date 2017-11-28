//单行注释 This is a sample program in chapter 2.

//package wanj.chapter2;          //包的申明

import javax.swing.JOptionPane; //导入语句

public 	class	FormatTest      //类的定义
{
	public static void main(String[] args)
  {
     String  name=JOptionPane.showInputDialog("What is your pet's name?");
	 String stringage=JOptionPane.showInputDialog("How old is it?");

	 int intage=Integer.parseInt(stringage);

	 JOptionPane.showMessageDialog(null,"next year,"+name+" will be "+(intage+1));//使用消息对话框输出
     //System.out.println("next year,"+name+" will be "+(intage+1));               //使用标准输出方式

	 System.exit(0);
  }
}
class T{}
class S{}


/*  多行注释
Java严格区分大小写
Java是一种自由格式语言，良好的书写格式
注意中英文标点
若使用包，则使用javac -d . FormatTest.java编译，生成正确的路径
两种输入和输出方法:在1.5中Scanner接收数据，println可以设定输出格式
*/