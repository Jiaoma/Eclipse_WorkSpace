
/*�ڶ���������ʱ,��ȡǮ�������������Ϊ�쳣����(InsufficientFundsException).
  ˼·:(1)����һ��InsufficientFundsException
       (2)���������ȡǮ������withdrawal���ܻ�������쳣�������ڸ÷������ж�����Ƿ�����ȡǮ����,
       ��������׳�InsufficientFundsException����Ҫ�ڷ���ͷ�������쳣
       (3)�����쳣�������ϼ���������withdrawal��ʱ��
*/

//bank��
class Bank
{
   private double balance=0;

   public void deposit(double amount)
   {
	  if(amount>0) {balance+=amount;}
   }

   public void withdraw(double amount) throws InsufficientFundsException
   {
	   if (balance<amount)
	   {
          String message="The balance is "+balance+",the withdraw is "+amount;
          throw new InsufficientFundsException(message);
       }
       balance=balance-amount;
   }
}

//�Զ�����쳣��
class InsufficientFundsException extends Exception   //Throwable
{
	//Ĭ�ϵĹ��췽��
	public InsufficientFundsException(){}

    //������ϸ������Ϣ�Ĺ��췽��
    public InsufficientFundsException(String message)
	{
		 super(message);
    }
}

//������
public  class MyExceptionTest
{
   public static void main(String args[])
   {
	 try
     {
		 Bank bank=new Bank( );
         bank.deposit(50);
         bank.withdraw(100);
         System.out.println("Withdrawal successful!");
     }
     catch(InsufficientFundsException e)
     {
	     e.printStackTrace();
	 }

   }
}





/*�����
     catch(Exception e)
	 {
	     e.printStackTrace();
	 }
���� catch(InsufficientFundsException e)֮ǰ��������޷�ͨ��*/

