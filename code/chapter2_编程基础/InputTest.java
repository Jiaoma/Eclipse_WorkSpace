//Scanner��ʹ��
import java.util.Scanner;

public class InputTest
{
   public static void main(String [] args)
   {
       Scanner in=new Scanner(System.in);

       //get first input
       System.out.println("What is your pet's name?");
       String name=in.nextLine();

       //get second input
       System.out.println("How old is it?");
       int age=in.nextInt();

       //display output on console
       System.out.println("Next year,"+name+" will be "+(age+1));

   }
}

//����lu lu,��nextLine��Ϊnext����������ʱ���쳣