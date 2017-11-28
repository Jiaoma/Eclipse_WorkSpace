//同步代码块
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
	   //将具有原子性的代码放到synchronized语句中，形成了同步代码块
	   //在同一时刻，只能有一个线程进入同步代码块内运行，只有该线程离开同步代码块之后，其他线程才能进入
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