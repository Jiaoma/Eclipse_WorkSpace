/**
   @version 1.00 2000-05-07
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ColorChooserTest
{
   public static void main(String[] args)
   {
      ColorChooserFrame frame = new ColorChooserFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a color chooser panel
*/
class ColorChooserFrame extends JFrame
{
   public ColorChooserFrame()
   {
      setTitle("ColorChooserTest");
      setSize(300,200);
      JButton button = new JButton("select a color");
	  button.addActionListener(new ModalListener());
      add(button,"North");
    }
   private class ModalListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
      {
          Color defaultColor = getBackground();
          Color selected = JColorChooser.showDialog(null,"Set background", defaultColor);
          if(selected!=null) getContentPane().setBackground(selected);
      }
   }
}

