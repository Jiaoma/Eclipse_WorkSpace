abstract class Shape
{
   public abstract double area();
 }

class Circle extends Shape
{
   private int radius;
   public Circle(int r) { radius=r; }
   public double area(){  return 3.14*radius*radius; }
}

class Square extends Shape
{
   private int width;
   public Square (int w){ width=w; }
   public double area(){ return width*width; }
}

class AbstractClassTest
{
   public static void main(String [] args)
   {
      Shape m;
      m=new Circle(10);
      System.out.println(m.area());
      m=new Square(4);
      System.out.println(m.area());
   }
}

//若shape中无area,则出现错误
//应该将子类中都有的成员变量和方法都放在父类中
//抽象类中可包括抽象方法和非抽象方法