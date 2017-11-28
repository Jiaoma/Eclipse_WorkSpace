import java.util.*;

/**
 * This program demonstrates a <code>for</code> loop.
 * @version 1.20 2004-02-10
 * @author Cay Horstmann

 * ����齱�н��ĸ��ʡ����磬��1-50֮������ֳ�ȡ6���������н���
 * ����У�50*49*48*47*46*45��/(1*2*3*4*5*6)�ֽ�����н�����1/15890700
 * ��n�������г�ȡk�����ֹ���n*(n-1)*...*(n-k+1)/(1*2*3*...*k)�ֿ��ܽ��,
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
