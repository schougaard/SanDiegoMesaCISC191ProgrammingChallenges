package edu.sdmesa.cisc191.model;

import edu.sdmesa.cisc191.controller.MazeController;
import edu.sdmesa.cisc191.model.Cell.Direction;

/**
 * Lead Author(s):
 * 
 * @author Alex Chow
 * 
 *         Other contributors:
 *         None
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
 * This class is the base abstract class for implementing a solver class.
 * The DFSSolver class inherits this, and must implement the solve method.
 */
public abstract class MazeSolver
{
	/**
	 * TODO: ???
	 */
	private boolean cleared = false;

	/**
	 * A maze solver has a maze to solve
	 */
	private Maze maze;
	
	/**
	 * TODO: ???
	 */
	private Maze ogMaze;
	
	/**
	 * The current location to take the next step from.
	 * There is a PATH from the entrance to the currentLocation.
	 */
	private Location currentLocation;	

	/**
	 * Constructor.
	 * 
	 * @param maze       the maze to solve
	 * @param controller the controller to call for GUI and maze manipulation
	 */
	public MazeSolver(Maze maze)
	{
		this.maze = maze;
		this.ogMaze = new Maze(maze);
	}

	/**
	 * Find a complete way from the entrance of the maze to the exit, if possible
	 */
	public void solve()
	{
		solveRecursive(maze.entranceLocation);
	}
	
	/**
	 * 
	 * Find a complete way from the currentLocation to the exit of the maze
	 * @param currentLocation
	 * @return true if a way can be found
	 */
	public abstract boolean solveRecursive(Location currentLocation);

	/**
	 * Color a cell as currently being checked to see if the cell is a path.
	 * This does not set the internal state of the cell to anything else like
	 * the methods that start with the word "mark." The cell will simply be
	 * colored light gray.
	 * 
	 * @param row The row of the cell to be colored as checking.
	 * @param col The column of the cell to be colored as checking.
	 */
	public void markAsEvaluating(Location location)
	{
		maze.getCellAtLocation(location).setType(Cell.Type.EVALUATING);
	}

	/**
	 * Color a cell as that we're currently on it. Think of it as where you
	 * currently are in the maze. This does not set the internal state of the
	 * cell to anything else like the methods that start with the word "mark."
	 * The cell will simply be colored blue.
	 * 
	 * @param row The row of the cell to be colored as current.
	 * @param col The column of the cell to be colored as current.
	 */
	public void markAsCurrent(Location location)
	{
		maze.getCellAtLocation(location).setType(Cell.Type.CURRENT);
	}

	/**
	 * Gets the maze reference.
	 * 
	 * @return the maze
	 */
	public Maze getMaze()
	{
		return maze;
	}

	/**
	 * Check if the cell at row, col is a path. This means it's not a wall,
	 * and it's not waiting for further exploration, and we haven't walked
	 * here before.
	 * 
	 * @param row The row of the cell to check
	 * @param col The column of the cell to check
	 * @return true if the cell is a path; false if not.
	 */
	public boolean isPath(Location location)
	{
		// need to store og type; otherwise will be overridden by evaluating
		Cell.Type ogType = maze.getCellAtLocation(location).getType();

		markAsEvaluating(location);
		if (ogMaze.isLocationOnPath(location) && ogType != Cell.Type.WAITING)
		{
			return true;
		}
		else
		{
			unmark(location);
			return false;
		}
	}

	/**
	 * Checks if the cleared flag had been set.
	 * 
	 * @return the value of the cleared flag
	 */
	public boolean isCleared()
	{
		return cleared;
	}

	/**
	 * Mark a cell as the solution. This will internally change the state
	 * of the cell from PATH to SOLUTION. The cell will also be colored
	 * green.
	 * 
	 * @param row The row of the cell to set solution as.
	 * @param col The column of the cell to set solution as.
	 */
	public void markAsSolution(Location location)
	{
		maze.markAsSolution(location);
	}

	/**
	 * Mark a cell as waiting. Waiting means we've walked to that cell,
	 * and is waiting to see if there are paths ahead that lead to the exit
	 * or a dead end. This will internally change the state of the cell
	 * from PATH to WAITING. The cell will also be colored dark gray.
	 * 
	 * @param row The row of the cell to set the waiting state as.
	 * @param col The column of the cell to set the waiting state as.
	 */
	public void markAsWaiting(Location location)
	{
		maze.markAsWaiting(location);
	}

	/**
	 * Mark a cell as visited. Visited means we're done checking every
	 * direction from that cell. It means no matter going up, left, right,
	 * or down from that cell will lead us to a dead end. This will internally
	 * change the state of the cell from PATH to VISITED. The cell will also
	 * be colored red.
	 * 
	 * @param row The row of the cell to set the waiting state as.
	 * @param col The column of the cell to set the waiting state as.
	 */
	public void markAsVisited(Location location)
	{
		maze.markAsVisited(location);
	}

	/**
	 * Sets the cleared flag.
	 * 
	 * @param value of the cleared flag
	 */
	public void setCleared(boolean value)
	{
		cleared = value;
	}

	/**
	 * Sets the maze of this solver.
	 * 
	 * @param maze to set
	 */
	public void setMaze(Maze maze)
	{
		this.maze = maze;
	}

	/**
	 * Unmarks the cell to the original type.
	 * 
	 * @param location the location of the cell to unmark.
	 */
	private void unmark(Location location)
	{
		maze.unmark(location);
	}

	/**
	 * Sets the text at row and col to "L".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelLeft(Location location)
	{
		maze.setLabelLeft(location);
	}

	/**
	 * Sets the text at row and col to "R".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelRight(Location location)
	{
		maze.setLabelRight(location);
	}

	/**
	 * Sets the text at row and col to "U".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelUp(Location location)
	{
		maze.setLabelUp(location);
	}

	/**
	 * Sets the text at row and col to "D".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelDown(Location location)
	{
		maze.setLabelDown(location);
	}

	/**
	 * @return current location
	 */
	public Location getCurrentLocation()
	{
		return currentLocation;
	}

	/**
	 * @param currentLocation to set
	 */
	public void setCurrentLocation(Location currentLocation)
	{
		this.currentLocation = currentLocation;
		markAsCurrent(this.currentLocation);
	}
}
