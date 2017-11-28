
import java.awt.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ImageBackgroundTest
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
      setSize(400,400);
      this.setContentPane(new ImagePanel());

      JTextField field1=new JTextField(10);
	  add(field1);
	  JTextField field2=new JTextField(10);
	  add(field2);
	  JButton button=new JButton("°´Å¥");
      add(button);
   }
}

class MyPanel extends JPanel
{
	public MyPanel()
	{

	}
}

class ImagePanel extends JPanel
{
   //Image image;
   Image image;
   public ImagePanel()
   {
      // acquire the image
      try
      {
         image = ImageIO.read(new File("lotus.jpg"));
	  }
	  catch(IOException e)
	  {
	      e.printStackTrace();
	  }

   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(image, 0, 0,getWidth(),getHeight(), null);
   }
}







