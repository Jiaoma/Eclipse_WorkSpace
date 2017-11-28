import java.util.*;
public class StringBufferTest
{
  public static void main(String [] args)
  {
    StringBuffer s=new StringBuffer("12345");
    System.out.println("��1�� s:"+s);
    StringBuffer t=new StringBuffer("12345");
    System.out.println("��2�� t:"+t);

    //��String��ͬ��StringBufferû�и�дObject�е�equals����������ָ��ͬһ����ʱ������true
    if(s.equals(t))
       System.out.println("��3�� s equals t");
    else
       System.out.println("��3�� s not equals t");

    if(s.toString().equals(t.toString()))
       System.out.println("��4�� s equals t");

    s.reverse();
    System.out.println("��5�� s:"+s);

    s.setCharAt(0,'0');
    System.out.println("��6�� s:"+s);

    s.insert(3,"aaa");
    System.out.println("��7�� s:"+s);

    s.append("zzz");
    System.out.println("��8�� s:"+s);


  }
}