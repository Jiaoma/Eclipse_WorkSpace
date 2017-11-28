import java.util.*;

/**
 * This program demonstrates array manipulation.
 * 从n个数字中随机抽取k个不同数字,显示这些数字
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class LotteryDrawing
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("输入抽取的数字个数: ");
      int k = in.nextInt();

      System.out.print("输入最大可抽取的数字: ");
      int n = in.nextInt();

      // 数组number中存放1,2,...,n
      int[] numbers = new int[n];
      for (int i = 0; i < numbers.length; i++)
         numbers[i] = i + 1;

      // 数组result中存放随机抽取的数字
      int[] result = new int[k];
      for (int i = 0; i < result.length; i++)
      {
         // make a random index between 0 and n - 1
         int r = (int) (Math.random() * n);//0<=r<max

         // pick the element at the random location
         result[i] = numbers[r];//抽取number[r]中的数字

         // move the last element into the random location
         numbers[r] = numbers[n - 1];
         n--;
      }

      // print the sorted array
      Arrays.sort(result);//排序
      System.out.println("Bet the following combination. It'll make you rich!");
       //输出抽取的数字
      for (int r : result)
         System.out.println(r);
   }
}
