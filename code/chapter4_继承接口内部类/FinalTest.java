
//final class A{}//�޷��̳�
class A{ }

public class FinalTest extends A
{
  private final int x;//��final int x=1;��ȷ,final��ǳ�Ա����

  public FinalTest()
  {
     x=1;//��ȷ
  }
  public void set��()
  {
    //x=1;//����,final��Ա����ֻ���ڶ���ʱ��ֵ���췽���и�ֵ
  }
  public final void test()
  {
    final int y=1;//final��Ǿֲ�����
  }

  public static void main(String [] args)
  {
    System.out.println(Double.MIN_VALUE);//public static final
    System.out.println(Double.MAX_VALUE);
  }
}

/*
�� final��ǵ��಻�ܱ��̳�
�� final��ǵı����ǳ�����ֻ�ܸ�ֵһ�Σ�final��Ա���������ڶ����ʱ��ֵ���ڹ��췽���и�ֵ������ʹ�ã�
�� final��ǵķ������ܱ�����
*/
