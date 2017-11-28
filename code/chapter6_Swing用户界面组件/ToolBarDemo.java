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
   Menu��һ����ܣ������˵��͹�������

*/
class ToolBarFrame extends JFrame
{
	public ToolBarFrame()
	{
		setSize(350,250);
		setTitle("ToolBar Demo");

	    //�˵��������˵�File�Ͳ˵�Sample
	    JMenuBar menuBar=new JMenuBar();

	    //�˵�File,����new��exit�����˵���
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

	    //�˵�Sample,�����˵���plain,cut,copy,paste,�ָ�������ѡ��check,��ѡ��radio0,radio1,�Ӳ˵�subOptions
	    JMenu sampleMenu=new JMenu("Sample");
	    sampleMenu.add(new JMenuItem("Plain"));//�ı��Ĳ˵���
	    sampleMenu.add(new JMenuItem("cut",new ImageIcon("cut.gif")));//��ͼ��Ĳ˵���
	    sampleMenu.add(new JMenuItem("copy",new ImageIcon("copy.gif")));
	    sampleMenu.add(new JMenuItem("paste",new ImageIcon("paste.gif")));
	    sampleMenu.addSeparator();//��ӷָ���

	     ButtonGroup group=new ButtonGroup();
	     JRadioButtonMenuItem radioButton1=new JRadioButtonMenuItem("radio1");//��ѡ��ť
	     group.add(radioButton1);
	     sampleMenu.add(radioButton1);
	     JRadioButtonMenuItem radioButton2=new JRadioButtonMenuItem("radio2");//��ѡ��ť
	     group.add(radioButton2);
	     sampleMenu.add(radioButton2);
	     sampleMenu.addSeparator();

	     sampleMenu.add(new JCheckBoxMenuItem("check"));//��Ӹ�ѡ��ť

	     //�����Ӳ˵�
	     JMenu subMenu=new JMenu("subOptions");
	     subMenu.add(new JMenuItem("aaa"));
	     subMenu.add(new JMenuItem("bbb"));
	     subMenu.add(new JMenuItem("ccc"));
	     sampleMenu.add(subMenu);

	     menuBar.add(sampleMenu);
	     setJMenuBar(menuBar);

	     //----------------��ӹ�����-----------------//
	     JToolBar toolBar=new JToolBar();

	     JButton cutButton=new JButton(new ImageIcon("cut.gif"));
	     cutButton.setToolTipText("����");//������ʾ
	     toolBar.add(cutButton);//������

	     JButton copyButton=new JButton(new ImageIcon("copy.gif"));
		 copyButton.setToolTipText("����");
	     toolBar.add(copyButton);

	     add(toolBar,"North");

     }
}