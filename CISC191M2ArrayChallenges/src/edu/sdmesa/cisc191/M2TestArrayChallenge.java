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

class M2TestArrayChallenge
{
	@Test
	void testContains()
	{
		int[] array0 = {};
		assertEquals(false, contains(array0, 1));

		int[] array1 = {1};
		assertEquals(true, contains(array1, 1));
		assertEquals(false, contains(array1, 2));
		
		int[] array2 = {1, 2, 3};
		assertEquals(true, contains(array2, 2));
		assertEquals(false, contains(array2, 4));
	}

// To remove //: select line(s) and type Ctrl-/ 
//
//	/**
//	 * find returns the first index of a value in an array,
//	 * or -1 if the value is not in the array
//	 */
//	@Test
//	void testFind()
//	{
//		int[] array0 = {};
//		assertEquals(-1, find(array0, 1));
//
//		int[] array1 = {1};
//		assertEquals(0, find(array1, 1));
//		assertEquals(-1, find(array1, 2));
//		
//		int[] array2 = {4, 5, 6};
//	    assertEquals(0, find(array2, 4));
//	    assertEquals(1, find(array2, 5));
//		assertEquals(2, find(array2, 6));
//		assertEquals(-1, find(array2, 7));
//		
//		int[] array3 = {1, 1, 3};
//		assertEquals(0, find(array3, 1));
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
//		assertEquals(2, countValues(array2, 'R'));
//		assertEquals(2, countValues(array2, 'A'));
//	    assertEquals(2, countValues(array2, 'C'));
//	    assertEquals(1, countValues(array2, 'E'));
//	}
//
//	@Test
//	void testInOrder()
//	{
//		int[] array0 = {};
//		assertEquals(true, inOrder(array0));
//
//		int[] array1 = {1};
//		assertEquals(true, inOrder(array1));
//
//		int[] array12 = {1, 2};
//		assertEquals(true, inOrder(array12));
//
//		int[] array21 = {2, 1};
//		assertEquals(false, inOrder(array21));
//		
//		int[] array2 = {1, 2, 3};
//		assertEquals(true, inOrder(array2));
//
//	    int[] array3 = {1, 3, 2};
//	    assertEquals(false, inOrder(array3));
//
//		int[] array4 = {-1, -2, 3};
//		assertEquals(false, inOrder(array4));
//
//		int[] array5 = {-1, -2, -3};
//		assertEquals(false, inOrder(array5));
//
//	    int[] array6 = {-3, -2, -1};
//	    assertEquals(true, inOrder(array6));
//	}
//
//	/**
//	 * The swap method exchanges two elements in a given array based on index
//	 */
//	@Test
//	void testSwap()
//	{
//		int[] array0 = {2, 3};
//	    int[] array1 = {3, 2};
//		assertArrayEquals(array1, swap(array0, 0));
//
//		int[] array10 = {6, 5, 4};
//      int[] array11 = {5, 6, 4};
//	    assertArrayEquals(array11, swap(array10, 0));
//      int[] array12 = {5, 4, 6};
//      assertArrayEquals(array12, swap(array10, 1));
//	}
//
//	/**
//	 * The bubbleUp method would do one pass of an array in the Bubble sort algorithm
//	 * See: Section Step-by-step example in https://en.wikipedia.org/wiki/Bubble_sort
//	 * The bubbleUp method does one pass of an array
//   * Hint: swap
//	 */
//	@Test
//	void testBubbleUp()
//	{
//		int[] array0 = {2, 3};
//	    // No change, array is already sorted
//		assertArrayEquals(array0, bubbleUp(array0));
//
//		int[] array1 = {3, 2};
//		assertArrayEquals(new int[] {array1[1], array1[0]}, bubbleUp(array1));
//		
//		int[] array10 = {5, 1, 4, 2, 8};
//		int[] array11 = {1, 4, 2, 5, 8};
//		assertArrayEquals(array11, bubbleUp(array10));
//
//		int[] array12 = {1, 2, 4, 5, 8};
//		assertArrayEquals(array12, bubbleUp(array11));
//
//		// No change, array is already sorted
//		assertArrayEquals(array12, bubbleUp(array12));
//	}
//
//	/**
//	 * The bubbleSort method sorts an array.
//	 * Hint: while the elements are not inOrder, repeatedly use bubbleUp
//	 */
//	@Test
//	void testBubbleSort()
//	{
//		int[] array0 = {5, 1, 4, 2, 8};
//		int[] array2 = {1, 2, 4, 5, 8};
//		assertArrayEquals(array2, bubbleSort(array0));
//
//	    int[] array10 = {4, 3, 2, 1};
//	    int[] array11 = {1, 2, 3, 4};
//	    assertArrayEquals(array11, bubbleSort(array10));
//	}
//
//	/**
//	 * The copy method returns a new array with the same elements as the original array
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
//		array1copy[0] = 'B';
//		assertEquals('B', array1copy[0]);
//		assertEquals('A', array1[0]);
//
//		char[] array2 = {'X', 'Y', 'Z'};
//		assertNotEquals(array2, copy(array2));
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
//		assertArrayEquals(new char[]{'D', C', 'B', 'A'}, backwards(array2));
//		assertArrayEquals(new char[]{'A', 'B', 'C', 'D'}, array2);
//	}
//
//	/**
//	 * A palindrome is a word that is spelled the same forwards and (hint:) backwards
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
//		char[] array4 = "PALINDROME".toCharArray()
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
//	void testAddLastRow()
//	{
//		int[][] matrix2 = {{1,   2,  3,  4}, 
//				           {5,   6,  7},
//				           {9,  10},
//				           {13, 14, 15, 16}};
//		assertEquals(4+7+10+16, addLastRow(matrix2));		
//		
//	}

}
