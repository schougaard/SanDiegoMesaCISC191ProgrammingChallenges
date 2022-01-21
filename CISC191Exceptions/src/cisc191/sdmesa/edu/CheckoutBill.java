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
	private double billAmount = 0;
	private double tipPercent = -1;

	/**
	 * Set the amount from which to calculate the total bill
	 * 
	 * @param amount
	 * @throws IllegalArgumentException is thrown if amount is not positive
	 */
	public void setBillAmount(double amount) throws IllegalArgumentException
	{
		billAmount = amount;
	}

	/**
	 * Set the tip percent from which to calculate the total bill
	 * 
	 * @param amount
	 * @throws IllegalArgumentException is thrown if amount is negative
	 */
	public void setTipPercent(double percent) throws IllegalArgumentException
	{
		tipPercent = percent;
	}

	/**
	 * Calculate the total bill from the bill amount and tip percentage
	 * 
	 * @param amount
	 * @throws IllegalArgumentException is thrown if bill amount is not positive or
	 *                                  tip percent is negative
	 */
	public double calculateTotalBill() throws IllegalArgumentException
	{
		return billAmount * (1 + tipPercent / 100);
	}

	public static void main(String[] args)
	{
		// TODO: prevent the program from crashing
		CheckoutBill bill = new CheckoutBill();
		bill.setTipPercent(18);
		bill.calculateTotalBill();
	}

}
