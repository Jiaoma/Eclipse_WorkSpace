import java.io.*;
import java.util.*;

public class FileStatic
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Please input the file name");
			Scanner consoleInput=new Scanner(System.in);
			String fileName=consoleInput.next();
			consoleInput.close();
			FileReader filein=new FileReader(fileName);
			Scanner fileScanner=new Scanner(filein);
			int word_num=0;
			int letter_num=0;
			String input="";
			while(fileScanner.hasNext())
			{
				input=fileScanner.next();
				if(!input.isEmpty())
				{
					word_num++;
					letter_num+=input.length();
				}
			}
			System.out.println("word num:"+word_num+"     letter num:"+letter_num);
			filein.close();
			fileScanner.close();
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}
	}
}