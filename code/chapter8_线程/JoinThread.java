//�����߳�
public class JoinThread
{
   public static void main(String [] args)
   {
      ThreadTest t=new ThreadTest();
      Thread tt=new Thread(t);
      tt.start();


      for(int j=0;j<=50;j++)
      {
	     if(j==10)
	     {
		    try
		    {
			  tt.join();//ttִ����ɺ�main�ٿ�ʼִ��
			}
			catch(InterruptedException e)
			{
			  e.printStackTrace();
			}
		 }
		 System.out.println(Thread.currentThread().getName()+" is running "+j);
	  }
   }
}


class ThreadTest implements Runnable
{
   public void run()
   {
      for(int k=0;k<=50;k++)
      {
         System.out.println(Thread.currentThread().getName()+" is running "+k);
      }
   }
}



