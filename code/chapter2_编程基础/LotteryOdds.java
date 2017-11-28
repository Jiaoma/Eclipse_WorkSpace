import java.util.*;

/**
 * This program demonstrates a <code>for</code> loop.
 * @version 1.20 2004-02-10
 * @author Cay Horstmann

 * 计算抽奖中奖的概率。例如，从1-50之间的数字抽取6个数字来中奖，
 * 则会有（50*49*48*47*46*45）/(1*2*3*4*5*6)种结果，中奖几率1/15890700
 * 从n个数字中抽取k个数字共有n*(n-1)*...*(n-k+1)/(1*2*3*...*k)种可能结果,
 */


public class LotteryOdds
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("How many numbers do you need to draw? ");
      int k = in.nextInt();

      System.out.print("What is the highest number you can draw? ");
      int n = in.nextInt();

      /*
       * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
       */

      int lotteryOdds = 1;
      for (int i = 1; i <= k; i++)
         lotteryOdds = lotteryOdds * (n - i + 1) / i;

      System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
   }
}
