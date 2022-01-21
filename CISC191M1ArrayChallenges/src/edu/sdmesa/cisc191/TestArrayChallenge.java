package edu.sdmesa.cisc191;

import static edu.sdmesa.cisc191.ArrayChallenge.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Lead Author(s):
 * @author Tasha Frankie
 * @author Allan Schougaard 
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt, J. D., & Stein, C. (n.d.). 
 * JUnit 5 user guide. JUnit 5. 
 * https://junit.org/junit5/docs/current/user-guide/
 * 
 * Bubble sort. (2001, October 29). Wikipedia, the free encyclopedia. 
 * https://en.wikipedia.org/wiki/Bubble_sort
 * 
 * Palindrome. (2020, July 15). Wikipedia, the free encyclopedia. 
 * https://en.wikipedia.org/wiki/Palindrome
 *  
 * Version/date: 2.0  
 * 
 * Responsibilities of class:
 * Test ArrayChallenge implementation
 */

/**
 * Your mission, should you choose to accept it:
 * 
 * For each of the test methods below create a method in the ArrayChallenge
 * class that makes the test run and pass.
 * 
 * Read the test methods to understand what the ArrayChallenge class methods
 * should do. The assertEquals methods check to see if the two arguments are
 * equal. If they are equal the test passes; if not, the test will be marked as
 * failed and the execution stops.
 * 
 * To run the tests from the main menu, select Run -> Run.
 * 
 * To implement a test method:
 * 
 * 1. Uncomment the entire test method. To uncomment a block, select the block
 * and hold down Ctrl while typing /
 * 
 * 2. To make the test compile and run: implement a method with the correct
 * signature, but returning a fake value, such as -1, null or similar. After
 * this the test method should run but fail.
 * 
 * 3. To make the tests pass: Then change the method to return the correct value
 * and run the test again.
 * 
 */

class TestArrayChallenge
{

	@Test
	void testMax()
	{
		int[] array1 = { 1 };
		assertEquals(1, max(array1));

		int[] array2 = { 1, 2, 2147483647 };
		assertEquals(2147483647, max(array2));

		int[] array3 = { -1, 2, -2147483648 };
		assertEquals(2, max(array3));

		int[] array4 = { -1, -2, -3 };
		assertEquals(-1, max(array4));
	}

// To remove //: select line(s) and type Ctrl-/ 
	
//	@Test
//	void testMin()
//	{
//		int[] array1 = {1};
//		assertEquals(1, min(array1));
//		
//		int[] array2 = {2, 1, 3};
//		assertEquals(1, min(array2));
//
//		int[] array3 = {-1, -2, 2147483647};
//		assertEquals(-2, min(array3));
//
//		int[] array4 = {-1, -2, -2147483648};
//		assertEquals(-2147483648, min(array4));
//	}
//
//	@Test
//	void testSum()
//	{
//		int[] array0 = {};
//		assertEquals(0, sum(array0));
//		
//		int[] array1 = {1};
//		assertEquals(1, sum(array1));
//		
//		int[] array2 = {1, 2, 3};
//		assertEquals(1+2+3, sum(array2));
//
//		int[] array3 = {-1, -2, 3};
//		assertEquals(-1+(-2)+3, sum(array3));
//
//		int[] array4 = {-1, -2, -3};
//		assertEquals(-1+(-2)+(-3), sum(array4));
//	}
//
//	@Test
//	void testAverage()
//	{
//		int[] array1 = {17};
//		assertEquals(17.0, average(array1));
//		
//		int[] array2 = {2, 3};
//		assertEquals((2+3)/2.0, average(array2));
//
//		int[] array3 = {-1, -2, 3};
//		assertEquals((-1+(-2)+3)/3.0, average(array3));
//
//		int[] array4 = {-1, -2, -3};
//		assertEquals((-1+(-2)+(-3))/3.0, average(array4));
//	}
//
//	@Test
//	void testMedian()
//	{
//		int[] array1 = {17};
//		assertEquals(17.0, median(array1));
//		
//		int[] array2 = {1, 2, 3};
//		assertEquals(2.0, median(array2));
//
//		int[] array3 = {1, 3};
//		assertEquals((1+3)/2.0, median(array3));
//
//		int[] array4 = {1, 2, 3, 4, 5};
//		assertEquals(3.0, median(array4));
//	}
}
