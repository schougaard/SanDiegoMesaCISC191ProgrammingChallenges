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
 * Purpose: The responsibility of Wall is to be a Cell that never changes.
 */
public class Wall extends Cell
{
	/**
	 * A cell has many listeners so the GUI can listen in on changes and update
	 * accordingly
	 */
	private final ArrayList<PropertyChangeListener> propertyChangeListeners = new ArrayList<PropertyChangeListener>();
	
	/**
	 * A Wall still has a status--being evaluated.
	 */
	private Cell.Status status = Status.INVALID;

	private final Stack<Cell.Status> statusHistory = new Stack<Cell.Status>();
	
	/**
	 * Purpose:
	 * 
	 * @param initLocation
	 */
	public Wall(Location initLocation)
	{
		super(initLocation);
	}
	
	public Wall(Wall otherWall)
	{
		this(otherWall.getLocation());
		status = otherWall.status;
		
		// History belongs to a specific cell in a specific maze (and Stacks are mutable) so we need a deep copy
		for(Cell.Status status: statusHistory)
		{
			statusHistory.push(status);
		}
	}

	public String toString()
	{
		return "Wall: " + getLocation();
	}

	public boolean equals(Object other)
	{
		if (this == other) return true;
		if (other == null) return false;
		if (!(other instanceof Wall)) return false;

		Wall otherCell = (Wall) other;
		// Not testing anything else because walls don't have anything else.
		return this.getLocation().equals(otherCell.getLocation());
	}

	@Override
	public Direction getDirection()
	{
		throw new RuntimeException("Walls don't have directions");
	}

	@Override
	public void setDirection(Direction direction)
	{
		throw new RuntimeException("Walls don't have directions");
	}

	@Override
	public Status getStatus()
	{
		return status;
	}

	@Override
	public void setStatus(Status status)
	{
		statusHistory.add(this.status);
		this.status = status;
		updatePropertyChangeListeners();
	}

	@Override
	public void undoSetStatus()
	{
		this.status = statusHistory.pop();
		updatePropertyChangeListeners();
	}

	@Override
	public Status lastStatus()
	{
		throw new RuntimeException("Walls don't have status");
	}

	@Override
	public boolean isPath()
	{
		return false;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		propertyChangeListeners.add(listener);
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

}
