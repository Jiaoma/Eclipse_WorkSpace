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

    public void outerMethod()
    {
      System.out.println("x is "+x);
    }

    public void makeInner()
    {
       InnerOne anInner=new InnerOne();
       anInner.innerMethod();
    }
  }


  public class InnerClassTest
  {
	  public void main(String [] args)
	  {
	     OuterOne anOuter=new OuterOne();
	     anOuter.makeInner( );
	  }

  }