//捕获多个异常
import java.util.*;
class ExceptionMultiCatch
{
	public static void main(String args[])
	{
	   int x=(int)(Math.random()*5);
	   int y=(int)(Math.random()*10);
	   int []z=new int[5];
	   System.out.println("x="+x+" y="+y);

	   try
	   {
		   System.out.println("y/x="+(y/x));
		   System.out.println("z[y]="+z[y]);
	   }
	   catch(ArithmeticException e)
	   {
		   System.out.println("Arithmetic problem:"+e);
	   }
	   catch(ArrayIndexOutOfBoundsException e)
	   {
		   System.out.println("Subscript problem:"+e);//得到简短描述
		   System.out.println("e.getMessage():"+e.getMessage());//得到错误信息
		   System.out.println("e.getClass.getName():"+e.getClass().getName());//获取异常对象的实际类型
	       e.printStackTrace();
	   }

    }//end main
 }//end class
