package wanj.chapter3.example1;

//import wanj.chapter3.example2.Test;
//import wanj.chapter3.example2.*;

public class ImportTest
{
  public static void main(String [] args)
  {
     wanj.chapter3.example2.Test t=new wanj.chapter3.example2.Test();
     //Test t=new Test();//ֱ��ʹ�õ���Test,��������Ϊ��������ͬһ����
     t.print();
  }
}


//��ʹ��javac -d . Test.java
//javac -d . ImportTest.java
//�����ļ�