//�ó�����ʾ����ζ����Լ��ĶԻ����Լ��Ի���Ϳ��֮������ݴ���
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDialogTest
{
	public static void main(String [] args)
	{
		DialogFrame frame = new DialogFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}

/*�Զ���Ŀ���࣬����һ���˵�����һ���ı�����������˵���inputʱ������һ���Ի���
�����û��������Ϣ�����û��ڶԻ���������Ϣ���ҵ��OK��ťʱ����Щ���ݽ���ʾ�ڿ�ܵ��ı����С�*/
class DialogFrame extends JFrame
{
	private InputDialog dialog;
	private JTextArea textArea;

	public DialogFrame()
	{
		setSize(600,400);

		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		JMenu toolMenu=new JMenu("tool");
		menuBar.add(toolMenu);
		JMenuItem inputItem=new JMenuItem("input");
		inputItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if( dialog==null)
				   dialog=new InputDialog(DialogFrame.this);
                dialog.reset();             //���öԻ��������
                dialog.setLocation(100,100);//������ʾλ��
				dialog.setVisible(true)  ;//��ʾ�Ի���
				if(dialog.getOk())        //��ȡ�Ի������ݣ���ʾ���ı���
				   textArea.append(dialog.getName()+","+dialog.getEmail()+"\n");
			}
		});
	    toolMenu.add(inputItem);

	    JMenuItem exitItem=new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		 {
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
	    toolMenu.add(exitItem);

	    textArea=new JTextArea();
	    add(textArea);
	}

}

class InputDialog extends JDialog
{
	private JTextField nameField;
	private JTextField emailField;
	private boolean ok=false;             //�����û���ѡ��

	public InputDialog(JFrame owner)
	{
		super(owner,"Input Dialog",true);//ӵ���߿�ܡ����⡢�Ƿ�Ϊģʽ�Ի���

		JPanel panel1=new JPanel();
		panel1.add(new JLabel("name:"));
		nameField=new JTextField(20);
		panel1.add(nameField);
		panel1.add(new JLabel("email:"));
		emailField=new JTextField(20);
		panel1.add(emailField);

		JPanel panel2=new JPanel();
		JButton okButton=new JButton("  ok  ");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				 ok=true;
				 setVisible(false);
			}
		});
		panel2.add(okButton);

		JButton cancelButton=new JButton("cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				  ok=false;
				  setVisible(false);
			}
		});
		panel2.add(cancelButton);

		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		setSize(300,150);
	}

	public String getName()
	{
		return nameField.getText().trim();
	}
	public String getEmail()
	{
		return emailField.getText().trim();
	}
	public boolean getOk()
	{
		return ok;
	}
	public void reset()
	{
		nameField.setText("");
		emailField.setText("");
		ok=false;
	}
}
