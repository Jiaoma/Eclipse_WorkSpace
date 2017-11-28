//使用阻塞队列
import java.util.concurrent.*;

class Data
{
  private String name;
  private String sex;
  public Data(String name,String sex)
  {
	  this.name=name;
	  this.sex=sex;
  }
  public  String toString()
  {
	  return "name:"+name+" sex:"+sex;
  }
}

//生产者
class Producer implements Runnable
{
  private BlockingQueue<Data> q=null;

  public Producer(BlockingQueue<Data> q)
  {
    this.q=q;
  }

  public void run()
 {
    int i=0;
    while(true)
    {
		try
		{
	      //向数据空间放入数据
	      if(i==0)
	         q.put(new Data("张孝祥","男"));
	      else
	         q.put(new Data("陈琼","女"));
	      i=(i+1)%2;
	    }catch(InterruptedException e)
	    {
			e.printStackTrace();
		}
	}
   }//end run
}//end class

//消费者
class Consumer implements Runnable
{
   private BlockingQueue<Data> q=null;
   public Consumer(BlockingQueue<Data> q)
   {
     this.q=q;
   }
   public void run()
   {
     while(true)
     {
		 try
		 {
   	        //从数据空间取数据
   	        System.out.println(Thread.currentThread().getName()+":"+q.take());
		 }catch(InterruptedException e)
	    {
		    e.printStackTrace();
		}
  	  }
   }
}

public class BlockingQueueTest
{
  public static void main(String [] args)
  {
     BlockingQueue<Data> dataQueue=new ArrayBlockingQueue<Data>(1);
     new Thread(new Producer(dataQueue)).start();
     new Thread(new Consumer(dataQueue)).start();
  }
}



