//从n个数字中抽取k个数字共有n*(n-1)*...*(n-k+1)/(1*2*3*...*k)种可能结果,中奖几率

import javax.swing.*;
public class ForLotteryTest
{
  public static void main(String [] args)
  {
     String input=JOptionPane.showInputDialog("需要抽取几个数字?");
     int k=Integer.parseInt(input);

     input=JOptionPane.showInputDialog("可抽取的最大数字:");
     int n=Integer.parseInt(input);

     int lotteryodds=1;
     for(int i=1;i<=k;i++)
         lotteryodds=lotteryodds*(n-i+1)/i;

     System.out.println("Your odds are 1 in "+lotteryodds+". Good Luck!");
     System.exit(0);

  }

}
