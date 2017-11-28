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

//��shape����area,����ִ���
//Ӧ�ý������ж��еĳ�Ա�����ͷ��������ڸ�����
//�������пɰ������󷽷��ͷǳ��󷽷�