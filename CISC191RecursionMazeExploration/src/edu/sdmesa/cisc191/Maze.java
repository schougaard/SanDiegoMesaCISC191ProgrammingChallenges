package edu.sdmesa.cisc191;
import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;

/**
 * Lead Author(s):
 * @author Alex Chow
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 1.0
 */

/**
 * This class represents a maze logically. Meaning, all the data for the maze
 * is stored here, including what type each cell is, the exit point, the 
 * entrance point, and colors.
 */
public class Maze
{
	private CellType[][] maze;
	private int width;
	private int height;
	
	public static enum CellType {
		WALL,		// if this cell represents a wall
		PATH,		// if this cell represents a path
		FRONTIER,	// used for other algorithms like BFS, etc.
		VISITED,	// if this cell has been visited
		CURRENT,	// if we're currently on the cell
		CHECKING,	// if we're checking the cell
		SOLUTION,	// if this path is part of the solution
		WAITING,	// if this cell is waiting for a result
	}
	
	public final static Color WALL_COLOR = Color.black;
	public final static Color PATH_COLOR = Color.white;
	public final static Color VISITED_COLOR = Color.red;
	public final static Color CURRENT_COLOR = Color.blue;
	public final static Color SOLUTION_COLOR = Color.green;
	public final static Color CHECKING_COLOR = Color.lightGray;
	public final static Color WAITING_COLOR = Color.darkGray;
	
	/**
	 * A setter constructor.
	 * @param maze the maze to set
	 */
	public Maze(CellType[][] maze)
	{
		this.maze = maze;
		this.width = maze[0].length;
		this.height = maze.length;
	}
	
	/**
	 * Copy constructor.
	 * @param maze the maze to copy
	 */
	public Maze(Maze maze) {
		this(new CellType[maze.getHeight()][maze.getWidth()]);
		
		for (int row = 0; row < this.maze.length; row++) {
			for (int col = 0; col < this.maze[0].length; col++) {
				this.maze[row][col] = maze.getCellValueAt(row, col);
			}
		}
	}
	
	/**
	 * Gets the width of the maze.
	 * @return width of the maze
	 */
	public int getWidth() {
		return maze[0].length;
	}
	
	/**
	 * Gets the height of the maze.
	 * @return height of the maze
	 */
	public int getHeight() {
		return maze.length;
	}
	
	/**
	 * Get the cell type at the specified row and column.
	 * @param row the cell row
	 * @param col the cell column
	 * @return the cell type
	 */
	public CellType getCellValueAt(int row, int col) {
		return maze[row][col];
	}

	/**
	 * Convenience method to get the cell type at a specific point.
	 * @param point the point (column, row)
	 * @return the cell type
	 */
	public CellType getCellValueAt(Point point) {
		return getCellValueAt(point.y, point.x);
	}
	
	/**
	 * Mark a cell as some cell type. Namely, set the value of a cell in a
	 * 2D array to the specified value. If the operation was not successful,
	 * (e.g., because the point is invalid), then nothing will be done and
	 * the method will return false. Otherwise, return true.
	 * @param point the point that represents the column and row of a cell
	 * @param cellType the cell type to set
	 * @return whether the operation was successful
	 */
	public boolean markAs(Point point, CellType cellType) {
		return markAs(point.y, point.x, cellType);
	}
	
	/**
	 * Mark a cell as some cell type. Namely, set the value of a cell in a
	 * 2D array to the specified value. If the operation was not successful,
	 * (e.g., because the point is invalid), then nothing will be done and
	 * the method will return false. Otherwise, return true.
	 * @param row the cell row
	 * @param col the cell column
	 * @param cellType the cell type to set
	 * @return whether the operation was successful
	 */
	public boolean markAs(int row, int col, CellType cellType) {
		if (!isValidCell(row, col)) return false;
		
		maze[row][col] = cellType;
		return true;
	}
	
	/**
	 * Returns whether the cell at the specified point is valid (i.e.,
	 * outside of range or not). 
	 * @param point the point
	 * @return true if the cell is valid, false otherwise
	 */
	public boolean isValidCell(Point point) {
		return isValidCell(point.y, point.x);
	}
	
	/**
	 * Returns whether the cell at the specified point is valid (i.e.,
	 * outside of range or not). 
	 * @param row the cell row
	 * @param col the cell column
	 * @return true if the cell is valid, false otherwise
	 */
	public boolean isValidCell(int row, int col) {
		if (col < 0 || col >= width || row < 0 || row >= height) {
			return false;
		}

		return true;
	}
	
	/**
	 * Returns whether the cell at the specified point can be marked as a
	 * path. Takes a point as a parameter. See
	 * {@link #canBeAPath(int, int) canBeAPath}.
	 * @param point the point
	 * @return true if the cell can be a path; false otherwise.
	 */
	public boolean canBeAPath(Point point) {
		return canBeAPath(point.y, point.x);
	}
	
	/**
	 * Returns whether the cell at the specified point can be marked as a
	 * path. Takes row and column as parameters. The checks are:
	 * - Validity (within borders?)
	 * - If the cell is a designated entrance or exit cell
	 * - If the cell is on the border
	 * @param row the cell row
	 * @param col the cell column
	 * @return true if the cell can be a path; false otherwise
	 */
	public boolean canBeAPath(int row, int col)
	{
		if (!isValidCell(row, col)) return false;		// coords even in the maze?
		if (row == height - 1 && col == 1) return true;	// entrance
		if (row == 0 && col == width - 2) return true;	// exit
		
		// no borders besides exit and entrance can be a path
		if (row == 0 || col == 0 || row == height - 1 || col == width - 1) return false;
		
		return true;
	}

	/**
	 * A convenience method to print the maze grid.
	 */
	public void print() {
		System.out.println("-----------");
		for (int row = 0; row < height; row++) {
			System.out.println(Arrays.toString(maze[row]));
		}
	}
	
	/**
	 * Gets the entrance point.
	 * @return the entrance point
	 */
	public Point getEntrancePoint() {
		return new Point(1, height - 1);
	}
	
	/**
	 * Gets the exit point.
	 * @return the exit point
	 */
	public Point getExitPoint() {
		return new Point(width - 2, 0);
	}
	
	/**
	 * Returns whether the cell at the specified point is an exit.
	 * @param point the point
	 * @return true if the cell is an exit; false otherwise
	 */
	public boolean isExit(Point point) {
		return isExit(point.y, point.x);
	}

	/**
	 * Returns whether the cell at the specified point is an exit.
	 * @param row the cell row
	 * @param col the cell column
	 * @return true if the cell is an exit; false otherwise
	 */
	public boolean isExit(int row, int col)
	{
		Point exitPoint = getExitPoint();
		return exitPoint.y == row && exitPoint.x == col;
	}

	/**
	 * Returns whether the cell at the specified point is an entrance.
	 * @param point
	 * @return true if the cell is an entrance; false otherwise
	 */
	public boolean isEntrance(Point point) {
		return isEntrance(point.y, point.x);
	}

	/**
	 * Returns whether the cell at the specified point is an entrance.
	 * @param row
	 * @param col
	 * @return true if the cell is an exit; false otherwise
	 */
	public boolean isEntrance(int row, int col)
	{
		Point entrancePoint = getEntrancePoint();
		return entrancePoint.y == row && entrancePoint.x == col;
	}
	
	/**
	 * Returns whether the cell at the specified row and column is a path.
	 * @param row the cell row
	 * @param col the cell column
	 * @return true if the cell is a path; false otherwise
	 */
	public boolean isPath(int row, int col) {
		return isValidCell(row, col) && maze[row][col] == CellType.PATH;
	}
}
