import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class CardLayoutTest
{
   public static void main(String [] args)
   {
      CardFrame  frame=new CardFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

//CardFrame定义的框架包括面板cardPanel和controlPanel.
//cardPanel使用CardLayout,包括3个重叠的面板。controlPanel上包括4个按钮和一个文本框。
//使用controlPanel上的按钮和文本框控制cardPanel上显示的面板。
class  CardFrame extends JFrame
{
    private JPanel cardPanel=new JPanel();
    private JPanel controlPanel=new JPanel();
    private JButton firstButton=new JButton("First");
    private JButton lastButton=new JButton("Last");
    private JButton nextButton=new JButton("Next");
    private JButton prevButton=new JButton("Prev");
    private JTextField textField=new JTextField(6);
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
	   controlPanel.add(firstButton);
	   controlPanel.add(prevButton);
	   controlPanel.add(nextButton);
	   controlPanel.add(lastButton);
	   controlPanel.add(textField);


	   //将cardPanel和controlPanel添加到框架中
	   add(cardPanel,"Center");
	   add(controlPanel,"South");

	   //注册按钮的事件监听器
	   firstButton.addActionListener(new ActionListener()
	   {
		  public void actionPerformed(ActionEvent event)
	     {
		    //显示cardPanel上第一个被添加的组件（面板）
		    cardLayout.first(cardPanel);
		 }
	   });

	   lastButton.addActionListener(new ActionListener()
	   	   {
	   		  public void actionPerformed(ActionEvent event)
	   	     {
	   		   //显示cardPanel上最后一个被添加的组件（面板）
	   		   cardLayout.last(cardPanel);
	   		 }
	   });

	   nextButton.addActionListener(new ActionListener()
	   	   {
	   		  public void actionPerformed(ActionEvent event)
	   	     {
				//显示cardPanel上当前组件之后的下一个组件
	   		    cardLayout.next(cardPanel);
	   		 }
	   });

	   prevButton.addActionListener(new ActionListener()
	   	   {
			   //显示cardPanel上当前组件的前一个组件
	   		  public void actionPerformed(ActionEvent event)
	   	     {
	   		   cardLayout.previous(cardPanel);
	   		 }
	   });

	   textField.addActionListener(new ActionListener()
	   	   	   {
				  //显示指定的组件
	   	   		  public void actionPerformed(ActionEvent event)
	   	   	     {
	   	   		    cardLayout.show(cardPanel,textField.getText().trim());
	   	   		 }
	   	   });


	}
}