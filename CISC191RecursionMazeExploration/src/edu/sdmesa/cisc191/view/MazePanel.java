package edu.sdmesa.cisc191.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.sdmesa.cisc191.model.Location;
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
 * This class is the GUI for the maze. It includes a grid layout and methods
 * to update drawing and coloring cells, as well as labeling cells.
 */
public class MazePanel extends JPanel
{
	// A maze GUI has-many cells
	private CellWidget[][] grid;

	public MazePanel(Maze initMaze)
	{
		setPreferredSize(new Dimension(600, 600));
		setupMazeGUI(initMaze);
	}

	/**
	 * Set up the maze part of the GUI (the grid).
	 * 
	 * @param maze the maze to initialize GUI with
	 */
	private void setupMazeGUI(Maze initMaze)
	{
		int width = initMaze.getWidth();
		int height = initMaze.getHeight();

		// set up grid
		setLayout(new GridLayout(height, width));
		grid = new CellWidget[height][width];
		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				// add cell to both the internal grid and the panel
				CellWidget cell = new CellWidget(initMaze.getCellAtLocation(new Location(row, col)));
				cell.update();
				add(cell);
			}
		}
		updateCells();
	}


	/**
	 * Update by redrawing all cells.
	 * 
	 * @param maze the maze to update cells
	 */
	public void updateCells()
	{
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[row].length; col++)
			{
				grid[row][col].update();
			}
		}
	}


	/**
	 * Sets the text of the label at the cell to the specified string.
	 * 
	 * @param maze the maze
	 * @param row  cell row
	 * @param col  cell column
	 * @param dir  the direction String ("L", "R", "U", "D")
	 */
	public void setLabelAt(Location location, String dir)
	{
		invokeAndWait(() -> {
			grid[location.getRow()][location.getColumn()].setText(dir);
		});
	}

	public void waitForGUI()
	{
		try
		{
			SwingUtilities.invokeAndWait(() -> {
			});
		}
		catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void invokeAndWait(Runnable r)
	{
		SwingUtilities.invokeLater(r);
		// try
		// {
		// }
		// catch (InvocationTargetException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// catch (InterruptedException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
