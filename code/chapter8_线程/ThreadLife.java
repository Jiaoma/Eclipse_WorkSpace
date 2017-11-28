//控制线程的生命
public class ThreadLife
{
   public static void main(String [] args)
   {
      ThreadTest t=new ThreadTest();
      new Thread(t).start();
      for(int i=0;i<100;i++)
      {
        if (i==50)
          t.stopMe();
        System.out.println("mainThread is running "+i);
      }
   }
}

class ThreadTest implements Runnable
{
   private boolean bFlag=true;
   public void stopMe()
   {
     bFlag=false;
   }
  public void run()
  {
     while(bFlag)
     {
       System.out.println(Thread.currentThread().getName()+" is running");
     }
  }
}
