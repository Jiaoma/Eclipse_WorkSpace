public class ForTest
{
   public static void main(String [] args)
  {
     int k=0;

     //for (int i,int j;k<=10;k++) //错误

     //for(int i,j;k<=10;k++)//正确

     //for(int i=0;k<=10;k++)//正确

     //int i,j;
     //for(i=0,j=0;k<=10;k++)//正确

     //for(int i,i=0;k<=10;k++)//错误

     //System.out.println(k);
    }
}
/*
  for语句的第一部分，不能同时有变量申明语句和其他语句
  如果包含变量申明语句，则只能包括一条该申明语句。
*/