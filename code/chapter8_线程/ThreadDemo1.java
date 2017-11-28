//使用Thread创建多线程
public class ThreadDemo1
{
   public static void main(String [] args)
   {
      TestThread t=new TestThread();
      t.start();//not t.run();

      for(int i=0;i<100;i++)
      {
	     System.out.println(Thread.currentThread().getName()+" is running "+i);
	  }
   }
}

class TestThread extends Thread
{
   public void run()
   {
     for(int i=0;i<100;i++)
     {
	    System.out.println("Test Thread is running "+i);
	 }
   }
}



/*
System.out.println(t.getPriority());
t.setPriority(Thread.MIN_PRIORITY);
t.setPriority(Thread.MAX_PRIORITY);
t.setPriority(Thread.MAX_PRIORITY);
*/