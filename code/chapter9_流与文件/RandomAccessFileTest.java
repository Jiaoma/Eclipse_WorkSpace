//��Ա�������������䱣�����ļ��У���������6���ַ���ռ��12�ֽڣ�
//����4�ֽڣ������ļ��ж���

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

        //���ַ���������д���ļ�
        fout.writeChars(e1.getName());
        fout.writeInt(e1.getAge());
        fout.writeChars(e2.getName());
        fout.writeInt(e2.getAge());
        fout.writeChars(e3.getName());
        fout.writeInt(e3.getAge());
        fout.close();

        //����
        fin=new RandomAccessFile("employee.dat","r");
		String name;
		int age;
		fin.seek(0);                  //��λ���ļ���ʼλ��
        for(int i=0;i<3;i++)
        {
		   name="";
           for(int j=0;j<6;j++)
              name=name+fin.readChar();
           age=fin.readInt();
           System.out.println(name+" "+age);
	     }


	     //�����ȡ
	     Scanner s=new Scanner(System.in);
	     int i=s.nextInt();//Ҫ��ȡ��Ա��
         fin.seek((i-1)*16);//��λ
         name="";
         for(int j=0;j<6;j++)
              name=name+fin.readChar();
         age=fin.readInt();
         System.out.println("��"+i+"��Ա������ϢΪ"+name+" "+age);

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
     //����6���ַ��������
     if(name.length()>6)
       name=name.substring(0,6);

     //����6���ַ����򲹿ո�
     while(name.length()<6)
       name=name+" ";
     this.name=name;
     this.age=age;
   }
   public String getName(){return name;}
   public int getAge(){return age;}
}




