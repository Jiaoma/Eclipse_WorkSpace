
//final class A{}//无法继承
class A{ }

public class FinalTest extends A
{
  private final int x;//或final int x=1;正确,final标记成员变量

  public FinalTest()
  {
     x=1;//正确
  }
  public void setＸ()
  {
    //x=1;//错误,final成员变量只能在定义时赋值或构造方法中赋值
  }
  public final void test()
  {
    final int y=1;//final标记局部变量
  }

  public static void main(String [] args)
  {
    System.out.println(Double.MIN_VALUE);//public static final
    System.out.println(Double.MAX_VALUE);
  }
}

/*
● final标记的类不能被继承
● final标记的变量是常量，只能赋值一次（final成员变量必须在定义的时候赋值或在构造方法中赋值，才能使用）
● final标记的方法不能被覆盖
*/
