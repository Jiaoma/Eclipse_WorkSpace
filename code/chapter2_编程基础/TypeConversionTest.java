//type conversion and promotion

public class TypeConversionTest
{
   public static void main(String[] args)
   {
    /*//赋值时进行的自动转换和强制转换
     byte b=3;//可以将int直接量赋值给byte,short,char变量
     int x=b;
     //b=x;  //错误
     b=(byte)x;//强制转换
    */

    /*//数学运算时进行的自动转换（自动提升promotion）
     byte b=5;
     b=b-2;//错误,因为进行了自动提升,结果为int型
     System.out.println(b);
    */


    /*
     float f=2.1f;
     byte b=20;
     int i=100;
	 char c='a';//97
	 double d=1.2;
	 short s=10;

	 double result=(f*b)+(i/c)-(d*s);
	 System.out.println("result="+result);
     System.out.println('a'+1);
     */

   }
}