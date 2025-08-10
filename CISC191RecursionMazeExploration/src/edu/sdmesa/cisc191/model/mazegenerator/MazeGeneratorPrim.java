package edu.sdmesa.cisc191.model.mazegenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import edu.sdmesa.cisc191.model.Location;
import edu.sdmesa.cisc191.model.Maze;

public class MazeGeneratorPrim extends MazeGenerator
{
	/**
	 * Generates a maze using Prim's algorithm.
	 * 
	 * @param width  width of the maze
	 * @param height height of the maze
	 * @return a Maze object
	 */
	public Maze generateMaze(int width, int height)
	{
		// 1. Start with a grid full of walls. "1" represents something there;
		// "0"
		// means nothing there. We start out with the maze being all 1s.
		Maze maze = new Maze();
		setToAllWalls(maze);

		ArrayList<Location> frontierList = new ArrayList<>();

		// 2. Start from a random cell in the maze. Mark it as a passage (0),
		// and add the cell to the "frontier" list (the list of candidate cells
		// to be picked in next iterations of this while loop)
		Location startLocation = maze.entranceLocation.getLocationAbove();
		maze.makeLocationPath(startLocation);
		frontierList.add(startLocation);

		// 3. While there are frontier cells in the list:
		do
		{
			// 3.1 Pick a random wall from the list. If the frontier cell can
			// expand,
			// then get the cells that the frontier cell can expand to.
			Location frontierLocation = pickRandomFromList(frontierList);
			LinkedList<Location> locationsToBeMarked = getReachableLocations(
					maze, frontierLocation);

			// 3.2. For each cell to be marked, mark them as passage (0).
			// In reality, it would probably only pick one cell at a time,
			// so this is poorly named.
			for (Location locationToBeMarked : locationsToBeMarked)
			{
				// first mark the reachable cell
				maze.makeLocationPath(locationToBeMarked);

				// then bridge the two cells together by carving a path in
				// between them
				Location inbetweenLocation = getLocationBetween(maze,
						frontierLocation, locationToBeMarked);
				maze.makeLocationPath(inbetweenLocation);
			}

			// we only remove the frontier path if it can't be expanded
			if (locationsToBeMarked.isEmpty())
			{
				frontierList.remove(frontierLocation);
			}
			else
			{
				// otherwise, add all frontier cells to frontier list
				frontierList.addAll(locationsToBeMarked);
			}

		} while (!frontierList.isEmpty());

		return maze;
	}

	/**
	 * A helper method to set all cells in a maze to a wall.
	 * For Prim's algorithm's purposes.
	 * 
	 * @param maze the maze
	 */
	private void setToAllWalls(Maze maze)
	{
		for (int row = 0; row < maze.getHeight(); row++)
		{
			for (int col = 0; col < maze.getWidth(); col++)
			{
				Location location = new Location(row, col);
				maze.makeLocationWall(location);
			}
		}
	}

	/**
	 * A helper method to get a list of reachable cells from a point
	 * in a maze.
	 * 
	 * @param cells the maze
	 * @param point the point
	 * @return the list of points
	 */
	private LinkedList<Location> getReachableLocations(Maze maze,
			Location location)
	{
		LinkedList<Location> reachableLocations = new LinkedList<>();
		LinkedList<Location> directions = new LinkedList<>();

		// check each direction. Note how it's 2 units since each cell could be
		// a wall as well
		if (location.hasLocationToLeft(2))
		{
			directions.add(location.getLocationToLeft().getLocationToLeft());
		}

		if (location.hasLocationToRight(2))
		{
			directions.add(location.getLocationToRight().getLocationToRight());
		}

		if (location.hasLocationAbove(2))
		{
			directions.add(location.getLocationAbove().getLocationAbove());
		}

		if (location.hasLocationBelow(2))
		{
			directions.add(location.getLocationBelow().getLocationBelow());
		}

		// shuffle to make random paths
		// Collections.shuffle(Arrays.asList(directions));

		// check in each direction
		for (Location direction : directions)
		{
			// don't add if it can't be a path or it already is a path
			if (canBeAPath(direction)
					&& !maze.getCellAtLocation(direction).isPath())
			{
				reachableLocations.add(direction);
			}
		}

		return reachableLocations;
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
	private boolean canBeAPath(Location location)
	{
		if (location.equals(Maze.entranceLocation)) return true;
		if (location.equals(Maze.exitLocation)) return true;

		// no borders besides exit and entrance can be a path
		// Outer perimeter should be walls
		if (location.isOuterPerimeter()) return false;

		return true;
	}

	/**
	 * A helper method to get cell in between two cells.
	 * 
	 * @param maze the maze
	 * @param a    first cell
	 * @param b    second cell
	 * @return the middle cell
	 */
	private Location getLocationBetween(Maze maze, Location a,
			Location b)
	{
		return new Location((a.getRow() + b.getRow()) / 2,
				(a.getColumn() + b.getColumn()) / 2);
	}

	/**
	 * Pick a random thing from a set.
	 * 
	 * @param set the generic typed set
	 * @return an object of type T from the set
	 */
	private <T> T pickRandomFromSet(Set<T> set)
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
	private <T> T pickRandomFromList(List<T> list)
	{
		if (list.size() == 0)
		{
			return null;
		}

		int index = (int) (MazeGeneratorFactory.randomIndexPicker
				.nextInt(list.size()));
		return list.get(index);
	}
}
