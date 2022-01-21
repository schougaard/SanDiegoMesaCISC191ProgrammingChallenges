package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Tasha Frankie
 * @author Allan Schougaard
 * @otherContributors: None
 * @version 2.0
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * @see Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt,
 *      J. D., & Stein, C. (n.d.). JUnit 5 user guide. JUnit 5.
 *      https://junit.org/junit5/docs/current/user-guide/
 */
class TestThreading
{

	/**
	 * Testing that a warehouse can receive and ship items, and that items are
	 * shipped last-in first-out.
	 * 
	 * @throws OutOfStockException if the warehouse is out of stock
	 */
	@Test
	void testWarehouse() throws OutOfStockException
	{
		Warehouse warehouse = new Warehouse();
		Item item1 = new Item();
		assertEquals(0, warehouse.getNumberOfItemsInStock());
		warehouse.receive(item1);
		assertEquals(1, warehouse.getNumberOfItemsInStock());
		assertEquals(item1, warehouse.ship());
		assertEquals(0, warehouse.getNumberOfItemsInStock());
		Item item2 = new Item();
		Item item3 = new Item();
		warehouse.receive(item2);
		warehouse.receive(item3);
		assertEquals(2, warehouse.getNumberOfItemsInStock());
		assertEquals(item3, warehouse.ship());
		assertEquals(item2, warehouse.ship());
		assertEquals(0, warehouse.getNumberOfItemsInStock());
		// Throws OutOfStockException when out of stock and asked to ship an item
		assertThrows(OutOfStockException.class, () -> {
	        warehouse.ship();
	    });
	}

	/**
	 * In this test we are simulating many producers creating items sequentially
	 * that are then stored in a warehouse.
	 */
//	@Test
//	void testProducingSequentially()
//	{
//		Warehouse store = new Warehouse();
//
//		int numberOfProducers = 10000;
//		int numberOfItemsPerProducer = 10;
//		Producer[] producers = new Producer[numberOfProducers];
//		for (int i = 0; i < numberOfProducers; i++)
//		{
//			producers[i] = new Producer("Producer " + i, store, numberOfItemsPerProducer);
//		}
//
//		// Execute all the producers in the current thread
//		for (int i = 0; i < numberOfProducers; i++)
//		{
//			producers[i].run();
//		}
//
//		// There should be numberOfProducers*numberOfItemsPerProducer items at the warehouse
//		assertEquals(numberOfProducers * numberOfItemsPerProducer, store.getNumberOfItemsInStock());
//	}

	/**
	 * In this test we are simulating many consumers receiving items sequentially
	 * from a warehouse.
	 */
//	@Test
//	void testConsumingSequentially()
//	{
//		Warehouse store = new Warehouse();
//
//		int numberOfConsumers = 10000;
//		int numberOfItemsPerConsumer = 10;
//		int numberOfItemsToProduce = numberOfConsumers * numberOfItemsPerConsumer;
//
//		new Producer("Producer A", store, numberOfItemsToProduce).run();
//
//		// There should be many items at the warehouse
//		assertEquals(numberOfItemsToProduce, store.getNumberOfItemsInStock());
//
//		Consumer[] consumers = new Consumer[numberOfConsumers];
//		for (int i = 0; i < numberOfConsumers; i++)
//		{
//			consumers[i] = new Consumer("Consumer " + i, store, numberOfItemsPerConsumer);
//		}
//
//		// Execute all the consumers in the current thread
//		for (int i = 0; i < numberOfConsumers; i++)
//		{
//			consumers[i].run();
//		}
//
//		// There should be no items at the warehouse
//		assertEquals(0, store.getNumberOfItemsInStock());
//	}

	/**
	 * In this test we are simulating many producers creating items concurrently
	 * that are then stored in a warehouse.
	 * 
	 * @throws InterruptedException if the program is interrupted, which should not
	 *                              happen
	 */
//	@Test
//	void testProducingConcurrently() throws InterruptedException
//	{
//		Warehouse store = new Warehouse();
//
//		// You may have to run this test multiple times for it to fail
//		// If the program does not run, reduce the following numbers
//		// If the test does not fail, increase the following numbers
//		int numberOfProducers = 10000;
//		int numberOfItemsPerProducer = 10;
//		Producer[] producers = new Producer[numberOfProducers];
//		for (int i = 0; i < numberOfProducers; i++)
//		{
//			producers[i] = new Producer("Producer " + i, store, numberOfItemsPerProducer);
//		}
//
//		// Execute all the producers in separate threads
//		for (int i = 0; i < numberOfProducers; i++)
//		{
//			producers[i].start();
//		}
//
//		// Wait for producers to complete
//		for (int i = 0; i < numberOfProducers; i++)
//		{
//			producers[i].join();
//		}
//
//		// There should be numberOfProducers*numberOfItemsPerProducer items at the warehouse
//		assertEquals(numberOfProducers * numberOfItemsPerProducer, store.getNumberOfItemsInStock());
//	}

	/**
	 * In this test we are simulating many consumers receiving items concurrently
	 * from a warehouse.
	 * 
	 * @throws InterruptedException if the program is interrupted, which should not
	 *                              happen
	 */
//	@Test
//	void testConsumingConcurrently() throws InterruptedException
//	{
//		Warehouse store = new Warehouse();
//
//		// You may have to run this test multiple times for it to fail
//		// If the program does not run, reduce the following numbers
//		// If the test does not fail, increase the following numbers
//		int numberOfConsumers = 10000;
//		int numberOfItemsPerConsumer = 10;
//		int numberOfItemsToProduce = numberOfConsumers * numberOfItemsPerConsumer;
//
//		new Producer("Producer A", store, numberOfItemsToProduce).run();
//
//		assertEquals(numberOfItemsToProduce, store.getNumberOfItemsInStock());
//
//		Consumer[] consumers = new Consumer[numberOfConsumers];
//		for (int i = 0; i < numberOfConsumers; i++)
//		{
//			consumers[i] = new Consumer("Consumer " + i, store, numberOfItemsPerConsumer);
//		}
//
//		// Execute all the consumers in separate threads
//		for (int i = 0; i < numberOfConsumers; i++)
//		{
//			consumers[i].start();
//		}
//
//		// Wait for producers to complete
//		for (int i = 0; i < numberOfConsumers; i++)
//		{
//			consumers[i].join();
//		}
//
//		// There should be no items at the warehouse
//		assertEquals(0, store.getNumberOfItemsInStock());
//	}
	
	/**
	 * In this test we are simulating many consumers receiving items concurrently
	 * with many producers.
	 * 
	 * @throws InterruptedException if the program is interrupted, which should not
	 *                              happen
	 */
//	@Test
//	void testProducingConsumingConcurrently() throws InterruptedException
//	{
//		Warehouse store = new Warehouse();
//
//		int numberOfProducers = 10000;
//		int numberOfItemsPerProducer = 10;
//		Producer[] producers = new Producer[numberOfProducers];
//		for (int i = 0; i < numberOfProducers; i++)
//		{
//			producers[i] = new Producer("Producer " + i, store, numberOfItemsPerProducer);
//		}
//		
//		int numberOfConsumers = numberOfProducers;
//		int numberOfItemsPerConsumer = numberOfItemsPerProducer;
//		Consumer[] consumers = new Consumer[numberOfConsumers];
//		for (int i = 0; i < numberOfConsumers; i++)
//		{
//			consumers[i] = new Consumer("Consumer " + i, store, numberOfItemsPerConsumer);
//		}
//				
//		// Execute all the producers and consumers in separate threads
//		for (int i = 0; i < numberOfProducers/2; i++)
//		{
//			producers[i].start();
//		}
//		for (int i = 0; i < numberOfConsumers/2; i++)
//		{
//			consumers[i].start();
//		}
//		for (int i = numberOfProducers/2; i < numberOfProducers; i++)
//		{
//			producers[i].start();
//		}
//		for (int i = numberOfConsumers/2; i < numberOfConsumers; i++)
//		{
//			consumers[i].start();
//		}
//		
//		// Wait for producers to complete
//		for (int i = 0; i < numberOfProducers; i++)
//		{
//			producers[i].join();
//		}
//
//		// Wait for producers to complete
//		for (int i = 0; i < numberOfConsumers; i++)
//		{
//			consumers[i].join();
//		}
//
//		// There should be no items at the warehouse
//		assertEquals(0, store.getNumberOfItemsInStock());
//	}

}
