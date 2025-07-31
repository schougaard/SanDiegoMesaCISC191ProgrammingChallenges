/**
* Lead Author(s):
* @author a; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-07-17
*/
package edu.sdmesa.cisc191.model;

import java.util.Stack;

import edu.sdmesa.cisc191.view.CellWidget;

/**
 * Purpose: The reponsibility of Cell is ...
 *
 * Cell is-a ...
 * Cell is ...
 */
public class Cell
{
	/**
	 * A cell has-a location in the maze
	 */
	private final Location location;

	/**
	 * A cell has-a CellWidget associated with it
	 */
	private CellWidget cellWidget;
	
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
	 * A cell may have a history of types that it was marked.
	 */
	private Stack<Cell.Type> history;
	
	/**
	 * Cells have different types (meaning state, that can change)
	 */
	public static enum Type
	{
		WALL, // if this cell represents a wall
		PATH, // if this cell represents a path
		FRONTIER, // used for other algorithms like BFS, etc.
		VISITED, // if this cell has been visited
		CURRENT, // if we're currently on the cell
		EVALUATING, // if we're checking the cell
		SOLUTION, // if this path is part of the solution
		WAITING, // if this cell is waiting for a result
	}
	
	/**
	 * A cell has-a type, some are fixed (WALL), some change
	 */
	private Type type;
	
	public Cell(Location initLocation, Cell.Type initType)
	{
		location = initLocation;
		type = initType;
		history = new Stack<>();
	}
	
	public Cell(Cell otherCell)
	{
		location = otherCell.location;
		type = otherCell.type;
		direction = otherCell.direction;
		history = otherCell.history;
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
		history.add(this.type);
		this.type = type;
	}

	/**
	 * Represents an undo action in terms of setting the type.
	 * Set to the last type it was set to.
	 */
	public void undoSetType()
	{
		this.type = history.pop();
	}

	/**
	 * TODO: check? It might be easier to get the cell widget associated with a cell this way.
	 * @param cellWidget
	 */
	public void setCellWidget(CellWidget cellWidget)
	{
		this.cellWidget = cellWidget;
	}

	public CellWidget getCellWidget()
	{
		return cellWidget;
	}
}
