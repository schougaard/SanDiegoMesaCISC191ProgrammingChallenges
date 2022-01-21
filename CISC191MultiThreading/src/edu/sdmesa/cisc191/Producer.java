package edu.sdmesa.cisc191;

/**
 * Producers creates a number of new Items and sends them to a Warehouse
 *  
 * @author Tasha Frankie
 * @author Allan Schougaard
 * @otherContributors: None
 * @version 1.0
 */
public class Producer extends Thread
{
	private String name;
	private Warehouse warehouse;
	private int numberOfItemsToProduce;

	public Producer(String givenName, Warehouse givenWarehouse, int givenNumberOfItemsToProduce)
	{
		name = givenName;
		warehouse = givenWarehouse;
		numberOfItemsToProduce = givenNumberOfItemsToProduce;
	}

	@Override
	public void run()
	{
		System.out.println(name + " running in Thread: " + Thread.currentThread().getName());

		// TODO: produce numberOfItemsToProduce new items
		

		System.out.println(name + " ended.");
	}

}
