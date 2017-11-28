//: Shapes.java
// Polymorphism in Java

class Shape
{
	public void draw() {}
	public void erase() {}
}

class Circle extends Shape
{
	public void draw()
	{
		System.out.println("Circle.draw()");
	}
	public void erase()
	{
		System.out.println("Circle.erase()");
	}
}


class Square extends Shape
{
	public void draw()
	{
		System.out.println("Square.draw()");
	}
	public void erase()
	{
		System.out.println("Square.erase()");
	}
}

class Triangle extends Shape
{
	public void draw()
	{
		System.out.println("Triangle.draw()");
	}
	public void erase()
	{
		System.out.println("Triangle.erase()");
	}
}

public class Shapes
{
	public static Shape randShape()
	{
		switch((int)(Math.random() * 3))
		{
			default:
			case 0: return new Circle();
			case 1: return new Square();
			case 2: return new Triangle();
		}
	}
	public static void main(String[] args)
	{
		for(int i = 0; i < 9; i++)
	   {
	      Shape a;
	      a=randShape();
	      a.draw();
	   }
    }
}