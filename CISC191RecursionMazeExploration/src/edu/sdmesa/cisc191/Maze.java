package edu.sdmesa.cisc191;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
 * This class represents a maze logically. Meaning, all the data for the maze
 * is stored here, including what type each cell is, the exit point, the
 * entrance point, and colors.
 */
public class Maze
{
	/**
	 * The number of rows in the maze
	 */
	public final static int HEIGHT = 19;

	/**
	 * The number of columns in the maze
	 */
	public final static int WIDTH = 19;

	/**
	 * A maze has-an entrance, where the path through the maze starts
	 */
	public final Location entranceLocation = new Location(HEIGHT - 1, 1);

	/**
	 * A maze has-an exit, where the path through the maze ends
	 */
	public final Location exitLocation = new Location(0, WIDTH - 2);

	/**
	 * A maze has-many cells
	 */
	private CellType[][] cells;

	/**
	 * Cells have different types
	 */
	public static enum CellType
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

	// TODO: remove, they should only be found in GUICell
	// Everywhere else should use CellType
	public final static Color WALL_COLOR = Color.black;
	public final static Color PATH_COLOR = Color.white;
	public final static Color VISITED_COLOR = Color.red;
	public final static Color CURRENT_COLOR = Color.blue;
	public final static Color SOLUTION_COLOR = Color.green;
	public final static Color CHECKING_COLOR = Color.lightGray;
	public final static Color WAITING_COLOR = Color.darkGray;

	/**
	 * A setter constructor.
	 * 
	 * @param maze the maze to set
	 */
	public Maze(CellType[][] maze)
	{
		this.cells = maze;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param maze the maze to copy
	 */
	public Maze(Maze maze)
	{
		this(new CellType[HEIGHT][WIDTH]);

		for (int row = 0; row < this.cells.length; row++)
		{
			for (int col = 0; col < this.cells[0].length; col++)
			{
				this.cells[row][col] = maze
						.getCellValueAt(new Location(row, col));
			}
		}
	}

	/**
	 * Gets the width of the maze.
	 * 
	 * @return width of the maze
	 */
	public int getWidth()
	{
		return WIDTH;
	}

	/**
	 * Gets the height of the maze.
	 * 
	 * @return height of the maze
	 */
	public int getHeight()
	{
		return HEIGHT;
	}

	/**
	 * Convenience method to get the cell type at a specific point.
	 * 
	 * @param location the location
	 * @return the cell type
	 */
	public CellType getCellValueAt(Location location)
	{
		return cells[location.getRow()][location.getColumn()];
	}

	/**
	 * Mark a cell as some cell type. Namely, set the value of a cell in a
	 * 2D array to the specified value. If the operation was not successful,
	 * (e.g., because the point is invalid), then nothing will be done and
	 * the method will return false. Otherwise, return true.
	 * 
	 * @param location the location
	 * @param cellType the cell type to set
	 * @return whether the operation was successful
	 */
	public boolean markAs(Location location, CellType cellType)
	{
		cells[location.getRow()][location.getColumn()] = cellType;
		return true;
	}

	/**
	 * A helper method to get a list of reachable cells from a point
	 * in a maze.
	 * 
	 * @param cells the maze
	 * @param point the point
	 * @return the list of points
	 */
	public LinkedList<Location> getReachableCells(Location location)
	{
		// TODO: see Location getSourroundingLocations
		
		LinkedList<Location> reachableCells = new LinkedList<>();
		LinkedList<Location> directions = new LinkedList<>();

		// check each direction. Note how it's 2 units since each cell could be
		// a wall as well
		try
		{
			directions.add(location.getLocationToLeft().getLocationToLeft());
		}
		catch (IllegalArgumentException e)
		{
			// e.printStackTrace();
		}

		try
		{
			directions.add(location.getLocationToRight().getLocationToRight());
		}
		catch (IllegalArgumentException e)
		{
			// e.printStackTrace();
		}

		try
		{
			directions.add(location.getLocationAbove().getLocationAbove());
		}
		catch (IllegalArgumentException e)
		{
			// e.printStackTrace();
		}

		try
		{
			directions.add(location.getLocationBelow().getLocationBelow());
		}
		catch (IllegalArgumentException e)
		{
			// e.printStackTrace();
		}

		// shuffle to make random paths
		// Collections.shuffle(Arrays.asList(directions));

		// check in each direction
		for (Location direction : directions)
		{
			if (canBeAPath(direction)
					&& getCellValueAt(direction) != Maze.CellType.PATH)
			{
				reachableCells.add(direction);
			}
		}

		return reachableCells;
	}

	/**
	 * Returns whether the cell at the specified point can be marked as a
	 * path. Takes row and column as parameters. The checks are:
	 * - Validity (within borders?)
	 * - If the cell is a designated entrance or exit cell
	 * - If the cell is on the border
	 * 
	 * @param row the cell row
	 * @param col the cell column
	 * @return true if the cell can be a path; false otherwise
	 */
	public boolean canBeAPath(Location location)
	{
		int row = location.getRow();
		int col = location.getColumn();

		if (row == HEIGHT - 1 && col == 1) return true; // entrance
		if (row == 0 && col == WIDTH - 2) return true; // exit

		// no borders besides exit and entrance can be a path
		if (row == 0 || col == 0 || row == HEIGHT - 1 || col == WIDTH - 1)
			return false;

		return true;
	}
	
	@Override
	public String toString()
	{
		String returnValue = "";
		for (CellType[] row : cells)
		{
			returnValue += Arrays.toString(row) + '\n';
		}
		return returnValue;
	}

	/**
	 * Gets the entrance location.
	 * 
	 * @return the entrance location
	 */
	public Location getEntranceLocation()
	{
		return entranceLocation;
	}

	/**
	 * Gets the exit location.
	 * 
	 * @return the exit location
	 */
	public Location getExitLocation()
	{
		return exitLocation;
	}

	/**
	 * Returns whether the cell at the specified location is an exit.
	 * 
	 * @param location the location
	 * @return true if the cell is an exit; false otherwise
	 */
	public boolean isExit(Location location)
	{
		return exitLocation.equals(location);
	}

	/**
	 * Returns whether the cell at the specified location is an entrance.
	 * 
	 * @param location the location
	 * @return true if the cell is an entrance; false otherwise
	 */
	public boolean isEntrance(Location location)
	{
		return entranceLocation.equals(location);
	}

	/**
	 * Returns whether the cell at the specified row and column is a path.
	 * 
	 * @param row the cell row
	 * @param col the cell column
	 * @return true if the cell is a path; false otherwise
	 */
	public boolean isLocationOnPath(Location location)
	{
		return getCellValueAt(location) == CellType.PATH;
	}
	
	/**
	 * @param currentLocation
	 * @return list of locations surrounding the current location that are not walls
	 */
	public LinkedList<Location> getSurroundingPossibleLocations(Location currentLocation)
	{
		LinkedList<Location> locations = currentLocation.getSourroundingLocations();
		// Should be .filter
		for (Location location : locations)
		{
			if (getCellValueAt(location) == CellType.WALL)
			{
				locations.remove(location);
			}
		}
		
		return locations;
	}
}
