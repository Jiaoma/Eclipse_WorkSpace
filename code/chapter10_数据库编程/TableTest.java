/**
 �ó���������ʾJTable���÷�
 */

import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.Vector;


public class TableTest
{
	public static void main(String[] args)
	{
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/**
 * һ����ܣ�����һ����
 */
class MainFrame extends JFrame
{
	//������ʾ���е���ϵ����Ϣ
	private JTable table;

	//���Ӧ��ģʽ
	private DefaultTableModel tableModel;

	public MainFrame()
	{
		setTitle("TableTest");
		setLocation(150,150);
		setSize(700, 400);

		String[][] dataVector={{"1","��ǿ","Jerry"},
		                       {"2","�ξ�","lily"}};
		String[] columnNames={"personId","personName","nickName"};//������¼�е�����

		tableModel = new DefaultTableModel(dataVector,columnNames);//����ģʽ
		table = new JTable(tableModel);//������
		JScrollPane scrollPane = new JScrollPane(table);//���ӹ�����
		add(scrollPane);

		//����һ��
		//String [] newData={"3","����","Mike"};
		//tableModel.addRow(newData);

		//ɾ��һ��
		//tableModel.removeRow(1);//��0��ʼ���

		//�޸�
        tableModel.setValueAt("4",0,0);//����0��0�д���ֵΪ4

	}
}

/*
//����һ��
String [] newData={"3","����","Mike"};
tableModel.addRow(newData);

//ɾ��һ��
tableModel.removeRow(1);//��0��ʼ���

//�޸�
tableModel.setValueAt("4",0,0);//����0��0�д���ֵΪ4

//ʹ��Vector
Vector<Vector> dataVector=new Vector<Vector>();
Vector<String> temp=new Vector<String>();
temp.add("1");
temp.add("��ǿ");
temp.add("Jerry");
dataVector.add(temp);
temp=new Vector<String>();
temp.add("2");
temp.add("�ξ�");
temp.add("lily");
dataVector.add(temp);

Vector<String> columnNames=new Vector<String>();
columnNames.add("personId");
columnNames.add("personName");
columnNames.add("nickName");
*/
