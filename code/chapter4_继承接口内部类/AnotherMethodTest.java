//不使用匿名内部类

import java.awt.*;
import java.awt.event.*;

class AnotherMethod extends Frame
{
   private int count;
   private Label label;
   private MButton button;
   public AnotherMethod( )
   {
       label=new Label("count= "+count);
       button=new MButton("hello");
       button.addActionListener(new MButtonActionListener(this));
       add(label,BorderLayout.SOUTH);
       add(button,BorderLayout.NORTH);
   }

   public void setCount(int count)
   {
	   this.count=count;
   }
   public int getCount()
   {
   	   return count;
   }
   public void setLabelText(String text)
   {
	   label.setText(text);
   }
}


class MButton extends Button
{
	public MButton()
	{
	}
	public MButton(String name)
	{
		super(name);
	}
}


class MButtonActionListener implements ActionListener
{
	AnotherMethod m;
	public MButtonActionListener()
	{

	}
	public MButtonActionListener(AnotherMethod m)
   {
	    this.m=m;
	}
	public void actionPerformed(ActionEvent ev)
   {
         m.setCount(m.getCount()+1);
	     m.setLabelText("count ="+m.getCount());
   }
}


public class AnotherMethodTest
{
	public static void main (String [ ]args)
   {
      AnotherMethod  x=new AnotherMethod();
      x.setSize(100,100);
      x.setVisible(true);
   }
}
