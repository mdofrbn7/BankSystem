package Bank;

public class StudentAccount extends BankAccount {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String  institutionName;

public StudentAccount(String name, int balance ,String  institutionName) {
	super(name, balance,100, 0, institutionName, "N/A" );
	this.institutionName=institutionName;
        
        //int min_balance=100;
//	this.type="Stuedent Account";
}



}
