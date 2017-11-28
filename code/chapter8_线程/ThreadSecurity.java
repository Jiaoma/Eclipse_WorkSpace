//线程安全问题

public class ThreadSecurity
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
   public void run()
   {
     while(true)
     {
	    if(tickets>0)
	    {
		   try
		   {
		      Thread.sleep(1000);//迫使线程暂停执行，让出cpu给别的线程。在指定时间之后，再获得执行机会。
		   }
		   catch(InterruptedException e)
		   {
			   e.printStackTrace();
		   }
		  System.out.println(Thread.currentThread().getName()+" is selling ticket "+tickets--);
		}

	 }//end while
   }//end run
}//end class