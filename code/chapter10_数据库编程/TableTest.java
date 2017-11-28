/**
 该程序用来显示JTable的用法
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
 * 一个框架，包括一个表
 */
class MainFrame extends JFrame
{
	//表单，显示所有的联系人信息
	private JTable table;

	//表对应的模式
	private DefaultTableModel tableModel;

	public MainFrame()
	{
		setTitle("TableTest");
		setLocation(150,150);
		setSize(700, 400);

		String[][] dataVector={{"1","李强","Jerry"},
		                       {"2","何静","lily"}};
		String[] columnNames={"personId","personName","nickName"};//用来记录列的名称

		tableModel = new DefaultTableModel(dataVector,columnNames);//创建模式
		table = new JTable(tableModel);//创建表
		JScrollPane scrollPane = new JScrollPane(table);//增加滚动条
		add(scrollPane);

		//增加一行
		//String [] newData={"3","王良","Mike"};
		//tableModel.addRow(newData);

		//删除一行
		//tableModel.removeRow(1);//从0开始编号

		//修改
        tableModel.setValueAt("4",0,0);//设置0行0列处的值为4

	}
}

/*
//增加一行
String [] newData={"3","王良","Mike"};
tableModel.addRow(newData);

//删除一行
tableModel.removeRow(1);//从0开始编号

//修改
tableModel.setValueAt("4",0,0);//设置0行0列处的值为4

//使用Vector
Vector<Vector> dataVector=new Vector<Vector>();
Vector<String> temp=new Vector<String>();
temp.add("1");
temp.add("李强");
temp.add("Jerry");
dataVector.add(temp);
temp=new Vector<String>();
temp.add("2");
temp.add("何静");
temp.add("lily");
dataVector.add(temp);

Vector<String> columnNames=new Vector<String>();
columnNames.add("personId");
columnNames.add("personName");
columnNames.add("nickName");
*/
