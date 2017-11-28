import java.io.*;
/**
   Title:Engineer类<br>
   Description:通过Engineer类说明java中的文档注释<br>
   @author John
   @version 1.00
 */

 public class Engineer
 {
   /**
    代表工程师的姓名
    */
    private String engineer_name;

   /** 这是构造方法
     @param name 它是engineer的名字
     */
    public Engineer(String name)
    {
       engineer_name=name;
    }

   /** 这是repairing方法的说明
    @param sum 它是需要修理的机器总数
    @param alltime 它是需要修理的总时间
    @return 成功修理的机器的数量
    */
    public int repairing(int sum,int alltime)
    {
		return 1;
    }
 }


 //javadoc -d doc Engineer.java
 //javadoc -d doc -version -author Engineer.java 将版本和作者抽取出来
 //javadoc -d doc2 *.java 抽取当前目录下所有类的帮助
 //抽取以下信息
 //包、公有类和接口、公有的和受保护的方法、公有的和受保护的成员变量