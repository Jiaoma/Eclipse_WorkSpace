class Outer
{
  int outer_i=100;
  void test( )
  {
    Inner in=new Inner( );
    in.display( );
  }
/*
  void showy()
  {
    System.out.println(y);//错误,外部类不能直接访问内部类的方法和成员变量
    display( );//错误
  }
  */
  class Inner
  {
	int y=10;
    void display()
    {
      System.out.println("display:outer_i="+outer_i);//访问外部类的成员变量
    }
  }
}


class InnerMemberClassTest
{
  public static void main(String [] args)
  {
    Outer outer=new Outer();
    outer.test( );
  }
}