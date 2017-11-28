class Chinese
{
  private String name;
  private int age;
  private  static String country="中国";

  public static void sing( )
  {
    System.out.println("啊");
    //age=23;//错误,不能访问非静态成员
    //singOurCountry ( );//错误,不能访问非静态成员
    //this.age=23;//错误,不能使用this
    System.out.println(country);
  }

  public void singOurCountry( )
  {
    sing( );//类中其他方法可以访问
  }
}

public class StaticMethodTest
{
  public static void main(String [] args)
  {
     Chinese.sing( );//引用:类名.方法名( )
     Chinese ch1=new Chinese ( );
     ch1.sing( );//引用:对象名.方法名( )

     System.out.println(Math.pow(4,3));//一个方法不需要访问对象的状态
  }
}

//如果一个方法不需要访问对象的状态或者只需要访问类的静态成员，则使用静态方法