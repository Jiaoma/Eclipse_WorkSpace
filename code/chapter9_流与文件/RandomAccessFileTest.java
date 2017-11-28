//将员工的姓名和年龄保存在文件中，其中姓名6个字符，占用12字节，
//年龄4字节，随后从文件中读出

import java.io.*;
import java.util.*;

public class RandomAccessFileTest
{
   public static void main(String args[])
   {
	  Employee e1=new Employee("Mary",24);
	  Employee e2=new Employee("Tony",32);
	  Employee e3=new Employee("Jackson",41);

      RandomAccessFile fout=null;
      RandomAccessFile fin=null;

      try
      {
		fout=new  RandomAccessFile("employee.dat","rw");

        //将字符串和整数写入文件
        fout.writeChars(e1.getName());
        fout.writeInt(e1.getAge());
        fout.writeChars(e2.getName());
        fout.writeInt(e2.getAge());
        fout.writeChars(e3.getName());
        fout.writeInt(e3.getAge());
        fout.close();

        //读出
        fin=new RandomAccessFile("employee.dat","r");
		String name;
		int age;
		fin.seek(0);                  //定位到文件开始位置
        for(int i=0;i<3;i++)
        {
		   name="";
           for(int j=0;j<6;j++)
              name=name+fin.readChar();
           age=fin.readInt();
           System.out.println(name+" "+age);
	     }


	     //随机读取
	     Scanner s=new Scanner(System.in);
	     int i=s.nextInt();//要读取的员工
         fin.seek((i-1)*16);//定位
         name="";
         for(int j=0;j<6;j++)
              name=name+fin.readChar();
         age=fin.readInt();
         System.out.println("第"+i+"个员工的信息为"+name+" "+age);

         fin.close();

        }//end try
       catch (IOException e)
       {
		  System.out.println("File access error:"+e);
	    }
	}//end main
}//end class

class Employee
{
   private String name;
   private int age;
   public Employee(String name,int age)
   {
     //多余6个字符，则剪切
     if(name.length()>6)
       name=name.substring(0,6);

     //少于6个字符，则补空格
     while(name.length()<6)
       name=name+" ";
     this.name=name;
     this.age=age;
   }
   public String getName(){return name;}
   public int getAge(){return age;}
}




