/**

*/

import java.io.*;
import java.util.*;

public class DataFileTest
{
   public static void main(String[] args)
   {
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Carl Cracker", 75000);
      staff[1] = new Employee("Harry Hacker", 50000);
      staff[2] = new Employee("Tony Tester", 40000);

      try
      {
         // save all employee records to the file employee.dat
         PrintWriter out = new PrintWriter(new FileWriter("employee1.dat"));
         writeData(staff, out);
         out.close();

         // retrieve all records into a new array
         BufferedReader in = new BufferedReader(new  FileReader("employee1.dat"));
         Employee[] newStaff = readData(in);
         in.close();

         // print the newly read employee records
         for (int i = 0; i < newStaff.length; i++)
            System.out.println(newStaff[i]);
      }
      catch(IOException exception)
      {
         exception.printStackTrace();
      }
   }

   /**
      Writes all employees in an array to a print writer
      @param e an array of employees
      @param out a print writer
   */
   static void writeData(Employee[] e, PrintWriter out)
      throws IOException
   {
      // write number of employees
      out.println(e.length);

      for (int i = 0; i < e.length; i++)
         e[i].writeData(out);
   }

   /**
      Reads an array of employees from a buffered reader
      @param in the buffered reader
      @return the array of employees
   */
   static Employee[] readData(BufferedReader in)
      throws IOException
   {
      // retrieve the array size
      int n = Integer.parseInt(in.readLine());

      Employee[] e = new Employee[n];
      for (int i = 0; i < n; i++)
      {
         e[i] = new Employee();
         e[i].readData(in);
      }
      return e;
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

   public String toString()
   {
      return getClass().getName()
         + " name=" + name
         + ",salary=" + salary;

   }

   /**
      Writes employee data to a print writer
      @param out the print writer
   */
   public void writeData(PrintWriter out) throws IOException
   {
       out.println(name);
       out.println(salary );
   }

   /**
      Reads employee data from a buffered reader
      @param in the buffered reader
   */
   public void readData(BufferedReader in) throws IOException
   {
      name = in.readLine();
      salary = Double.parseDouble(in.readLine());
   }
}

