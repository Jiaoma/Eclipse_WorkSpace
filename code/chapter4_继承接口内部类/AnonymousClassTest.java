//匿名内部类的使用

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AnonymousClassTest extends JFrame
{
   private int count;
   private JLabel label;
   private JButton button;

   public static void main (String [ ]args)
   {
	   AnonymousClassTest  x=new AnonymousClassTest();
       x.setSize(300,300);
	   x.setVisible(true);
   }

   public AnonymousClassTest()
   {
     label=new JLabel("    count= "+count);
     add(label,BorderLayout.SOUTH);
     button=new JButton("ok");
     add(button,BorderLayout.NORTH);

     button.addActionListener( new  ActionListener( )
	 		   {
	 			  public void actionPerformed(ActionEvent ev)
	 			  {
	 				  count++;
	 				  label.setText("count ="+count);
	 			   }
	 		   }
			 );//end addActionListner();
   }
}


