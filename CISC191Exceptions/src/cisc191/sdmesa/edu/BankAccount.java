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
	private double balance = 0;

	public double getBalance()
	{
		return balance;
	}

	/**
	 * Deposit amount into account
	 * 
	 * @param amount
	 * @throws InvalidAmountException is thrown if amount is not positive
	 */
	public void deposit(double amount)
	{
	}

	/**
	 * Withdraw amount from account
	 * 
	 * @param amount
	 * @throws InvalidAmountException     is thrown if amount is not positive
	 * @throws InsufficientFundsException is thrown if there is not enough funds in
	 *                                    the account to make the withdrawal
	 */
	public void withdraw(double amount)
	{
	}

	/**
	 * Deposit and withdraw money
	 * 
	 * @return the remaining balance
	 */
	public static double getOrAsMuchAsPossible(double requestAmount)
	{
		double amount = 0;
		BankAccount account = new BankAccount();
		account.deposit(400);

		// TODO: Try to get requestAmount (method will be called with $500)
		amount = requestAmount;
		account.withdraw(requestAmount);

		// TODO: If there are insufficient funds, get as much as you can
		amount = account.getBalance();
		account.withdraw(amount);

		// TODO: Return what was withdrawn, no matter what amount was withdrawn
		return amount;
	}

}
