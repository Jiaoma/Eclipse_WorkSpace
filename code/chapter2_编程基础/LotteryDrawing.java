import java.util.*;

/**
 * This program demonstrates array manipulation.
 * ��n�������������ȡk����ͬ����,��ʾ��Щ����
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class LotteryDrawing
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("�����ȡ�����ָ���: ");
      int k = in.nextInt();

      System.out.print("�������ɳ�ȡ������: ");
      int n = in.nextInt();

      // ����number�д��1,2,...,n
      int[] numbers = new int[n];
      for (int i = 0; i < numbers.length; i++)
         numbers[i] = i + 1;

      // ����result�д�������ȡ������
      int[] result = new int[k];
      for (int i = 0; i < result.length; i++)
      {
         // make a random index between 0 and n - 1
         int r = (int) (Math.random() * n);//0<=r<max

         // pick the element at the random location
         result[i] = numbers[r];//��ȡnumber[r]�е�����

         // move the last element into the random location
         numbers[r] = numbers[n - 1];
         n--;
      }

      // print the sorted array
      Arrays.sort(result);//����
      System.out.println("Bet the following combination. It'll make you rich!");
       //�����ȡ������
      for (int r : result)
         System.out.println(r);
   }
}
