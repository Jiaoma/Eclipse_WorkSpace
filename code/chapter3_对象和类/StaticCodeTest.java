class StaticCode
{
   private static String country;//类变量

   public StaticCode()           //构造方法
   {
     System.out.println("beging executing constructor  ");
   }

   static                       //静态代码块只能访问静态的成员，在类被导入时执行一次
   {
      country="china";
      System.out.println("StaticCode is loading");
   }
                                //非静态代码块，不常用，每次创建对象会被执行一次
   {
	   System.out.println("Non Static block is loading");
   }
}

public class StaticCodeTest
{
  public static void main(String [] args)
  {
    System.out.println("beging executing main method");
    new StaticCode( );
    new StaticCode( );
  }

}

//java -verbose StaticCodeTest

//java -verbose StaticCodeTest