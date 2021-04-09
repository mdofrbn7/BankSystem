package Bank;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class SavingsAccount extends BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float rate= .05f;
	double maxWithLimit;
//	String type;
	
	public SavingsAccount(String name, int balance,int maxWithLimit) {
		super(name, balance, 2000, maxWithLimit, "N/A" , "N/A");
		this.maxWithLimit= maxWithLimit;
//		this.type="Savings Account";
	}
	
	public double getNetBalance()
	{
		double NetBalance= getbalance()+(getbalance()*rate);
		return NetBalance;
	}
	
	public void withdraw(int amount) throws MaxWithdraw, MaxBalance
	{
		if(amount<maxWithLimit)
		{
			super.withdraw(amount);
			
		}
		else
		{
			throw new MaxWithdraw("Maximum Withdraw Limit Exceed");
		}
		
	}
	
	
}
