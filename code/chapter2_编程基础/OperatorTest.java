//运算符(整数与浮点数除的区别;&&与&的区别;移位运算符)
public class OperatorTest
{
   public static void main(String [] args)
   {

      /*
      //整数与浮点数
       int i=3510;
       System.out.println(i/1000*1000);
       double j=3510;
       System.out.println(j/1000*1000);
       //System.out.println(i/0);//产生异常
       System.out.println(j/0);//得到无穷大
      */

      /* //&&与&的区别
       int x=0;
       int y=0;
       if(x!=0&y==y/x)
          System.out.println("y="+y);
       */

      //位运算
      // int z=9;
      //System.out.println((z&8)/8);//用二进制表示的z从右数第4位，如果为1则，得到1；如果为0，则得到0


      /*//移位运算符
      int x=0x80000000;
      int y=0x80000000;
      System.out.println("x="+x);
      System.out.println("x="+Integer.toBinaryString(x));
      x=x>>1;
      y=y>>>1;
      System.out.println("x="+Integer.toBinaryString(x));
      System.out.println("y="+Integer.toBinaryString(y));
      */

     }
}