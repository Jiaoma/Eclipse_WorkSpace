import java.io.*;

public class FileStreamTest
{
   public static void main(String[] args)
   {
       File f=new File("c:\\test\\Hello.txt");
       try
       {
          FileOutputStream out=new FileOutputStream(f);//创建一个向指定 f对象表示的文件中写入数据的文件输出流
          //FileOutputStream out=new FileOutputStream("c:\\test\\Hello.txt");
          byte buf[]="Hello,welcome to Beijing!".getBytes();
          out.write(buf);
          out.close();
       }
       catch(IOException e)
       {
           e.printStackTrace();
       }

       try
       {
           FileInputStream in=new FileInputStream(f);
           byte buf[]=new byte[1024];
           int len=in.read(buf);
           System.out.println(new String(buf,0,len));
           in.close();
       }
       catch(IOException e)
      {
          e.printStackTrace();
       }


   }
}