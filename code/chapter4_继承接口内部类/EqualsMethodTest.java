
import java.util.*;

public class EqualsMethodTest
{
   public static void main(String [] args)
   {
      Employee e1=new Employee("Jane",2000,new Date());
      Employee e2=new Employee("Jack",3000,new Date());
      Employee e3=new Employee("Jane",2000,new Date());
      Employee staff[]=new Employee[3];
      staff[0]=e1;
      staff[1]=e2;
      staff[2]=e3;
      //staff[0]与e1对应同一对象
      if (staff[0].equals(e1))//方法调用时，e1发生自动转换，传值给otherobject
         System.out.println("staff[0] equals e1");

      //staff[0]与staff[3]对应的对象的内容相同
      if(staff[0].equals(staff[2]))
         System.out.println("staff[0] equals  staff[2]");

      if (staff[0].equals(e2))
         System.out.println("staff[0] euqls e2");
   }
}

class Employee
{
	private String name;
    private double salary;
    private Date hireDay;

	public Employee(String name, double salary, Date hireDay)
   {  this.name = name;
      this.salary =salary;
      this.hireDay =hireDay;
   }

   //如果两个Emoloyee对象name,salary和hireDay相同，则认为他们相同
   public boolean equals(Object otherobject)
   {
      if(this==otherobject) return true;
      if(otherobject==null) return false;
      if(getClass()!=otherobject.getClass())  return false;
      Employee other=(Employee)otherobject;//强制转换
      if(name.equals(other.name)&&salary==other.salary&&hireDay.equals(other.hireDay))
      //上面这句也可以写成下面的形式，直接对otherobject强制转换；可以尝试，如果不转换，会发生什么情况
     //if(name.equals(((Employee)otherobject).name)&&salary==((Employee)otherobject).salary&&hireDay.equals(((Employee)otherobject).hireDay))
         return true;
      else return false;
   }
}

