package wanj.chapter3;//�ļ��ж������λ�ڸð���

public class PackageTest
{
   public static void main(String [] args)
   {
      new Test1().print();
   }
}

class Test1
{
   public void print()
   {
      System.out.println("the program is demostrating how to use package");
   }
}

//�������ƣ�wanj.chapter3.PackageTest��wanj.chapter3.Test1
//1.ִ��javac PackageTest.java ��java PackageTest,java wanj.chapter3.PackageTest
//2.����Ŀ¼wanj\chapter3,����class�ļ���java PackgeTest,java wanj.chapter3.PackageTest
//3.javac -d . PackageTest.java  java wanj.chapter3.PackageTest