/**
   ���������չʾ��
   ��1�����ع��췽��
   ��2��this���ù��췽��
   ��3��Ĭ�Ϲ��췽��
   ��4����̬��ʼ���飬��ʼ���飬�����г�ʼ�������췽���еĳ�ʼ��
*/

import java.util.*;

public class InitialTest
{
   public static void main(String[] args)
   {
      Employee staff1 = new Employee("Harry", 40000);
      System.out.println("*--*--*--*--*--*--*--*--*--*\n");
      Employee staff2 = new Employee(60000);
      System.out.println("*--*--*--*--*--*--*--*--*--*\n");
      Employee staff3 = new Employee();
      System.out.println("*--*--*--*--*--*--*--*--*--*\n");

      System.out.println("name="+staff1.getName()+",id="+staff1.getId()+",salary="+staff1.getSalary());
      System.out.println("name="+staff2.getName()+",id="+staff2.getId()+",salary="+staff2.getSalary());
      System.out.println("name="+staff3.getName()+",id="+staff3.getId()+",salary="+staff3.getSalary());
   }
}

class Employee
{
	private static int nextId;//�����

	private String name = "no name"; // ������ʱ��ʼ����instance variable initialization
	private double salary;
	private int id;

   // �������������صĹ��췽����three overloaded constructors
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
      System.out.println("���������Ĺ��췽��");
   }

   public Employee(double s)
   {
      // �������е��������췽���� Employee(String, double) constructor
      this("Employee #" + nextId, s);
      System.out.println("һ�������Ĺ��췽��");
   }

   // �޲εĹ��췽����the default constructor
   public Employee()
   {
      // name initialized to ""--see below
      // salary not explicitly set--initialized to 0
      // id initialized in initialization block
      System.out.println("�޲����Ĺ��췽��");
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public int getId()
   {
      return id;
   }

   // ��̬��ʼ������飬static initialization block
   static
   {
      Random generator = new Random();
      nextId =generator.nextInt(10000);//��nextId��ֵΪ>=0,<9999��һ�������
      System.out.println("��̬��ʼ�������");
   }

   //�����ʼ������飬object initialization block
   {
       id = nextId;
       nextId++;
       System.out.println("�����ʼ�������");
    }
}
