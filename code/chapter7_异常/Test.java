//���finally��ִ�й���
import java.util.*;
class Test
{
	public static void main(String args[])
	{
         method();
         System.out.println("main end");
    }

    public static void method( )
    {
		try{
			//int y=10/2;//����ִ��
			//int y=10/0;//����ArithmeticException
			//int[] y=new int[3];//���������쳣
			//y[3]=4;
			System.out.println("try end");
		}
		catch(ArithmeticException e)
		{
			System.out.println("ArithmeticException");
		}
		finally
		{
			System.out.println("finally");
		}
		System.out.println("method end");
	}
 }//end class

 //����ִ��
 //����ArithmeticException
 //���������쳣
