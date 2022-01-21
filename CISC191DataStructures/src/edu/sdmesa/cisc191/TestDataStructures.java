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
	void testLinkedList()
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
//	void testArrayList()
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
//	void testQueue()
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
//	void testStack()
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
//	void testTree()
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
