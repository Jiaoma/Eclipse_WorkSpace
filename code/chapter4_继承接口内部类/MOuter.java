public class MOuter
{
   private int member=100;

   public void go(int x, final int y)
   {
	  int a=x+y;
	  final int b=x-y;

	  //go方法内的内部类
	  class MInner
	  {
	  	 public void method()
	  	 {
	  	  	 System.out.println("member is "+member);//访问外部类的成员变量
	  	  	 System.out.println("y is "+y);//访问方法的final局部变量
	  	  	 System.out.println("b is "+b);//访问方法的final局部变量
	  	  	 //System.out.println("x is "+x);//错误，不能访问外部方法的非final局部变量
	    	 //System.out.println("a is "+a);//错误
	  	  }//method结束
	  }//MInner结束


      MInner aMInner=new MInner();
      aMInner.method();

	}//end go

	public static void main(String [] args)
   {
	      MOuter aMOuter=new MOuter();
	      aMOuter.go(200,300);
   }
}
