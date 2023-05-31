package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.LinkedList;

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
//		// See why Lucas number are better than Fibonacci number, watch:
//		// Parker, M. (n.d.). Lucas Numbers - Numberphile [Video]. YouTube. 
//		// https://www.youtube.com/watch?v=PeUbRXnbmms
//		// Parker, M. (n.d.). Golden Ratio BURN (Internet Beef) - Numberphile [Video]. YouTube. 
//		// https://www.youtube.com/watch?v=cjx23aMeBkQ
//		
//		assertEquals(2, Recursion.lucas(0));
//		assertEquals(1, Recursion.lucas(1));
//		assertEquals(3, Recursion.lucas(2));
//		assertEquals(4, Recursion.lucas(3));
//		assertEquals(76, Recursion.lucas(9));
//	}
	
	
//	@Test
//	void testNextCollatzNumber()
//	{
//		// See:
//		// Collatz conjecture. (2023, May 21). Wikipedia, the free encyclopedia. 
//		// https://en.wikipedia.org/wiki/Collatz_conjecture
//		//
//		// Veritasium. (2021, July 30). The Simplest Math Problem No One Can Solve - Collatz Conjecture [Video]. YouTube. 
//		// https://www.youtube.com/watch?v=094y1Z2wpJg
//		
//		// The next Collatz number is calculated like this:
//		// if n is even, return n/2.
//		// if n is odd, return 3n+1.	
//		
//		assertEquals(4, Recursion.nextCollatzNumber(1));    // 3n+1
//		assertEquals(1, Recursion.nextCollatzNumber(2));    // n/2
//		assertEquals(10, Recursion.nextCollatzNumber(3));   // 3n+1
//		assertEquals(178, Recursion.nextCollatzNumber(59)); // 3n+1
//	}

//	@Test
//	void testCollatzList()
//	{
//		// This challenge is to construct the list of Collatz numbers given the first number.
//		// If you find a list that does get to 1, please contact me immediately!
//	
//		LinkedList<Integer> list1 = new LinkedList<Integer>();
//		list1.add(1); // Stop the recursion at n=1
//		assertEquals(list1, Recursion.collatzList(1));
//
//		LinkedList<Integer> list2 = new LinkedList<Integer>();
//		list2.add(2);
//		list2.add(1);
//		assertEquals(list2, Recursion.collatzList(2));
//		
//		LinkedList<Integer> list4 = new LinkedList<Integer>();
//		list4.add(4);
//		list4.add(Recursion.nextCollatzNumber(4));
//		list4.add(1);
//		assertEquals(list4, Recursion.collatzList(4));
//		
//		LinkedList<Integer> list5 = new LinkedList<Integer>();
//		list5.add(5);
//		list5.add(16);
//		list5.add(8);
//		list5.add(4);
//		list5.add(2);
//		list5.add(1);
//		assertEquals(list5, Recursion.collatzList(5));
//		
//		LinkedList<Integer> list27 = new LinkedList<Integer>();
//		list27.add(27);
//		list27.addAll(Recursion.collatzList(3*27+1));
//		assertEquals(list27, Recursion.collatzList(27));
//		assertEquals(112, Recursion.collatzList(27).size());
//		
//		LinkedList<Integer> list28 = new LinkedList<Integer>();
//		list28.add(28);
//		list28.addAll(Recursion.collatzList(28/2));
//		assertEquals(list28, Recursion.collatzList(28));
//		assertEquals(19, Recursion.collatzList(28).size());
//		
//		LinkedList<Integer> list29 = new LinkedList<Integer>();
//		list29.add(29);
//		list29.addAll(Recursion.collatzList(Recursion.nextCollatzNumber(29)));
//		assertEquals(list29, Recursion.collatzList(29));
//		assertEquals(19, Recursion.collatzList(29).size());
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
//	}
	
//	@Test
//	public void testNameNode()
//	{
//		NameNode rootNode = new NameNode("M");
//		assertEquals("M", rootNode.getName());
//		assertEquals(null, rootNode.getLeft());
//		assertEquals(null, rootNode.getRight());
//		
//		NameNode h = new NameNode("H");
//		rootNode.setLeft(h);
//		//    M
//		//   /
//		//  H
//		// H is inserted to the left of M because it comes before M in alphabetical order
//		assertEquals("H", rootNode.getLeft().getName());
//		assertEquals(null, rootNode.getRight());
//		
//		NameNode s = new NameNode("S");
//		rootNode.setRight(s);
//		//    M
//		//   / \
//		//  H   S
//		// S is inserted to the right of M because it comes after M in alphabetical order
//		assertEquals("H", rootNode.getLeft().getName());
//		assertEquals("S", rootNode.getRight().getName());
//		
//		NameNode a = new NameNode("A");
//		h.setLeft(a);
//		//     M
//		//    / \
//		//   H   S
//		//  /
//		// A
//		assertEquals("H", rootNode.getLeft().getName());
//		assertEquals("S", rootNode.getRight().getName());
//		assertEquals("A", rootNode.getLeft().getLeft().getName());
//		assertEquals(null, rootNode.getLeft().getRight());
//		
//		NameNode z = new NameNode("Z");
//		s.setRight(z);
//		//     M
//		//    / \
//		//   H   S
//		//  /     \
//		// A       Z		
//	    assertEquals("H", rootNode.getLeft().getName());
//		assertEquals("S", rootNode.getRight().getName());
//		assertEquals("A", rootNode.getLeft().getLeft().getName());
//		assertEquals("Z", rootNode.getRight().getRight().getName());
//		
//		NameNode r = new NameNode("R");
//		s.setLeft(r);
//		//     M
//		//    / \
//		//   H   S
//		//  /   / \
//		// A   R   Z
//		assertEquals("H", rootNode.getLeft().getName());
//		assertEquals("S", rootNode.getRight().getName());
//		assertEquals("A", rootNode.getLeft().getLeft().getName());
//		assertEquals("R", rootNode.getRight().getLeft().getName());
//		assertEquals("Z", rootNode.getRight().getRight().getName());
//	}
	
//	@Test void testFirstName()
//	{
//		// Hint: where in the tree is the lowest letter in alphabetical order found?
//		NameNode rootNode = new NameNode("M");
//		assertEquals("M", rootNode.getFirstName());
//		NameNode h = new NameNode("H");
//		rootNode.setLeft(h);
//		assertEquals("H", rootNode.getFirstName());
//		NameNode s = new NameNode("S");
//		rootNode.setRight(s);
//		assertEquals("H", rootNode.getFirstName());
//		NameNode a = new NameNode("A");
//		h.setLeft(a);
//		assertEquals("A", rootNode.getFirstName());
//		NameNode z = new NameNode("Z");
//		s.setRight(z);
//		assertEquals("A", rootNode.getFirstName());
//		NameNode r = new NameNode("R");
//		s.setLeft(r);
//		assertEquals("A", rootNode.getFirstName());
//	}

//	@Test void testGetLastName()
//	{
//		// Hint: where in the tree is the highest letter in alphabetical order found?
//		NameNode rootNode = new NameNode("M");
//		assertEquals("M", rootNode.getLastName());
//		NameNode h = new NameNode("H");
//		rootNode.setLeft(h);
//		assertEquals("M", rootNode.getLastName());
//		NameNode s = new NameNode("S");
//		rootNode.setRight(s);
//		assertEquals("S", rootNode.getLastName());
//		NameNode a = new NameNode("A");
//		h.setLeft(a);
//		assertEquals("S", rootNode.getLastName());
//		NameNode z = new NameNode("Z");
//		s.setRight(z);
//		assertEquals("Z", rootNode.getLastName());
//		NameNode r = new NameNode("R");
//		s.setLeft(r);
//		assertEquals("Z", rootNode.getLastName());
//	}
	
//	@Test void testToString()
//	{
//		// Hint: Recursively call toString on the NameNodes
//		NameNode rootNode = new NameNode("M");
//		assertEquals("M", rootNode.toString());
//		assertNull(rootNode.getLeft());
//		assertNull(rootNode.getRight());
//		// Hint: 
//		assertEquals("M", rootNode.getName());
//		
//		NameNode h = new NameNode("H");
//		rootNode.setLeft(h);
//		assertEquals("HM", rootNode.toString());
//		assertEquals("H", rootNode.getLeft().toString());
//		assertNull(rootNode.getRight());
//		// Hint:
//		assertEquals("HM", rootNode.getLeft().toString() + rootNode.getName());
//		
//		NameNode s = new NameNode("S");
//		rootNode.setRight(s);
//		assertEquals("HMS", rootNode.toString());
//		assertEquals("H", rootNode.getLeft().toString());
//		assertEquals("S", rootNode.getRight().toString());
//		// Hint:
//		assertEquals("HMS", rootNode.getLeft().toString() + rootNode.getName() + rootNode.getRight().toString());
//		
//		NameNode a = new NameNode("A");
//		h.setLeft(a);
//		assertEquals("AHMS", rootNode.toString());
//		// Hint:
//		assertEquals("AHMS", rootNode.getLeft().toString() + rootNode.getName() + rootNode.getRight().toString());
//		
//		NameNode z = new NameNode("Z");
//		s.setRight(z);
//		assertEquals("AHMSZ", rootNode.toString());
//		// Hint:
//		assertEquals("AHMSZ", rootNode.getLeft().toString() + rootNode.getName() + rootNode.getRight().toString());
//		
//		NameNode r = new NameNode("R");
//		s.setLeft(r);
//		assertEquals("AHMRSZ", rootNode.toString());
//		assertEquals("AH", rootNode.getLeft().toString());
//		assertEquals("RSZ", rootNode.getRight().toString());
//		// Hint:
//		assertEquals("AHMRSZ", rootNode.getLeft().toString() + rootNode.getName() + rootNode.getRight().toString());
//	}
	
//	@Test
//	public void testInsert()
//	{
//		NameNode tree = new NameNode("Noel");
//		assertEquals("Noel", tree.toString());
//		tree.insert("Abe");
//		assertEquals("AbeNoel", tree.toString());
//		tree.insert("Alice");
//		assertEquals("AbeAliceNoel", tree.toString());
//		tree.insert("Zoe");
//		assertEquals("AbeAliceNoelZoe", tree.toString());
//		tree.insert("Aaron");
//		assertEquals("AaronAbeAliceNoelZoe", tree.toString());
//	}


}
