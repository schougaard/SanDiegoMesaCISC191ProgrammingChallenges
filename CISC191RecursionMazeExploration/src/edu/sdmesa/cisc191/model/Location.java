package edu.sdmesa.cisc191.model;

import java.util.LinkedList;

/**
 * Lead Author(s):
 * 
 * @author Alex Chow
 * 
 *         Other contributors:
 *         Allan Schougaard
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Version/date: 1.0
 */

/**
 * 
 * Purpose: The responsibility of Location is to represent a location inside of
 * the maze.
 * Locations are non-mutable, and only valid locations to be created.
 */
public class Location
{
	/**
	 * A location has-a row index
	 */
	private final int row;

	/**
	 * A location has-a column index
	 */
	private final int column;

	/**
	 * Purpose: Create a new location in a maze
	 * 
	 * @param initRow    the row index of the location; counting from top to
	 *                   bottom; 0 ≤ row < number of rows in maze
	 * @param initColumn the column index of the location; counting from left to
	 *                   right; ; 0 ≤ column < number of columns in maze
	 * @throws IllegalArgumentException if initRow or initColumn are either
	 *                                  negative or beyond the index in a given
	 *                                  direction
	 */
	public Location(int initRow, int initColumn) throws IllegalArgumentException
	{
		if (initRow < 0 || initRow >= Maze.HEIGHT)
		{
			throw new IllegalArgumentException(
					"Row must be between 0 and " + Maze.HEIGHT + "!");
		}

		if (initColumn < 0 || initColumn >= Maze.WIDTH)
		{
			throw new IllegalArgumentException(
					"Column must be between 0 and " + Maze.WIDTH + "!");
		}

		row = initRow;
		column = initColumn;
	}

	public boolean hasLocationToRight()
	{
		try
		{
			getLocationToRight();
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}
	
	public boolean hasLocationToLeft()
	{
		try
		{
			getLocationToLeft();
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}

	public boolean hasLocationAbove()
	{
		try
		{
			getLocationAbove();
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}

	public boolean hasLocationBelow()
	{
		try
		{
			getLocationBelow();
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}

	/**
	 * @return the location to the right
	 * @throws IllegalArgumentException if there is no valid location to the
	 *                                  right
	 */
	public Location getLocationToRight() throws IllegalArgumentException
	{
		return new Location(row, column + 1);
	}

	/**
	 * @return the location to the left
	 * @throws IllegalArgumentException if there is no valid location to the
	 *                                  left
	 */
	public Location getLocationToLeft() throws IllegalArgumentException
	{
		return new Location(row, column - 1);
	}

	/**
	 * @return the location above
	 * @throws IllegalArgumentException if there is no valid location above
	 */
	public Location getLocationAbove() throws IllegalArgumentException
	{
		return new Location(row - 1, column);
	}

	/**
	 * @return the location below
	 * @throws IllegalArgumentException if there is no valid location below
	 */
	public Location getLocationBelow() throws IllegalArgumentException
	{
		return new Location(row + 1, column);
	}

	public boolean isOuterPerimeter()
	{
		return row == 0 || column == 0 || row == Maze.HEIGHT - 1
				|| column == Maze.WIDTH - 1;
	}

	/**
	 * @return all possible locations surrounding this location
	 */
	public LinkedList<Location> getAdjacentLocations()
	{
		LinkedList<Location> locations = new LinkedList<Location>();

		try
		{
			locations.add(getLocationToLeft());
		}
		catch (IllegalArgumentException e)
		{
			// Ignore
		}

		try
		{
			locations.add(getLocationAbove());
		}
		catch (IllegalArgumentException e)
		{
			// Ignore
		}

		try
		{
			locations.add(getLocationToRight());
		}
		catch (IllegalArgumentException e)
		{
			// Ignore
		}

		try
		{
			locations.add(getLocationBelow());
		}
		catch (IllegalArgumentException e)
		{
			// Ignore
		}

		return locations;
	}

	/**
	 * @return row index of the location
	 */
	public int getRow()
	{
		return row;
	}

	/**
	 * @return column index of the location
	 */
	public int getColumn()
	{
		return column;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Location)) return false;

		Location other = (Location) obj;

		return other.row == row && other.column == column;
	}

	@Override
	public String toString()
	{
		return "(" + row + "," + column + ")";
	}
}
