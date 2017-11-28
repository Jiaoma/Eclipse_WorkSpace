class OuterOne
{
    private int x;

    public class InnerOne//内部类
   {
       private int y;
       public void innerMethod()
       {
          System.out.println("enclosing x is "+x);//访问外部类的成员变量
          System.out.println("y is " +y);
       }
    }

    public void makeInner()
    {
	   System.out.println("x is "+x);
        //System.out.println("y is "+y);//错误,外部类不能访问内部类的成员变量
       InnerOne anInner=new InnerOne();
       anInner.innerMethod();
    }
  }

public class InnerClassTest
{
	public static void main(String [] args)
	{
	     OuterOne anOuter=new OuterOne();
	     anOuter.makeInner();
	}
}



/*  class OuterOne//局部变量，内部类成员变量，外部类成员变量同名
  {
     private int size;
     public class InnerOne
     {
	    private int size;
	    public void doStuff(int size)
	    {
		   size++;
		   this.size++;
		   OuterOne.this.size++;
		}
	 }

  }
  */