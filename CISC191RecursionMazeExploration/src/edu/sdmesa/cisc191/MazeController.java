/**
 * Lead Author(s):
 * @author Alex Chow
 */
package edu.sdmesa.cisc191;

import java.awt.Color;
import java.util.concurrent.Semaphore;

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
 * This class is the controller between the application GUI and the backend
 * logic, which includes advancing the next step, waiting for some time,
 * pausing, unpausing, coloring cells, and resetting.
 */
public class MazeController
{	
	public final static int minWait = 1;
	public final static int maxWait = 1000;
	private final Semaphore stepSemaphore = new Semaphore(0); // locked
	
	private Maze maze;
	private MazeGUI gui;
	private ControlsGUI controlsGUI;
	private boolean paused = true;
	private int waitMillis = maxWait;
	private MazeExplorer explorer;
	
	public MazeController(Maze maze, MazeGUI gui, MazeExplorer explorer)
	{
		this.maze = maze;
		this.gui = gui;
		this.explorer = explorer;
	}
	
	/**
	 * Gets the control panel GUI.
	 * @return the control panel GUI
	 */
	public ControlsGUI getControlsGUI()
	{
		return controlsGUI;
	}
	
	/**
	 * Sets the control panel GUI.
	 * @param controlsGUI the control panel GUI
	 */
	public void setControlsGUI(ControlsGUI controlsGUI)
	{
		this.controlsGUI = controlsGUI;
	}
	
	/**
	 * Mark a cell as a specific cell type, then update and redraw it.
	 * @param row the cell row to mark
	 * @param col the cell column to mark
	 * @param cellType the cell type to mark the cell with
	 */
	public void markAsAndUpdateGUI(int row, int col, Maze.CellType cellType) {
		maze.markAs(row, col, cellType);
		gui.updateCell(maze, row, col);
		
		waitForNextStep();
	}
	
	/**
	 * Color a cell directly with a color
	 * @param row the cell row to color
	 * @param col the cell column to color
	 * @param color the color
	 */
	public void colorCell(int row, int col, Color color) {
		if (maze.isValidCell(row, col))
		{
			gui.colorCell(row, col, color);
		}
		waitForNextStep();
	}
	
	/**
	 * Color a cell with a cell type
	 * @param row the cell row to color
	 * @param col the cell column to color
	 * @param cellType the cell type to color the cell with
	 */
	public void colorCell(int row, int col, Maze.CellType cellType) {
		colorCell(row, col, gui.getColorFromCellType(cellType));
	}
	
	/**
	 * "Pause" this thread by acquiring a semaphore, or wait for some time
	 * if currently playing with some wait time amount.
	 */
	public void waitForNextStep() {
		if (waitMillis == 0) {
			return;
		}
		
		// if playing, then wait for a little
		if (!paused) {
			sleep(waitMillis);
		} else {
			try
			{
				stepSemaphore.acquire();
			}
			catch (InterruptedException e)
			{
				// preserve the interrupted status
	            Thread.currentThread().interrupt();
			}
		}
	}
	
	/**
	 * Get the color of a cell
	 * @param row the cell row
	 * @param col the cell column
	 * @return the color of the cell
	 */
	public Color getColorAt(int row, int col) {
		return gui.getColorAt(row, col);
	}
	
	/**
	 * Make this thread sleep for a specified amount of time.
	 * @param millis the time to wait in milliseconds
	 */
	private void sleep(int millis) {
		try
		{
			Thread.sleep(millis);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Proceed to the next step by releasing the semaphore.
	 */
	public void nextStep() {
		stepSemaphore.release(); // call this on "Next" button click
	}
	
	/**
	 * A convenience method to set the label for the cell at row and column.
	 * @param row the cell row
	 * @param col the cell column
	 * @param dir the direction as a String
	 */
	public void setLabelAt(int row, int col, String dir) {
		gui.setLabelAt(maze, row, col, dir);
	}
	
	/**
	 * Set the time to wait in milliseconds.
	 * @param millis the time in milliseconds
	 */
	public void setMillis(int millis) {
		waitMillis = millis;
	}
	
	/**
	 * Both logically toggle pausing and also update the GUI correspondingly.
	 */
	public void togglePause() {
		paused = !paused;
		if (!paused) {
			controlsGUI.disableButton(controlsGUI.getResetButton());
			controlsGUI.disableButton(controlsGUI.getStepButton());
			stepSemaphore.release();
		} else {
			controlsGUI.enableButton(controlsGUI.getResetButton());
			controlsGUI.enableButton(controlsGUI.getStepButton());
		}
		controlsGUI.togglePause();
	}
	
	/**
	 * Return whether the app is paused.
	 * @return true if paused; false otherwise
	 */
	public boolean isPaused() {
		return paused;
	}
	
	/**
	 * Reset the explorer. This resets the semaphore permits and also the
	 * explorer (reset all coloring, cell types, states, etc.)
	 */
	public void reset() {
		stepSemaphore.drainPermits();
		explorer.reset();
	}

	/**
	 * A setter for the maze field.
	 * @param maze the maze to set with
	 */
	public void setMaze(Maze maze)
	{
		this.maze = maze;
	}

	/**
	 * Get the time to wait in milliseconds.
	 * @return the time to wait in milliseconds
	 */
	public int getMillis()
	{
		return waitMillis;
	}
	
	/**
	 * Returns whether the maze has been cleared.
	 */
	public void mazeCleared() {
		controlsGUI.disableButton(controlsGUI.getStepButton());
		controlsGUI.disableButton(controlsGUI.getPauseButton());
	}
}
