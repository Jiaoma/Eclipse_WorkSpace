//ʹ����������
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

//������
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
	      //�����ݿռ��������
	      if(i==0)
	         q.put(new Data("��Т��","��"));
	      else
	         q.put(new Data("����","Ů"));
	      i=(i+1)%2;
	    }catch(InterruptedException e)
	    {
			e.printStackTrace();
		}
	}
   }//end run
}//end class

//������
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
   	        //�����ݿռ�ȡ����
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



