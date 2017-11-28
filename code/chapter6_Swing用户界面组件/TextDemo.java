import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextDemo extends JFrame
{
   private JTextField field;
   private JTextArea area;
   public static void main(String [] args)
   {
      (new TextDemo()).setVisible(true);

   }
   public TextDemo()
   {
      setTitle("TextDemo");
      setSize(350,250);
      Container cont=getContentPane();
      field=new JTextField(20);
      field.addKeyListener(
		  new KeyAdapter
         {
             public void keyTyped(KeyEvent e)
            {
                area.append("key:"+e.getKeyChar()+"\n");
             }
          });
      field.addActionListener(
		  new ActionListener
             {
				 public void actionPerformed(ActionEvent e)
                 {
                      area.append("action:"+field.getText()+"\n");
                 }
              });
      cont.add(field,BorderLayout.NORTH);

      area=new JTextArea();
      cont.add(area,BorderLayout.CENTER);
   }
}