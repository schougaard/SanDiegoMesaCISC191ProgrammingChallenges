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
		PATH, // if this cell represents a path
		FRONTIER, // used for other algorithms like BFS, etc.
		VISITED, // if this cell has been visited
		CURRENT, // if we're currently on the cell
		CHECKING, // if we're checking the cell
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
	}
	
	public Cell(Cell otherCell)
	{
		location = otherCell.location;
		type = otherCell.type;
		direction = otherCell.direction;
	}
	
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
		this.type = type;
	}
	

}
