//线程通信

//实现了线程同步和通信
class Data
{
  private String name;
  private String sex;
  boolean bFull=false;//标志，记录数据空间的数据是否被放入或取出

  public synchronized  void put(String name,String sex)
  {
     if(bFull)//如果数据已经放入，还未被取出，则等待
    {
	  try{ wait();}
	  catch(InterruptedException e){e.printStackTrace();}
    }
     this.name=name;
     this.sex=sex;
     bFull=true;
     notify();
  }
  public synchronized void get()
  {
     if(!bFull)//如果数据已经被取出，还未放入新的数据，则等待
     {
	    try{ wait();}
	    catch(InterruptedException e){e.printStackTrace();}
	 }
     System.out.println(name+"----->"+sex);
     bFull=false;
     notify();
     }
}

//生产者
class Producer implements Runnable
{
  private Data q=null;

  public Producer(Data q)
  {
    this.q=q;
  }

  public void run()
 {
    int i=0;
    while(true)
    {
	  //向数据空间放入数据
	  if(i==0)
	     q.put("张孝祥","男");
	  else
	     q.put("陈琼","女");
	  i=(i+1)%2;
	}
   }//end run
}//end class

//消费者
class Consumer implements Runnable
{
   private Data q=null;
   public Consumer(Data q)
   {
     this.q=q;
   }
   public void run()
   {
     while(true)
     {
   	    //从数据空间取数据
   	    q.get();
  	  }
   }
}

public class CommunicationThread
{
  public static void main(String [] args)
  {
     Data q=new Data();
     new Thread(new Producer(q)).start();
     new Thread(new Consumer(q)).start();
  }
}



