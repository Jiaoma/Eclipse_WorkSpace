class Chinese
{
  private String name;
  private int age;
  private  static String country="�й�";

  public static void sing( )
  {
    System.out.println("��");
    //age=23;//����,���ܷ��ʷǾ�̬��Ա
    //singOurCountry ( );//����,���ܷ��ʷǾ�̬��Ա
    //this.age=23;//����,����ʹ��this
    System.out.println(country);
  }

  public void singOurCountry( )
  {
    sing( );//���������������Է���
  }
}

public class StaticMethodTest
{
  public static void main(String [] args)
  {
     Chinese.sing( );//����:����.������( )
     Chinese ch1=new Chinese ( );
     ch1.sing( );//����:������.������( )

     System.out.println(Math.pow(4,3));//һ����������Ҫ���ʶ����״̬
  }
}

//���һ����������Ҫ���ʶ����״̬����ֻ��Ҫ������ľ�̬��Ա����ʹ�þ�̬����