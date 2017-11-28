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
      super(n, s, year, month, day);//���ø���Ĵ��ι��췽��
      bonus = 0;
   }

   public double getSalary()//���ǣ���д����
   {
      double baseSalary = super.getSalary();//���ø��౻���ǵķ���
      return baseSalary + bonus;
   }

   public void setBonus(double b)//��������
   {
      bonus = b;
   }
}

//Manager��Employee֮�����is-a��ϵ��
//Employee�ࣺ����(superclass)������(base class)������(parent class)
//Manager�ࣺ����(subclass)��������(derived class)��������(child class)

//���ཫ�̳и����Ա(��Ա����������) ,������ֱ�ӷ��ʸ���private��Ա
//���̳�, ���̳�
//����Ը��������չ�����⻯
// (1)�����µĳ�Ա�������ͷ���
// (2)���¶��常�������еı���������
// (3)���¶��常�������еķ���������(override )
//�����еķ���Ӧ�븸���еı����ǵķ�������ȫ��ͬ�ģ������б�����ֵ�����ҷ���Ȩ�޲��ܸ��ϸ�
//super():�����ǵķ���������Ĺ��췽��
