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
    System.out.println(y);//����,�ⲿ�಻��ֱ�ӷ����ڲ���ķ����ͳ�Ա����
    display( );//����
  }
  */
  class Inner
  {
	int y=10;
    void display()
    {
      System.out.println("display:outer_i="+outer_i);//�����ⲿ��ĳ�Ա����
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