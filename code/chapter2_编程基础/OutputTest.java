//��ʽ���������

import java.util.Date;
import java.util.Random;

public class OutputTest
{
   public static void main(String [] args)
   {

       double x=Math.random()*10000;//����һ���������0<=x<10000
       //double x=new Random().nextDouble()*10000;

       System.out.println(x);//��x��Ӧ������������������0����λ�����
       System.out.printf("%08.2f \n",x);//fΪת��������������������8���ַ���Ⱥ�С�������λ���x;0��������ǰ�油��
       System.out.printf("%,.2f \n",x);//����־��ʾ����˷���ķָ���
       System.out.printf("%1$10.4f %1$9.2f %2$s \n",x,"abc");//1$��һ��������2$�ڶ�������
       System.out.printf("%tc \n",new Date());//c�������������ں�ʱ��
       System.out.printf("%tb \n",new Date()); //b������
   }
}