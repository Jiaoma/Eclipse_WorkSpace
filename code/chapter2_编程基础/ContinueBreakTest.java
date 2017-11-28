public class ContinueBreakTest
{
   public static void main(String [] args)
  {
    st:
      for(int i=1;i<=3;i++)
         for(int j=1;j<=3;j++)
         {
			 //if (j==2) break;    //退出内层循环
             //if (j==2) break st;//跳至带标签的语句块末尾
             //if (j==2) continue;//跳出当前循环的剩余语句，接着执行下一次循环
             //if (j==2) continue st;//跳到与标签匹配的循环的首部

             System.out.println("i*j="+i+"*"+j+"="+i*j);
		 }
    }
}