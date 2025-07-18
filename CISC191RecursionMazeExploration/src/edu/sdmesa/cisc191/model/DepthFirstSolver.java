package edu.sdmesa.cisc191.model;

import java.awt.Point;

import edu.sdmesa.cisc191.view.MazeController;

/**
 * Lead Author(s):
 * 
 * @author
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date:
 * 
 *         Responsibilities of class:
 * 
 */

// TODO: implement and remove all TODOs

public class DepthFirstSolver extends MazeSolver
{
	public DepthFirstSolver(Maze maze, MazeController controller)
	{
		super(maze, controller);
	}

	/**
	 * The high-level method to get a path in maze from entrance to exit.
	 */
	public void solve()
	{
		Location startLocation = getMaze().getEntranceCell().getLocation();

		/////// DO NOT TOUCH ANY LINES ABOVE
		// TODO: call the recursive method
		solveRecursive(startLocation);

		/////// DO NOT TOUCH ANY LINES BELOW

		// set cleared flag when recursion is done
		setCleared(true);
		if (!getMazeController().isPaused())
		{
			getMazeController().togglePause();
		}
		getMazeController().mazeCleared();
	}

	/**
	 * The recursive algorithm to solve a maze.
	 * 
	 * @param row the row to start solving the maze from
	 * @param col the column to start solving the maze from
	 * @return true if a path can be found. false if not
	 */
	public boolean solveRecursive(Location currentLocation)
	{
		if (Thread.currentThread().isInterrupted())
		{
			return false;
		}

		// mark as currently on this cell
		setCurrentLocation(currentLocation);

		/////// DO NOT TOUCH ANY LINES ABOVE
		// TODO: complete the recursive algorithm below
		if (getMaze().isExit(currentLocation))
		{
			markAsSolution(currentLocation);
			return true;
		}

		setLabelRight(currentLocation);
		try
		{
			if (isPath(currentLocation.getLocationToRight()))
			{
				markAsWaiting(currentLocation);
				if (solveRecursive(currentLocation.getLocationToRight()))
				{
					markAsSolution(currentLocation);
					return true;
				}
				else
				{
					setCurrentLocation(currentLocation);
				}
			}
		}
		catch (Exception e)
		{

		}

		setLabelLeft(currentLocation);
		try
		{
			if (isPath(currentLocation.getLocationToLeft()))
			{
				markAsWaiting(currentLocation);
				if (solveRecursive(currentLocation.getLocationToLeft()))
				{
					markAsSolution(currentLocation);
					return true;
				}
				else
				{
					setCurrentLocation(currentLocation);
				}
			}
		}
		catch (Exception e)
		{

		}

		setLabelDown(currentLocation);
		try
		{
			if (isPath(currentLocation.getLocationBelow()))
			{
				markAsWaiting(currentLocation);
				if (solveRecursive(currentLocation.getLocationBelow()))
				{
					markAsSolution(currentLocation);
					return true;
				}
				else
				{
					setCurrentLocation(currentLocation);
				}
			}
		}
		catch (Exception e)
		{

		}

		setLabelUp(currentLocation);
		try
		{
			if (isPath(currentLocation.getLocationAbove()))
			{
				markAsWaiting(currentLocation);
				if (solveRecursive(currentLocation.getLocationAbove()))
				{
					markAsSolution(currentLocation);
					return true;
				}
				setCurrentLocation(currentLocation);
			}
		}
		catch (Exception e)
		{

		}

		return false;
	}
}
