

class Cleanser {
   private String s = new String("Cleanser");
   public void append(String a) { s += a; }
   public void dilute() { append(" dilute()"); }
   public void apply() { append(" apply()"); }
   public void scrub() { append(" scrub()"); }
   public void print() { System.out.println(s); }
  }

class Detergent extends Cleanser {

  // Change a method:
  public void scrub() {
     append(" Detergent.scrub()");
     super.scrub(); // Call base-class version
  }

  // Add methods :
  public void foam() { append(" foam()"); }

}

class InheritTest
{

  public static void main(String [] args)
  {
    Detergent x1 = new Detergent();

    System.out.println("\nTesting subclass:");
    x1.dilute();
    x1.apply();
    x1.scrub();
    x1.foam();
    x1.print();

    Cleanser x2=new Cleanser();
    System.out.println("\nTesting subclass as base class:");
	x2.dilute();
	x2.apply();
	x2.scrub();
    x2.print();

  }
}