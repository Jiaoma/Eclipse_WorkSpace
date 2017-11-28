//线程通信

//实现了同步的Data类
class Data
{
  private String name;
  private String sex;
  public synchronized  void put(String name,String sex)
  {
     this.name=name;
     this.sex=sex;
  }
  public synchronized void get()
  {
     System.out.println(name+"----->"+sex);
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

public class CommunicationThread2
{
  public static void main(String [] args)
  {
     Data q=new Data();
     new Thread(new Producer(q)).start();
     new Thread(new Consumer(q)).start();
  }
}









