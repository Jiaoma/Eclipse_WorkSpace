//二维数组例子
import java.util.Arrays;
public class MatrixMultiply
{
	public static void main (String [] args)
	{
		int i,j,k;
		int [][]a=new int[2][3];
		int [][]b={{1,5,2,8},{5,9,10,-3},{2,7,-5,-18}};
		int [][]c=new int[2][4];

		for (i=0;i<a.length;i++)
		    for (j=0; j<a[0].length ;j++)
		         a[i][j]=i*j;

		for (i=0;i<c.length;i++)
		{
			for (j=0;j<c[0].length;j++)
			{
				c[i][j]=0;
				for(k=0;k<a[0].length;k++)
				   c[i][j]=c[i][j]+a[i][k]*b[k][j];
		    }
	    }

	    System.out.println("*******Matrix a**********");//显示a的内容
	    for(i=0;i<a.length;i++)
	    {
	         for(int temp:a[i])
			     System.out.print(temp+" ");
			  System.out.println();
	    }

	    System.out.println("\n*******Matrix b**********");//显示b的内容
	    for(i=0;i<b.length;i++)
	    {
			 for(int temp:b[i])
			     System.out.print(temp+" ");
			 System.out.println();
	    }

	    System.out.println("\n*******Matrix c**********");//显示c的内容
	    for(i=0;i<c.length;i++)
	    {
			 for(int temp:c[i])
			     System.out.print(temp+" ");
			 System.out.println();
    	}

         System.out.println("\n使用Arrays");
         System.out.println(Arrays.deepToString(a));
         System.out.println(Arrays.deepToString(b));
    	 System.out.println(Arrays.deepToString(c));
     }
}