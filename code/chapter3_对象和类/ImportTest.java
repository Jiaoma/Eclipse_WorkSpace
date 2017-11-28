package wanj.chapter3.example1;

//import wanj.chapter3.example2.Test;
//import wanj.chapter3.example2.*;

public class ImportTest
{
  public static void main(String [] args)
  {
     wanj.chapter3.example2.Test t=new wanj.chapter3.example2.Test();
     //Test t=new Test();//直接使用调用Test,编译器认为两个类在同一包中
     t.print();
  }
}


//先使用javac -d . Test.java
//javac -d . ImportTest.java
//编译文件