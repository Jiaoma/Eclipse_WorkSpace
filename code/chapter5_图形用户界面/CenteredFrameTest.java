//����Ļ������ʾһ�����
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
	  //��ȡ��Ļ��С
	  Toolkit kit = Toolkit.getDefaultToolkit(); //��java�У���ʹ��Toolkit���ϵͳ��Ϣ��
	  Dimension screenSize = kit.getScreenSize();//�����Ļ�ķֱ���
	  int screenHeight = screenSize.height;      //��Ļ�ĸ߶�
	  int screenWidth = screenSize.width;        //��Ļ�Ŀ��

	  //�趨��ܵĴ�С
	  setSize(screenWidth/2,screenHeight/2);

      //������ʾ���
      int x=(screenWidth-getWidth())/2;
      int y=(screenHeight-getHeight())/2;
      setLocation(x,y);//�趨��ܵ���ʾλ��

      //�趨ͼ��
      Image img=kit.getImage("blue-ball.gif");
      setIconImage(img);

      //�趨��ܵı���
      setTitle("CenteredFrame");

   }
}

