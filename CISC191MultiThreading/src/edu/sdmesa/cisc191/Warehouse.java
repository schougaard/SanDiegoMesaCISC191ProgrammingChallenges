package edu.sdmesa.cisc191;

import java.util.ArrayList;
import java.util.LinkedList;

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
 * Responsibilities of class: A Warehouse receives, stores and ships Items.
 * 
 */
public class Warehouse
{
	/**
	 * storage is managed as one big stack, where items are laid on top of each other
	 */
	private ArrayList<Item> storage = new ArrayList<Item>();

	public int getNumberOfItemsInStock()
	{
		// TODO: return the number of items in storage
		return -1;
	}

	/**
	 * TODO Modify to add item to the collection and make the tests pass.
	 * 
	 * @param item the item to store in the Warehouse
	 */
	public void receive(Item item)
	{
		//System.out.println("Warehouse receive(" + item + ") running in Thread: " + Thread.currentThread().getName());

		// TODO: store item at at the front of the list
		
	}

	/**
	 * TODO Modify to remove an item from the collection and make the tests pass
	 * @return the item that was retrieved from storage
	 * @throws OutOfStockException if there are no items to ship
	 */
	public Item ship() throws OutOfStockException
	{
		//System.out.println("Warehouse ship() running in Thread: " + Thread.currentThread().getName());

		// TODO: return the first item in the list,
		// if there are any items in storage
		return null;
		
	}

}
