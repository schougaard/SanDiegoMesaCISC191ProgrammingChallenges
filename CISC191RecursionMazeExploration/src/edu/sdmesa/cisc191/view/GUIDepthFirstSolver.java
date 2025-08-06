/**
* Lead Author(s):
* @author a; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-08-06
*/
package edu.sdmesa.cisc191.view;

import edu.sdmesa.cisc191.controller.MazeController;
import edu.sdmesa.cisc191.model.Location;
import edu.sdmesa.cisc191.model.Maze;
import edu.sdmesa.cisc191.model.MazeSolver;

/**
 * Purpose: The responsibility of GUIDepthFirstSolver is ...
 *
 * GUIDepthFirstSolver is-a ...
 * GUIDepthFirstSolver is ...
 */

// TODO: should be MazeSolverGUI (or MazeSolverView) which has-a controller and has-a maze solver

public class GUIDepthFirstSolver extends MazeSolver
{
	
	private MazeController controller;
	
	public GUIDepthFirstSolver(Maze maze, MazeController controller)
	{
		super(maze);
		this.controller = controller;
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
		if (!controller.isPaused())
		{
			controller.togglePause();
		}
		controller.mazeCleared();
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
		
		try
		{
			Thread.sleep(controller.getMillis());
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		markAsVisited(currentLocation);
		return false;
	}

}
