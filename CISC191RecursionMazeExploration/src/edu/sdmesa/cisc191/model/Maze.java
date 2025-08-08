package edu.sdmesa.cisc191.model;

import java.util.Arrays;
import java.util.LinkedList;

import edu.sdmesa.cisc191.model.Cell.Direction;

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
	private final Cell[][] cells;

	/**
	 * Create a maze with entry, exit and walls on the outer perimeter, except
	 * for entry and exit
	 */
	public Maze()
	{
		cells = new Cell[HEIGHT][WIDTH];

		// Most are paths
		for (int row = 1; row < HEIGHT-1; row++)
		{
			for (int col = 1; col < WIDTH-1; col++)
			{
				cells[row][col] = new Cell(new Location(row, col), Cell.Type.PATH);
			}
		}
		
		// Some are walls
		for (int row = 0; row < HEIGHT; row++)
		{
			cells[row][0] = new Cell(new Location(row, 0), Cell.Type.WALL);
			cells[row][WIDTH - 1] = new Cell(new Location(row, WIDTH - 1),
					Cell.Type.WALL);
		}
		for (int col = 0; col < WIDTH; col++)
		{
			cells[0][col] = new Cell(new Location(0, col), Cell.Type.WALL);
			cells[HEIGHT - 1][col] = new Cell(new Location(HEIGHT - 1, col),
					Cell.Type.WALL);

		}
		// Openings in the wall
		getCellAtLocation(entranceLocation).setType(Cell.Type.PATH);
		getCellAtLocation(exitLocation).setType(Cell.Type.PATH);
	}

	/**
	 * A setter constructor.
	 * 
	 * @param maze the maze to set
	 */
	public Maze(Cell[][] initCells)
	{
		this.cells = initCells;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param maze the maze to copy
	 */
	public Maze(Maze maze)
	{
		this(new Cell[HEIGHT][WIDTH]);

		for (int row = 0; row < this.cells.length; row++)
		{
			for (int col = 0; col < this.cells[0].length; col++)
			{
				cells[row][col] = new Cell(maze.cells[row][col]);
			}
		}
	}

	 /**
	 * A convenience method to print the maze grid.
	 */
	 public void print()
	 {
	 System.out.println("-----------");
	 for (int row = 0; row < HEIGHT; row++) {
	 System.out.println(Arrays.toString(cells[row]));
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
	public Cell getCellAtLocation(Location location)
	{
		return cells[location.getRow()][location.getColumn()];
	}

	/**
	 * @return the location to the right
	 * @throws IllegalArgumentException if there is no valid location to the
	 *                                  right
	 */
	public Cell getCellToRight(Cell cell) throws IllegalArgumentException
	{
		return getCellAtLocation(cell.getLocation().getLocationToRight());
	}

	/**
	 * @return the location to the left
	 * @throws IllegalArgumentException if there is no valid location to the
	 *                                  left
	 */
	public Cell getCellToLeft(Cell cell) throws IllegalArgumentException
	{
		return getCellAtLocation(cell.getLocation().getLocationToLeft());
	}

	/**
	 * @return the location above
	 * @throws IllegalArgumentException if there is no valid location above
	 */
	public Cell getCellAbove(Cell cell) throws IllegalArgumentException
	{
		return getCellAtLocation(cell.getLocation().getLocationAbove());
	}

	/**
	 * @return the location below
	 * @throws IllegalArgumentException if there is no valid location below
	 */
	public Cell getCellBelow(Cell cell) throws IllegalArgumentException
	{
		return getCellAtLocation(cell.getLocation().getLocationBelow());
	}

	/**
	 * A helper method to get a list of reachable cells from a point
	 * in a maze.
	 * 
	 * @param cells the maze
	 * @param point the point
	 * @return the list of points
	 */
	public LinkedList<Cell> getReachableCells(Cell cell)
	{
		LinkedList<Cell> reachableCells = new LinkedList<>();
		LinkedList<Cell> directions = new LinkedList<>();

		// check each direction. Note how it's 2 units since each cell could be
		// a wall as well
		try
		{
			directions.add(getCellAtLocation(cell.getLocation()
					.getLocationToLeft().getLocationToLeft()));
		}
		catch (IllegalArgumentException e)
		{
			// e.printStackTrace();
		}

		try
		{
			directions.add(getCellAtLocation(cell.getLocation()
					.getLocationToRight().getLocationToRight()));
		}
		catch (IllegalArgumentException e)
		{
			// e.printStackTrace();
		}

		try
		{
			directions.add(getCellAtLocation(
					cell.getLocation().getLocationAbove().getLocationAbove()));
		}
		catch (IllegalArgumentException e)
		{
			// e.printStackTrace();
		}

		try
		{
			directions.add(getCellAtLocation(
					cell.getLocation().getLocationBelow().getLocationBelow()));
		}
		catch (IllegalArgumentException e)
		{
			// e.printStackTrace();
		}

		// shuffle to make random paths
		// Collections.shuffle(Arrays.asList(directions));

		// check in each direction
		for (Cell direction : directions)
		{
			if (canBeAPath(direction)
					&& getCellAtLocation(direction.getLocation())
							.getType() != Cell.Type.PATH)
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
	 * 
	 *         TODO: anything that is not a WALL can be a PATH???
	 *         Rename?
	 */
	public boolean canBeAPath(Cell cell)
	{
		if (cell.getLocation().equals(entranceLocation)) return true;
		if (cell.getLocation().equals(exitLocation)) return true;

		// no borders besides exit and entrance can be a path
		// Outer perimeter should be walls
		if (cell.getLocation().isOuterPerimeter()) return false;

		return true;
	}
	
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
		getCellAtLocation(location).setType(Cell.Type.EVALUATING);
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
		getCellAtLocation(location).setType(Cell.Type.CURRENT);
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
		getCellAtLocation(location).setType(Cell.Type.SOLUTION);
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
		getCellAtLocation(location).setType(Cell.Type.WAITING);
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
		getCellAtLocation(location).setType(Cell.Type.VISITED);
	}
	
	/**
	 * Unmarks the cell to the original type.
	 * 
	 * @param location the location of the cell to unmark.
	 */
	public void unmark(Location location)
	{
		getCellAtLocation(location).undoSetType();
	}
	
	/**
	 * Sets the text at row and col to "L".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelLeft(Location location)
	{
		getCellAtLocation(location).setDirection(Direction.LEFT);
	}

	/**
	 * Sets the text at row and col to "R".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelRight(Location location)
	{
		getCellAtLocation(location).setDirection(Direction.RIGHT);
	}

	/**
	 * Sets the text at row and col to "U".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelUp(Location location)
	{
		getCellAtLocation(location).setDirection(Direction.UP);
	}

	/**
	 * Sets the text at row and col to "D".
	 * 
	 * @param row the row to set text at
	 * @param col the column to set text at
	 */
	public void setLabelDown(Location location)
	{
		getCellAtLocation(location).setDirection(Direction.DOWN);
	}

	@Override
	public String toString()
	{
		String returnValue = "";
		for (Cell[] row : cells)
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
	public Cell getEntranceCell()
	{
		return getCellAtLocation(entranceLocation);
	}

	/**
	 * Gets the exit location.
	 * 
	 * @return the exit location
	 */
	public Cell getExitCell()
	{
		return getCellAtLocation(exitLocation);
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
		return getCellAtLocation(location).getType() == Cell.Type.PATH;
	}

	/**
	 * @param currentLocation
	 * @return list of locations surrounding the current location that are not
	 *         walls
	 */
	public LinkedList<Cell> getSurroundingPossiblePaths(
			Location currentLocation)
	{
		LinkedList<Location> locations = currentLocation.getAdjacentLocations();
		LinkedList<Cell> possibleCells = new LinkedList<>();
		locations.stream()
				.filter(location -> getCellAtLocation(location)
						.getType() == Cell.Type.PATH)
				.forEach(location -> possibleCells
						.add(getCellAtLocation(location)));

		// OLD CODE
		// for (Location location : locations)
		// {
		// if (getCellAtLocation(location).getType() == Cell.Type.PATH)
		// {
		// possibleCells.add(getCellAtLocation(location));
		// }
		// }

		return possibleCells;
	}
}
