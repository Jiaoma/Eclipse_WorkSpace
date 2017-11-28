//格式化输出范例

import java.util.Date;
import java.util.Random;

public class OutputTest
{
   public static void main(String [] args)
   {

       double x=Math.random()*10000;//生成一个随机数，0<=x<10000
       //double x=new Random().nextDouble()*10000;

       System.out.println(x);//以x对应数据类型所允许最大非0数字位数输出
       System.out.printf("%08.2f \n",x);//f为转换符，代表浮点数；最少8个字符宽度和小数点后两位输出x;0代表数字前面补零
       System.out.printf("%,.2f \n",x);//，标志表示添加了分组的分隔符
       System.out.printf("%1$10.4f %1$9.2f %2$s \n",x,"abc");//1$第一个参数，2$第二个参数
       System.out.printf("%tc \n",new Date());//c代表完整的日期和时间
       System.out.printf("%tb \n",new Date()); //b代表月
   }
}