import javax.swing.JOptionPane; //导入语句
import java.util.*;
public class chess {

	public static void main(String[] args)
	{
		char[] map= {'1','2','3','4','5','6','7','8','9'};
		boolean isWin=false;
		int isFull=9;
		String  locationS;
		int location;
		while(!isWin && isFull>0)
		{
			locationS=JOptionPane.showInputDialog("-------------\n"+ "| "+map[0]+" | "+map[1]+" | "+map[2]+" |\n"
					+"-------------\n"+ "| "+map[3]+" | "+map[4]+" | "+map[5]+" |\n"
					+"-------------\n"+ "| "+map[6]+" | "+map[7]+" | "+map[8]+" |\n"
					+"-------------\n"+"请输入位置：\n");
			location=Integer.parseInt(locationS);
			map[location-1]='*';
			isFull--;
			isWin=judge('*',map);
			if(isWin||isFull==0)break;
			map[randomPlay(map)]='o';
			isFull--;
			if(judge('o',map)||isFull==0)break;
		}
		

		 if(isWin)
		 {
			 JOptionPane.showMessageDialog(null,"-------------\n"+ "| "+map[0]+" | "+map[1]+" | "+map[2]+" |\n"
						+"-------------\n"+ "| "+map[3]+" | "+map[4]+" | "+map[5]+" |\n"
						+"-------------\n"+ "| "+map[6]+" | "+map[7]+" | "+map[8]+" |\n"
						+"-------------\n"+"恭喜你赢了\n");//使用消息对话框输出
		 }
		 else if(isFull==0)
		 {
			 JOptionPane.showMessageDialog(null,"-------------\n"+ "| "+map[0]+" | "+map[1]+" | "+map[2]+" |\n"
						+"-------------\n"+ "| "+map[3]+" | "+map[4]+" | "+map[5]+" |\n"
						+"-------------\n"+ "| "+map[6]+" | "+map[7]+" | "+map[8]+" |\n"
						+"-------------\n"+"平局\n");
		 }
		 else
		 {
			 JOptionPane.showMessageDialog(null,"-------------\n"+ "| "+map[0]+" | "+map[1]+" | "+map[2]+" |\n"
						+"-------------\n"+ "| "+map[3]+" | "+map[4]+" | "+map[5]+" |\n"
						+"-------------\n"+ "| "+map[6]+" | "+map[7]+" | "+map[8]+" |\n"
						+"-------------\n"+"恭喜你输了\n");
		 }
	     //System.out.println("next year,"+name+" will be "+(intage+1));               //使用标准输出方式

		 System.exit(0);
	}
	public static boolean judge(char player,char[] map)
	{
		if((map[0]==player&&map[1]==player&&map[2]==player)
			||(map[3]==player&&map[4]==player&&map[5]==player)
			||(map[6]==player&&map[7]==player&&map[8]==player)
			||(map[0]==player&&map[3]==player&&map[6]==player)
			||(map[1]==player&&map[4]==player&&map[7]==player)
			||(map[2]==player&&map[5]==player&&map[8]==player)
			||(map[0]==player&&map[4]==player&&map[8]==player)
			||(map[2]==player&&map[4]==player&&map[6]==player))
		{
			return true;
		}
		else
			return false;
			
	}
	public static int randomPlay(char[] map)
	{
		int p;
		do
		{
			p=(int)(Math.random()*100)%9;
		}while(map[p]=='o' || map[p]=='*');
		return p;					
	}
}
