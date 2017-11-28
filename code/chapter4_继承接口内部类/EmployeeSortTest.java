import java.util.*;

public class EmployeeSortTest
{
	 public static void main(String[] args)
	 {
	     // ����������Ա���󣬱�����������
	     Employee[] staff = new Employee[3];

	     staff[0] = new Employee("Carl Cracker",75000,2004,1,2);
	     staff[1] = new Employee("Harry Hacker",35000,2006,10,12);
	     staff[2] = new Employee("Tony Tester",38000 ,2007,7,5);

	     Arrays.sort(staff);

         //���ÿ����Ա����Ϣ
	     for (Employee e : staff)
	     {   System.out.println("����:" + e.getName());
	         System.out.println("����:" + e.getSalary());
	         System.out.printf("��Ӷ����:%tF \n\n",e.getHireDay());
	     }
      }
}

class Employee implements Comparable<Employee>
{
   //��Ա���������ݳ�Ա
   private String name;
   private double salary;
   private Date hireDay;

   //�в����Ĺ��췽��
   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);// GregorianCalendarʹ��0��ʾ1��
      hireDay = calendar.getTime();
   }

   public int compareTo( Employee other)
   {
       if(salary<other.salary) return -1;
       if(salary>other.salary) return 1;
       return 0;
    }

   public String getName()
   {
      return name;
   }
   public double getSalary()
   {
      return salary;
   }
   public Date getHireDay()
   {
      return hireDay;
   }
   public void raiseSalary(double byPercent)
   {
      salary =salary*(1+byPercent/100);
   }
}