
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
      //staff[0]��e1��Ӧͬһ����
      if (staff[0].equals(e1))//��������ʱ��e1�����Զ�ת������ֵ��otherobject
         System.out.println("staff[0] equals e1");

      //staff[0]��staff[3]��Ӧ�Ķ����������ͬ
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

   //�������Emoloyee����name,salary��hireDay��ͬ������Ϊ������ͬ
   public boolean equals(Object otherobject)
   {
      if(this==otherobject) return true;
      if(otherobject==null) return false;
      if(getClass()!=otherobject.getClass())  return false;
      Employee other=(Employee)otherobject;//ǿ��ת��
      if(name.equals(other.name)&&salary==other.salary&&hireDay.equals(other.hireDay))
      //�������Ҳ����д���������ʽ��ֱ�Ӷ�otherobjectǿ��ת�������Գ��ԣ������ת�����ᷢ��ʲô���
     //if(name.equals(((Employee)otherobject).name)&&salary==((Employee)otherobject).salary&&hireDay.equals(((Employee)otherobject).hireDay))
         return true;
      else return false;
   }
}

