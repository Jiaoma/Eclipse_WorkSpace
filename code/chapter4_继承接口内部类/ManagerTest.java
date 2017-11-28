/**
   @version 1.21 2004-02-21
   @author Cay Horstmann
*/

import java.util.*;

public class ManagerTest
{
   public static void main(String[] args)
   {
      // construct a Manager object
      Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);

      Employee[] staff = new Employee[3];

      // fill the staff array with Manager and Employee objects
      staff[0] = boss;
      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

      // print out information about all Employee objects
      for (Employee e : staff)
         System.out.println("name=" + e.getName()
            + ",salary=" + e.getSalary());
   }
}

class Employee
{
   private String name;
   private double salary;
   private Date hireDay;

   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      hireDay = calendar.getTime();
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
      double raise = salary * byPercent / 100;
      salary += raise;
   }
}

class Manager extends Employee
{
   private double bonus;

   public Manager(String n, double s, int year, int month, int day)
   {
      super(n, s, year, month, day);//调用父类的带参构造方法
      bonus = 0;
   }

   public double getSalary()//覆盖，改写方法
   {
      double baseSalary = super.getSalary();//调用父类被覆盖的方法
      return baseSalary + bonus;
   }

   public void setBonus(double b)//新增方法
   {
      bonus = b;
   }
}

//Manager和Employee之间存在is-a关系。
//Employee类：超类(superclass)，基类(base class)，父类(parent class)
//Manager类：子类(subclass)，派生类(derived class)，孩子类(child class)

//子类将继承父类成员(成员变量，方法) ,但不能直接访问父类private成员
//单继承, 多层继承
//子类对父类可做扩展和特殊化
// (1)创建新的成员：变量和方法
// (2)重新定义父类中已有的变量：隐藏
// (3)重新定义父类中已有的方法：覆盖(override )
//子类中的方法应与父类中的被覆盖的方法有完全相同的：参数列表、返回值；而且访问权限不能更严格
//super():被覆盖的方法，父类的构造方法
