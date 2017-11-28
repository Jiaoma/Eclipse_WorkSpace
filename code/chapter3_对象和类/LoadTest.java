public class LoadTest
{
  public static void main(String [] args)
  {
    // Person t;//java -verbose LoadTest将显示不会载入Person.class
     Person t=new Person();
     //Person.id=123;
     //Person.t();

  }
}

class Person
{
   public static int id;
   public static void t(){ }
}


//在以下情况虚拟机载入类
//1.首次创建Person的对象
//2.首次访问Person的静态方法，静态字段

