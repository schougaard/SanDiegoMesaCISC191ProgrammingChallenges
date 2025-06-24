package edu.sdmesa.cisc191;

public interface Consumer<Item>
{
	/**
	 * Consumes an element from the collection 
	 * by removing an element that was previously produced by a Producer.
	 * @return the consumed element
	 */
	public Item consume();
}