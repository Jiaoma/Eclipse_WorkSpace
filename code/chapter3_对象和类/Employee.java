import java.util.Date;
import java.util.GregorianCalendar;
public class Employee
{
   //��Ա���������ݳ�Ա��ʵ����
   private String name;
   private double salary;
   private Date hireDay;

   //�в����Ĺ��췽��
   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);// GregorianCalendarʹ��0��ʾ1��
      hireDay = calendar.getTime();//���������������ʾ��ʱ���

   }

   //�޲����Ĺ��췽��
   public Employee()
   {
   }

   //����
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

��������������Ա����ͬ���ľֲ��������÷���������������������Ǿֲ�������
�ڷ����п���ʹ�ó�Ա������
�������Է���һ��Դ�ļ��У�Ҳ����λ�ڲ�ͬ��Դ�ļ���ÿ��Դ�ļ�ֻ����һ��public�ࣻ
���гɷֵ�λ�ÿɸ��ݸ��˵���дϰ�ߵ�����

Date��ʱ��㣬����һ���̶�ʱ���ĺ�����
*/