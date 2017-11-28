//À¿À¯
class A
{
  synchronized void foo(B b)
  {
    String name=Thread.currentThread().getName();
    System.out.println(name + " entered A.foo ");
    try
    {
       Thread.sleep(1000);
    }
    catch(Exception e)
    {
       System.out.println(e);
    }
    System.out.println(name + " trying to call B.last()");
    b.last();
  }//end syn

  synchronized void last()
  {
     System.out.println("inside A.last");
  }
}

class B
{
  synchronized void bar(A a)
  {
    String name=Thread.currentThread().getName();
    System.out.println(name + " entered B.bar ");
    try
    {
       Thread.sleep(1000);
    }
    catch(Exception e)
    {
       System.out.println(e);
    }
    System.out.println(name + " trying to call A.last()");
    a.last();
  }//end syn

  synchronized void last()
  {
     System.out.println("inside B.last");
  }
}

class MyThread1 implements Runnable
{
   B b;
   A a;
   public MyThread1(A a,B b)
   {
     this.b=b;
     this.a=a;
   }
   public void run()
   {
        Thread.currentThread().setName("MyThread1");
        b.bar(a);
        System.out.println("back in MyThread1");
    }

}

class MyThread2 implements Runnable
{
   B b;
   A a;
   public MyThread2(A a,  B b)
   {
	   this.b=b;
	   this.a=a;
   }
   public void run()
   {
       Thread.currentThread().setName("MyThread2");
       a.foo(b);
       System.out.println("back in MyThread2");
   }
}

public class DeadLock
{
	public static void main(String [] args)
   {

	   A a=new A();
	   B b=new B();
	   MyThread1 m=new MyThread1(a,b);
	   MyThread2 n=new MyThread2(a,b);
	   Thread t1=new Thread(m);
	   Thread t2=new Thread(n);
	   t1.start();
	   t2.start();
	   System.out.println("end in main thread");
    }

}