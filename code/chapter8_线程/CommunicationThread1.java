//δʵ��ͬ����ͨѶ�Ĵ���

//��Ʒ
class Data
{
  private String name;
  private String sex;
  public void put(String name,String sex)
  {
     this.name=name;
     this.sex=sex;
  }
  public void get()
  {
     System.out.println(name+"----->"+sex);
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



public class CommunicationThread1
{
  public static void main(String [] args)
  {
     Data q=new Data();
     new Thread(new Producer(q)).start();
     new Thread(new Consumer(q)).start();
  }
}


//����ʱ����Ҽ��ó�����ͣ
