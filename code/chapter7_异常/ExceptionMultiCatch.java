//�������쳣
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
		   System.out.println("Subscript problem:"+e);//�õ��������
		   System.out.println("e.getMessage():"+e.getMessage());//�õ�������Ϣ
		   System.out.println("e.getClass.getName():"+e.getClass().getName());//��ȡ�쳣�����ʵ������
	       e.printStackTrace();
	   }

    }//end main
 }//end class
