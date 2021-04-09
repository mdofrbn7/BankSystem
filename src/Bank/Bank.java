package Bank;
import java.io.Serializable;
import javax.swing.DefaultListModel;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import java.sql.*;
import javax.swing.JOptionPane;
import Bank.BankAccount;
import java.sql.*;

public class Bank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private BankAccount[] accounts= new BankAccount[100];
//	public int addAccount(BankAccount acc)
//	{
//            acc =new BankAccount();
////		int i=0;
////		for(i=0;i<100;i++)
////		{
////			if(getAccounts()[i]==null)
////			{
////				break;
////			}
////		}
////		getAccounts()[i]=acc;
////		return i;
//            
//	}
	
	public void addAccount(String name, int balance, int maxWithLimit )
	{
		SavingsAccount acc=new SavingsAccount(name, balance, maxWithLimit);
//		return this.addAccount(acc);
	}
	
	public void addAccount(String name, int balance, String tradeLicense) throws Exception
	{
		CurrentAccount acc = new CurrentAccount(name, balance,tradeLicense);
//		return this.addAccount(acc);
	}
	
	public void addAccount(String name, String  institutionName, int balance)
	{
		StudentAccount acc= new StudentAccount(name,balance,institutionName);
//		return this.addAccount(acc);
	}
	
	public boolean findAccount(String aacountNum)
	{
            Connection c = null;
             Statement stmt = null;
             
            try {
             
              c = DriverManager.getConnection("jdbc:sqlite:acccount_info.db");
              c.setAutoCommit(false);
              //System.out.println("Opened database successfully");

              stmt = c.createStatement();
           
              ResultSet rs = stmt.executeQuery( "SELECT * FROM accounts;" );
              while ( rs.next() ) {
                 String id = rs.getString("id");
                 if(id==aacountNum){
                     return true;
                 }else{
                     continue;
                 }
              }
              rs.close();
              stmt.close();
              c.close();
           } catch ( Exception e ) {
              JOptionPane.showMessageDialog(null, e);
              System.exit(0);
             
           }	
            return false;
	}
	
	public void deposit(String aacountNum, int amt) throws InvalidAmount,AccNotFound
	
	{
		if(amt<0)
		{
			throw new InvalidAmount("Invalid Deposit amount");
		}
		boolean temp=findAccount(aacountNum);
		if(temp==false)
		{
			throw new AccNotFound("Account Not Found");
		}
		if(temp)
		{      
                    Connection c = null;
                    Statement stmt = null;
                    try{
                        
                        c = DriverManager.getConnection("jdbc:sqlite:account_info.db");
                        c.setAutoCommit(false);
                        //System.out.println("Opened database successfully");
//                        
//                        ResultSet rs = stmt.executeQuery( "SELECT * FROM accounts;" );
//
//                 c = DriverManager.getConnection("jdbc:sqlite:account_info.db");
//                 c.setAutoCommit(false);
//                 //JOptionPane.showMessageDialog(null,"Opened database successfully");
//
//                 stmt = c.createStatement();
//                 ResultSet rs = stmt.executeQuery( "SELECT * FROM accounts;" );


//                         while ( rs.next() ) {
//                            int id = rs.getInt("id");
//                            int balance = rs.getInt("Balance");
                            stmt = c.createStatement();
                            String sql = "SELECT id, Balance FROM accounts WHERE id = "+aacountNum+";";
                            stmt.executeUpdate(sql);
                            ResultSet rs = stmt.executeQuery( "SELECT * FROM accounts;" );
                            int balance = rs.getInt("Balance");
                            int  updateBalance = balance + amt;
                            String sql_update = "UPDATE accounts set Balance = "+updateBalance +" where id="+aacountNum+";";
                            stmt.executeUpdate(sql_update);
                            c.commit();

                    }catch(Exception e){
                        //fg
                    }
                    
			
		}
		
	}
	
	
	public void withdraw(String aacountNum, int amt) throws MaxBalance,AccNotFound, MaxWithdraw, InvalidAmount
	{
		boolean temp=findAccount(aacountNum);
		
		if(temp==false)
		{
			throw new AccNotFound("Account Not Found");
		}
		
		if(amt<=0)
		{
			throw new InvalidAmount("Invalid Amount");
		}
		if(temp){
                    Connection c = null;
                    Statement stmt = null;
                    try{
                        
                        c = DriverManager.getConnection("jdbc:sqlite:account_info.db");
                        c.setAutoCommit(false);
                            stmt = c.createStatement();
                            String sql = "SELECT id, Balance FROM accounts WHERE id = "+aacountNum+";";
                            stmt.executeUpdate(sql);
                            ResultSet rs = stmt.executeQuery( "SELECT * FROM accounts;" );
                            int balance = rs.getInt("Balance");
                            
                            if(amt>balance){
                                throw new MaxBalance("Insufficient Balance");
                            }
                           int  updateBalance = balance -amt;
                            String sql_update = "UPDATE accounts set Balance = "+updateBalance +" where id="+aacountNum+";";
                            stmt.executeUpdate(sql_update);
                            c.commit();

                    }catch(Exception e){
                        //fg
                    }
                    
                }
		
	}
	
}
