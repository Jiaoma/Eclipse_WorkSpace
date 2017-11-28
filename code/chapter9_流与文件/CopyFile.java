import java.io.*;
public class CopyFile
{
	public static void main(String [] args)
	{
		FileInputStream in=null;
		FileOutputStream out=null;
        try
        {
			in=new FileInputStream("lotus.jpg");//如果文件不存在则出现FileNotFoundException
			out=new FileOutputStream("lotus-new.jpg");//如果文件不存在，则创建；如果文件存在，则删除后创建

			int t;
			while((t=in.read())!=-1)//顺序读取文件text里的内容并赋值整型变量t,直到文件结束为止。
			{
			   out.write(t);
		    }

		    in.close();
		    out.close();

		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}