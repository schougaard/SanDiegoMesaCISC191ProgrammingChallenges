package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

/**
 * @author Tasha Frankie
 * @author Allan Schougaard
 * @otherContributors: None
 * @version 2.1
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
	 * Testing that an engine uses 1 unit of fuel each second after it is started (in almost real-time).
	 * An engine is a thread that run until it is out of fuel.
	 * 
	 * @throws InterruptedException if the Engine is interrupted
	 */
//	@Test
//	void testEngine() throws InterruptedException
//	{
//		Engine engine1 = new Engine();
//		engine1.setFuelLevel(5);
//		// 3, 2, 1 - start!
//		engine1.start();
//		Thread.sleep(1010);
//		// See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html#isAlive()
//		assertTrue(engine1.isAlive());
//		assertEquals(4, engine1.getFuelLevel());
//		Thread.sleep(1010);
//		// Engine is running
//		assertTrue(engine1.isAlive());
//		assertEquals(3, engine1.getFuelLevel());
//		Thread.sleep(1010);
//		assertTrue(engine1.isAlive());
//		assertEquals(2, engine1.getFuelLevel());
//		Thread.sleep(1010);
//		assertTrue(engine1.isAlive());
//		assertEquals(1, engine1.getFuelLevel());		
//		Thread.sleep(1010);
//		// Engine has stopped
//		assertFalse(engine1.isAlive());
//		assertEquals(0, engine1.getFuelLevel());
//		
//		// No fuel - no go
//		Engine engine2 = new Engine();
//		engine2.setFuelLevel(0);
//		assertEquals(0, engine2.getFuelLevel());
//		engine2.start();
//		Thread.sleep(10);
//		assertFalse(engine2.isAlive());
//		assertEquals(0, engine2.getFuelLevel());
//		
//		// Running two engines at the same time
//		Engine engine10 = new Engine();
//		engine10.setFuelLevel(5);
//		engine10.start();
//		Engine engine11 = new Engine();
//		engine11.setFuelLevel(3);
//		engine11.start();
//		
//		Thread.sleep(2100);
//		assertTrue(engine10.isAlive());
//		assertEquals(3, engine10.getFuelLevel());
//		assertTrue(engine11.isAlive());
//		assertEquals(1, engine11.getFuelLevel());
//		
//		Thread.sleep(1010);
//		assertTrue(engine10.isAlive());
//		assertEquals(2, engine10.getFuelLevel());
//		assertFalse(engine11.isAlive());
//		assertEquals(0, engine11.getFuelLevel());
//		
//		Thread.sleep(2010);
//		assertFalse(engine10.isAlive());
//		assertEquals(0, engine10.getFuelLevel());
//	}
	
	/**
	 * Testing that a bank account can accept deposits and withdrawals in any order
	 * @throws InterruptedException should not happen
	 */
//	@Test
//	void testBankAccountDepositWithdrawSequentially() throws InterruptedException
//	{
//		BankAccount account = new BankAccount();
//		
//		// Deposit money
//		Thread[] depositors = new Thread[1];
//		for (int i=0; i<depositors.length; i++)
//		{
//			depositors[i] = new BankDepositor(account, 10000);				
//		}		
//		// Withdraw the same amount of money
//		Thread[] withdrawers = new Thread[depositors.length];
//		for (int i=0; i<withdrawers.length; i++)
//		{
//			withdrawers[i] = new BankWithdrawer(account, 10000);					
//		}
//		
//		// Start all the threads
//		for (int i=0; i<depositors.length; i++)
//		{
//			depositors[i].run();
//			withdrawers[i].run();
//		}
//		
//		assertEquals(0, account.getBalance());
//	}
	
	/**
	 * Testing that a bank account can accept deposits concurrently
	 * @throws InterruptedException should not happen
	 */
//	@Test
//	void testBankAccountDepositConcurrently() throws InterruptedException
//	{
//		BankAccount account = new BankAccount();
//		// Deposit money
//		// If this does not error on first run, increase the number of threads
//		// and change the assertEquals
//		Thread[] threads = new Thread[2];
//		for (int i=0; i<threads.length; i++)
//		{
//			threads[i] = new BankDepositor(account, 100000);					
//		}
//		// Start all the withdrawals
//		for (int i=0; i<threads.length; i++)
//		{
//			threads[i].start();
//		}
//		// Wait for all withdrawals to end
//		for (int i=0; i<threads.length; i++)
//		{
//			threads[i].join();
//		}
//		
//		assertEquals(2*100000, account.getBalance());
//	}
	
	/**
	 * Testing that a bank account can accept withdrawals concurrently
	 * @throws InterruptedException should not happen
	 */
//	@Test
//	void testBankAccountWithdrawConcurrently() throws InterruptedException
//	{
//		BankAccount account = new BankAccount();
//		account.deposit(100000*2);
//		// Withdraw the same amount of money as deposited
//		// If this does not error on first run, increase the number of threads
//		// and change the deposit.
//		Thread[] threads = new Thread[2];
//		for (int i=0; i<threads.length; i++)
//		{
//			threads[i] = new BankWithdrawer(account, 100000);					
//		}
//		// Start all the withdrawals
//		for (int i=0; i<threads.length; i++)
//		{
//			threads[i].start();
//		}
//		// Wait for all withdrawals to end
//		for (int i=0; i<threads.length; i++)
//		{
//			threads[i].join();
//		}
//		
//		assertEquals(0, account.getBalance());
//	}
	
	
	/**
	 * Testing that a bank account can accept deposits and withdrawals concurrently
	 * @throws InterruptedException should not happen
	 */
//	@Test
//	void testBankAccountDepositWithdrawConcurrently1() throws InterruptedException
//	{
//		BankAccount account = new BankAccount();
//		
//		// Deposit money
//		Thread depositor = new BankDepositor(account, 100000);
//		// Withdraw the same amount of money
//		Thread withdrawer = new BankWithdrawer(account, 100000);
//		// Start all the threads
//		depositor.start();
//		withdrawer.start();
//		// Wait for all threads to end
//		depositor.join();
//		withdrawer.join();
//		
//		assertEquals(0, account.getBalance());
//	}
	
	
	/**
	 * Testing that a bank account can accept high volume deposits and withdrawals concurrently
	 * @throws InterruptedException should not happen
	 */
//	@Test
//	void testBankAccountDepositWithdrawConcurrently2() throws InterruptedException
//	{
//		BankAccount account = new BankAccount();
//		
//		// Deposit money
//		// If this does not error on first run, increase the number of depositors
//		Thread[] depositors = new Thread[2];
//		for (int i=0; i<depositors.length; i++)
//		{
//			depositors[i] = new BankDepositor(account, 10000);				
//		}		
//		// Withdraw the same amount of money
//		Thread[] withdrawers = new Thread[depositors.length];
//		for (int i=0; i<withdrawers.length; i++)
//		{
//			withdrawers[i] = new BankWithdrawer(account, 10000);					
//		}
//		
//		// Start all the threads
//		for (int i=0; i<depositors.length; i++)
//		{
//			depositors[i].start();
//			withdrawers[i].start();
//		}
//		// Wait for all threads to end
//		for (int i=0; i<depositors.length; i++)
//		{
//			depositors[i].join();
//			withdrawers[i].join();
//		}
//		
//		assertEquals(0, account.getBalance());
//	}

	/**
	 * Testing that a warehouse can receive and ship items, and that items are
	 * shipped last-in first-out.
	 * 
	 * @throws OutOfStockException if the warehouse is out of stock
	 */
//	@Test
//	void testWarehouse() throws OutOfStockException
//	{
//		Warehouse warehouse = new Warehouse();
//		Item item1 = new Item();
//		assertEquals(0, warehouse.getNumberOfItemsInStock());
//		warehouse.receive(item1);
//		assertEquals(1, warehouse.getNumberOfItemsInStock());
//		assertEquals(item1, warehouse.ship());
//		assertEquals(0, warehouse.getNumberOfItemsInStock());
//		Item item2 = new Item();
//		Item item3 = new Item();
//		warehouse.receive(item2);
//		warehouse.receive(item3);
//		assertEquals(2, warehouse.getNumberOfItemsInStock());
//		assertEquals(item3, warehouse.ship());
//		assertEquals(item2, warehouse.ship());
//		assertEquals(0, warehouse.getNumberOfItemsInStock());
//		// Throws OutOfStockException when out of stock and asked to ship an item
//		assertThrows(OutOfStockException.class, () -> {
//	        warehouse.ship();
//	    });
//	}

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
	 * Note: When trying to consume, the warehouse may be out of stock,
	 * in which case the consumer will have to wait and try again.
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
	
//	@Test
//	void testConsumingConcurrentlyWithOutOfStock() throws InterruptedException
//	{
//		Warehouse store = new Warehouse();
//
//		// Produce one item
//		new Producer("Producer A", store, 1).run();
//
//		assertEquals(1, store.getNumberOfItemsInStock());
//
//		// Now, consume two items.
		// But, the producers have only produced one item at this stage so 
//		// the consumer will have to check again
//		Consumer consumer = new Consumer("Consumer", store, 2);
//		consumer.start();
//		
//		Thread.currentThread().sleep(200);
//		assertEquals(0, store.getNumberOfItemsInStock());
//
//		// Produce one more item so the consumer can get the requested items
//		new Producer("Producer B", store, 1).run();
//
//		// Wait for producer to complete
//		consumer.join();
//
//		// There should be no items at the warehouse
//		assertEquals(0, store.getNumberOfItemsInStock());
//	}
	
	/**
	 * In this test we are simulating many consumers receiving items concurrently
	 * with many producers. We are running many threads concurrently, so you computer's
	 * fan may spin up as all the cores in the CPU are being used and therefore
	 * use more power.
	 * If you are on MacOS you may have to reduce the number of threads
	 * as Apple does not allow you to run this many threads.
	 * Of course, then issue may not show itself.
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
//		// Wait for consumers to complete
//		for (int i = 0; i < numberOfConsumers; i++)
//		{
//			consumers[i].join();
//		}
//
//		// There should be no items at the warehouse
//		assertEquals(0, store.getNumberOfItemsInStock());
//	}

}
