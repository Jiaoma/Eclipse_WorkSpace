class Chinese
{
   public static String country="�й�";
   private String name;
   private int age;
   public void singOurCountry()
   {
      System.out.println("��,�װ���"+country);//����ķ�����ʹ��ͬ��ͨ��Ա����
   }
}



public class StaticVariableTest
{
   public static void main(String [] args)
   {
     //��������������÷�ʽ
     System.out.println("Chinese country is "+Chinese.country);
     Chinese ch1=new Chinese( );
     System.out.println("Chinese country is "+ch1.country);
     ch1.singOurCountry( );


     //�����ֻ��һ�ݣ��ڶ������乲��
     Chinese ch2=new Chinese( );
     ch2.country="china";//���д��Chinese.country="china"
     ch1.singOurCountry( );
     //static int i=0;//���󣬾ֲ���������ʹ��static


     //��̬����ʹ�ý϶�
     System.out.println(Math.PI);

    /*//ͳ�ƶ���ĸ���
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
