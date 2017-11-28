//�߳�ͨ��
import javax.swing.*;

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
  private boolean tag=true;

  public Producer(Data q)
  {
    this.q=q;
  }

  public void run()
 {
    int i=0;
    while(tag)
    {
	  //�����ݿռ��������
	  if(i==0)
	     q.put("��Т��","��");
	  else
	     q.put("����","Ů");
	  i=(i+1)%2;
	}
   }//end run

   public void setTag(boolean tag)
   {
	   this.tag=tag;
   }
}//end class

//������
class Consumer implements Runnable
{
   private Data q=null;
   private boolean tag=true;

   public Consumer(Data q)
   {
     this.q=q;
   }
   public void run()
   {
     while(tag)
     {
   	    //�����ݿռ�ȡ����
   	    q.get();
  	  }
   }
    public void setTag(boolean tag)
   {
   	   this.tag=tag;
   }
}

public class CommunicationInterruptThread
{
  public static void main(String [] args)
  {
     Data q=new Data();
     Producer producer=new  Producer(q);
     new Thread(producer).start();
     Consumer consumer=new Consumer(q);
     new Thread(consumer).start();

     String input=JOptionPane.showInputDialog("����stop��ֹ����");
     if(input.equals("stop"))
     {
		 producer.setTag(false);
		 consumer.setTag(false);
	 }
  }
}



