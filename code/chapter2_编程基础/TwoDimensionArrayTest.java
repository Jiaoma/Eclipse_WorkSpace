public class TwoDimensionArrayTest
{
   public static void main(String [ ]args)
   {
     int [][] iarray={{1,2},{3,4,5},{6,7,8,9}};

     String [][] s1array={{"hello"},{"how","are","you"}};

     String [][] s2array=new String[2][];
     s2array[0]=new String[1];
     s2array[1]=new String[3];

     s2array[0][0]=new String("hello");

     s2array[1][0]=new String("how");
     s2array[1][1]=new String("are");
     s2array[1][2]=new String("you");


     String [][] s3=new String[2][1];
     s3[0][0]="hello";
     s3[1][0]="how";


   }

}