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
package edu.sdmesa.cisc191.model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Purpose: The responsibility of Cell is track type and direction for a location in a maze.
 * Type can be wall, path, solution, etc.
 * Direction is the direction taken from the location: none, up, down, left, right.
 */
public class Cell
{
	/**
	 * A cell has-a location in the maze
	 */
	private final Location location;
	
	/**
	 * A cell has many listeners so the GUI can listen in on changes and update accordingly
	 */
	private final ArrayList<PropertyChangeListener> propertyChangeListeners = new ArrayList<PropertyChangeListener>();
	
	/**
	 * 
	 * Purpose: The responsibility of Direction is to note the direction the search is going in.
	 */
	public static enum Direction
	{
		NONE, LEFT, RIGHT, UP, DOWN;
	}
	
	/**
	 * A cell may have a search direction.
	 */
	private Direction direction = Direction.NONE;
	
	/**
	 * Cells have different types (meaning state, that can change)
	 */
	public static enum Type
	{
		WALL, // if this cell represents a wall
		PATH, // if this cell represents a path (part of a possible solution)
		FRONTIER, // used for other algorithms like BFS, etc.
		VISITED, // if this cell has been visited
		CURRENT, // if the cell that the algorithm is currently considering
		EVALUATING, // if we're checking the cell
		SOLUTION, // if this path is part of the solution
		WAITING, // if this cell is waiting for a result
	}
	
	/**
	 * A cell may have a history of types that it was marked.
	 */
	private Stack<Cell.Type> typeHistory;
	
	// TODO: should we factor this out into:
	// Type is immutable
//	public static enum Type
//	{
//		WALL, // if this cell represents a wall
//		PATH // if this cell represents a path (part of a possible solution)
//	}
//	
//	public static enum Status
//	{
//		FRONTIER, // used for other algorithms like BFS, etc.
//		VISITED, // if this cell has been visited
//		CURRENT, // if the cell that the algorithm is currently considering
//		EVALUATING, // if we're checking the cell
//		SOLUTION, // if this path is part of the solution
//		WAITING, // if this cell is waiting for a result
//	}
//	private Stack<Cell.Status> statusHistory;
	
	/**
	 * A cell has-a type, some are fixed (e.g., WALL), some change
	 */
	private Type type;
	
	public Cell(Location initLocation, Cell.Type initType)
	{
		location = initLocation;
		type = initType;
		typeHistory = new Stack<Cell.Type>();
	}
	
	public Cell(Cell otherCell)
	{
		location = otherCell.location;
		type = otherCell.type;
		direction = otherCell.direction;
		
		// History belongs to a specific cell in a specific maze (and Stacks are mutable) so we need a deep copy
		typeHistory = new Stack<Cell.Type>();
		for(Cell.Type type: typeHistory)
		{
			typeHistory.push(type);
		}
	}
	
	/**
	 * Purpose: register a listener that gets called when the cell changes
	 * @param listener the listener to be called
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeListeners.add(listener);
	}
	
	/**
	 * @return the location
	 */
	public Location getLocation()
	{
		return location;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection()
	{
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction)
	{
		this.direction = direction;
		updatePropertyChangeListeners();
	}

	/**
	 * @return the type
	 */
	public Type getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type)
	{
		typeHistory.add(this.type);
		this.type = type;
		updatePropertyChangeListeners();
	}

	/**
	 * Represents an undo action in terms of setting the type.
	 * Set to the last type it was set to.
	 */
	public void undoSetType()
	{
		this.type = typeHistory.pop();
		updatePropertyChangeListeners();
	}
	
	/**
	 * Get the last cell type it was set to.
	 * 
	 * @return the last cell type it was set to
	 */
	public Cell.Type lastType()
	{
		return typeHistory.peek();
	}
	
	public String toString()
	{
		return "(" + location + "," + type + "," + direction + ")";
	}

	public boolean equals(Object other)
	{
		if (this == other) return true;
		if (other == null) return false;
		if (!(other instanceof Cell)) return false;
		
		Cell otherCell = (Cell) other;
		// Not testing history
		return this.location.equals(otherCell.location) && this.type.equals(otherCell.type) && this.direction.equals(otherCell.direction); 
	}
	
	/**
	 * Purpose: call propertyChange on all registered PropertyChangeListeners
	 * @see addPropertyChangeListener(PropertyChangeListener listener)
	 */
	private void updatePropertyChangeListeners()
	{
		for(PropertyChangeListener listener: propertyChangeListeners)
		{
			listener.propertyChange(null); // null is good enough
		}
	}

}
