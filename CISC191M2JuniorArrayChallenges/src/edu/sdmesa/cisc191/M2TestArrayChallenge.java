package edu.sdmesa.cisc191;

import static edu.sdmesa.cisc191.M2ArrayChallenge.*;
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
 * Test M2ArrayChallenge implementation
 */

/**
 * *** INSTRUCTIONS ***
 * Your mission, should you choose to accept it:
 * 
 * For each of the test methods below create a method in the M2ArrayChallenge
 * class that makes the test run and pass.
 * 
 * Read the test methods to understand what the M2ArrayChallenge class methods
 * should do. The assertEquals methods check to see if the two arguments are
 * equal. If they are equal the test passes; if not, the test will be marked as
 * failed and the execution stops.
 * 
 * To run the tests from the main menu, select Run -> Run.
 * 
 * To implement a test method:
 * 
 * 1. Uncomment the entire test method, including @Test. 
 * To uncomment a block, select the block and hold down Ctrl while typing /
 * 
 * 2. To make the test compile and run: implement a method with the correct
 * signature, but returning a fake value, such as -1, null or similar. After
 * this the test method should run but fail.
 * 
 * 3. Make the tests pass: Change the method to return the correct value
 * and run the test again.
 * 
 */

class M2TestArrayChallenge
{
	@Test
	void testContains()
	{
		char[] array0 = {};
		assertEquals(false, contains(array0, 'z'));

		char[] array1 = {'A'};
		assertEquals(true, contains(array1, 'A'));
		assertEquals(false, contains(array1, 'B'));
		
		char[] array2 = {'A', 'B', 'C'};
		assertEquals(true, contains(array2, 'A'));
		assertEquals(true, contains(array2, 'B'));
		assertEquals(true, contains(array2, 'C'));
		assertEquals(false, contains(array2, 'c'));
	}

 //To remove //: select line(s) and type Ctrl-/ 

//	/**
//	 * find returns the first index of a value in an array,
//	 * or -1 if the value is not in the array
//	 */
//	@Test
//	void testFind()
//	{
//		char[] array0 = {};
//		assertEquals(-1, find(array0, 'A'));
//
//		char[] array1 = {'A'};
//		assertEquals(0, find(array1, 'A'));
//		assertEquals(-1, find(array1, '2'));
//		
//		char[] array2 = {'A', 'Z', 'B'};
//		assertEquals(0, find(array2, 'A'));
//    	assertEquals(1, find(array2, 'Z'));
//		assertEquals(2, find(array2, 'B'));
//		assertEquals(-1, find(array2, 'C'));
//		
//		char[] array3 = {'A', 'A', 'A'};
//		assertEquals(0, find(array3, 'A'));
//	}
//
//	@Test
//	void testCountValues()
//	{
//		char[] array0 = {};
//		assertEquals(0, countValues(array0, 'Q'));
//
//		char[] array1 = {'X'};
//		assertEquals(1, countValues(array1, 'X'));
//		assertEquals(0, countValues(array1, 'A'));
//		
//		char[] array2 = "RACECAR".toCharArray();
//		assertEquals(2, countValues(array2, 'A'));
//		assertEquals(0, countValues(array2, 'B'));
//		assertEquals(2, countValues(array2, 'C'));
//		assertEquals(0, countValues(array2, 'D'));
//		assertEquals(1, countValues(array2, 'E'));
//		assertEquals(2, countValues(array2, 'R'));
//	}
//
//	/**
//	 * Test that inOrder returns false even if one element is in the wrong place
//	 * Hint: compare pair-wise
//	 */
//	@Test
//	void testInOrder()
//	{
//		// All the elements of an empty array are sorted; all none of them.
//		char[] array0 = {};
//		assertEquals(true, inOrder(array0));
//
//		char[] array1 = {'A'};
//		assertEquals(true, inOrder(array1));
//
//		char[] array12 = {'A', 'B'};
//		assertEquals(true, inOrder(array12));
//
//		char[] array21 = {'B', 'A'};
//		assertEquals(false, inOrder(array21));
//		
//		char[] array2 = {'A', 'B', 'C'};
//		assertEquals(true, inOrder(array2));
//
//		char[] array3 = {'C', 'B', 'A'};
//	    assertEquals(false, inOrder(array3));
//
//	    char[] array4 = {'B', 'C', 'A'};
//		assertEquals(false, inOrder(array4));
//	}
//
//	/**
//	 * The swap method exchanges two elements in a given array based on index
//	 */
//	@Test
//	void testSwapElements()
//	{
//		char[] array0 = {'A', 'B'};
//		char[] array1 = {'B', 'A'};
//	    // Swap elements in-situ/in-place: make changes in the array
//	    swapElements(array0, 0);
//		assertArrayEquals(array1, array0);
//		// Note how C "bubbles" to the top
//		char[] array10 = {'C', 'B', 'A'};
//		char[] array11 = {'B', 'C', 'A'};
//		swapElements(array10, 0);
//	    assertArrayEquals(array11, array10);
//	    char[] array12 = {'B', 'A', 'C'};
//	    swapElements(array10, 1);
//	    assertArrayEquals(array12, array10);
//	    char[] array13 = {'A', 'B', 'C'};
//	    swapElements(array10, 0);
//	    assertArrayEquals(array13, array10);
//	}
//
//	/**
//	 * The bubbleUp method would do one pass of an array in the Bubble sort algorithm
//	 * See: Section Step-by-step example in https://en.wikipedia.org/wiki/Bubble_sort
//	 * The bubbleUp method does one pass of an array
//   * Hint: use swapElements
//	 */
//	@Test
//	void testBubbleUp()
//	{
//		char[] array0 = {'A', 'B'};
//		bubbleUp(array0);
//	    // No change, array is already sorted
//		assertArrayEquals("AB".toCharArray(), array0);
//
//		char[] array1 = {'B', 'A'};
//		bubbleUp(array1);
//		assertArrayEquals("AB".toCharArray(), array1);
//		
//		char[] array3 = {'C', 'B', 'A'};
//		bubbleUp(array3);
//		assertArrayEquals("BAC".toCharArray(), array3);
//		bubbleUp(array3);
//		assertArrayEquals("ABC".toCharArray(), array3);
//		bubbleUp(array3);
//		// No change
//		assertArrayEquals("ABC".toCharArray(), array3);
//	}
//
//	/**
//	 * The bubbleSort method sorts an array.
//	 * Hint: while the elements are not inOrder, repeatedly use bubbleUp
//	 */
//	@Test
//	void testBubbleSort()
//	{
//		char[] array0 = {'C', 'B', 'A'};
//	    bubbleSort(array0);
//		assertArrayEquals("ABC".toCharArray(), array0);
//
//	    char[] array10 = "LKJHGFDSA".toCharArray();
//	    bubbleSort(array10);
//	    assertArrayEquals("ADFGHJKLS".toCharArray(), array10);
//	}
//
//	/**
//	 * The copy method returns a new array with the same elements as the original array.
//	 * Is that a shallow or a deep copy?
//	 */
//	@Test
//	void testCopy()
//	{
//		char[] array0 = {};
//		assertArrayEquals(array0, copy(array0));
//
//		char[] array1 = {'A'};
//		char[] array1copy = copy(array1);
//		assertArrayEquals(array1, array1copy);
//		assertNotEquals(array1, array1copy);
//		array1copy[0] = 'B';
//		assertEquals('B', array1copy[0]);
//		assertEquals('A', array1[0]);
//
//		char[] array2 = {'X', 'Y', 'Z'};
//		assertNotEquals(array2, copy(array2));
//	}
//	
//	@Test
//	void testArrayElementsEqual()
//	{
//		//An array is equal to itself, expecting true here.
//		char[] array0a = {};
//		assertTrue(arrayElementsEqual(array0a, array0a));
//		
//		//Two empty arrays are deemed equal! 
//		char[] array0b = {};
//		assertTrue(arrayElementsEqual(array0a, array0b));
//
//		//two arrays of equal length containing the same elements in the same order are equal
//		char[] array1 = {'A'};
//		char[] array2 = copy(array1);
//		assertTrue(arrayElementsEqual(array1, array2));
//		
//		//two arrays of the same length but different contents are NOT equal	
//		array2[0] = 'B';
//		assertEquals('B', array2[0]);
//		assertEquals('A', array1[0]);
//		assertFalse(arrayElementsEqual(array1, array2));
//
//		//two arrays with different contents and size are not equal
//		char[] array3 = {'X', 'Y', 'Z'};
//		assertFalse(arrayElementsEqual(array0a, array3));		
//		assertFalse(arrayElementsEqual(array3, array0a));		
//		assertFalse(arrayElementsEqual(array1, array3));		
//		assertFalse(arrayElementsEqual(array3, array2));
//		assertTrue(arrayElementsEqual(array3, array3));
//	}
//	
//	@Test
//	void testBackwards()
//	{
//		char[] array0 = {};
//		assertArrayEquals(array0, backwards(array0));
//
//		char[] array1 = {'X'};
//		assertArrayEquals(array1, backwards(array1));
//
//		char[] array2 = {'A', 'B', 'C', 'D'};
//		assertArrayEquals(new char[]{'D', 'C', 'B', 'A'}, backwards(array2));
//		assertArrayEquals(new char[]{'A', 'B', 'C', 'D'}, array2);
//		
//		assertArrayEquals("SPOTS".toCharArray(), backwards("STOPS".toCharArray()));
//		assertArrayEquals("DESSERTS".toCharArray(), backwards("STRESSED".toCharArray()));
//	}
//
//	/**
//	 * A palindrome is a word that is spelled (hint:) equally forwards and (hint:) backwards
//	 * Hint: use methods that you have already implemented
//	 */
//	@Test
//	void testIsPalindrome()
//	{
//		char[] array0 = {};
//		assertEquals(true, isPalindrome(array0));
//
//		char[] array1 = {'X'};
//		assertEquals(true, isPalindrome(array1));
//
//		char[] array2 = "AB".toCharArray();
//		assertEquals(false, isPalindrome(array2));
//
//		char[] array3 = "XX".toCharArray();
//		assertEquals(true, isPalindrome(array3));
//
//		char[] array4 = "PALINDROME".toCharArray();
//		assertEquals(false, isPalindrome(array4));		
//
//		char[] array5 = "RACECAR".toCharArray();
//		assertEquals(true, isPalindrome(array5));		
//	}
//	
//	@Test
//	void testGetElement()
//	{
//		int[][] matrix = {{1, 2, 3}, 
//						  {4, 5, 6},
//						  {7, 8, 9}};
//
//      // Use row and column for parameter names
//		assertEquals(1, getElement(matrix, 0, 0));
//		assertEquals(2, getElement(matrix, 0, 1));
//		assertEquals(4, getElement(matrix, 1, 0));
//	}
//
//	@Test
//	void testAddRow()
//	{
//		int[][] matrix1 = {{1, 2, 3}, 
//						   {4, 5, 6},
//						   {7, 8, 9}};
//      // Hint: have you implemented a method that can do the sum?
//		assertEquals(1+2+3, addRow(matrix1, 0));
//		assertEquals(4+5+6, addRow(matrix1, 1));
//		assertEquals(7+8+9, addRow(matrix1, 2));
//		
//		int[][] matrix2 = {{1, 2, 3, 4}, 
//				           {5, 6, 7, 8},
//				           {9, 10, 11, 12}};
//		assertEquals(1+2+3+4, addRow(matrix2, 0));
//		assertEquals(5+6+7+8, addRow(matrix2, 1));
//		assertEquals(9+10+11+12, addRow(matrix2, 2));
//	}
//
//	@Test
//	void testAddColumn()
//	{
//		// Assume that the input arrays are not ragged
//		int[][] matrix1 = {{1, 2, 3}, 
//				  		   {4, 5, 6},
//				  		   {7, 8, 9}};
//		assertEquals(1+4+7, addColumn(matrix1, 0));
//		assertEquals(2+5+8, addColumn(matrix1, 1));
//		assertEquals(3+6+9, addColumn(matrix1, 2));	
//		
//		int[][] matrix2 = {{1, 2, 3}, 
//				           {4, 5, 6},
//				           {7, 8, 9},
//				           {10, 11, 12}};
//		assertEquals(1+4+7+10, addColumn(matrix2, 0));
//		assertEquals(2+5+8+11, addColumn(matrix2, 1));
//		assertEquals(3+6+9+12, addColumn(matrix2, 2));	
//	}
//
//	@Test
//	void testAddLeftToRightDiagonal()
//	{
//		// Assume that the input arrays are square
//
//		int[][] array0 = {};
//		assertEquals(0, addLeftToRightDiagonal(array0));
//		
//		int[][] matrix1 = {{1, 2, 3}, 
//						   {4, 5, 6},
//						   {7, 8, 9}};
//		assertEquals(1+5+9, addLeftToRightDiagonal(matrix1));
//		
//		int[][] matrix2 = {{1,   2,  3,  4}, 
//						   {5,   6,  7,  8},
//						   {9,  10, 11, 12},
//						   {13, 14, 15, 20}};
//		assertEquals(1+6+11+20, addLeftToRightDiagonal(matrix2));
//	}
//
//	@Test
//	void testAddRightToLeftDiagonal()
//	{
//	    // Assume that the input arrays are square
//
//		int[][] array0 = {};
//		assertEquals(0, addRightToLeftDiagonal(array0));
//		
//		int[][] matrix1 = {{1, 2, 3}, 
//				   		   {4, 5, 6},
//				   		   {7, 8, 9}};
//		assertEquals(3+5+7, addRightToLeftDiagonal(matrix1));
//		
//		int[][] matrix2 = {{1,   2,  3,  4}, 
//						   {5,   6,  7,  8},
//						   {9,  10, 11, 12},
//						   {13, 14, 15, 20}};
//		assertEquals(4+7+10+13, addRightToLeftDiagonal(matrix2));		
//	}
//
//	@Test
//	void testAddLastRowElement()
//	{
//		// Use row and column (if needed) for index variable names
//
//		int[][] matrix2 = {{1,   2,  3,  4}, 
//				           {5,   6,  7},
//				           {9,  10},
//				           {13, 14, 15, 16}};
//		assertEquals(4+7+10+16, addLastRowElement(matrix2));			
//	}
//
//	@Test
//	void testAddAll()
//	{
//		int[][] array0 = {};
//		assertEquals(0, addAll(array0));
//
//  	// Use row and column for index variable names
//
//		int[][] matrix2 = {{1,   2,  3,  4}, 
//				           {5,   6,  7},
//				           {9,  10},
//				           {13, 14, 15, 16}};
//		assertEquals(1+2+3+4+5+6+7+9+10+13+14+15+16, addAll(matrix2));
//	}

}
