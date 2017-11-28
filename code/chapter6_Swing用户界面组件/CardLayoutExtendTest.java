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

	   //����cardPanel�Ĳ��ֹ�����
	   cardPanel.setLayout(cardLayout);

       //��cardPanel������������壩
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

	   //��controlPanel����Ӱ�ť���ı���
	   controlPanel.setLayout(new GridLayout(1,6));
	   controlPanel.add(firstButton);
	   controlPanel.add(secondButton);
	   controlPanel.add(thirdButton);

	   //��cardPanel��controlPanel��ӵ������
	   add(cardPanel,"Center");
	   add(controlPanel,"North");

	   //ע�ᰴť���¼�������
	   firstButton.addActionListener(new ActionListener()
	   {
		  public void actionPerformed(ActionEvent event)
	     {
		    //��ʾcardPanel�ϵ�һ������ӵ��������壩
		    cardLayout.show(cardPanel,"first");
		 }
	   });

	   secondButton.addActionListener(new ActionListener()
	   	   {
	   		  public void actionPerformed(ActionEvent event)
	   	     {
	   		   //��ʾcardPanel�����һ������ӵ��������壩
	   		   cardLayout.show(cardPanel,"second");
	   		 }
	   });

	   thirdButton.addActionListener(new ActionListener()
	   	   {
	   		  public void actionPerformed(ActionEvent event)
	   	     {
				//��ʾcardPanel�ϵ�ǰ���֮�����һ�����
	   		    cardLayout.show(cardPanel,"third");
	   		 }
	   });

	}
}