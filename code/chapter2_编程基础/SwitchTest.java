
//switch���ʹ��ʵ��

import javax.swing.*;

public class SwitchTest
{
   public static void main(String [] args)
   {
      String input=JOptionPane.showInputDialog("�������ڼ�?");
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
