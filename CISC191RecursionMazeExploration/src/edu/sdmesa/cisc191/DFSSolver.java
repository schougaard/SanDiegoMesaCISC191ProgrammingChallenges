package edu.sdmesa.cisc191;
import java.awt.Point;

/**
 * Lead Author(s):
 * @author 
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * 
 */

//TODO: implement and remove all TODOs

public class DFSSolver extends MazeSolver
{	
	public DFSSolver(Maze maze, MazeController controller)
	{
		super(maze, controller);
	}
	
	/**
	 * The high-level method to get a path in maze from entrance to exit.
	 */
	public void solve() {
		Point startPoint = getMaze().getEntrancePoint();
		int startRow = startPoint.y;
		int startCol = startPoint.x;
		
		/////// DO NOT TOUCH ANY LINES ABOVE
		// TODO: call the recursive method

		
		/////// DO NOT TOUCH ANY LINES BELOW
		
		// set cleared flag when recursion is done
        setCleared(true);
    	if (!getMazeController().isPaused()) {
    		getMazeController().togglePause();
    	}
    	getMazeController().mazeCleared();
	}	
	
	/**
	 * The recursive algorithm to solve a maze.
	 * @param row the row to start solving the maze from
	 * @param col the column to start solving the maze from
	 * @return true if a path can be found. false if not
	 */
	public boolean solveRecursive(int row, int col) {
		if (Thread.currentThread().isInterrupted()) {
	        return false;
	    }
		
		// mark as currently on this cell
		colorAsCurrent(row, col);
		
		/////// DO NOT TOUCH ANY LINES ABOVE
		// TODO: complete the recursive algorithm below
		
		return false;
	}
}
