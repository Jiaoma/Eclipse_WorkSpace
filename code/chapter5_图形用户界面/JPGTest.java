import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class JPGTest
{
	 public static void main(String args[])  throws Exception
	 {
		 MFrame frame=new MFrame();
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
	 }
}

class MFrame extends JFrame
{
	 DrawingPanel panel;
	 JFileChooser chooser=new JFileChooser();;
	 public MFrame() throws Exception
	 {
		 setSize(500,500);
		 setLocation(200,100);
		 panel=new DrawingPanel();
		 add(panel);

         JPanel buttonPanel=new JPanel();
		 JButton readButton=new JButton("显示图像文件");
		 readButton.addActionListener(new ReadListener());
		 buttonPanel.add(readButton);

		 JButton shapeButton=new JButton("随机显示图形");
		 shapeButton.addActionListener(new ShapeListener());
		 buttonPanel.add(shapeButton);

		 JButton saveButton=new JButton("保存到jpg文件");
		 saveButton.addActionListener(new SaveListener());
		 buttonPanel.add(saveButton);

		 add(buttonPanel,BorderLayout.SOUTH);

	 }

	 class SaveListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			  //获取要保存图片的文件
			  chooser.setCurrentDirectory(new File("."));
			  JPGFileFilter filter= new JPGFileFilter();//设置文件过滤器，显示后缀为 .jpg的文件
			  chooser.setFileFilter(filter);
			  chooser.showSaveDialog(null); // 显示选择对话框
              File file=chooser.getSelectedFile();

              //图片保存到文件
		      int imgWidth =panel.getWidth();
		      int  imgHeight =panel.getHeight();
		      BufferedImage  myImage  =  new  BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		      Graphics2D  g2  =  myImage.createGraphics();
		      panel.paint(g2);//panel上的内容写到myImage
		      try
		      {
		            ImageIO.write(myImage,"JPEG",file);
		       }
		      catch  (Exception  e1)
		      {
		            e1.printStackTrace();
		      }
		 }
	 }

	 class ReadListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			  //获取要显示的文件
			  chooser.setCurrentDirectory(new File("."));
			  JPGFileFilter filter= new JPGFileFilter();//设置文件过滤器，显示后缀为 .jpg的文件
			  chooser.setFileFilter(filter);
			  chooser.showOpenDialog(null); // 显示选择对话框
              File file=chooser.getSelectedFile();

              //显示
		      try
		      {
		           BufferedImage myImage=ImageIO.read(file);
				   panel.setImage(myImage);
				   repaint();
		       }
		      catch  (Exception  e1)
		       {
		            e1.printStackTrace();
		       }
		 }
	 }

	  class ShapeListener implements ActionListener
	  {
	 		 public void actionPerformed(ActionEvent e)
	 		 {
				 //随机生成要显示的图形
	 		      Shape shape=null;
	 		      int i=(int)(Math.random()*3);
	 		      switch(i)
	 		      {
					  case 0:shape=new Rectangle2D.Double(100.0,100.0,200.0,150.0); break;
					  case 1:shape=new Ellipse2D.Double(100,100,200,150);break;
					  case 2:shape=new Line2D.Double(0,0,200,200);break;
				  }

				  //绘制图形
				  panel.setShape(shape);
				  repaint();
	 		 }
	 }
}

class DrawingPanel extends JPanel
{
    private Image image=null;
    private Shape shape=null;

    public void paint(Graphics g)
   {
    	super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D)g;
    	if(image!=null)
        {
			g.drawImage(image,0,0,getWidth(),getHeight(),null);
        }
        if(shape!=null)
        {
		    g2.setPaint(Color.red);
        	g2.draw(shape);
        }
    }
    public void setImage(Image image)
    {
	    this.image=image;
	    shape=null;
    }

    public void setShape(Shape shape)
	{
	    this.shape=shape;
	    image=null;
    }
}

/**
   下面是一个文件过滤器，接受所有 .jpg文件
*/
class JPGFileFilter extends FileFilter
{
   //返回该类型的说明信息
   public String getDescription()
   {
      return "jpg文件";
   }

   //测试文件是否可以接受
   public boolean accept(File f)
   {
      if (f.isDirectory()) return true;
      String name = f.getName().toLowerCase();
      if( name.endsWith(".jpg"))
         return true;
      else return false;
   }
}
