package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Lead Author(s):
 * 
 * @author Tasha Frankie
 * @author Allan Schougaard
 * 
 *         Other contributors: None
 * 
 *         References: Morelli, R., & Walde, R. (2016). Java, Java, Java:
 *         Object-Oriented Problem Solving.
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M.,
 *         Rancourt, J. D., & Stein, C. (n.d.). JUnit 5 user guide. JUnit 5.
 *         https://junit.org/junit5/docs/current/user-guide/
 * 
 *         Version/date: 1.0
 */

class TestRecursion
{

	@Test
	void testCalculateBalance()
	{
		// We are using the format:
		// calculateBalance(startBalance, interestRate, numberOfPeriods)
		assertEquals(0.01, Recursion.calculateEndBalance(0.01, 0.05, 0));
		assertEquals(52.50, Recursion.calculateEndBalance(50.00, 0.05, 1));

		// The last argument in the assertEquals below means verify to within 1 cent
		// ($0.01) accuracy.

		// What will the stock market do with $100 over 20 and 30 years:
		assertEquals(386.96, Recursion.calculateEndBalance(100.00, 0.07, 20), 0.01);
		assertEquals(761.22, Recursion.calculateEndBalance(100.00, 0.07, 30), 0.01);

		// What will a savings account do with $100 over 30 years:
		assertEquals(100.90, Recursion.calculateEndBalance(100.00, 0.0003, 30), 0.01);
	}

//	@Test
//	void testCalculatePopulation()
//	{
//		// Inspired by:
//		// Mathispower4u. (2013, September 23). Logistic Growth: Using Recursive
//		// Equations. YouTube. https://www.youtube.com/watch?v=E2REyozXL3Y
//
//		// Note: Populations are whole numbers
//		// We are using the format:
//		// calculateEndPopulation(startPopulation, sustainablePpopulation, growthFactor,
//		// numberOfPeriods)
//		assertEquals(2000, Recursion.calculateEndPopulation(2000, 10000, 0.05, 0));
//		assertEquals(2080, Recursion.calculateEndPopulation(2000, 10000, 0.05, 1));
//		assertEquals(2162, Recursion.calculateEndPopulation(2000, 10000, 0.05, 2));
//		assertEquals(2246, Recursion.calculateEndPopulation(2000, 10000, 0.05, 3));
//
//		assertEquals(2901, Recursion.calculateEndPopulation(2000, 10000, 0.05, 10));
//		assertEquals(4011, Recursion.calculateEndPopulation(2000, 10000, 0.05, 20));
//		assertEquals(6448, Recursion.calculateEndPopulation(2000, 10000, 0.05, 40));
//		assertEquals(8325, Recursion.calculateEndPopulation(2000, 10000, 0.05, 60));
//		// Population slowly approaching 10000
//		assertEquals(9318, Recursion.calculateEndPopulation(2000, 10000, 0.05, 80));
//		assertEquals(9738, Recursion.calculateEndPopulation(2000, 10000, 0.05, 100));
//		assertEquals(9898, Recursion.calculateEndPopulation(2000, 10000, 0.05, 120));
//		// But never quite getting to 10000
//		assertEquals(9980, Recursion.calculateEndPopulation(2000, 10000, 0.05, 1000));
//		assertEquals(9980, Recursion.calculateEndPopulation(2000, 10000, 0.05, 5000));
//
//		// Try this to see what can happen with recursive programs where the
//		// programming environment (JVM) does not perform tail-recursion optimization
//		// assertEquals(9980, Recursion.calculateEndPopulation(2000, 10000, 0.05,
//		// 100000));
//	}

}
