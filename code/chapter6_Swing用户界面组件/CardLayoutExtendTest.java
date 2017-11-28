import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class CardLayoutExtendTest
{
   public static void main(String [] args)
   {
      CardFrame  frame=new CardFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class  CardFrame extends JFrame
{
    private JPanel cardPanel=new JPanel();
    private JPanel controlPanel=new JPanel();
    private JButton firstButton=new JButton("First");
    private JButton secondButton=new JButton("Second");
    private JButton thirdButton=new JButton("Third");


    private CardLayout cardLayout=new CardLayout();

    public CardFrame()
    {
	   setSize(400,200);
	   setTitle("Card Layout");

	   //设置cardPanel的布局管理器
	   cardPanel.setLayout(cardLayout);

       //向cardPanel上添加组件（面板）
	   JPanel panel=new JPanel();
	   panel.add(new Label("this is panel one"));
	   cardPanel.add(panel,"first");

	   panel=new JPanel();
	   panel.add(new Label("this is panel two"));
	   cardPanel.add(panel,"second");

	   panel=new JPanel();
	   panel.add(new Label("this is panel three"));
	   cardPanel.add(panel,"third");

	   cardPanel.setBorder(BorderFactory.createRaisedBevelBorder());

	   //向controlPanel上添加按钮和文本框
	   controlPanel.setLayout(new GridLayout(1,6));
	   controlPanel.add(firstButton);
	   controlPanel.add(secondButton);
	   controlPanel.add(thirdButton);

	   //将cardPanel和controlPanel添加到框架中
	   add(cardPanel,"Center");
	   add(controlPanel,"North");

	   //注册按钮的事件监听器
	   firstButton.addActionListener(new ActionListener()
	   {
		  public void actionPerformed(ActionEvent event)
	     {
		    //显示cardPanel上第一个被添加的组件（面板）
		    cardLayout.show(cardPanel,"first");
		 }
	   });

	   secondButton.addActionListener(new ActionListener()
	   	   {
	   		  public void actionPerformed(ActionEvent event)
	   	     {
	   		   //显示cardPanel上最后一个被添加的组件（面板）
	   		   cardLayout.show(cardPanel,"second");
	   		 }
	   });

	   thirdButton.addActionListener(new ActionListener()
	   	   {
	   		  public void actionPerformed(ActionEvent event)
	   	     {
				//显示cardPanel上当前组件之后的下一个组件
	   		    cardLayout.show(cardPanel,"third");
	   		 }
	   });

	}
}