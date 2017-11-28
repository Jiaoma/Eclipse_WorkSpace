
//switch语句使用实例

import javax.swing.*;

public class SwitchTest
{
   public static void main(String [] args)
   {
      String input=JOptionPane.showInputDialog("今天星期几?");
      int x=Integer.parseInt(input);
      switch(x)
       {
        case 1:System.out.println("Monday");break;
        case 2:System.out.println("Tuesday");break;
        case 3:System.out.println("Wednesday");break;
        case 4:System.out.println("Tursday");break;
        case 5:System.out.println("Friday");break;
        case 6:System.out.println("Sunday");break;
        case 7:System.out.println("Saturday");break;
        default:System.out.println("Sorry,I don't know.");
       }
      System.exit(0);

   }
}
