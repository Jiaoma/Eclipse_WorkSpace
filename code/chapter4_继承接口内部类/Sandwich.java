//: Sandwich.java
// Order of constructor calls
//meal--lunch--portablelunch--sandwich(bread,cheese,lettuce)
class Meal
{
  public Meal() { System.out.println("Meal()"); }
}

class Bread
{
   public Bread() { System.out.println("Bread()"); }
}

class Cheese
{
   public Cheese() { System.out.println("Cheese()"); }
}

class Lettuce
{
   public Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal
{
    public Lunch() { System.out.println("Lunch()");}
}

class PortableLunch extends Lunch
{
   public PortableLunch()
   {
      System.out.println("PortableLunch()");
   }
}

public class Sandwich extends PortableLunch
{
   private Bread b = new Bread();
   private Cheese c = new Cheese();
   private Lettuce l = new Lettuce();
   public Sandwich()
   {
      System.out.println("Sandwich()");
    }
   public static void main(String[] args)
   {
      Sandwich s=new Sandwich();
    }
}

/*���췽����ִ�д���
  1�����ø���Ĺ��췽����������費�ϵķ����ݹ���ȥ�����ȹ������ֲ�νṹ�ĸ���Ȼ������һ�㵼���ࡣ
  2������ǰ�ඨ���г��ֵĴ���ִ�������еĸ�ֵ��
  3��ִ�е�ǰ�๹�췽��������
  */
