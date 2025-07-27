package edu.sdmesa.cisc191;

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
	private boolean cleared = false;

	private Maze maze;
	private Maze ogMaze;
	private MazeController controller;
	private Location currentLocation;

	/**
	 * Constructor.
	 * 
	 * @param maze       the maze to solve
	 * @param controller the controller to call for GUI and maze manipulation
	 */
	public MazeSolver(Maze maze, MazeController controller)
	{
		this.maze = maze;
		this.ogMaze = new Maze(maze);
		this.controller = controller;
	}

	public abstract void solve();

	public abstract boolean solveRecursive(Location currLoc);

	/**
	 * Color a cell as currently being checked to see if the cell is a path.
	 * This does not set the internal state of the cell to anything else like
	 * the methods that start with the word "mark." The cell will simply be
	 * colored light gray.
	 * 
	 * @param row The row of the cell to be colored as checking.
	 * @param col The column of the cell to be colored as checking.
	 */
	public void colorAsEvaluating(Location location)
	{
		controller.colorCell(location, Maze.CellType.EVALUATING);
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
	public void colorAsCurrent(Location location)
	{
		controller.colorCell(location, Maze.CellType.CURRENT);
	}

	/**
	 * Gets the maze controller object.
	 * 
	 * @return the maze controller
	 */
	public MazeController getMazeController()
	{
		return controller;
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
		colorAsEvaluating(location);
		if (ogMaze.isLocationOnPath(location) && !isWaiting(location))
		{
			return true;
		}
		else
		{
			uncolor(location);
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
		maze.markAs(location, Maze.CellType.SOLUTION);
		controller.colorCell(location, Maze.CellType.SOLUTION);
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
		maze.markAs(location, Maze.CellType.WAITING);
		controller.colorCell(location, Maze.CellType.WAITING);
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
		maze.markAs(location, Maze.CellType.VISITED);
		controller.colorCell(location, Maze.CellType.VISITED);
	}

	/**
	 * Sets the maze controller.
	 * 
	 * @param controller the maze controller
	 */
	public void setController(MazeController controller)
	{
		this.controller = controller;
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
	 * Uncolors the cell to the original color.
	 * 
	 * @param row the row of the cell to uncolor
	 * @param col the column of the cell to uncolor
	 */
	private void uncolor(Location location)
	{
		controller.colorCell(location, maze.getCellValueAt(location));
	}

	/**
	 * Checks if a cell is in the WAITING state.
	 * 
	 * @param row the row of the cell to check
	 * @param col the column of the cell to check
	 * @return if the cell's state is WAITING
	 */
	private boolean isWaiting(Location location)
	{
		return maze.getCellValueAt(location) == Maze.CellType.WAITING;
	}

	/**
	 * Sets the text at row and col to "L".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelLeft(Location location)
	{
		controller.setLabelAt(location, "L");
	}

	/**
	 * Sets the text at row and col to "R".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelRight(Location location)
	{
		controller.setLabelAt(location, "R");
	}

	/**
	 * Sets the text at row and col to "U".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelUp(Location location)
	{
		controller.setLabelAt(location, "U");
	}

	/**
	 * Sets the text at row and col to "D".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelDown(Location location)
	{
		controller.setLabelAt(location, "D");
	}

	public Location getCurrentLocation()
	{
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation)
	{
		this.currentLocation = currentLocation;
		colorAsCurrent(this.currentLocation);
	}
}
