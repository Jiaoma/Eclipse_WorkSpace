
public class PassReferenceVariable
{
   public static void main(String [] args)
   {
	  /*//方法中对引用变量的修改不会回传
	  Employee a=new Employee("Alice",70000,2007,11,3);
	  Employee b=new Employee("Bob",60000,2006,12,5);
	  System.out.println("swap调用前 a="+a.getName());
      System.out.println("swap调用前 b="+b.getName());
	  swap(a,b);
	  System.out.println("swap调用后 a="+a.getName());
	  System.out.println("swap调用后 b="+b.getName());
      */


	  //方法中对引用变量标识的对象的修改会被保留
	  Employee harry=new Employee("Harry",50000,2005,9,8);
	  System.out.println("tripleSalary调用前salary="+harry.getSalary());
	  tripleSalary(harry);
	  System.out.println("tripleSalary调用后salary="+harry.getSalary());


   }

   public static void swap(Employee x,Employee y)
   {
	   Employee temp=x;
	   x=y;
	   y=temp;
	   System.out.println("swap结束前 x="+x.getName());
	   System.out.println("swap结束前 y="+y.getName());
   }

   public static void tripleSalary(Employee x)
   {
       x.raiseSalary(200);
       System.out.println("tripleSalary结束前salary="+x.getSalary());
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

