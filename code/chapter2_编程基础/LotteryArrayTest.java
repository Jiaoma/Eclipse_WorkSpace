//从n个数字中随机抽取k个不同数字,显示这些数字
import javax.swing.JOptionPane;
import java.util.Arrays;

public class LotteryArrayTest
{
   public static void main(String [] args)
   {
      String input=JOptionPane.showInputDialog("输入抽取的数字个数:");
      int num=Integer.parseInt(input);
      input=JOptionPane.showInputDialog("输入最大可抽取的数字:");
      int max=Integer.parseInt(input);

      //数组number中存放1,2,...,n
      int [] number=new int[max];
      for(int i=0;i<number.length;i++)
          number[i]=i+1;

      //数组result中存放随机抽取的数字
      int [] result=new int[num];
      int ranNum;
      for(int i=0;i<result.length;i++)
     {
         ranNum=(int)(Math.random( )*max);//0<=r<max
         result[i]=number[ranNum];  //抽取number[r]中的数字
         number[ranNum]=number[max-1];
         max--;
     }

      Arrays.sort(result);//排序
      //输出抽取的数字
      for(int r:result)
     {
          System.out.println(r);
     }

     System.exit(0);
   }

}