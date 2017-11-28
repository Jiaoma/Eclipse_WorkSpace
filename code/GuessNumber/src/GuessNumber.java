import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class GuessNumber {
	


	public static void main(String[] args)
	{
		MyFrame frame = new MyFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}

class MyFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Random random = new Random();
	private int number = random.nextInt(1000)%(1000-1+1) + 1;
	private int counte=0;
	public MyFrame()
	{
		setSize(500,350);
		setTitle("GuessNumber");
		
		JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
		textField=new JTextField(15);
		textField.setLocation(100, 150);
		textField.setBounds(100, 150, 200, 30);
	    panel.add(textField);

		
	    
	    JLabel counterLabel=new JLabel("���Ѿ�����"+counte+"��");
	    counterLabel.setLocation(0, 0);
	    counterLabel.setBounds(0,0,150,30);
	    panel.add(counterLabel);
	    JLabel Label1=new JLabel("����²������");
	    Label1.setLocation(10, 130);
	    Label1.setBounds(10, 130, 70, 60);
	    panel.add(Label1);
	    JLabel Label2=new JLabel("");
	    Label2.setBounds(350,130, 100, 60);
	    Label2.setLocation(350, 130);
	    panel.add(Label2);
	    
	    JButton confirmButton=new JButton("ȷ��");
	    JButton restartButton=new JButton("���¿�ʼ");
	    JButton exitButton=new JButton("�˳�");
	    confirmButton.addActionListener(new ActionListener() {
	    
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		int input=Integer.parseInt(textField.getText());
	    		if	(input<number)
	    		{
	    			panel.setBackground(Color.BLUE);
	    			counte++;
	    			Label2.setText("̫С");
	    			counterLabel.setText("���Ѿ�����"+counte+"��");	
	    		}
	    		else if(input>number)
	    		{
	    			panel.setBackground(Color.RED);
	    			counte++;
	    			Label2.setText("̫��");
	    			counterLabel.setText("���Ѿ�����"+counte+"��");	
	    		}
	    		else
	    		{
	    			panel.setBackground(Color.WHITE);
	    			Label2.setText("��ȷ");
	    			counte++;
	    			counterLabel.setText("���Ѿ�����"+counte+"��");	
	    			confirmButton.setEnabled(false);
	    			textField.setEnabled(false);
	    		}
	    	}
	    });
	    
	    restartButton.addActionListener(new ActionListener() {
		    
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		textField.setText("");
	    		counte=0;
	    		counterLabel.setText("���Ѿ�����"+counte+"��");	
	    		textField.setEnabled(true);
	    		confirmButton.setEnabled(true);
	    		panel.setBackground(Color.WHITE);
	    	}
	    });
	    
	    exitButton.addActionListener(new ActionListener() {
		    
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		System.exit(0);
	    	}
	    });
	    confirmButton.setLocation(50, 200);
	    
	    confirmButton.setBounds(50, 200, 90, 30);
	    restartButton.setLocation(150, 200);
	    restartButton.setBounds(150, 200, 90, 30);
	    
	    exitButton.setLocation(250, 200);
	    
	    exitButton.setBounds(250, 200, 90, 30);
	    panel.add(confirmButton);
	    panel.add(restartButton);
	    panel.add(exitButton);
	    add(panel);
	}

}
