//数组示例

import javax.swing.JOptionPane;
import java.util.Arrays;

public class ArrayTest
{
  public static void main(String [] args)
  {
     /*//初始化
     int [] array1={1,4,5};//int array1 []={1,4,5}//相同;
     //int [3] array1={1,4,5}；//错误
     String [] array2={"how","are","you"};

     //基本类型的数组
     int [] array4=new int[10];
     //int [ ] array4;

     System.out.println("数组创建之后被自动初始化");
     for(int i=0;i<10;i++)
        System.out.println(array4[i]);

    for(int i=0;i<10;i++)
        array4[i]=i*i;
    System.out.println(array4[10]);//越界*/


    //引用类型的数组
    /*String [] array5=new String[4];
    for(int i=0;i<4;i++)
        array5[i]=JOptionPane.showInputDialog("请输入第"+i+"个元素:");
    for(int i=0;i<4;i++)
        System.out.println(array5[i]);
    System.exit(0);*/


   /* System.out.println("System.arraycopy()的使用");
    int []ia={0,1,2,3,4};
    int []ib={100,101,102,103,104,105};
    System.arraycopy(ia,2,ib,3,3);
    for(int element:ib)
        System.out.println(element);


   System.out.println("Arrays.copyOf()的使用");
   int[] ic={0,1,2,3,4};
   int[] id= Arrays.copyOf(ic,ic.length);//若第二个参数大于ic的元素个数，则相应的元素初值为0
   for(int element:id)
       System.out.println(element);


    System.out.println("Arrays.sort()的使用");
    Arrays.sort(ib);
    System.out.println("after sort:");
    for(int i=0;i<ib.length;i++)
        System.out.println(ib[i]);
    */


   /* System.out.println("两行交换");
    int [ ][ ] a={{1,2},{2,3},{3,4,5}};
    int [] temp=a[0];
	a[0]=a[1];
    a[1]=temp;
    System.out.println(Arrays.deepToString(a));*/

  }

}








