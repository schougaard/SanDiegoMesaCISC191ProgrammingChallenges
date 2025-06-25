package edu.sdmesa.cisc191;

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
 * This class is the main app. It includes all the different GUI panels, the
 * maze, and all the controlling logic. This is the high-level code for the
 * different components of the app.
 */
public class MazeExplorer
{
	private MazeGUI mazeGUI;			// the maze GUI
	private ControlsGUI controlsGUI;	// the control panel GUI
	private MazeExplorerGUI gui;		// the maze explorer GUI
	private Maze ogMaze;				// the original maze
	private Maze maze;					// copy of the maze
	private MazeController controller; 	// the controller in MVC
	private MazeSolver solver;			// the DFS maze solver
	private Thread solverThread;		// the maze solver thread

	public MazeExplorer()
	{
		maze = MazeGenerator.generateMaze(MazeGenerator.Algorithm.PRIM, 20);
		setup();
	}

	public MazeExplorer(int seed)
	{
		maze = MazeGenerator.generateMaze(MazeGenerator.Algorithm.PRIM, 20, seed);
		setup();
	}
	
	private void setup()
	{
		ogMaze = new Maze(maze);
		mazeGUI = new MazeGUI(maze);
		controller = new MazeController(maze, mazeGUI, this);
		controlsGUI = new ControlsGUI(controller, this);
		controller.setControlsGUI(controlsGUI);
		gui = new MazeExplorerGUI(mazeGUI, controlsGUI);
		
		reset();
		runSolver();
	}
	
	/**
	 * Gets the maze solver.
	 * @return the DFS solver instance
	 */
	public MazeSolver getSolver()
	{
		return solver;
	}

	/**
	 * Gets the maze.
	 * @return the maze instance
	 */
	public Maze getMaze()
	{
		return maze;
	}

	/**
	 * Sets the maze.
	 * @param maze the maze instance
	 */
	public void setMaze(Maze maze)
	{
		this.maze = maze;
	}

	/**
	 * Gets the MazeGUI instance.
	 * @return the mazeGUI instance
	 */
	public MazeGUI getMazeGUI()
	{
		return mazeGUI;
	}

	/**
	 * Sets the MazeGUI instance.
	 * @param mazeGUI the mazeGUI instance
	 */
	public void setMazeGUI(MazeGUI mazeGUI)
	{
		this.mazeGUI = mazeGUI;
	}

	/**
	 * Gets the controller.
	 * @return the maze controller instance
	 */
	public MazeController getController()
	{
		return controller;
	}

	/**
	 * Sets the controller.
	 * @param controller the maze controller instance
	 */
	public void setController(MazeController controller)
	{
		this.controller = controller;
	}

	/**
	 * Gets the maze explorer GUI.
	 * @return the maze explorer GUI instance
	 */
	public MazeExplorerGUI getGui()
	{
		return gui;
	}

	/**
	 * Sets the maze explorer GUI
	 * @param gui the maze explorer GUI instance
	 */
	public void setGui(MazeExplorerGUI gui)
	{
		this.gui = gui;
	}
	
	/**
	 * Reset the whole app.
	 */
	public void reset() {
		if (solverThread != null) {
			solverThread.interrupt();
		}
		
		// keep checking to see if the recursion has returned
		try
		{
			while (solver != null && !solver.isCleared()) {
				Thread.sleep(5);
			}
			Thread.sleep(5);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		// reset everything else
		maze = new Maze(ogMaze);
		controller.setMaze(maze);
		mazeGUI.updateAllCells(maze);
		mazeGUI.clearAllLabels(maze);
		
		solver = new DFSSolver(maze, controller);
	}
	
	/**
	 * Solve the maze.
	 */
	public void runSolver() {
		if (solver == null) {
			return;
		}
		
		solverThread = new Thread(() -> {
			solver.solve();
		});
		
		solverThread.start();
	}
	
	/**
	 * Exit the app.
	 */
	public void exit() {
		solverThread.interrupt();
		gui.window.dispose();
	}
	
	public static void main(String[] args)
	{
		new MazeExplorer();
	}
}
