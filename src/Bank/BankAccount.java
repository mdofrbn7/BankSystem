package Bank;
import Data.CreateNewDB;
import Data.CreateTableOnDB;
import java.io.Serializable;

import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import Data.InsertRecordOnDB;

public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	private int balance;
	int min_balance;
	String id;
	
	
	public BankAccount(String name, int balance, int min_balance , int maxWithdrawLimit, String Institution, String TradeLicenceNo) {
            
		this.name = name;
		this.balance = balance;
		this.min_balance = min_balance;
		id = 10000 + (int)(Math.random()*89999) + "";
                String type= ""+ this.getClass();
                
                
                InsertRecordOnDB ins=new InsertRecordOnDB();
                ins.insert(id , name, balance, type, maxWithdrawLimit,Institution, TradeLicenceNo  );
                
	}


	public void deposit(int amount)
	{
		balance+=amount;
                
	}
	
	public void withdraw(int amount) throws MaxWithdraw, MaxBalance
	{
		if((balance-amount)>=min_balance && amount<balance)
		{
			balance-=amount;
			
		}
		
		else
		{
			throw new MaxBalance("Insufficient Balance");
		}
	}
	
	public int getbalance()
	{
		return balance;
	}
        
        
}
	
//	@Override
//	public String toString() {
//            
//		//return "Name: " + name + ", Id: " + id + ", Balance: " + balance +"Type:"+this.getClass();
//	}
//}
