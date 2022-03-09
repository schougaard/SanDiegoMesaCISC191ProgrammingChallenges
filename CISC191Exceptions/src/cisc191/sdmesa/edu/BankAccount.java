package cisc191.sdmesa.edu;

/**
 * Lead Author(s):
 * @author 
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * 
 */
/**
 */
public class BankAccount
{
	// A bank account has a current balance starting at $0.00
	private double balance = 0;

	/**
	 * 
	 * @return the current balance
	 */
	public double getBalance()
	{
		return balance;
	}

	/**
	 * Deposit amount into account
	 * 
	 * @param amount to deposit
	 * @throws InvalidAmountException is thrown if amount is not positive
	 */
	public void deposit(double amount)
	{
		// TODO
	}

	/**
	 * Withdraw amount from account
	 * 
	 * @param amount to withdraw
	 * @throws InvalidAmountException     is thrown if amount is not positive
	 * @throws InsufficientFundsException is thrown if there is not enough funds in
	 *                                    the account to make the withdrawal
	 */
	public void withdraw(double amount)
	{
		// TODO
	}

	/**
	 * Withdraw amount requested or the biggest amount possible
	 * 
	 * @return the amount withdrawn
	 */
	public double getOrAsMuchAsPossible(double requestAmount)
	{
		// TODO:
		// Try to withdraw the requested amount
		// If it fails, get as much as possible
		return -1;
	}

}
