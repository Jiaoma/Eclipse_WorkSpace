//String��ʹ��
public class StringTest
{
   public static void main( String [] args)
   {
      //���ֳ�ʼ���Ĳ�ͬ
      String s1="abc";
      String s2="abc";
      String s3=new String("abc");
      String s4=new String("abc");

      //==�жϴ�ŵ�ַ�Ƿ���ͬ
      if (s1==s2)
         System.out.println("s1==s2");
      else
         System.out.println("s1!=s2");

      if (s3==s4)
		 System.out.println("s3==s4");
      else
    	  System.out.println("s3!=s4");

      if ((s1==s3)||(s1==s4))
         System.out.println("s1==s3��s1==s4");
      else
          System.out.println("s1!=s3��s1!=s4");


      //�ж������Ƿ���ͬ
      if(s1.equals(s2)&&s3.equals(s4)&&s1.equals(s3))
          System.out.println("s1.euqls(s2)) ��s3.equals(s4)��s1.euqls(s3) is true");


     /* //��������
     String s="hello,java";
     int t=s.indexOf('o');
     int m=s.indexOf("java");
     String l=s.substring(0,4);
     char n=s.charAt(4);
     String k=s.replace(',','!');
     System.out.println("s="+s+"\n s����Ϊ"+s.length()+"\nt="+t+"\nm="+m+"\nl="+l+"\nn="+n+"\nk="+k);
   */
   }
}