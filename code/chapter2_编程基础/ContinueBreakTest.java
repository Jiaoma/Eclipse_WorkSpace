public class ContinueBreakTest
{
   public static void main(String [] args)
  {
    st:
      for(int i=1;i<=3;i++)
         for(int j=1;j<=3;j++)
         {
			 //if (j==2) break;    //�˳��ڲ�ѭ��
             //if (j==2) break st;//��������ǩ������ĩβ
             //if (j==2) continue;//������ǰѭ����ʣ����䣬����ִ����һ��ѭ��
             //if (j==2) continue st;//�������ǩƥ���ѭ�����ײ�

             System.out.println("i*j="+i+"*"+j+"="+i*j);
		 }
    }
}