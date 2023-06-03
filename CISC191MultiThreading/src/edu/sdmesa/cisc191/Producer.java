package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * 
 * @author
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 * Version/date:
 * 
 * Responsibilities of class:
 * 
 */

//TODO: comment the code

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
