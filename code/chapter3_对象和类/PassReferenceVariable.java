
public class PassReferenceVariable
{
   public static void main(String [] args)
   {
	  /*//�����ж����ñ������޸Ĳ���ش�
	  Employee a=new Employee("Alice",70000,2007,11,3);
	  Employee b=new Employee("Bob",60000,2006,12,5);
	  System.out.println("swap����ǰ a="+a.getName());
      System.out.println("swap����ǰ b="+b.getName());
	  swap(a,b);
	  System.out.println("swap���ú� a="+a.getName());
	  System.out.println("swap���ú� b="+b.getName());
      */


	  //�����ж����ñ�����ʶ�Ķ�����޸Ļᱻ����
	  Employee harry=new Employee("Harry",50000,2005,9,8);
	  System.out.println("tripleSalary����ǰsalary="+harry.getSalary());
	  tripleSalary(harry);
	  System.out.println("tripleSalary���ú�salary="+harry.getSalary());


   }

   public static void swap(Employee x,Employee y)
   {
	   Employee temp=x;
	   x=y;
	   y=temp;
	   System.out.println("swap����ǰ x="+x.getName());
	   System.out.println("swap����ǰ y="+y.getName());
   }

   public static void tripleSalary(Employee x)
   {
       x.raiseSalary(200);
       System.out.println("tripleSalary����ǰsalary="+x.getSalary());
   }
}



/*
class PassReferenceVariable
{

   public static void main(String [] args)
   {
     PassReferenceVariable obj=new PassReferenceVariable();
     int []x={5};
     obj.change(x);
     System.out.println(x[0]);
     }

    public  void change(int [] x)
    {
       x[0]=3;
    }

}*/

