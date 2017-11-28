//该程序显示了如何定义自己的对话框以及对话框和框架之间的数据传递
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

/*自定义的框架类，包含一个菜单栏和一个文本区。当点击菜单项input时，出现一个对话框，
接收用户输入的信息。当用户在对话框输入信息并且点击OK按钮时，这些数据将显示在框架的文本区中。*/
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
                dialog.reset();             //重置对话框的数据
                dialog.setLocation(100,100);//设置显示位置
				dialog.setVisible(true)  ;//显示对话框
				if(dialog.getOk())        //获取对话框数据，显示在文本区
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
	private boolean ok=false;             //保存用户的选择

	public InputDialog(JFrame owner)
	{
		super(owner,"Input Dialog",true);//拥有者框架、标题、是否为模式对话框

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
