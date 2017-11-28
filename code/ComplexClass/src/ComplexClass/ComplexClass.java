
package ComplexClass;

import javax.swing.JOptionPane;

public class ComplexClass 
{
	public static void main(String[] args)
	{
		ComplexNumber a=new ComplexNumber(3.3,4.5);
		ComplexNumber b=new ComplexNumber(-4,3);
		ComplexNumber c=new ComplexNumber();
		JOptionPane.showMessageDialog(null,"c 的实部为："+c.getReal()+"虚部为"+c.getVirt());
		c.plus(a);
		JOptionPane.showMessageDialog(null,"c+a 的实部为："+c.getReal()+"虚部为"+c.getVirt());
		c.reduce(b);
		JOptionPane.showMessageDialog(null,"c+a-b 的实部为："+c.getReal()+"虚部为"+c.getVirt());
	}
}

class ComplexNumber
{
	private double realNum;
	private double virtNum;
	public ComplexNumber()
	{
		realNum=0.0;
		virtNum=0.0;
	}
	public ComplexNumber(double _rNum,double _vNum)
	{
		realNum=_rNum;
		virtNum=_vNum;
	}
	public double getReal()
	{
		return realNum;
	}
	public double getVirt()
	{
		return virtNum;
	}
	public void plus(ComplexNumber b)
	{
		realNum+=b.getReal();
		virtNum+=b.getVirt();
	}
	public void reduce(ComplexNumber b)
	{
		realNum-=b.getReal();
		virtNum-=b.getVirt();
	}
}