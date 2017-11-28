import java.awt.event.*;
import java.awt.*;

public class WindowCloser extends WindowAdapter
{
   public void WindowClosing(WindowEvent event)
   {
      Window window=event.getWindow();
      window.setVisible(false);
      window.dispose();
      System.exit(0);
   }
}