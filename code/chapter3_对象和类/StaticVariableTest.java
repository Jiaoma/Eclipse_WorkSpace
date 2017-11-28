class Chinese
{
   public static String country="中国";
   private String name;
   private int age;
   public void singOurCountry()
   {
      System.out.println("啊,亲爱的"+country);//在类的方法中使用同普通成员变量
   }
}



public class StaticVariableTest
{
   public static void main(String [] args)
   {
     //类变量的两种引用方式
     System.out.println("Chinese country is "+Chinese.country);
     Chinese ch1=new Chinese( );
     System.out.println("Chinese country is "+ch1.country);
     ch1.singOurCountry( );


     //类变量只有一份，在多个对象间共享
     Chinese ch2=new Chinese( );
     ch2.country="china";//最好写成Chinese.country="china"
     ch1.singOurCountry( );
     //static int i=0;//错误，局部变量不能使用static


     //静态常量使用较多
     System.out.println(Math.PI);

    /*//统计对象的个数
     A n=new A( );
     A m=new A( );
     A c=new A( );
     System.out.println("There are "+A.count+" objects of class A");
     */

    }
}

class A
{
   public static int count=0;
   public A( )
   {
     count=count+1;
   }
}
