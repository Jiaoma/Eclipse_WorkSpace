interface Runner
{
   int ID=1;      //public static final
   void run();    //public abstract
}

interface Flyer
{
  void fly();
}

//一个接口可以继承另一个接口
interface Animal extends Runner
{
   void breathe();
}

//类Fish实现了接口Animal中的所有方法
class Fish implements Animal
{
   public void run()
   {
     System.out.println("fish is swimming");
   }

   public void breathe()
   {
      System.out.println("fish is bubbling");
   }
}

//抽象类LandAnimal实现了接口Animal中的一个方法，所以必须是abstract
abstract class LandAnimal implements Animal
{
  public void breathe()
  {
     System.out.println("land animal is breathing");
  }
}

//类Student继承类Person，并且实现了接口Runner
class Student extends Person implements Runner
{
   public void run()
   {
     System.out.println("a student is running");
   }

}

//类Bird实现了多个接口
class Bird implements Runner,Flyer
{
   public void run()
   {
      System.out.println("a bird is running");
   }
   public void fly()
   {
      System.out.println("a bird is flying");
   }
}

class InterfaceTest
{
  public static void main(String [] args)
  {
    Fish fish=new Fish();
    //Runner r=new Runner（）;//错误，接口不能实例化；
    Animal a=fish;//接口引用变量
    int j;
    j=Runner.ID;//接口名.成员变量名
    j=Animal.ID;
    j=fish.ID;//对象名.成员变量名
    //fish.ID=2;//错误，常量
  }
}