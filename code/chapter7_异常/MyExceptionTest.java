
/*在定义银行类时,若取钱数大于余额则作为异常处理(InsufficientFundsException).
  思路:(1)定义一个InsufficientFundsException
       (2)在银行类的取钱方法中withdrawal可能会产生该异常，所以在该方法中判断余额是否少于取钱数额,
       如果是则抛出InsufficientFundsException，需要在方法头部声明异常
       (3)捕获异常安排在上级方法调用withdrawal的时候
*/

//bank类
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

//自定义的异常类
class InsufficientFundsException extends Exception   //Throwable
{
	//默认的构造方法
	public InsufficientFundsException(){}

    //带有详细描述信息的构造方法
    public InsufficientFundsException(String message)
	{
		 super(message);
    }
}

//测试类
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





/*如果将
     catch(Exception e)
	 {
	     e.printStackTrace();
	 }
放在 catch(InsufficientFundsException e)之前，则编译无法通过*/

