import java.io.*;
public class CopyFile
{
	public static void main(String [] args)
	{
		FileInputStream in=null;
		FileOutputStream out=null;
        try
        {
			in=new FileInputStream("lotus.jpg");//����ļ������������FileNotFoundException
			out=new FileOutputStream("lotus-new.jpg");//����ļ������ڣ��򴴽�������ļ����ڣ���ɾ���󴴽�

			int t;
			while((t=in.read())!=-1)//˳���ȡ�ļ�text������ݲ���ֵ���ͱ���t,ֱ���ļ�����Ϊֹ��
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