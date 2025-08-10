/**
 * Lead Author(s):
 * 
 * @author a; student ID
 * @author Full name; student ID
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         <<Add more references here>>
 *
 *         Version: 2025-08-09
 */
package edu.sdmesa.cisc191.model.cell;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Stack;

import edu.sdmesa.cisc191.model.Location;

/**
 * Purpose: The reponsibility of Path is ...
 *
 * Path is-a ...
 * Path is ...
 */
public class Path extends Cell
{
	/**
	 * A cell has many listeners so the GUI can listen in on changes and update
	 * accordingly
	 */
	private final ArrayList<PropertyChangeListener> propertyChangeListeners = new ArrayList<PropertyChangeListener>();

	/**
	 * A cell may have a search direction.
	 */
	private Cell.Direction direction = Direction.NONE;

	private Cell.Status status = Status.NOT_STARTED;

	private final Stack<Cell.Status> statusHistory = new Stack<Cell.Status>();

	public Path(Location initLocation)
	{
		super(initLocation);
		status = Status.NOT_STARTED;
	}
	
	public Path(Path otherPath)
	{
		super(otherPath.getLocation());
		status = otherPath.status;
		direction = otherPath.direction;
		
		// History belongs to a specific cell in a specific maze (and Stacks are mutable) so we need a deep copy
		for(Cell.Status status: statusHistory)
		{
			statusHistory.push(status);
		}
	}

	/**
	 * Purpose: register a listener that gets called when the cell changes
	 * 
	 * @param listener the listener to be called
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeListeners.add(listener);
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
	 * @return the status
	 */
	public Status getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status)
	{
		statusHistory.add(this.status);
		this.status = status;
		updatePropertyChangeListeners();
	}

	/**
	 * Represents an undo action in terms of setting the status.
	 * Set to the last status it was set to.
	 */
	public void undoSetStatus()
	{
		this.status = statusHistory.pop();
		updatePropertyChangeListeners();
	}

	/**
	 * Get the last cell status it was set to.
	 * 
	 * @return the last cell status it was set to
	 */
	public Cell.Status lastStatus()
	{
		return statusHistory.peek();
	}

	public String toString()
	{
		return "(" + getLocation() + "," + status + "," + direction + ")";
	}

	public boolean equals(Object other)
	{
		if (this == other) return true;
		if (other == null) return false;
		if (!(other instanceof Cell)) return false;

		Cell otherCell = (Cell) other;
		// Not testing history
		return this.getLocation().equals(otherCell.getLocation())
				&& this.status.equals(otherCell.getStatus())
				&& this.direction.equals(otherCell.getDirection());
	}

	/**
	 * Purpose: call propertyChange on all registered PropertyChangeListeners
	 * 
	 * @see addPropertyChangeListener(PropertyChangeListener listener)
	 */
	private void updatePropertyChangeListeners()
	{
		for (PropertyChangeListener listener : propertyChangeListeners)
		{
			listener.propertyChange(null); // null is good enough
		}
	}

	@Override
	public boolean isPath()
	{
		return true;
	}

}
