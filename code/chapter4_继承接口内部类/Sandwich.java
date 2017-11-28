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

/*构造方法的执行次序
  1、调用父类的构造方法。这个步骤不断的反复递归下去，首先构造这种层次结构的根，然后是下一层导出类。
  2、按当前类定义中出现的次序执行声明中的赋值；
  3、执行当前类构造方法的主体
  */
