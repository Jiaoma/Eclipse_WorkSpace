import java.io.*;
import java.util.*;

public class TextFileTest
{
   public static void main(String[] args)
   {
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Carl Cracker", 75000);
      staff[1] = new Employee("Harry Hacker", 50000);
      staff[2] = new Employee("Tony Tester", 40000);

      try
      {
         // save all employee records to the file employee.txt
         PrintWriter out = new PrintWriter(new FileWriter("employee.txt"));
         out.println(staff.length);
         for(int i=0;i<staff.length;i++)
         {
			 out.println(staff[i].getName());
             out.println(staff[i].getSalary());
		 }
		 out.close();

         // retrieve all records
         BufferedReader in = new BufferedReader(new  FileReader("employee.txt"));
         int num=Integer.parseInt(in.readLine());
         for(int i=0;i<num;i++)
         {
            String name = in.readLine();
            double salary = Double.parseDouble(in.readLine());
            System.out.println(name+" "+salary );
	     }


		  /* Scanner in=new Scanner(new FileReader("employee.txt"));
		   int num=Integer.parseInt(in.nextLine());
		   for(int i=0;i<num;i++)
		   {
		      String name=in.nextLine();
		      double salary = Double.parseDouble(in.nextLine());
		      System.out.println(name+" "+salary );
	     }*/
	     in.close();
      }
      catch(IOException exception)
      {
         exception.printStackTrace();
      }
   }
}


class Employee
{
   private String name;
   private double salary;

   public Employee() {}

   public Employee(String n, double s)
   {
      name = n;
      salary = s;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }
}

