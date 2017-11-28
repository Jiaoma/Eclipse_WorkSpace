
import java.io.*;
import java.util.*;

class ObjectStreamTest
{
   public static void main(String[] args)
   {
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Mary Hacker", 30000);
      staff[1] = new Employee("Harry Hacker", 50000);
      staff[2] = new Employee("Tony Tester", 40000);

      try
      {
         // save all employee records to the file employee.dat
         ObjectOutputStream out = new ObjectOutputStream(new  FileOutputStream("employee3.dat"));
         out.writeObject(staff);
         out.close();

         // retrieve all records into a new array
         ObjectInputStream in =  new ObjectInputStream(new  FileInputStream("employee3.dat"));
         Employee[] newStaff = (Employee[])in.readObject();
         in.close();

         // print the newly read employee records
         for (int i = 0; i < newStaff.length; i++)
            System.out.println(newStaff[i]);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}

class Employee implements Serializable
{
   private String name;
   private double salary;
   public Employee() {}

   public Employee(String n, double s )
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

   public String toString()
   {
      return getClass().getName()+ "[name=" + name + ",salary=" + salary+ "]";
   }
}

