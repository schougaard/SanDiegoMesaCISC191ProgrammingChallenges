package edu.sdmesa.cisc191;

import static edu.sdmesa.cisc191.M1Challenge.*;
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
 * Test M1Challenge implementation
 */

/**
 * ***********************
 * I N S T R U C T I O N S
 * ***********************
 * 
 * Your mission, should you choose to accept it:
 * 
 * For each of the test methods below create a method in the M1Challenge
 * class that makes the test run and pass.
 * 
 * You run the test methods in this file by selecting the Run menu -> Run as -> JUnit test
 * testAdd() should pass, but testMax() will fail.
 * 
 * Read the test methods below to understand what the M1Challenge class methods
 * should do. The assertEquals methods check to see if the two arguments are
 * equal. If they are equal the test passes; if not, the test will be marked as
 * failed and the execution stops.
 * 
 * To implement a test method:
 * 
 * 1. Uncomment the entire test method. To uncomment a block, select the block
 * and hold down Ctrl while typing /
 * @Test indicates that the next method is a test method, and
 * it must be in the source code, and not be commented out.
 * 
 * 2. To make the test compile and run: implement a method with the correct
 * signature, but returning a fake value, such as -1, null or similar.
 * See: multiply and max
 * After this the test method should run (but fail).
 * 
 * 3. To make the tests pass: Change the method to return the correct value
 * and run the test again.
 * 
 */

class TestM1Challenge
{

	@Test // This indicates that the next method is a test method
	void testAdd()
	{
		// add(..., ...) adds two numbers
		// This checks that add(2, 2) returns 4.
		assertEquals(4, add(2, 2));
		// This checks that add(2, -2) returns 0.
		assertEquals(0, add(2, -2));
	}
	
	@Test // @Test must not in a comment
	void testMultiply()
	{
		// multiply(..., ...) multiplies two numbers
		// This checks that add(2, 2) returns 4.
		assertEquals(4, multiply(2, 2));
		// This checks that add(2, -2) returns 0.
		assertEquals(-4, multiply(2, -2));
	}
	
// To remove //: select line(s) and type Ctrl-/ 
	
//	@Test
//	void testGetFirst()
//	{
//		int[] array1 = { 1 };
//		assertEquals(1, getFirst(array1));
//		int[] array2 = { 0, 1, 2 };
//		assertEquals(0, getFirst(array2));
//	}
//	
//	@Test
//	void testGetLast()
//	{
//		int[] array1 = { 1 };
//		assertEquals(1, getLast(array1));
//		int[] array2 = { 0, 1, 2 };
//		assertEquals(2, getLast(array2));
//	}
//	
//	@Test
//	void testGetMiddle()
//	{
//		// Only solve for the examples given here
//		int[] array1 = { 1 };
//		assertEquals(1, getMiddle(array1));
//		int[] array2 = { 0, 4, 8 };
//		assertEquals(4, getMiddle(array2));
//	    int[] array3 = { 0, 1, 2, 3, 4 };
//	    assertEquals(2, getMiddle(array3));
//	}
//	
//	@Test
//	void testMax()
//	{
//		int[] array1 = { 1 };
//		// This checks that max returns 1 (the only element)
//		assertEquals(1, max(array1));
//		
//		array1[0] = -2147483648;
//		assertEquals(-2147483648, max(array1));
//
//		int[] array2 = { 1, 2, 2147483647 };
//		// This checks that max returns 2147483647, the largest element
//		assertEquals(2147483647, max(array2));
//
//		int[] array3 = { -1, 2, -2147483648 };
//		// This checks that max returns 2, which is the largest element
//		assertEquals(2, max(array3));
//
//		int[] array4 = { -42, -2, -3 };
//		// This checks that max returns -2, which is the largest element
//		assertEquals(-2, max(array4));
//		
//		int[] array5 = { 3, 1, 2 };
//		assertEquals(3, max(array5));
//				
//		int[] array6 = { 2, 1, 3 };
//		assertEquals(3, max(array6));
//		
//		int[] array7 = { 2, 3, 1 };
//		assertEquals(3, max(array7));
//	}
//
//	@Test
//	void testMin()
//	{
//		int[] array1 = {1};
//		assertEquals(1, min(array1));
//		
//		array1[0] = 2147483647;
//		assertEquals(2147483647, min(array1));
//		
//		int[] array2 = {2, 1, 3};
//		assertEquals(1, min(array2));
//
//		int[] array3 = {-1, -2, 2147483647};
//		assertEquals(-2, min(array3));
//
//		int[] array4 = {-1, -2, -2147483648};
//		assertEquals(-2147483648, min(array4));
//		
//		int[] array5 = {1, 2, 3};
//		assertEquals(1, min(array5));	
//		
//		int[] array6 = {3, 2, 1};
//		assertEquals(1, min(array6));
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
//              // hint: can you use sum?
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

}
