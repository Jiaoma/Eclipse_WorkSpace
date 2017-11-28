/**
   @version 1.03 2004-08-22
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;
import java.io.*;

/**
   This program demonstrates the use of a progress bar
   to monitor the progress of a thread.
*/
public class ProgressBarTest
{
   public static void main(String[] args)
   {
      JFrame frame = new ProgressBarFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame that contains a button to launch a simulated activity,
   a progress bar, and a text area for the activity output.
*/
class ProgressBarFrame extends JFrame
{
   public ProgressBarFrame()
   {
	  final int fileNum=getFileNum("c:\\RavBin");

      setTitle("ProgressBarTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // this text area holds the activity output
      textArea = new JTextArea();

      // set up panel with button and progress bar

      JPanel panel = new JPanel();
      startButton = new JButton("Start");
      progressBar = new JProgressBar();
      progressBar.setStringPainted(true);
      panel.add(startButton);
      panel.add(progressBar);

      checkBox = new JCheckBox("indeterminate");
      checkBox.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               progressBar.setIndeterminate(checkBox.isSelected());
            }
         });
      panel.add(checkBox);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      add(panel, BorderLayout.SOUTH);

      // set up the button action

      startButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               progressBar.setMaximum(fileNum);
               activity = new SimulatedActivity(fileNum);
               new Thread(activity).start();
               activityMonitor.start();
               startButton.setEnabled(false);
            }
         });


      // set up the timer action

      activityMonitor = new Timer(100, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int current = activity.getCurrent();
               String currentFileName=activity.getCurrentFileName();
               int currentFileNum=activity.getCurrentFileNum();

               // show progress
               textArea.append(currentFileNum + " "+currentFileName+"\n");
               progressBar.setStringPainted(!progressBar.isIndeterminate());
               progressBar.setValue(currentFileNum);

               // check if task is completed
               if (current == activity.getTarget())
               {
                  activityMonitor.stop();
                  startButton.setEnabled(true);
               }
            }
         });
   }

   public int getFileNum(String directName)
   {
   	   File direct=new File(directName);
   	   String file_list[]=direct.list();
   	   return file_list.length;
   }

   private Timer activityMonitor;
   private JButton startButton;
   private JProgressBar progressBar;
   private JCheckBox checkBox;
   private JTextArea textArea;
   private SimulatedActivity activity;

   public static final int DEFAULT_WIDTH = 400;
   public static final int DEFAULT_HEIGHT = 200;
}

/**
   A similated activity runnable.
*/
class SimulatedActivity implements Runnable
{
   /**
      Constructs the simulated activity thread object. The
      thread increments a counter from 0 to a given target.
      @param t the target value of the counter.
   */
   public SimulatedActivity(int t)
   {
      current = 0;
      target = t;
      currentFileNum=0;;
   }


   public int getTarget()
   {
      return target;
   }

   public int getCurrent()
   {
      return current;
   }
   public int getCurrentFileNum()
   {
	   return currentFileNum;
   }
   public String getCurrentFileName()
   {
	   return currentFileName;
   }

   public void run()
   {
	  File direct=new File("c:\\RavBin");
	  String file_list[]=direct.list();
      try
      {
         for(int i=0;i<file_list.length;i++)
         {
            Thread.sleep(100);
            File current_file=new File(file_list[i]);
            currentFileName=""+current_file.getAbsoluteFile();
            currentFileNum++;
         }
      }
      catch(InterruptedException e)
      {
      }
   }


   private  String currentFileName;
   private  int currentFileNum;
   private int current;
   private int target;

}







