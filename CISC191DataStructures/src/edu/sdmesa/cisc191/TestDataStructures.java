package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * @author Tasha Frankie
 * @author Allan Schougaard
 * 
 * @version 2.0
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * @see Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt,
 *      J. D., & Stein, C. (n.d.). JUnit 5 user guide. JUnit 5.
 *      https://junit.org/junit5/docs/current/user-guide/
 */

class TestDataStructures
{
	@Test
	public void testLinkedList()
	{
		LinkedList<String> list = new LinkedList<String>();
		LinkedListProducer producer = new LinkedListProducer(list);
		LinkedListConsumer consumer = new LinkedListConsumer(list);

		assertEquals(true, list.isEmpty());

		producer.produce("1st");
		producer.produce("2nd");
		producer.produce("3rd");

		assertEquals("1st", consumer.consumeHead());
		assertEquals("3rd", consumer.consumeTail());
		assertEquals("2nd", consumer.consumeTail());
		assertEquals(true, list.isEmpty());
	}

//	@Test
//	public void testArrayList()
//	{
//		ArrayList<String> list = new ArrayList<String>();
//
//		ArrayListProducer producer = new ArrayListProducer(list);
//		ArrayListConsumer consumer = new ArrayListConsumer(list);
//
//		producer.produce(0, "1st");
//		producer.produce(1, "3rd");
//		producer.produce(1, "2nd");
//
//		assertEquals("1st", consumer.consume());
//
//		producer.produce(1, "4th");
//
//		assertEquals("2nd", consumer.consume());
//		assertEquals("4th", consumer.consume());
//		assertEquals("3rd", consumer.consume());
//	}

//	@Test
//	public void testQueue()
//	{
//		Queue<String> queue = new LinkedList<String>();
//		QueueProducer producer = new QueueProducer(queue);
//		QueueConsumer consumer = new QueueConsumer(queue);
//
//		assertEquals(true, queue.isEmpty());
//
//		producer.produce("1st");
//		producer.produce("2nd");
//		producer.produce("3rd");
//
//		assertEquals("1st", consumer.consume());
//		assertEquals("2nd", consumer.consume());
//
//		producer.produce("4th");
//
//		assertEquals("3rd", consumer.consume());
//		assertEquals("4th", consumer.consume());
//		assertEquals(true, queue.isEmpty());
//	}

//	@Test
//	public void testStack()
//	{
//		Stack<String> stack = new Stack<String>();
//		StackProducer producer = new StackProducer(stack);
//		StackConsumer consumer = new StackConsumer(stack);
//
//		assertEquals(true, stack.isEmpty());
//
//		producer.produce("1st");
//		producer.produce("2nd");
//		producer.produce("3rd");
//
//		assertEquals("3rd", consumer.consume());
//		assertEquals("2nd", consumer.consume());
//
//		producer.produce("4th");
//
//		assertEquals("4th", consumer.consume());
//		assertEquals("1st", consumer.consume());
//		assertEquals(true, stack.isEmpty());
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
	
//	@Test void testLeast()
//	{
//		// Hint: where in the tree is the lowest letter in alphabetical order found?
//		NameNode rootNode = new NameNode("M");
//		assertEquals("M", rootNode.getLeast().getName());
//		NameNode h = new NameNode("H");
//		rootNode.setLeft(h);
//		assertEquals("H", rootNode.getLeast().getName());
//		NameNode s = new NameNode("S");
//		rootNode.setRight(s);
//		assertEquals("H", rootNode.getLeast().getName());
//		NameNode a = new NameNode("A");
//		h.setLeft(a);
//		assertEquals("A", rootNode.getLeast().getName());
//		NameNode z = new NameNode("Z");
//		s.setRight(z);
//		assertEquals("A", rootNode.getLeast().getName());
//		NameNode r = new NameNode("R");
//		s.setLeft(r);
//		assertEquals("A", rootNode.getLeast().getName());
//	}

//	@Test void testLargest()
//	{
//		// Hint: where in the tree is the highest letter in alphabetical order found?
//		NameNode rootNode = new NameNode("M");
//		assertEquals("M", rootNode.getLargest().getName());
//		NameNode h = new NameNode("H");
//		rootNode.setLeft(h);
//		assertEquals("M", rootNode.getLargest().getName());
//		NameNode s = new NameNode("S");
//		rootNode.setRight(s);
//		assertEquals("S", rootNode.getLargest().getName());
//		NameNode a = new NameNode("A");
//		h.setLeft(a);
//		assertEquals("S", rootNode.getLargest().getName());
//		NameNode z = new NameNode("Z");
//		s.setRight(z);
//		assertEquals("Z", rootNode.getLargest().getName());
//		NameNode r = new NameNode("R");
//		s.setLeft(r);
//		assertEquals("Z", rootNode.getLargest().getName());
//	}
	
//	@Test void testToString()
//	{
//		NameNode rootNode = new NameNode("M");
//		assertEquals("M", rootNode.toString());
//		NameNode h = new NameNode("H");
//		rootNode.setLeft(h);
//		assertEquals("HM", rootNode.toString());
//		NameNode s = new NameNode("S");
//		rootNode.setRight(s);
//		assertEquals("HMS", rootNode.toString());
//		NameNode a = new NameNode("A");
//		h.setLeft(a);
//		assertEquals("AHMS", rootNode.toString());
//		NameNode z = new NameNode("Z");
//		s.setRight(z);
//		assertEquals("AHMSZ", rootNode.toString());
//		NameNode r = new NameNode("R");
//		s.setLeft(r);
//		assertEquals("AHMRSZ", rootNode.toString());
//	}
	
//	@Test
//	public void testInsert()
//	{
//		NameNode tree = new NameNode("Noel");
//		assertEquals("Noel", tree.toString());
//		tree.insert("Abe");
//		assertEquals("AbeNoel", tree.toString());
//		tree.insert("Alex");
//		assertEquals("AbeAlexNoel", tree.toString());
//		tree.insert("Xavier");
//		assertEquals("AbeAlexNoelXavier", tree.toString());
//		tree.insert("Aaron");
//		assertEquals("AaronAbeAlexNoelXavier", tree.toString());
//	}

}
