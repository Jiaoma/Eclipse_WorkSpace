import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ToolBarDemo
{
   public static void main(String[] args)
   {
      ToolBarFrame frame = new ToolBarFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   Menu是一个框架，包含菜单和工具栏。

*/
class ToolBarFrame extends JFrame
{
	public ToolBarFrame()
	{
		setSize(350,250);
		setTitle("ToolBar Demo");

	    //菜单栏包括菜单File和菜单Sample
	    JMenuBar menuBar=new JMenuBar();

	    //菜单File,包括new和exit两个菜单项
	    JMenu fileMenu=new JMenu("File");
	    JMenuItem newItem=new JMenuItem("new");
	    fileMenu.add(newItem);
	    JMenuItem exitItem=new JMenuItem("exit");
	    fileMenu.add(exitItem);
	    menuBar.add(fileMenu);
	    exitItem.addActionListener(new
	    ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
			     System.exit(0);
			}
		});

	    //菜单Sample,包括菜单项plain,cut,copy,paste,分隔符，复选框check,单选框radio0,radio1,子菜单subOptions
	    JMenu sampleMenu=new JMenu("Sample");
	    sampleMenu.add(new JMenuItem("Plain"));//文本的菜单项
	    sampleMenu.add(new JMenuItem("cut",new ImageIcon("cut.gif")));//带图标的菜单项
	    sampleMenu.add(new JMenuItem("copy",new ImageIcon("copy.gif")));
	    sampleMenu.add(new JMenuItem("paste",new ImageIcon("paste.gif")));
	    sampleMenu.addSeparator();//添加分隔符

	     ButtonGroup group=new ButtonGroup();
	     JRadioButtonMenuItem radioButton1=new JRadioButtonMenuItem("radio1");//单选按钮
	     group.add(radioButton1);
	     sampleMenu.add(radioButton1);
	     JRadioButtonMenuItem radioButton2=new JRadioButtonMenuItem("radio2");//单选按钮
	     group.add(radioButton2);
	     sampleMenu.add(radioButton2);
	     sampleMenu.addSeparator();

	     sampleMenu.add(new JCheckBoxMenuItem("check"));//添加复选按钮

	     //定义子菜单
	     JMenu subMenu=new JMenu("subOptions");
	     subMenu.add(new JMenuItem("aaa"));
	     subMenu.add(new JMenuItem("bbb"));
	     subMenu.add(new JMenuItem("ccc"));
	     sampleMenu.add(subMenu);

	     menuBar.add(sampleMenu);
	     setJMenuBar(menuBar);

	     //----------------添加工具栏-----------------//
	     JToolBar toolBar=new JToolBar();

	     JButton cutButton=new JButton(new ImageIcon("cut.gif"));
	     cutButton.setToolTipText("剪切");//设置提示
	     toolBar.add(cutButton);//添加组件

	     JButton copyButton=new JButton(new ImageIcon("copy.gif"));
		 copyButton.setToolTipText("复制");
	     toolBar.add(copyButton);

	     add(toolBar,"North");

     }
}