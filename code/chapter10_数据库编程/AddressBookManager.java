/**
 该程序可以添加、修改、删除联系人信息。联系人信息存放在数据库中，通过PersonDao中的方法完成数据库的访问。
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class AddressBookManager
{
	public static void main(String[] args)
	{
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/**
 * 一个框架，包括一个表和工具条
 */
class MainFrame extends JFrame
{
	//工具栏
	private JToolBar bar;

	//表单，显示所有的联系人信息
	private JTable table;

	//表对应的模式，保存了所有联系人的信息
	private DefaultTableModel tableModel;

	//添加联系人的对话框
	private EditPersonDialog addPersonDialog;

	//编辑联系人信息的对话框
	private EditPersonDialog editPersonDialog;

	public MainFrame()
	{
		setTitle("个人通讯录");
		setLocation(150,150);
		setSize(700, 400);

		// 添加工具栏，包括四个按钮：添加、删除、编辑和退出
		bar = new JToolBar();
		addBarButton(new ImageIcon("add.jpg"),"添加联系人",new AddPersonListener());
		addBarButton(new ImageIcon("delete.jpg"),"删除联系人",new DeletePersonListener());
		addBarButton(new ImageIcon("edit.jpg"),"修改联系人",new EditPersonListener());
		addBarButton(new ImageIcon("exit.jpg"),"退出",new ExitListener());
		add(bar, BorderLayout.NORTH);

		Vector<Vector> dataVector=new Vector<Vector>();//用来保存所有联系人的信息，每一个元素是一个vector，保存一个人的信息
		try
		{
			ArrayList<Person> array = PersonDao.getAllPerson();//获取当前的所有联系人信息
			for (Person p : array)
			{
				Vector temp=p.getVector();//将person的信息放在temp中
				dataVector.add(temp);
			}
		} catch (SQLException e) // PersonDao.getAllPerson()可能抛出SQLException、IOException异常
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		Vector<String> columnNames=new Vector<String>();//用来记录列的名称
		columnNames.add("personId");
		columnNames.add("personName");
		columnNames.add("nickName");
		columnNames.add("email");
		columnNames.add("mobilePhone");

		tableModel = new DefaultTableModel(dataVector,columnNames);//使用获取的联系人信息和列信息创建表对应的模式
		table = new JTable(tableModel);//创建表
		JScrollPane scrollPane = new JScrollPane(table);//增加滚动条
		add(scrollPane);
	}

   //向工具栏上添加按钮
	private void addBarButton(ImageIcon icon,String tip,ActionListener listener)
	{
	    JButton button = new JButton(icon);
		button.addActionListener(listener);
		button.setToolTipText(tip);
		bar.add(button);
	}

   //退出按钮的事件监听器类
    private class ExitListener implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}

    //添加联系人按钮的事件监听器类。
	private class AddPersonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt)
		{
			if (addPersonDialog == null)
			{
				addPersonDialog = new EditPersonDialog(MainFrame.this, "添加联系人");//创建对话框
			}
			addPersonDialog.reset(new Person());  // 重置对话框的数据为空
			addPersonDialog.setLocation(300, 200);// 设置显示位置
			addPersonDialog.setVisible(true);     // 显示对话框
			if (addPersonDialog.getOk())          // 如果用户选择了对话框上的确定按钮，则获取对话框数据，保存到数据库中
			{
				Person person = addPersonDialog.getPerson();//获取对话框数据
				try {
					PersonDao.savePerson(person);//保存数据到数据库中
					person=PersonDao.getPersonByName(person.getPersonName());
				    tableModel.addRow(person.getVector());//更新主框架上的表，将添加的用户显示在列表中
				} catch (SQLException e)
				{
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

    //删除联系人按钮的事件监听器类。
	private class DeletePersonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			try
			{
				int selectRow=table.getSelectedRow();//获取选择的行
				if( selectRow==-1)                  //如果没有选择行
			        return;
				int selectPersonId=((Integer)tableModel.getValueAt(selectRow,0)).intValue();//取得personId

				if (JOptionPane.showConfirmDialog(MainFrame.this,
						"你确定要删除该联系人的信息吗？", "确认删除联系人",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION)
				{
					PersonDao.deleteById(selectPersonId); //在数据库中删除该联系人
					tableModel.removeRow(selectRow);      //在表中删除该联系人
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}
	}

    //编辑按钮的事件监听器类，修改一个已经有的联系人的信息。
	private class EditPersonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			int selectRow = table.getSelectedRow(); //获取用户选择的联系人在表中的位置
			if( selectRow==-1)
			   return;
			if (editPersonDialog == null)
			{
				editPersonDialog = new EditPersonDialog(MainFrame.this, "编辑联系人");//创建对话框
			}
			Person oldPerson=new Person((Vector)tableModel.getDataVector().get(selectRow));
			editPersonDialog.reset(oldPerson); //重置对话框的数据为当前列表中所选的联系人
			editPersonDialog.setLocation(300, 200);     // 设置显示位置
			editPersonDialog.setVisible(true);          // 显示对话框

			if (editPersonDialog.getOk())               // 如果用户选择了确定按钮，则获取对话框数据，保存到数据库中
			{
			   Person newPerson=editPersonDialog.getPerson();
			   try
			   {
					PersonDao.updatePerson(newPerson);//修改数据库中的数据
				} catch (SQLException e)
				{
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				//重置列表中的相关联系人的信息
				tableModel.setValueAt(newPerson.getPersonName(),selectRow,1);
				tableModel.setValueAt(newPerson.getNickName(),selectRow,2);
				tableModel.setValueAt(newPerson.getEmail(),selectRow,3);
				tableModel.setValueAt(newPerson.getMobilePhone(),selectRow,4);
	         }

		}
	}

}

/** 编辑和添加联系人的对话框 */
class EditPersonDialog extends JDialog
{
	// 对话框上部面板
    protected JPanel normalPanel;

	// 对话框下面的按钮面板
	protected JPanel buttonPanel;

	// 接收联系人的名字的文本域
	protected JTextField personName;

	// 接收联系人的昵称的文本域
	protected JTextField nickName;

	// 接收联系人的电子邮件的文本域
	protected JTextField email;

	// 接收联系人手机的文本域
	protected JTextField mobilePhone;

	// 记录用户的是否点击了ok按钮
	protected boolean ok = false;

	// 当前添加、编辑或显示联系人
	protected Person person;
	//ok按钮
	private JButton okButton;

    //cancel按钮
	private JButton cancelButton;

	/** 构造方法 */
	public EditPersonDialog(JFrame owner, String title)
	{
		super(owner, title, true);

		// 设置大小
		setSize(400, 200);

		// 创建上部的面板，并添加组件
		normalPanel = new JPanel();
		normalPanel.add(new JLabel(" 姓名"));
		personName = new JTextField(30);
		normalPanel.add(personName);
		normalPanel.add(new JLabel(" 昵称"));
		nickName = new JTextField(30);
		normalPanel.add(nickName);
		normalPanel.add(new JLabel(" 手机"));
		mobilePhone = new JTextField(30);
		normalPanel.add(mobilePhone);
		normalPanel.add(new JLabel("email"));
		email = new JTextField(30);
		normalPanel.add(email);
		add(normalPanel, BorderLayout.CENTER);

		// 创建下面的按钮面板
		buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);

		// 添加ok按钮和事件监听器
		okButton = new JButton("确定");
		okButton.addActionListener(new OkButtonActionListener());
		buttonPanel.add(okButton);

		// 添加cancel按钮和事件监听器
		cancelButton = new JButton("取消");
		buttonPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				ok = false;
				setVisible(false);
			}
		});
		buttonPanel.add(cancelButton);
	}

	/** ok按钮的事件处理监听器 ，作为内部类处理*/
	private class OkButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (personName.getText().trim().length() > 0)// 如果联系人名字非空，则将根据用户输入重置person的内容，ok置为true,隐藏对话框；否则提示用户输入名字
			{
				ok = true;
				person.setPersonName(personName.getText().trim());
				person.setNickName(nickName.getText().trim());
				person.setMobilePhone(mobilePhone.getText().trim());
				person.setEmail(email.getText().trim());
				setVisible(false);
			} else
				JOptionPane.showMessageDialog(EditPersonDialog.this, "姓名不能为空","警告", JOptionPane.WARNING_MESSAGE);
		}
	}

	/** 返回对话框中填入的联系人信息 */
	public Person getPerson()
	{
		return person;
	}

	/** 返回ok */
	public boolean getOk()
	{
		return ok;
	}

	/** 重置文本域中的内容 */
	public void reset(Person person)
	{
		this.person = person;
		personName.setText(person.getPersonName());
		nickName.setText(person.getNickName());
		mobilePhone.setText(person.getMobilePhone());
		email.setText(person.getEmail());
		ok = false;
	}
}

