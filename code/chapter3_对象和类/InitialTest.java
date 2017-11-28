/**
   下面的例子展示了
   （1）重载构造方法
   （2）this调用构造方法
   （3）默认构造方法
   （4）静态初始化块，初始化块，声明中初始化，构造方法中的初始化
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
	private static int nextId;//类变量

	private String name = "no name"; // 在申明时初始化，instance variable initialization
	private double salary;
	private int id;

   // 以下是三个重载的构造方法，three overloaded constructors
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
      System.out.println("两个参数的构造方法");
   }

   public Employee(double s)
   {
      // 调用类中的其他构造方法， Employee(String, double) constructor
      this("Employee #" + nextId, s);
      System.out.println("一个参数的构造方法");
   }

   // 无参的构造方法，the default constructor
   public Employee()
   {
      // name initialized to ""--see below
      // salary not explicitly set--initialized to 0
      // id initialized in initialization block
      System.out.println("无参数的构造方法");
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

   // 静态初始化代码块，static initialization block
   static
   {
      Random generator = new Random();
      nextId =generator.nextInt(10000);//将nextId赋值为>=0,<9999的一个随机数
      System.out.println("静态初始化代码块");
   }

   //对象初始化代码块，object initialization block
   {
       id = nextId;
       nextId++;
       System.out.println("对象初始化代码块");
    }
}
