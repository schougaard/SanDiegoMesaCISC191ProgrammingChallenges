package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Tasha Frankie
 * @author Allan Schougaard
 * 
 * @version 1.1
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * @see Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt,
 *      J. D., & Stein, C. (n.d.). JUnit 5 user guide. JUnit 5.
 *      https://junit.org/junit5/docs/current/user-guide/
 */

class TestRecursion
{
	@Test
	void testAddLess()
	{
		assertEquals(0, Recursion.addLess(0));
		assertEquals(1+0, Recursion.addLess(1));
		assertEquals(2+1, Recursion.addLess(2));
		assertEquals(3+Recursion.addLess(2), Recursion.addLess(3));
		assertEquals(100+Recursion.addLess(99), Recursion.addLess(100));
	}
	
//	@Test
//	void testMultiplyLess()
//	{
//		assertEquals(1, Recursion.multiplyLess(1));
//		assertEquals(2*1, Recursion.multiplyLess(2));
//		assertEquals(3*2, Recursion.multiplyLess(3));
//		assertEquals(100*Recursion.multiplyLess(99), Recursion.multiplyLess(100));
//	}
	
//	@Test
//	void testLucasNumbers()
//	{
//		// See:
//		// Lucas numbers. (n.d.). Brilliant | Learn interactively. 
//		// https://brilliant.org/wiki/lucas-numbers/
//		
//		assertEquals(2, Recursion.lucas(0));
//		assertEquals(1, Recursion.lucas(1));
//		assertEquals(3, Recursion.lucas(2));
//		assertEquals(4, Recursion.lucas(3));
//		assertEquals(76, Recursion.addLess(9));
//	}

//	@Test
//	void testCalculateBalance()
//	{
//		// We are using the format:
//		// calculateBalance(startBalance, interestRate, numberOfPeriods)
//		assertEquals(0.01, Recursion.calculateEndBalance(0.01, 0.05, 0));
//		assertEquals(52.50, Recursion.calculateEndBalance(50.00, 0.05, 1));
//
//		// The last argument in the assertEquals below means verify to within 1 cent
//		// ($0.01) accuracy.
//
//		// What will the stock market do with $100 over 20 and 30 years:
//		assertEquals(386.96, Recursion.calculateEndBalance(100.00, 0.07, 20), 0.01);
//		assertEquals(761.22, Recursion.calculateEndBalance(100.00, 0.07, 30), 0.01);
//
//		// What will a savings account do with $100 over 30 years:
//		assertEquals(100.90, Recursion.calculateEndBalance(100.00, 0.0003, 30), 0.01);
//	}

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
