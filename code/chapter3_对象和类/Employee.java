import java.util.Date;
import java.util.GregorianCalendar;
public class Employee
{
   //成员变量，数据成员，实例域
   private String name;
   private double salary;
   private Date hireDay;

   //有参数的构造方法
   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);// GregorianCalendar使用0表示1月
      hireDay = calendar.getTime();//获得日历对象所表示的时间点

   }

   //无参数的构造方法
   public Employee()
   {
   }

   //方法
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

/*

如果方法中有与成员变量同名的局部变量，该方法对这个变量名的引用是局部变量；
在方法中可以使用成员变量；
多个类可以放在一个源文件中，也可以位于不同的源文件，每个源文件只包括一个public类；
类中成分的位置可根据个人的书写习惯调整。

Date：时间点，距离一个固定时间点的毫秒数
*/