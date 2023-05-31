package edu.sdmesa.cisc191;

/**
 * @author Tasha Frankie
 * @author Allan Schougaard
 * @otherContributors: None
 * @version 2.0
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *      
 * The class is used when a Warehouse does not have any Items in stock.
 */
public class OutOfStockException extends Exception
{
	/**
	 * Contains a message about which thread was running when the exception was thrown.
	 */
	public OutOfStockException()
	{
		super(Thread.currentThread().getName() + " thread could not get an item shipped");
	}
}
