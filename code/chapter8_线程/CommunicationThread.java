//�߳�ͨ��

//ʵ�����߳�ͬ����ͨ��
class Data
{
  private String name;
  private String sex;
  boolean bFull=false;//��־����¼���ݿռ�������Ƿ񱻷����ȡ��

  public synchronized  void put(String name,String sex)
  {
     if(bFull)//��������Ѿ����룬��δ��ȡ������ȴ�
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
     if(!bFull)//��������Ѿ���ȡ������δ�����µ����ݣ���ȴ�
     {
	    try{ wait();}
	    catch(InterruptedException e){e.printStackTrace();}
	 }
     System.out.println(name+"----->"+sex);
     bFull=false;
     notify();
     }
}

//������
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
	  //�����ݿռ��������
	  if(i==0)
	     q.put("��Т��","��");
	  else
	     q.put("����","Ů");
	  i=(i+1)%2;
	}
   }//end run
}//end class

//������
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
   	    //�����ݿռ�ȡ����
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



