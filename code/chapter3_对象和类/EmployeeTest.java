/**
   @version 1.11 2004-02-19
   @author Cay Horstmann
*/

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeTest
{
   public static void main(String[] args)
   {
      // 创建三个雇员对象，保存在数组中
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee( );


      // 每个人的工资上调5%
      for (Employee e : staff)
         e.raiseSalary(5);

      // 输出每个雇员的信息
      for (Employee e : staff)
      {   System.out.println("姓名:" + e.getName());
          System.out.println("工资:" + e.getSalary());
          System.out.printf("雇佣日期:%tF \n\n",e.getHireDay());
      }
   }
}

