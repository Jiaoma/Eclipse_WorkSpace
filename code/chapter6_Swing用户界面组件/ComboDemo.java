import java.awt.*;
import javax.swing.*;
public class ComboDemo extends JFrame
{
   public static void main(String []args)
   {
     (new ComboDemo()).setVisible(true);
   }

   public ComboDemo()
   {
      super("ComboDemo");
      setSize(350,250);
      Container cont=getContentPane();
      cont.setLayout(new FlowLayout());
      String[] initialValues={"Dragon","Ghost","unicorn"};
      JComboBox combo=new JComboBox(initialValues);
      combo.setEditable(true);
      cont.add(combo);
   }
}