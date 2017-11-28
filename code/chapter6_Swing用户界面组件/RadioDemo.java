import java.awt.*;
import javax.swing.*;
public class RadioDemo
{
  public static void main(String [] args)
  {
     JFrame frame=new JFrame("Radio Demo");
     frame.setSize(350,250);
     Container cont=frame.getContentPane();
     cont.setLayout(new FlowLayout());
     ButtonGroup buttonGroup=new ButtonGroup();
     JRadioButton radioButton=new JRadioButton("R=rare",true);
     buttonGroup.add(radioButton);
     cont.add(radioButton);
     radioButton=new JRadioButton("Medium");
     buttonGroup.add(radioButton);
     cont.add(radioButton);
     radioButton=new JRadioButton("Well Done");
     buttonGroup.add(radioButton);
     cont.add(radioButton);
     //radioButton=new JRadioButton("different");
     //cont.add(radioButton);
     frame.setVisible(true);
  }
}