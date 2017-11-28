//使用runnable接口创建多线程
public class ThreadDemo3
{
   public static void main(String [] args)
   {
      TestThread tt=new TestThread();
      Thread t=new Thread(tt);
      t.start();

      for(int i=0;i<100;i++)
      {
	     System.out.println(Thread.currentThread().getName()+" is running "+i);
	  }
   }
}

class TestThread implements Runnable
{
   public void run()
   {
     for(int i=0;i<100;i++)
     {
	    System.out.println(Thread.currentThread().getName()+" is running "+i);
	 }
   }
}