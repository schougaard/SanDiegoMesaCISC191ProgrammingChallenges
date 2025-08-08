package edu.sdmesa.cisc191.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
 * This class contains methods to generate mazes procedurally. As of the
 * current version, it supports two algorithms: Random and Prim's algorithm.
 * The random algorithm does not really generate a maze; it simply randomly
 * selects cells to be walls/paths. The mazes generated using Prim's algorithm
 * look like mazes. You can also use a seed to generate the same maze for
 * testing purposes.
 * MazeGenerator is a factory of mazes;
 * https://en.wikipedia.org/wiki/Factory_method_pattern
 */
public class MazeGenerator
{
	public static Random randomIndexPicker;

	public static enum Algorithm
	{
		PRIM, RANDOM,
	}

	/**
	 * Generate a maze with a given algorithm and dimension
	 * 
	 * @param algo      the algorithm
	 * @param dimension the size of one side of the maze
	 * @return a Maze object
	 */
	public static Maze generateMaze(Algorithm algo)
	{
		int seed = (int) (Math.random() * Integer.MAX_VALUE);
		randomIndexPicker = new Random(seed);

		return generateMaze(algo, seed);
	}

	/**
	 * Generate a maze with a given algorithm, width, height, and seed.
	 * 
	 * @param algo   the algorithm
	 * @param width  the width of the maze
	 * @param height the height of the maze
	 * @param seed   the random seed
	 * @return a Maze object
	 */
	public static Maze generateMaze(Algorithm algo, int seed)
	{
		int width = Maze.WIDTH;
		int height = Maze.HEIGHT;
		randomIndexPicker = new Random(seed);

		// make width an odd number
		if (width % 2 == 0)
		{
			width--;
		}

		// make height an odd number
		if (height % 2 == 0)
		{
			height--;
		}

		Maze maze;
		switch (algo)
		{
			case PRIM:
				maze = generateMazePrim(width, height);
				break;
			case RANDOM:
				maze = generateMazeRandom(width, height, seed);
				break;
			default:
				// no algorithm specified, so all empty, but with walls
				maze = new Maze();
		}

		// carve out the entrance and exit
		maze.getEntranceCell().setType(Cell.Type.PATH);
		maze.getExitCell().setType(Cell.Type.PATH);

		return maze;
	}

	/**
	 * Generates a maze randomly. It's practically not a maze.
	 * 
	 * @param width  width of the maze
	 * @param height height of the maze
	 * @param seed   a random seed
	 * @return a Maze object
	 */
	private static Maze generateMazeRandom(int width, int height, int seed)
	{
		Cell[][] mazeData = new Cell[height][width];

		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				mazeData[row][col] = (int) (Math.random() * 10) < 3
						? new Cell(new Location(row, col), Cell.Type.WALL)
						: new Cell(new Location(row, col), Cell.Type.PATH);
			}
		}

		Maze maze = new Maze(mazeData);

		return maze;
	}

	/**
	 * Generates a maze using Prim's algorithm.
	 * 
	 * @param width  width of the maze
	 * @param height height of the maze
	 * @return a Maze object
	 */
	private static Maze generateMazePrim(int width, int height)
	{
		// 1. Start with a grid full of walls. "1" represents something there;
		// "0"
		// means nothing there. We start out with the maze being all 1s.
		Maze maze = new Maze();
		setToAllWalls(maze);

		ArrayList<Cell> frontierList = new ArrayList<>();

		// 2. Start from a random cell in the maze. Mark it as a passage (0),
		// and add the cell to the "frontier" list (the list of candidate cells
		// to be picked in next iterations of this while loop)
		Cell startCell = maze.getCellAbove(maze.getEntranceCell());
		startCell.setType(Cell.Type.PATH); // left
		frontierList.add(startCell);

		// 3. While there are frontier cells in the list:
		while (!frontierList.isEmpty())
		{
			// 3.1 Pick a random wall from the list. If the frontier cell can
			// expand,
			// then get the cells that the frontier cell can expand to.
			Cell frontierCell = pickRandomFromList(frontierList);
			LinkedList<Cell> cellsToBeMarked = maze
					.getReachableCells(frontierCell);

			// 3.2. For each cell to be marked, mark them as passage (0).
			// In reality, it would probably only pick one cell at a time,
			// so this is poorly named.
			for (Cell cellToBeMarked : cellsToBeMarked)
			{
				// first mark the reachable cell
				cellToBeMarked.setType(Cell.Type.PATH);

				// then bridge the two cells together by carving a path in
				// between them
				getCellBetween(maze, frontierCell, cellToBeMarked)
						.setType(Cell.Type.PATH);
			}

			// we only remove the frontier path if it can't be expanded
			if (cellsToBeMarked.isEmpty())
			{
				frontierList.remove(frontierCell);
			}
			else
			{
				// otherwise, add all frontier cells to frontier list
				frontierList.addAll(cellsToBeMarked);
			}

		}

		return maze;
	}

	/**
	 * A helper method to set all cells in a maze to a wall.
	 * For Prim's algorithm's purposes.
	 * 
	 * @param maze the maze
	 */
	private static void setToAllWalls(Maze maze)
	{
		for (int row = 0; row < maze.getHeight(); row++)
		{
			for (int col = 0; col < maze.getWidth(); col++)
			{
				maze.getCellAtLocation(new Location(row, col))
						.setType(Cell.Type.WALL);
			}
		}
	}

	/**
	 * A helper method to get cell in between two cells.
	 * 
	 * @param maze the maze
	 * @param a    first cell
	 * @param b    second cell
	 * @return the middle cell
	 */
	private static Cell getCellBetween(Maze maze, Cell a, Cell b)
	{
		return maze.getCellAtLocation(new Location(
				(a.getLocation().getRow() + b.getLocation().getRow()) / 2,
				(a.getLocation().getColumn() + b.getLocation().getColumn())
						/ 2));
	}

	/**
	 * Pick a random thing from a set.
	 * 
	 * @param set the generic typed set
	 * @return an object of type T from the set
	 */
	private static <T> T pickRandomFromSet(Set<T> set)
	{
		if (set.size() == 0)
		{
			return null;
		}

		int index = (int) (Math.random() * set.size());

		// for loop is required since a set has no notion of indices
		int i = 0;
		for (T element : set)
		{
			if (i == index) return element;
			i++;
		}

		return null;
	}

	/**
	 * Pick a random thing from a list.
	 * 
	 * @param list the generic typed list
	 * @return an object of type T from the list
	 */
	private static <T> T pickRandomFromList(List<T> list)
	{
		if (list.size() == 0)
		{
			return null;
		}

		int index = (int) (randomIndexPicker.nextInt(list.size()));
		return list.get(index);
	}
}
