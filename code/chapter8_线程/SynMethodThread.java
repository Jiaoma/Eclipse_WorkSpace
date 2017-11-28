//同步方法
public class SynMethodThread
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
	   sale();
     }
    }//end run

	//同步方法
    public  synchronized   void sale()
	{
	   if(tickets>0)
	   {
	     try
	     {
	        Thread.sleep(100);
	     }
	     catch(InterruptedException e)
	     {
		    e.printStackTrace();
	     }
	     System.out.println(Thread.currentThread().getName()+" is selling ticket "+tickets--);
	   }
     }//end sale

}//end class

