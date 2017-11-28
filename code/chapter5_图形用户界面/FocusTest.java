//������һ���ı���Ҫ������4���ַ���������벻��ȷ�������Զ����ظ��ı���
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
      {  //getComponent()����ȡ�û�ʧȥ����������Ҳ��ʹ��getSource(),getSource��EventObject�еķ���
         if (event.getComponent()==field1)
            if(field1.getText().length()!=4)
               field1.requestFocus();              //������ǿ���Ƶ�field1

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