//ͬ�������
public class SynBlockThread
{
   public static void main(String [] args)
   {
      TestThread t=new TestThread();
      new Thread(t).start();
      new Thread(t).start();
      new Thread(t).start();
      new Thread(t).start();
   }//end main
}//end class

class TestThread implements Runnable
{
   private int tickets=100;
   String str=new String("");
   public void run()
   {
     while(true)
     {
	   //������ԭ���ԵĴ���ŵ�synchronized����У��γ���ͬ�������
	   //��ͬһʱ�̣�ֻ����һ���߳̽���ͬ������������У�ֻ�и��߳��뿪ͬ�������֮�������̲߳��ܽ���
	   synchronized(str)
	   {
		  if(tickets>0)
	      {
		     try
		     {
		         Thread.sleep(100);
		     }
		     catch(Exception e)
		     {
			     e.printStackTrace();
		     }
		     System.out.println(Thread.currentThread().getName()+" is selling ticket "+tickets--);
		   }
       }//end synchronized
	 }//end while
   }//end run
}//end class