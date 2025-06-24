package edu.sdmesa.cisc191;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
 * This class contains methods to generate mazes procedurally. As of the
 * current version, it supports two algorithms: Random and Prim's algorithm.
 * The random algorithm does not really generate a maze; it simply randomly
 * selects cells to be walls/paths. The mazes generated using Prim's algorithm
 * look like mazes. You can also use a seed to generate the same maze for
 * testing purposes.
 */
public class MazeGenerator
{
	public static Random randomIndexPicker;
	public static enum Algorithm {
		PRIM,
		RANDOM,
	}
	
	/**
	 * Generate a maze with a given algorithm and dimension
	 * @param algo the algorithm
	 * @param dimension the size of one side of the maze
	 * @return a Maze object
	 */
	public static Maze generateMaze(Algorithm algo, int dimension) {
		int seed = (int)(Math.random() * Integer.MAX_VALUE);
		randomIndexPicker = new Random(seed);
		
		return generateMaze(algo, dimension, seed);
	}
	
	/**
	 * Generate a maze with a given algorithm, dimension, and seed
	 * @param algo the algorithm
	 * @param dimension the size of one side of the maze
	 * @param seed the random seed
	 * @return a Maze object
	 */
	public static Maze generateMaze(Algorithm algo, int dimension, int seed) {
		randomIndexPicker = new Random(seed);
		
		return generateMaze(algo, dimension, dimension, seed);
	}
	
	/**
	 * Generate a maze with a given algorithm, width, height, and seed.
	 * @param algo the algorithm
	 * @param width the width of the maze
	 * @param height the height of the maze
	 * @param seed the random seed
	 * @return a Maze object
	 */
	public static Maze generateMaze(Algorithm algo, int width, int height, int seed) {
		if (width < 5) {
			throw new IllegalArgumentException("Width must be at least 5!");
		}
		
		if (height < 5) {
			throw new IllegalArgumentException("Height must be at least 5!");
		}
		
		// make width an odd number
		if (width % 2 == 0) {
			width--;
		}
		
		// make height an odd number
		if (height % 2 == 0) {
			height--;
		}
		
		Maze maze;
		switch (algo) {
			case PRIM:
				maze = generateMazePrim(width, height);
				break;
			case RANDOM:
				maze = generateMazeRandom(width, height, seed);
				break;
			default:
				// no algorithm specified, so all empty
				maze = new Maze(new Maze.CellType[height][width]);
		}
		
		// carve out the entrance and exit
		maze.markAs(maze.getEntrancePoint(), Maze.CellType.PATH);
		maze.markAs(maze.getExitPoint(), Maze.CellType.PATH);
		
		return maze;
	}

	/**
	 * Generates a maze randomly. It's practically not a maze.
	 * @param width width of the maze
	 * @param height height of the maze
	 * @param seed a random seed
	 * @return a Maze object
	 */
	private static Maze generateMazeRandom(int width, int height, int seed)
	{
		Maze.CellType[][] mazeData = new Maze.CellType[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				mazeData[row][col] = (int)(Math.random() * 10) < 3 ? Maze.CellType.WALL : Maze.CellType.PATH;
			}
		}
		
		Maze maze = new Maze(mazeData);
		
		return maze;
	}

	/**
	 * Generates a maze using Prim's algorithm.
	 * @param width width of the maze
	 * @param height height of the maze
	 * @return a Maze object
	 */
	private static Maze generateMazePrim(int width, int height)
	{
		// 1. Start with a grid full of walls. "1" represents something there; "0"
		//    means nothing there. We start out with the maze being all 1s.
		Maze.CellType[][] mazeData = initMazeWithWalls(width, height);
		Maze maze = new Maze(mazeData);
		ArrayList<Point> frontierSet = new ArrayList<>();
		
		// 2. Start from a random cell in the maze. Mark it as a passage (0), 
		//    and add the cell to the "frontier" list (the list of candidate cells
		//    to be picked in next iterations of this while loop)
		Point startCell = new Point(1, height - 2);  // second-to-last row, 2nd from left
		maze.markAs(startCell, Maze.CellType.PATH);
		frontierSet.add(startCell);
		
		// 3. While there are frontier cells in the list:
		while (!frontierSet.isEmpty()) {
			// 3.1 Pick a random wall from the list. If the frontier cell can expand,
			//     then get the cells that the frontier cell can expand to.
			Point frontierCell = (Point)pickRandomFromList(frontierSet);
			ArrayList<Point> cellsToBeMarked = getReachableCells(maze, frontierCell);
			
			// 3.2. For each cell to be marked, mark them as passage (0).
			//      In reality, it would probably only pick one cell at a time,
			//      so this is poorly named.
			for (Point cellToBeMarked : cellsToBeMarked) {
				// first mark the reachable cell
				maze.markAs(cellToBeMarked, Maze.CellType.PATH);
				
				// then bridge the two cells together by carving a path in between them
				maze.markAs(getCellBetween(frontierCell, cellToBeMarked), Maze.CellType.PATH);
			}
				
			// we only remove the frontier path if it can't be expanded
			if (cellsToBeMarked.isEmpty()) {
				frontierSet.remove(frontierCell);
			} else {
				// otherwise, add all frontier cells to frontier list
				frontierSet.addAll(cellsToBeMarked);
			}
		}
		
		return maze;
	}
	
	/**
	 * A helper method to get cell in between two points.
	 * @param a first point
	 * @param b second point
	 * @return the middle point
	 */
	private static Point getCellBetween(Point a, Point b)
	{
		return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
	}

	/**
	 * Initializes the maze with walls. A helper method for Prim's algorithm.
	 * @param width width of the maze
	 * @param height height of the maze
	 * @return a 2D array of cell types
	 */
	private static Maze.CellType[][] initMazeWithWalls(int width, int height) {
		Maze.CellType[][] maze = new Maze.CellType[height][width];
		
		for (int row = 0; row < maze[0].length; row++) {
			for (int col = 0; col < maze.length; col++) {
				maze[row][col] = Maze.CellType.WALL;
			}
		}
		
		return maze;
	}
	
	/**
	 * Pick a random thing from a set.
	 * @param set the generic typed set
	 * @return an object of type T from the set
	 */
	private static <T> T pickRandomFromSet(Set<T> set) {
		if (set.size() == 0) {
			return null;
		}
		
		int index = (int)(Math.random() * set.size());
		
		// for loop is required since a set has no notion of indices
		int i = 0;
		for (T element : set) {
			if (i == index) return element;
			i++;
		}
		
		return null;
	}

	/**
	 * Pick a random thing from a list.
	 * @param list the generic typed list
	 * @return an object of type T from the list
	 */
	private static <T> T pickRandomFromList(List<T> list) {
		if (list.size() == 0) {
			return null;
		}
		
		int index = (int)(randomIndexPicker.nextInt(list.size()));
		return list.get(index);
	}
	
	/**
	 * A helper method to get a list of reachable cells from a point
	 * in a maze.
	 * @param maze the maze
	 * @param point the point
	 * @return the list of points
	 */
	private static ArrayList<Point> getReachableCells(Maze maze, Point point) {
		ArrayList<Point> reachableCells = new ArrayList<>();
		
		// check each direction. Note how it's 2 units since each cell could be a wall as well
		Point[] directions = {
			new Point(point.x - 2, point.y),	// left
			new Point(point.x + 2, point.y),	// right
			new Point(point.x, point.y - 2),	// up
			new Point(point.x, point.y + 2)		// down
		};
		
		// shuffle to make random paths
//		Collections.shuffle(Arrays.asList(directions));
		
		// check in each direction
		for (Point direction : directions) {
			if (maze.canBeAPath(direction) && maze.getCellValueAt(direction) != Maze.CellType.PATH) {
				reachableCells.add(direction);
			}
		}
		
		return reachableCells;
	}
}
