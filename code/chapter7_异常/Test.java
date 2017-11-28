//检查finally的执行过程
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
			//int y=10/2;//正常执行
			//int y=10/0;//出现ArithmeticException
			//int[] y=new int[3];//出现其他异常
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

 //正常执行
 //出现ArithmeticException
 //出现其他异常
