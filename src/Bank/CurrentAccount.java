package Bank;

public class CurrentAccount extends BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tradeLicenseNumber;
       

	public CurrentAccount(String name, int balance,String tradeLicenseNumber){
        super(name, balance, 5000, 0 , "N/A", tradeLicenseNumber);
            this.tradeLicenseNumber= tradeLicenseNumber;
            
            //if(balance<5000) throw new Exception("Insufficient Balance");

	
	
	
    }
}
