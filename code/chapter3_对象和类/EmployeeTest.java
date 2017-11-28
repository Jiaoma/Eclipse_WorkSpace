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
      // ����������Ա���󣬱�����������
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee( );


      // ÿ���˵Ĺ����ϵ�5%
      for (Employee e : staff)
         e.raiseSalary(5);

      // ���ÿ����Ա����Ϣ
      for (Employee e : staff)
      {   System.out.println("����:" + e.getName());
          System.out.println("����:" + e.getSalary());
          System.out.printf("��Ӷ����:%tF \n\n",e.getHireDay());
      }
   }
}

