//后台线程
public class DaemonThread
{
   public static void main(String [] args)
   {
      ThreadTest t=new ThreadTest();
      Thread tt=new Thread(t);
      tt.setDaemon(true);
      tt.start();
   }
}


class ThreadTest implements Runnable
{
   public void run()
   {
      while(true)
      {
         System.out.println(Thread.currentThread().getName()+" is running. ");
      }
   }
}



