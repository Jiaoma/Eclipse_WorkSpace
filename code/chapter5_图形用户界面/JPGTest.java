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
		 JButton readButton=new JButton("��ʾͼ���ļ�");
		 readButton.addActionListener(new ReadListener());
		 buttonPanel.add(readButton);

		 JButton shapeButton=new JButton("�����ʾͼ��");
		 shapeButton.addActionListener(new ShapeListener());
		 buttonPanel.add(shapeButton);

		 JButton saveButton=new JButton("���浽jpg�ļ�");
		 saveButton.addActionListener(new SaveListener());
		 buttonPanel.add(saveButton);

		 add(buttonPanel,BorderLayout.SOUTH);

	 }

	 class SaveListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			  //��ȡҪ����ͼƬ���ļ�
			  chooser.setCurrentDirectory(new File("."));
			  JPGFileFilter filter= new JPGFileFilter();//�����ļ�����������ʾ��׺Ϊ .jpg���ļ�
			  chooser.setFileFilter(filter);
			  chooser.showSaveDialog(null); // ��ʾѡ��Ի���
              File file=chooser.getSelectedFile();

              //ͼƬ���浽�ļ�
		      int imgWidth =panel.getWidth();
		      int  imgHeight =panel.getHeight();
		      BufferedImage  myImage  =  new  BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		      Graphics2D  g2  =  myImage.createGraphics();
		      panel.paint(g2);//panel�ϵ�����д��myImage
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
			  //��ȡҪ��ʾ���ļ�
			  chooser.setCurrentDirectory(new File("."));
			  JPGFileFilter filter= new JPGFileFilter();//�����ļ�����������ʾ��׺Ϊ .jpg���ļ�
			  chooser.setFileFilter(filter);
			  chooser.showOpenDialog(null); // ��ʾѡ��Ի���
              File file=chooser.getSelectedFile();

              //��ʾ
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
				 //�������Ҫ��ʾ��ͼ��
	 		      Shape shape=null;
	 		      int i=(int)(Math.random()*3);
	 		      switch(i)
	 		      {
					  case 0:shape=new Rectangle2D.Double(100.0,100.0,200.0,150.0); break;
					  case 1:shape=new Ellipse2D.Double(100,100,200,150);break;
					  case 2:shape=new Line2D.Double(0,0,200,200);break;
				  }

				  //����ͼ��
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
   ������һ���ļ����������������� .jpg�ļ�
*/
class JPGFileFilter extends FileFilter
{
   //���ظ����͵�˵����Ϣ
   public String getDescription()
   {
      return "jpg�ļ�";
   }

   //�����ļ��Ƿ���Խ���
   public boolean accept(File f)
   {
      if (f.isDirectory()) return true;
      String name = f.getName().toLowerCase();
      if( name.endsWith(".jpg"))
         return true;
      else return false;
   }
}
