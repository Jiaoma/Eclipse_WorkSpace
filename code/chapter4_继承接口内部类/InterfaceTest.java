interface Runner
{
   int ID=1;      //public static final
   void run();    //public abstract
}

interface Flyer
{
  void fly();
}

//һ���ӿڿ��Լ̳���һ���ӿ�
interface Animal extends Runner
{
   void breathe();
}

//��Fishʵ���˽ӿ�Animal�е����з���
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

//������LandAnimalʵ���˽ӿ�Animal�е�һ�����������Ա�����abstract
abstract class LandAnimal implements Animal
{
  public void breathe()
  {
     System.out.println("land animal is breathing");
  }
}

//��Student�̳���Person������ʵ���˽ӿ�Runner
class Student extends Person implements Runner
{
   public void run()
   {
     System.out.println("a student is running");
   }

}

//��Birdʵ���˶���ӿ�
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
    //Runner r=new Runner����;//���󣬽ӿڲ���ʵ������
    Animal a=fish;//�ӿ����ñ���
    int j;
    j=Runner.ID;//�ӿ���.��Ա������
    j=Animal.ID;
    j=fish.ID;//������.��Ա������
    //fish.ID=2;//���󣬳���
  }
}