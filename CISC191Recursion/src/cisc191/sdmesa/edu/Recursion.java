package cisc191.sdmesa.edu;

/**
 * Lead Author(s):
 * 
 * @author
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 * Version/date:
 * 
 * Responsibilities of class:
 * 
 */
public class Recursion
{
	/**
	 * Add n to the sum of all integers less than n (but not negative)
	 * @param n
	 * @return the sum of n+(n-1)+...+1+0
	 */
	public static int addLess(int n)
	{
		if (n == 0)
		{
			// Base case
			return 0;
		}
		else
		{
			// Recursive case
			// TODO
			return -17;
		}
	}
	
	/**
	 * Multiply all integers n and less (but not negative)
	 * @param n
	 * @return the product n*(n-1)*...*1
	 */
//	public static int mulitplyLess(int n)
//	{
//		// TODO
//		return -17;
//	}
	
	/**
	 * Calculate the n'th Lucas number.
	 * @see Lucas numbers. (n.d.). Brilliant | Learn interactively. https://brilliant.org/wiki/lucas-numbers/
	 * 
	 * @param n the number of the Lucas number
	 * @return L(n) = L(n-2) + L(n-1)
	 */
//	public static int lucas(int n)
//	{
//		// TODO:
//		switch (n)
//		{
//			case 0: return -42;
//			
//			// case:
//			// break;
//			//default:
//			// break;
//		}
//		return -422;
//	}
	
	/**
	 * Calculate the end balance given a starting balance, and interest rate
	 * (given as a decimal) and the number of times interest is added.
	 * 
	 * @param startBalance
	 * @param interestRate
	 * @param periods
	 * @return ending balance
	 */
//	public static double calculateEndBalance(double startBalance,
//			double interestRate, int periods)
//	{
//		return 0.0;
//	}

	/**
	 * Calculate the ending population
	 * 
	 * @param startPopulation the starting population
	 * @param maxPopulation the maximum population that the environment will sustain
	 * @param growthRate staring growth rate, 0 < growth rate < 1
	 * @param periods
	 * @return the ending population
	 */
//	public static int calculateEndPopulation(int startPopulation,
//			int maxPopulation, double growthRate, int periods)
//	{
//		return 0;
//	}

}
