/**
   在窗口中显示图像
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.*;

public class ImageTest
{
   public static void main(String[] args)
   {
      ImageFrame frame = new ImageFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
    A frame with an image panel
*/
class ImageFrame extends JFrame
{
   public ImageFrame()
   {
      setTitle("ImageTest");
      setSize(1024,768);

      // add panel to frame

      ImagePanel panel = new ImagePanel();
      add(panel);
   }
}

/**
   A panel that displays a tiled image
*/
class ImagePanel extends JPanel
{
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
      //g.drawImage(image, 0, 0, null);
      g.drawImage(image, 0, 0,getWidth(),getHeight(), null);
   }
}

