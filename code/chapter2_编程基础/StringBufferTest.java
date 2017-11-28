import java.util.*;
public class StringBufferTest
{
  public static void main(String [] args)
  {
    StringBuffer s=new StringBuffer("12345");
    System.out.println("第1行 s:"+s);
    StringBuffer t=new StringBuffer("12345");
    System.out.println("第2行 t:"+t);

    //与String不同，StringBuffer没有改写Object中的equals方法，仅当指向同一对象时，返回true
    if(s.equals(t))
       System.out.println("第3行 s equals t");
    else
       System.out.println("第3行 s not equals t");

    if(s.toString().equals(t.toString()))
       System.out.println("第4行 s equals t");

    s.reverse();
    System.out.println("第5行 s:"+s);

    s.setCharAt(0,'0');
    System.out.println("第6行 s:"+s);

    s.insert(3,"aaa");
    System.out.println("第7行 s:"+s);

    s.append("zzz");
    System.out.println("第8行 s:"+s);


  }
}