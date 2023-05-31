package cisc191.sdmesa.edu;

import java.util.*;

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
	 * @return the sum of n+(n-1)+...+1
	 */
	public static int addLess(final int n)
	{
		if (n == 1)
		{
			// Base case
			return -1;
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
//	public static int multiplyLess(final int n)
//	{
//		// TODO
//		return -17;
//	}
	
	/**
	 * Calculate the n'th Lucas number.
	 * @param n the number of the Lucas number
	 * @return L(n) = L(n-2) + L(n-1)
	 */
//	public static int lucas(final int n)
//	{
//		// TODO:
//		switch (n)
//		{
//          // Base cases
//			case 0: return -42;
//                  break;
//			// case ?:
//			           break;
//			//default: return -422; 
//                     break;
//		}
//	}
	
	/**
	 * Calculate the next Collatz number
	 * @param n the number to calculate from
	 * @return the next number in the Collatz sequence
	 */
//	public static int nextCollatzNumber(int n)
//	{
//		if (n%2==0)
//		{
//			return -1;
//		}
//		else
//		{
//			return -1;
//		}
//	}
	
	/**
	 * Calculate an entire Collatz sequence given a starting number
	 * @param n starting number
	 * @return list of Collatz numbers starting with n
	 */
//	public static List<Integer> collatzList(int n)
//	{
//		if (n==1)
//		{
//			LinkedList<Integer> list = new LinkedList<Integer>();
//			//TODO
//			return list; 
//		}
//		else
//		{
//			LinkedList<Integer> list = new LinkedList<Integer>();
//			//TODO
//			
//			return list;
//		}
//	}
	
//	/**
//	 * Calculate the end balance given a starting balance, and interest rate
//	 * (given as a decimal) and the number of times interest is added.
//	 * 
//	 * @param startBalance for the first period
//	 * @param interestRate how much interest the money accrues 
//	 * @param periods how many periods the money is invested (how many times interest is added)
//	 * @return ending balance how much is returned at the end of the last period
//	 */
//	public static double calculateEndBalance(final double startBalance,
//			final double interestRate, final int periods)
//	{
//		if (periods == 0)
//		{
//			// TODO:
//			return -1;
//		}
//		else
//		{
//			// TODO:
//			// Calculate the end balance for the first n-1 periods
//			// The start balance for the n'th period is the end balance for the first n-1 periods
//			double startBalanceForNthPeriod = calculateEndBalance(???);
//			// Then calculate the end balance for the n'th period by adding interest for one period.
//			return -2;
//		}
//	}

	/**
	 * Calculate the ending population
	 * 
	 * @param startPopulation the starting population
	 * @param maxPopulation the maximum population that the environment will sustain
	 * @param growthRate starting growth rate, 0 < growthRate < 1
	 * @param periods that the population lives
	 * @return the ending population
	 */
//	public static int calculateEndPopulation(final int startPopulation,
//			final int maxPopulation, final double growthRate, final int periods)
//	{
//		return 0;
//	}

}
