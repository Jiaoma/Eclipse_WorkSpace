//: Music.java
// Interfaces


interface Instrument
{

	int i =5 ; // static & final&public
    // Cannot have method definitions:
	void play(); // Automatically public,abstract
	String what();
	void adjust();
}

class Wind implements Instrument {
	public void play()
	{
		System.out.println("Wind.play()");
	}
	public String what() { return "Wind"; }
	public void adjust() {}   //注意"adjust(){};"与"adjust();"的区别
}

class Percussion implements Instrument {
	public void play()
	{
		System.out.println("Percussion.play()");
	}
	public String what() { return "Percussion"; }
	public void adjust() {}
}

class Stringed implements Instrument {
	public void play()
	{
		System.out.println("Stringed.play()");
	}
	public String what() { return "Stringed"; }
	public void adjust() {}
}


public class Music {

	public static void main(String[] args)
	{

		Instrument t=new Stringed();
		t.play();
		t=new Percussion();
		t.play();


    }
}