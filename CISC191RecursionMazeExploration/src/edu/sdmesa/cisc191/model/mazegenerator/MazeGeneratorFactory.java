package edu.sdmesa.cisc191.model.mazegenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import edu.sdmesa.cisc191.model.Maze;

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
 * MazeGeneratorFactory is a factory of mazes;
 * https://en.wikipedia.org/wiki/Factory_method_pattern
 */
public class MazeGeneratorFactory
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
		MazeGenerator mazeGenerator;

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
				mazeGenerator = new MazeGeneratorPrim();
				break;
			case RANDOM:
				mazeGenerator = new MazeGeneratorRandom();
				break;
			default:
				// no algorithm specified, so all empty, but with walls
				mazeGenerator = new MazeGeneratorDefault();
		}
		
		// generate the maze
		maze = mazeGenerator.generateMaze(width, height);

		// carve out the entrance and exit
		maze.makeLocationPath(maze.entranceLocation);
		maze.makeLocationPath(maze.exitLocation);

		return maze;
	}
}
