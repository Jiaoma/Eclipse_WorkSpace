import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuDemo
{
   public static void main(String[] args)
   {
      MenuFrame frame = new MenuFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   Menu��һ����ܣ������˵���

*/
class MenuFrame extends JFrame
{
	public MenuFrame()
	{
		setSize(350,250);
		setTitle("Menu Demo");



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
	     sampleMenu.addSeparator();//��ӷָ���

	     sampleMenu.add(new JCheckBoxMenuItem("check"));//��Ӹ�ѡ��ť

	     //�����Ӳ˵�
	     JMenu subMenu=new JMenu("subOptions");
	     subMenu.add(new JMenuItem("aaa"));
	     subMenu.add(new JMenuItem("bbb"));
	     subMenu.add(new JMenuItem("ccc"));
	     sampleMenu.add(subMenu);

	     menuBar.add(sampleMenu);
	     setJMenuBar(menuBar);

     }
}