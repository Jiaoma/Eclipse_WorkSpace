//假设有一个文本域，要求输入4个字符；如果输入不正确，则光标自动返回该文本域
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FocusTest
{
   public static void main(String[] args)
   {
      MyFrame frame = new MyFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}


class MyFrame extends JFrame
{
   public MyFrame()
   {
      setSize(300,200);
      MyPanel panel = new MyPanel();
      add(panel);
   }
}


class MyPanel extends JPanel
{
   JTextField field1,field2;

   public MyPanel()
   {
      field1=new JTextField(10);
      add(field1);
      field2=new JTextField(10);
      add(field2);

      FocusAdapter listener = new MyFocusListener();
      field1.addFocusListener(listener);
      field2.addFocusListener(listener);

   }

   private class MyFocusListener extends FocusAdapter
   {
      public void focusLost(FocusEvent event)
      {  //getComponent()返回取得或失去焦点的组件，也可使用getSource(),getSource是EventObject中的方法
         if (event.getComponent()==field1)
            if(field1.getText().length()!=4)
               field1.requestFocus();              //将焦点强制移到field1

         if(event.getComponent()==field2)
            field2.setText("field2 lost focus");
      }

      public void focusGained(FocusEvent event)
      {
	     if(event.getComponent()==field2)
	          field2.setText("field2 get focus");
	  }
   }
}