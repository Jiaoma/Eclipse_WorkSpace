class OuterOne
{
    private int x;

    public class InnerOne//�ڲ���
   {
       private int y;
       public void innerMethod()
       {
          System.out.println("enclosing x is "+x);//�����ⲿ��ĳ�Ա����
          System.out.println("y is " +y);
       }
    }

    public void makeInner()
    {
	   System.out.println("x is "+x);
        //System.out.println("y is "+y);//����,�ⲿ�಻�ܷ����ڲ���ĳ�Ա����
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



/*  class OuterOne//�ֲ��������ڲ����Ա�������ⲿ���Ա����ͬ��
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