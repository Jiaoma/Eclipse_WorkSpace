public class MOuter
{
   private int member=100;

   public void go(int x, final int y)
   {
	  int a=x+y;
	  final int b=x-y;

	  //go�����ڵ��ڲ���
	  class MInner
	  {
	  	 public void method()
	  	 {
	  	  	 System.out.println("member is "+member);//�����ⲿ��ĳ�Ա����
	  	  	 System.out.println("y is "+y);//���ʷ�����final�ֲ�����
	  	  	 System.out.println("b is "+b);//���ʷ�����final�ֲ�����
	  	  	 //System.out.println("x is "+x);//���󣬲��ܷ����ⲿ�����ķ�final�ֲ�����
	    	 //System.out.println("a is "+a);//����
	  	  }//method����
	  }//MInner����


      MInner aMInner=new MInner();
      aMInner.method();

	}//end go

	public static void main(String [] args)
   {
	      MOuter aMOuter=new MOuter();
	      aMOuter.go(200,300);
   }
}
