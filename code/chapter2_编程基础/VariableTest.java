public class VariableTest
{

   public static void main(String [] args)
   {

       // byte t1=138;//错误,超过表示范围,-127..128

        int t2=2;//局部变量

        final double PI=3.14;//常量
        //PI=13;

       {
	    int t3=3;
	    //int t3;//未初始化
	    System.out.println(t2);
	    System.out.println(t3);
	   }
        System.out.println(t2);
        //System.out.println(t3);//错误，超过作用范围*/
   }
}












/*
  1、取值范围
  2、变量分为
    成员变量：对象创建时创建，销毁时销毁
    自动变量（局部变量）：方法执行时存在
    类变量：static,静态的变量，类载入时创建，卸载时销毁
  3、成员变量和类变量可自动初始化；
  4、块是由一对花括号括起来的语句，代码块决定了其中定义的变量的作用范围
*/