package wanj.chapter3;//文件中定义的类位于该包中

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

//完整名称：wanj.chapter3.PackageTest，wanj.chapter3.Test1
//1.执行javac PackageTest.java ，java PackageTest,java wanj.chapter3.PackageTest
//2.创建目录wanj\chapter3,复制class文件，java PackgeTest,java wanj.chapter3.PackageTest
//3.javac -d . PackageTest.java  java wanj.chapter3.PackageTest