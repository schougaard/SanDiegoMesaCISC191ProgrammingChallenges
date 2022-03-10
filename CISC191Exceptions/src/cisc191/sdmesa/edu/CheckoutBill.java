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
public class CheckoutBill
{
	// A bill has an amount
	private double amount = 0;
	// A bill has a tip percent
	private double tipPercent = -1;

	/**
	 * Set the amount from which to calculate the total bill
	 * 
	 * @param billAmount amount on the bill
	 * @throws IllegalArgumentException is thrown if amount is not positive
	 */
	public void setBillAmount(double billAmount) throws IllegalArgumentException
	{
		// TODO
	}

	/**
	 * Set the tip percent from which to calculate the total bill
	 * 
	 * @param percent tip given
	 * @throws IllegalArgumentException is thrown if percent is negative
	 */
	public void setTipPercent(double percent) throws IllegalArgumentException
	{
		// TODO
	}

	/**
	 * Calculate the total bill from the bill amount and tip percentage
	 * @return total bill amount
	 * @throws IllegalStateException if bill amount is not positive or tip percent is negative
	 */
	public double calculateTotalBill() throws IllegalStateException
	{
		// TODO
		
		return amount * (1 + tipPercent / 100);
	}

	public static void main(String[] args)
	{
		// TODO: prevent the program from crashing
		
		CheckoutBill bill = new CheckoutBill();
		bill.setTipPercent(-1); 
		bill.calculateTotalBill();
		
		// TODO: Print out any error messages to user
	}

}
