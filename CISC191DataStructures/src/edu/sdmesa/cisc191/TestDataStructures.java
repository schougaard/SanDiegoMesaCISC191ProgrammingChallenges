package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
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
	public void testArrayListProducerConsumer()
	{
		ArrayList<String> list = new ArrayList<String>();
		// stringProducer is-a Producer (interface) of Strings
		Producer<String> stringProducer =  new StringArrayListProducer(list);
		// stringConsumer  is-a Consumer (interface) of Strings
		Consumer<String> stringConsumer = new StringArrayListConsumer(list);
		
		assertEquals(true, list.isEmpty());
		// Produce two items inserted in order on the list
		stringProducer.produce("1st");
		stringProducer.produce("2nd");

		// Consume (and remove) the 1st element on the list
		assertEquals("1st", stringConsumer.consume());

		stringProducer.produce("3rd");

		assertEquals("2nd", stringConsumer.consume());
		assertEquals("3rd", stringConsumer.consume());
		assertNull(stringConsumer.consume());
		
		assertEquals(true, list.isEmpty());
	}

//	@Test
//	public void testArrayList()
//	{
//		// In this scenario we are going to to test that ArrayLists can insert elements at a specific index
//		
//		ArrayList<String> list = new ArrayList<String>();
//		StringArrayListProducer listProducer = new StringArrayListProducer(list);
//		StringArrayListConsumer listConsumer = new StringArrayListConsumer(list);
//		
//		assertEquals(true, list.isEmpty());
//		listProducer.produce("1st");
//		// Insert at index
//		listProducer.produce(1, "3rd");
//		listProducer.produce(1, "2nd");
//
//		// Consume (and remove) the 1st element on the list
//		assertEquals("1st", listConsumer.consume());
//
//		listProducer.produce(1, "4th");
//		listProducer.produce("5th");
//
//		assertEquals("2nd", listConsumer.consume());
//		assertEquals("4th", listConsumer.consume());
//		assertEquals("3rd", listConsumer.consume());
//		assertEquals("5th", listConsumer.consume());
//		
//		assertEquals(true, list.isEmpty());
//		assertNull(listConsumer.consume());
//	}
//
//	@Test
//	public void testLinkedListProducerConsumert()
//	{
//		LinkedList<String> list = new LinkedList<String>();
//		// stringProducer is-a Producer (interface) of Strings
//		Producer<String> stringProducer =  new StringLinkedListProducer(list);
//		// stringConsumer  is-a Consumer (interface) of Strings
//		Consumer<String> stringConsumer = new StringLinkedListConsumer(list);
//		
//		assertEquals(true, list.isEmpty());
//		// Produce two items inserted in order on the list
//		stringProducer.produce("1st");
//		stringProducer.produce("2nd");
//
//		// Consume (and remove) the 1st element on the list
//		assertEquals("1st", stringConsumer.consume());
//
//		stringProducer.produce("3rd");
//
//		assertEquals("2nd", stringConsumer.consume());
//		assertEquals("3rd", stringConsumer.consume());
//		assertNull(stringConsumer.consume());
//		
//		assertEquals(true, list.isEmpty());
//	}
//
//	@Test
//	public void testQueue()
//	{
//		// In this scenario we are simulating a food ordering system
//		
//		Queue<String> queue = new LinkedList<String>();
//		Producer<String> producer = new StringQueueProducer(queue);
//		Consumer<String> consumer = new StringQueueConsumer(queue);
//
//		assertEquals(true, queue.isEmpty());
//
//		// Produce at the back end of the queue
//		producer.produce("Meal #1: Apple Pie");
//		producer.produce("Meal #2: Burger");
//		producer.produce("Meal #3: Caesar Salad");
//
//		// Consume at the front of the queue
//		assertEquals("Meal #1: Apple Pie", consumer.consume());
//		assertEquals("Meal #2: Burger", consumer.consume());
//
//		producer.produce("Meal #4: Dumplings");
//
//		assertEquals("Meal #3: Caesar Salad", consumer.consume());
//		assertEquals("Meal #4: Dumplings", consumer.consume());
//		assertEquals(true, queue.isEmpty());
//		
//		assertNull(consumer.consume());
//	}
//
//	@Test
//	public void testStack()
//	{
//		// In this (contrived) scenario we are making burgers by stacking ingredients 
//		
//		Stack<String> stack = new Stack<String>();
//		Producer<String> producer = new StringStackProducer(stack);
//		Consumer<String> consumer = new StringStackConsumer(stack);
//		
//		assertEquals(true, stack.isEmpty());
//		
//		// Produce places items on top of the stack
//		producer.produce("Bottom bun");
//		producer.produce("Lettuce");
//		producer.produce("Two patties");
//		
//		// Consume removes items from the top of the stack
//		assertEquals("Two patties", consumer.consume());
//		assertEquals("Lettuce", consumer.consume());
//		
//		producer.produce("Top bun");
//		
//		assertEquals("Top bun", consumer.consume());
//		assertEquals("Buttom bun", consumer.consume());
//		assertEquals(true, stack.isEmpty());
//		
//		assertNull(consumer.consume());
//	}
//	
//	@Test
//	public void testPalindrome()
//	{
//		// In this scenario, use a queue and a stack 
//		// to see if a word is a palindrome: https://en.wikipedia.org/wiki/Palindrome
//		
//		char[] lol = {'l', 'o', 'l'};
//		assertTrue(Palindrome.isPalindrome(lol));
//		char[] car = {'c', 'a', 'r'};
//		assertFalse(Palindrome.isPalindrome(car));
//		char[] cabc = {'c', 'a', 'b', 'c'};
//		assertFalse(Palindrome.isPalindrome(cabc));
//		char[] racecar = "racecar".toCharArray();
//		assertTrue(Palindrome.isPalindrome(racecar));
//
//	}
//	
//	@Test
//	public void testPhoneDirectory()
//	{
//		// This challenge is to implement a phone book that has-many name-phone number relations
//		PhoneDirectory directory = new PhoneDirectory();
//		directory.setNumberForPerson("Alice", 1111);	
//		assertEquals(1111, directory.findNumberForPerson("Alice"));
//		assertEquals(null, directory.findNumberForPerson("Bob"));
//				
//		directory.setNumberForPerson("Bob", 2222);	
//		assertEquals(1111, directory.findNumberForPerson("Alice"));
//		assertEquals(2222, directory.findNumberForPerson("Bob"));
//		
//		directory.setNumberForPerson("Bob's cell", 3333);	
//		assertEquals(1111, directory.findNumberForPerson("Alice"));
//		assertEquals(2222, directory.findNumberForPerson("Bob"));
//		assertEquals(3333, directory.findNumberForPerson("Bob's cell"));
//
//		directory.setNumberForPerson("Bob", 4444);	
//		assertEquals(1111, directory.findNumberForPerson("Alice"));
//		assertEquals(4444, directory.findNumberForPerson("Bob"));
//		assertEquals(3333, directory.findNumberForPerson("Bob's cell"));
//
//	    directory.forget("Bob");	
//	    assertEquals(null, directory.findNumberForPerson("Bob"));
//	    assertEquals(1111, directory.findNumberForPerson("Alice"));
//	    assertEquals(3333, directory.findNumberForPerson("Bob's cell"));
//	    
//	    assertNull(directory.findNumberForPerson("Xavier"));
//	}
//	
//	@Test
//	public void testSearchEngine()
//	{
//		// In this scenario we are creating an Internet search engine
//		// which returns multiple results for each search keyword.
//		// This implies that a search engine has many search results.
//		// Hint: this requires multiple data structures collaborating
//		SearchEngine goggles = new SearchEngine();
//		
//		goggles.add("ice cream", "http://mothersicecream.com");
//		assertTrue(goggles.search("ice cream") instanceof List);
//		assertEquals(1, goggles.search("ice cream").size());
//		goggles.add("ice cream", "http://notyourmothersicecream.com");
//		assertEquals(2, goggles.search("ice cream").size());
//		
//		goggles.add("car", "http://foundontheroaddead.com");
//		goggles.add("car", "http://cashanddrive.com");
//		goggles.add("car", "http://fancycar.com");
//		
//		assertTrue(goggles.search("ice cream").contains("http://notyourmothersicecream.com"));
//		assertTrue(goggles.search("ice cream").contains("http://mothersicecream.com"));
//		assertFalse(goggles.search("ice cream").contains("http://foundontheroaddead.com"));
//		assertFalse(goggles.search("ice cream").contains("http://fancycar.com"));
//		assertFalse(goggles.search("ice cream").contains("http://cashanddrive.com"));
//		
//		assertEquals(3, goggles.search("car").size());
//		assertTrue(goggles.search("car").contains("http://foundontheroaddead.com"));
//		assertTrue(goggles.search("car").contains("http://fancycar.com"));
//		assertTrue(goggles.search("car").contains("http://cashanddrive.com"));
//		assertFalse(goggles.search("car").contains("http://notyourmothersicecream.com"));
//		assertFalse(goggles.search("car").contains("http://mothersicecream.com"));
//
//		// If there are not search results for a given keyword, the engine returns an empty list
//		assertNotNull(goggles.search("404"));
//		assertTrue(goggles.search("404") instanceof List);
//		assertTrue(goggles.search("404").isEmpty());
//
//		// Make sure malicious hackers cannot break your search engine
//		// so do not hand out your data structures.
//		// Hint: think of Harbor
//		// Hint: use a list constructor
//		goggles.search("car").clear();
//		assertEquals(3, goggles.search("car").size());	
//	}
	
}
