//��n�������������ȡk����ͬ����,��ʾ��Щ����
import javax.swing.JOptionPane;
import java.util.Arrays;

public class LotteryArrayTest
{
   public static void main(String [] args)
   {
      String input=JOptionPane.showInputDialog("�����ȡ�����ָ���:");
      int num=Integer.parseInt(input);
      input=JOptionPane.showInputDialog("�������ɳ�ȡ������:");
      int max=Integer.parseInt(input);

      //����number�д��1,2,...,n
      int [] number=new int[max];
      for(int i=0;i<number.length;i++)
          number[i]=i+1;

      //����result�д�������ȡ������
      int [] result=new int[num];
      int ranNum;
      for(int i=0;i<result.length;i++)
     {
         ranNum=(int)(Math.random( )*max);//0<=r<max
         result[i]=number[ranNum];  //��ȡnumber[r]�е�����
         number[ranNum]=number[max-1];
         max--;
     }

      Arrays.sort(result);//����
      //�����ȡ������
      for(int r:result)
     {
          System.out.println(r);
     }

     System.exit(0);
   }

}