class StaticCode
{
   private static String country;//�����

   public StaticCode()           //���췽��
   {
     System.out.println("beging executing constructor  ");
   }

   static                       //��̬�����ֻ�ܷ��ʾ�̬�ĳ�Ա�����౻����ʱִ��һ��
   {
      country="china";
      System.out.println("StaticCode is loading");
   }
                                //�Ǿ�̬����飬�����ã�ÿ�δ�������ᱻִ��һ��
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