/**
 �ó��������ӡ��޸ġ�ɾ����ϵ����Ϣ����ϵ����Ϣ��������ݿ��У�ͨ��PersonDao�еķ���������ݿ�ķ��ʡ�
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
 * һ����ܣ�����һ����͹�����
 */
class MainFrame extends JFrame
{
	//������
	private JToolBar bar;

	//������ʾ���е���ϵ����Ϣ
	private JTable table;

	//���Ӧ��ģʽ��������������ϵ�˵���Ϣ
	private DefaultTableModel tableModel;

	//�����ϵ�˵ĶԻ���
	private EditPersonDialog addPersonDialog;

	//�༭��ϵ����Ϣ�ĶԻ���
	private EditPersonDialog editPersonDialog;

	public MainFrame()
	{
		setTitle("����ͨѶ¼");
		setLocation(150,150);
		setSize(700, 400);

		// ��ӹ������������ĸ���ť����ӡ�ɾ�����༭���˳�
		bar = new JToolBar();
		addBarButton(new ImageIcon("add.jpg"),"�����ϵ��",new AddPersonListener());
		addBarButton(new ImageIcon("delete.jpg"),"ɾ����ϵ��",new DeletePersonListener());
		addBarButton(new ImageIcon("edit.jpg"),"�޸���ϵ��",new EditPersonListener());
		addBarButton(new ImageIcon("exit.jpg"),"�˳�",new ExitListener());
		add(bar, BorderLayout.NORTH);

		Vector<Vector> dataVector=new Vector<Vector>();//��������������ϵ�˵���Ϣ��ÿһ��Ԫ����һ��vector������һ���˵���Ϣ
		try
		{
			ArrayList<Person> array = PersonDao.getAllPerson();//��ȡ��ǰ��������ϵ����Ϣ
			for (Person p : array)
			{
				Vector temp=p.getVector();//��person����Ϣ����temp��
				dataVector.add(temp);
			}
		} catch (SQLException e) // PersonDao.getAllPerson()�����׳�SQLException��IOException�쳣
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		Vector<String> columnNames=new Vector<String>();//������¼�е�����
		columnNames.add("personId");
		columnNames.add("personName");
		columnNames.add("nickName");
		columnNames.add("email");
		columnNames.add("mobilePhone");

		tableModel = new DefaultTableModel(dataVector,columnNames);//ʹ�û�ȡ����ϵ����Ϣ������Ϣ�������Ӧ��ģʽ
		table = new JTable(tableModel);//������
		JScrollPane scrollPane = new JScrollPane(table);//���ӹ�����
		add(scrollPane);
	}

   //�򹤾�������Ӱ�ť
	private void addBarButton(ImageIcon icon,String tip,ActionListener listener)
	{
	    JButton button = new JButton(icon);
		button.addActionListener(listener);
		button.setToolTipText(tip);
		bar.add(button);
	}

   //�˳���ť���¼���������
    private class ExitListener implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}

    //�����ϵ�˰�ť���¼��������ࡣ
	private class AddPersonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt)
		{
			if (addPersonDialog == null)
			{
				addPersonDialog = new EditPersonDialog(MainFrame.this, "�����ϵ��");//�����Ի���
			}
			addPersonDialog.reset(new Person());  // ���öԻ��������Ϊ��
			addPersonDialog.setLocation(300, 200);// ������ʾλ��
			addPersonDialog.setVisible(true);     // ��ʾ�Ի���
			if (addPersonDialog.getOk())          // ����û�ѡ���˶Ի����ϵ�ȷ����ť�����ȡ�Ի������ݣ����浽���ݿ���
			{
				Person person = addPersonDialog.getPerson();//��ȡ�Ի�������
				try {
					PersonDao.savePerson(person);//�������ݵ����ݿ���
					person=PersonDao.getPersonByName(person.getPersonName());
				    tableModel.addRow(person.getVector());//����������ϵı�����ӵ��û���ʾ���б���
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

    //ɾ����ϵ�˰�ť���¼��������ࡣ
	private class DeletePersonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			try
			{
				int selectRow=table.getSelectedRow();//��ȡѡ�����
				if( selectRow==-1)                  //���û��ѡ����
			        return;
				int selectPersonId=((Integer)tableModel.getValueAt(selectRow,0)).intValue();//ȡ��personId

				if (JOptionPane.showConfirmDialog(MainFrame.this,
						"��ȷ��Ҫɾ������ϵ�˵���Ϣ��", "ȷ��ɾ����ϵ��",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION)
				{
					PersonDao.deleteById(selectPersonId); //�����ݿ���ɾ������ϵ��
					tableModel.removeRow(selectRow);      //�ڱ���ɾ������ϵ��
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

    //�༭��ť���¼��������࣬�޸�һ���Ѿ��е���ϵ�˵���Ϣ��
	private class EditPersonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			int selectRow = table.getSelectedRow(); //��ȡ�û�ѡ�����ϵ���ڱ��е�λ��
			if( selectRow==-1)
			   return;
			if (editPersonDialog == null)
			{
				editPersonDialog = new EditPersonDialog(MainFrame.this, "�༭��ϵ��");//�����Ի���
			}
			Person oldPerson=new Person((Vector)tableModel.getDataVector().get(selectRow));
			editPersonDialog.reset(oldPerson); //���öԻ��������Ϊ��ǰ�б�����ѡ����ϵ��
			editPersonDialog.setLocation(300, 200);     // ������ʾλ��
			editPersonDialog.setVisible(true);          // ��ʾ�Ի���

			if (editPersonDialog.getOk())               // ����û�ѡ����ȷ����ť�����ȡ�Ի������ݣ����浽���ݿ���
			{
			   Person newPerson=editPersonDialog.getPerson();
			   try
			   {
					PersonDao.updatePerson(newPerson);//�޸����ݿ��е�����
				} catch (SQLException e)
				{
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				//�����б��е������ϵ�˵���Ϣ
				tableModel.setValueAt(newPerson.getPersonName(),selectRow,1);
				tableModel.setValueAt(newPerson.getNickName(),selectRow,2);
				tableModel.setValueAt(newPerson.getEmail(),selectRow,3);
				tableModel.setValueAt(newPerson.getMobilePhone(),selectRow,4);
	         }

		}
	}

}

/** �༭�������ϵ�˵ĶԻ��� */
class EditPersonDialog extends JDialog
{
	// �Ի����ϲ����
    protected JPanel normalPanel;

	// �Ի�������İ�ť���
	protected JPanel buttonPanel;

	// ������ϵ�˵����ֵ��ı���
	protected JTextField personName;

	// ������ϵ�˵��ǳƵ��ı���
	protected JTextField nickName;

	// ������ϵ�˵ĵ����ʼ����ı���
	protected JTextField email;

	// ������ϵ���ֻ����ı���
	protected JTextField mobilePhone;

	// ��¼�û����Ƿ�����ok��ť
	protected boolean ok = false;

	// ��ǰ��ӡ��༭����ʾ��ϵ��
	protected Person person;
	//ok��ť
	private JButton okButton;

    //cancel��ť
	private JButton cancelButton;

	/** ���췽�� */
	public EditPersonDialog(JFrame owner, String title)
	{
		super(owner, title, true);

		// ���ô�С
		setSize(400, 200);

		// �����ϲ�����壬��������
		normalPanel = new JPanel();
		normalPanel.add(new JLabel(" ����"));
		personName = new JTextField(30);
		normalPanel.add(personName);
		normalPanel.add(new JLabel(" �ǳ�"));
		nickName = new JTextField(30);
		normalPanel.add(nickName);
		normalPanel.add(new JLabel(" �ֻ�"));
		mobilePhone = new JTextField(30);
		normalPanel.add(mobilePhone);
		normalPanel.add(new JLabel("email"));
		email = new JTextField(30);
		normalPanel.add(email);
		add(normalPanel, BorderLayout.CENTER);

		// ��������İ�ť���
		buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);

		// ���ok��ť���¼�������
		okButton = new JButton("ȷ��");
		okButton.addActionListener(new OkButtonActionListener());
		buttonPanel.add(okButton);

		// ���cancel��ť���¼�������
		cancelButton = new JButton("ȡ��");
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

	/** ok��ť���¼���������� ����Ϊ�ڲ��ദ��*/
	private class OkButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (personName.getText().trim().length() > 0)// �����ϵ�����ַǿգ��򽫸����û���������person�����ݣ�ok��Ϊtrue,���ضԻ��򣻷�����ʾ�û���������
			{
				ok = true;
				person.setPersonName(personName.getText().trim());
				person.setNickName(nickName.getText().trim());
				person.setMobilePhone(mobilePhone.getText().trim());
				person.setEmail(email.getText().trim());
				setVisible(false);
			} else
				JOptionPane.showMessageDialog(EditPersonDialog.this, "��������Ϊ��","����", JOptionPane.WARNING_MESSAGE);
		}
	}

	/** ���ضԻ������������ϵ����Ϣ */
	public Person getPerson()
	{
		return person;
	}

	/** ����ok */
	public boolean getOk()
	{
		return ok;
	}

	/** �����ı����е����� */
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

