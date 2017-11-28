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

//CardFrame����Ŀ�ܰ������cardPanel��controlPanel.
//cardPanelʹ��CardLayout,����3���ص�����塣controlPanel�ϰ���4����ť��һ���ı���
//ʹ��controlPanel�ϵİ�ť���ı������cardPanel����ʾ����塣
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
	   controlPanel.add(firstButton);
	   controlPanel.add(prevButton);
	   controlPanel.add(nextButton);
	   controlPanel.add(lastButton);
	   controlPanel.add(textField);


	   //��cardPanel��controlPanel��ӵ������
	   add(cardPanel,"Center");
	   add(controlPanel,"South");

	   //ע�ᰴť���¼�������
	   firstButton.addActionListener(new ActionListener()
	   {
		  public void actionPerformed(ActionEvent event)
	     {
		    //��ʾcardPanel�ϵ�һ������ӵ��������壩
		    cardLayout.first(cardPanel);
		 }
	   });

	   lastButton.addActionListener(new ActionListener()
	   	   {
	   		  public void actionPerformed(ActionEvent event)
	   	     {
	   		   //��ʾcardPanel�����һ������ӵ��������壩
	   		   cardLayout.last(cardPanel);
	   		 }
	   });

	   nextButton.addActionListener(new ActionListener()
	   	   {
	   		  public void actionPerformed(ActionEvent event)
	   	     {
				//��ʾcardPanel�ϵ�ǰ���֮�����һ�����
	   		    cardLayout.next(cardPanel);
	   		 }
	   });

	   prevButton.addActionListener(new ActionListener()
	   	   {
			   //��ʾcardPanel�ϵ�ǰ�����ǰһ�����
	   		  public void actionPerformed(ActionEvent event)
	   	     {
	   		   cardLayout.previous(cardPanel);
	   		 }
	   });

	   textField.addActionListener(new ActionListener()
	   	   	   {
				  //��ʾָ�������
	   	   		  public void actionPerformed(ActionEvent event)
	   	   	     {
	   	   		    cardLayout.show(cardPanel,textField.getText().trim());
	   	   		 }
	   	   });


	}
}