//��n�������г�ȡk�����ֹ���n*(n-1)*...*(n-k+1)/(1*2*3*...*k)�ֿ��ܽ��,�н�����

import javax.swing.*;
public class ForLotteryTest
{
  public static void main(String [] args)
  {
     String input=JOptionPane.showInputDialog("��Ҫ��ȡ��������?");
     int k=Integer.parseInt(input);

     input=JOptionPane.showInputDialog("�ɳ�ȡ���������:");
     int n=Integer.parseInt(input);

     int lotteryodds=1;
     for(int i=1;i<=k;i++)
         lotteryodds=lotteryodds*(n-i+1)/i;

     System.out.println("Your odds are 1 in "+lotteryodds+". Good Luck!");
     System.exit(0);

  }

}
