//String的使用
public class StringTest
{
   public static void main( String [] args)
   {
      //两种初始化的不同
      String s1="abc";
      String s2="abc";
      String s3=new String("abc");
      String s4=new String("abc");

      //==判断存放地址是否相同
      if (s1==s2)
         System.out.println("s1==s2");
      else
         System.out.println("s1!=s2");

      if (s3==s4)
		 System.out.println("s3==s4");
      else
    	  System.out.println("s3!=s4");

      if ((s1==s3)||(s1==s4))
         System.out.println("s1==s3或s1==s4");
      else
          System.out.println("s1!=s3且s1!=s4");


      //判断内容是否相同
      if(s1.equals(s2)&&s3.equals(s4)&&s1.equals(s3))
          System.out.println("s1.euqls(s2)) 且s3.equals(s4)且s1.euqls(s3) is true");


     /* //基本方法
     String s="hello,java";
     int t=s.indexOf('o');
     int m=s.indexOf("java");
     String l=s.substring(0,4);
     char n=s.charAt(4);
     String k=s.replace(',','!');
     System.out.println("s="+s+"\n s长度为"+s.length()+"\nt="+t+"\nm="+m+"\nl="+l+"\nn="+n+"\nk="+k);
   */
   }
}