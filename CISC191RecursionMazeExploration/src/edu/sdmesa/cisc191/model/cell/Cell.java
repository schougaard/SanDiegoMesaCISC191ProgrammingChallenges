/**
* Lead Author(s):
* @author Alex Chow
* @author Allan Schougaard
*
* Other Contributors:
* Full name; student ID or contact information if not in class
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* Version: 2025-07-17
*/
package edu.sdmesa.cisc191.model.cell;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Stack;

import edu.sdmesa.cisc191.model.Location;

/**
 * Purpose: The responsibility of Cell is track status and direction for a location in a maze.
 * status can be wall, path, solution, etc.
 * Direction is the direction taken from the location: none, up, down, left, right.
 */
public abstract class Cell
{
	/**
	 * A cell has-a location in the maze
	 */
	private final Location location;
	
	/**
	 * 
	 * Purpose: The responsibility of Direction is to note the direction the search is going in.
	 */
	public static enum Direction
	{
		NONE, LEFT, RIGHT, UP, DOWN;
	}
	
	public static enum Status
	{
		INVALID,
		NOT_STARTED, 
		FRONTIER, // used for other algorithms like BFS, etc.
		VISITED, // if this cell has been visited
		CURRENT, // if the cell that the algorithm is currently considering
		EVALUATING, // if we're checking the cell
		SOLUTION, // if this path is part of the solution
		WAITING, // if this cell is waiting for a result
	}
	
	public Cell(Location initLocation)
	{
		location = initLocation;
	}
	
	/**
	 * @return the location
	 */
	public Location getLocation()
	{
		return location;
	}
	
	public abstract boolean isPath();
	
	public abstract void addPropertyChangeListener(PropertyChangeListener listener);
	
	/**
	 * @return the direction
	 */
	public abstract Direction getDirection();

	/**
	 * @param direction the direction to set
	 */
	public abstract void setDirection(Direction direction);

	/**
	 * @return the status
	 */
	public abstract Status getStatus();

	/**
	 * @param status the status to set
	 */
	public abstract void setStatus(Status status);

	/**
	 * Represents an undo action in terms of setting the status.
	 * Set to the last status it was set to.
	 */
	public abstract void undoSetStatus();
	
	/**
	 * Get the last cell status it was set to.
	 * 
	 * @return the last cell status it was set to
	 */
	public abstract Cell.Status lastStatus();
	
	public String toString()
	{
		return "(" + location + "," + getStatus() + "," + getDirection() + ")";
	}

	public boolean equals(Object other)
	{
		if (this == other) return true;
		if (other == null) return false;
		if (!(other instanceof Cell)) return false;
		
		Cell otherCell = (Cell) other;
		// Not testing history
		return this.location.equals(otherCell.location) && this.getStatus().equals(otherCell.getStatus()) && this.getDirection().equals(otherCell.getDirection()); 
	}


}
