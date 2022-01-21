package edu.sdmesa.cisc191;

/**
 * Consumers receive a number of Items from a Warehouse
 * 
 * @author Tasha Frankie
 * @author Allan Schougaard
 * @otherContributors: None
 * @version 1.0
 */
public class Consumer extends Thread
{
	private String name;
	private Warehouse warehouse;
	private int numberOfItemsToConsume;

	public Consumer(String givenName, Warehouse givenWarehouse, int givenNumberOfItemsToConsume)
	{
		name = givenName;
		warehouse = givenWarehouse;
		numberOfItemsToConsume = givenNumberOfItemsToConsume;
	}

	@Override
	public void run()
	{
		System.out.println(name + " running in Thread: " + Thread.currentThread().getName());

		// TODO: consume numberOfItemsToProduce items
		

		System.out.println(name + " ended.");
	}

}
