import java.util.*;

public class EmployeeSortTest
{
	 public static void main(String[] args)
	 {
	     // 创建三个雇员对象，保存在数组中
	     Employee[] staff = new Employee[3];

	     staff[0] = new Employee("Carl Cracker",75000,2004,1,2);
	     staff[1] = new Employee("Harry Hacker",35000,2006,10,12);
	     staff[2] = new Employee("Tony Tester",38000 ,2007,7,5);

	     Arrays.sort(staff);

         //输出每个雇员的信息
	     for (Employee e : staff)
	     {   System.out.println("姓名:" + e.getName());
	         System.out.println("工资:" + e.getSalary());
	         System.out.printf("雇佣日期:%tF \n\n",e.getHireDay());
	     }
      }
}

class Employee implements Comparable<Employee>
{
   //成员变量，数据成员
   private String name;
   private double salary;
   private Date hireDay;

   //有参数的构造方法
   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);// GregorianCalendar使用0表示1月
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