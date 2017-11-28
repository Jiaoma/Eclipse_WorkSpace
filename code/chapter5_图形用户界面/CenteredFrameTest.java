//在屏幕中央显示一个框架
import java.awt.*;
import javax.swing.*;

public class CenteredFrameTest
{
   public static void main(String[] args)
   {
      CenteredFrame frame = new CenteredFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class CenteredFrame extends JFrame
{
   public CenteredFrame()
   {
	  //获取屏幕大小
	  Toolkit kit = Toolkit.getDefaultToolkit(); //在java中，可使用Toolkit获得系统信息，
	  Dimension screenSize = kit.getScreenSize();//获得屏幕的分辨率
	  int screenHeight = screenSize.height;      //屏幕的高度
	  int screenWidth = screenSize.width;        //屏幕的宽度

	  //设定框架的大小
	  setSize(screenWidth/2,screenHeight/2);

      //居中显示框架
      int x=(screenWidth-getWidth())/2;
      int y=(screenHeight-getHeight())/2;
      setLocation(x,y);//设定框架的显示位置

      //设定图标
      Image img=kit.getImage("blue-ball.gif");
      setIconImage(img);

      //设定框架的标题
      setTitle("CenteredFrame");

   }
}

