/**
   ��������ť�¼�
   һ������Ϸ�����3����ť����Ӧÿ����ť��һ���¼������������û�����κ�һ����ť��
   ������ɫ������Ӧ�ı仯��
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest
{
   public static void main(String[] args)
   {
      ButtonFrame frame = new ButtonFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a button panel
*/
class ButtonFrame extends JFrame
{
   public ButtonFrame()
   {
      setTitle("ButtonTest");
      setSize(300,200);

      // add panel to frame

      ButtonPanel panel = new ButtonPanel();
      add(panel);
   }
}

// ButtonPanel��
class ButtonPanel extends JPanel
{
   public ButtonPanel()
   {
      // create buttons

      JButton yellowButton = new JButton("Yellow");
      JButton blueButton = new JButton("Blue");
      JButton redButton = new JButton("Red");

      // add buttons to panel

      add(yellowButton);
      add(blueButton);
      add(redButton);

      // create button actions

      ColorAction yellowAction = new ColorAction(Color.YELLOW);
      ColorAction blueAction = new ColorAction(Color.BLUE);
      ColorAction redAction = new ColorAction(Color.RED);

      // associate actions with buttons

      yellowButton.addActionListener(yellowAction);
      blueButton.addActionListener(blueAction);
      redButton.addActionListener(redAction);
   }


   //   An action listener that sets the panel's background color.
   private class ColorAction implements ActionListener
   {
      private Color backgroundColor;
      public ColorAction(Color c)
      {
         backgroundColor = c;
      }

      public void actionPerformed(ActionEvent event)
      {
         setBackground(backgroundColor);
      }
   }
}




/*
// ButtonPanel�ĵڶ���д��
class ButtonPanel extends JPanel
{
   public ButtonPanel()
   {
      makeButton("Yellow",Color.YELLOW);
      makeButton("Blue",Color.BLUE);
      makeButton("Red",Color.RED);
   }

   void makeButton(String name,Color c)
   {
      JButton button=new JButton(name);
      add(button);
      ColorAction action=new ColorAction(c);
      button.addActionListener(action);
   }

   private class ColorAction implements ActionListener
   {
      private Color backgroundColor;
      public ColorAction(Color c)
      {
         backgroundColor = c;
      }

      public void actionPerformed(ActionEvent event)
      {
         setBackground(backgroundColor);
      }
   }
}
*/

/*
//ButtonPanel�ĵ�����д��,ʹ�������ڲ���
class ButtonPanel extends JPanel
{
   public ButtonPanel()
   {
      makeButton("Yellow",Color.YELLOW);
      makeButton("Blue",Color.BLUE);
      makeButton("Red",Color.RED);
   }

   void makeButton(String name,final Color c)
   {
      JButton button=new JButton(name);
      add(button);
      button.addActionListener(new
      ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
             setBackground(c);
         }
      });
   }


}
*/

/*

//ButtonPanel�ĵ�����д��,���������¼���������
//���ַ�ʽ���������
class ButtonPanel extends JPanel implements ActionListener
{

   private JButton yellowButton;
   private JButton blueButton;
   private JButton redButton;

   public ButtonPanel()
   {
      yellowButton = new JButton("Yellow");
	  blueButton = new JButton("Blue");
	  redButton = new JButton("Red");

	  // add buttons to panel

	  add(yellowButton);
	  add(blueButton);
	  add(redButton);

	  // associate actions with buttons
	  yellowButton.addActionListener(this);//����屾������Ϊ������ť�ļ�����
	  blueButton.addActionListener(this);
      redButton.addActionListener(this);
   }

   public void actionPerformed(ActionEvent event)
   {
	  Object source=event.getSource();   //getSource���������¼�Դ����
	  if(source==yellowButton)     setBackground(Color.YELLOW);
      else if(source==blueButton)  setBackground(Color.BLUE);
      else if(source==redButton)   setBackground(Color.RED);
   }
}
*/