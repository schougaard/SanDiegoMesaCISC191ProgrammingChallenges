package edu.sdmesa.cisc191;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
 * This class is the GUI for the maze. It includes a grid layout and methods
 * to update drawing and coloring cells, as well as labeling cells.
 */
public class MazeGUI extends JPanel
{
	// the grid of panels for maze
	private JPanel[][] grid;
	private Maze maze;
	
	public MazeGUI(Maze maze)
	{
		this.maze = maze;
		setPreferredSize(new Dimension(600, 600));
		setupMazeGUI(maze);
	}

	/**
	 * Set up the maze part of the GUI (the grid).
	 * @param maze the maze to initialize GUI with
	 */
	private void setupMazeGUI(Maze maze)
	{
		int width = maze.getWidth();
		int height = maze.getHeight();
		
		// set up grid
		setLayout(new GridLayout(height, width));
		grid = new JPanel[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				// create a new JPanel to represent each cell in GUI
				JPanel cell = new JPanel();
				JLabel label = new JLabel("");
				label.setForeground(Color.white);
				cell.add(label);
				
				// add cell to both the internal grid and the panel
				grid[row][col] = cell;
				updateCell(maze, new Location(row, col));
				add(cell);
			}
		}
	}
	
	/**
	 * Update by redrawing one cell due to out of sync between cell type and
	 * cell color.
	 * @param maze the maze
	 * @param row the cell row
	 * @param col the cell column
	 */
	public void updateCell(Maze maze, Location location)
	{		
		Color cellColor = getColorFromCellType(maze.getCellValueAt(location));
		
		invokeAndWait(() -> {
			grid[location.getRow()][location.getColumn()].setBackground(cellColor);
		});
	}
	
	/**
	 * Update by redrawing all cells.
	 * @param maze the maze to update cells
	 */
	public void updateAllCells(Maze maze)
	{
		for (int row = 0; row < maze.getHeight(); row++) {
			for (int col = 0; col < maze.getWidth(); col++) {
				updateCell(maze, new Location(row, col));
			}
		}
	}
	
	/**
	 * Clear all labels/texts.
	 * @param maze the maze to clear all labels
	 */
	public void clearAllLabels(Maze maze)
	{
		invokeAndWait(() -> {
			for (int row = 0; row < maze.getHeight(); row++) {
				for (int col = 0; col < maze.getWidth(); col++) {
					((JLabel)grid[row][col].getComponent(0)).setText("");
				}
			}
		});
	}
	
	/**
	 * Gets the color from cell type.
	 * @param cellType the cell type
	 * @return the color corresponding to the given cell type.
	 */
	public Color getColorFromCellType(Maze.CellType cellType)
	{
		switch (cellType){
			case WALL:
				return Maze.WALL_COLOR;
			case CHECKING:
				return Maze.CHECKING_COLOR;
			case CURRENT:
				return Maze.CURRENT_COLOR;
			case PATH:
				return Maze.PATH_COLOR;
			case SOLUTION:
				return Maze.SOLUTION_COLOR;
			case VISITED:
				return Maze.VISITED_COLOR;
			case WAITING:
				return Maze.WAITING_COLOR;
			case FRONTIER:
			default:
				return Color.pink;
		}
	}
	
	/**
	 * A convenience method to color a cell with a color directly.
	 * @param row cell row to color
	 * @param col cell column to color
	 * @param color the color
	 */
	public void colorCell(Location location, Color color)
	{
		invokeAndWait(() -> {
			grid[location.getRow()][location.getColumn()].setBackground(color);
		});
	}
	
	/**
	 * A convenience method to color a cell with a specific cell type.
	 * @param row cell row to color
	 * @param col cell column to color
	 * @param cellType the cell type
	 */
	public void colorCell(Location location, Maze.CellType cellType)
	{
		colorCell(location, getColorFromCellType(cellType));
	}
	
	/**
	 * Return the cell color.
	 * @param row cell row
	 * @param col cell column
	 * @return the cell Color
	 */
	public Color getColorAt(Location location)
	{
		return grid[location.getRow()][location.getColumn()].getBackground();
	}
	
	/**
	 * Sets the text of the label at the cell to the specified string. 
	 * @param maze the maze
	 * @param row cell row
	 * @param col cell column
	 * @param dir the direction String ("L", "R", "U", "D")
	 */
	public void setLabelAt(Maze maze, Location location, String dir)
	{
		JLabel label = (JLabel)grid[location.getRow()][location.getColumn()].getComponent(0);
		
		invokeAndWait(() -> {
			label.setText(dir);
		});
	}
	
	public void waitForGUI()
	{
		try
		{
			SwingUtilities.invokeAndWait(() -> {});
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
//		try
//		{
//		}
//		catch (InvocationTargetException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (InterruptedException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
