package edu.sdmesa.cisc191.view;

import edu.sdmesa.cisc191.model.Location;
import edu.sdmesa.cisc191.model.Maze;
import edu.sdmesa.cisc191.model.MazeGenerator;
import edu.sdmesa.cisc191.model.MazeSolver;

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
 * This class is the main app. It includes all the different GUI panels, the
 * maze, and all the controlling logic. This is the high-level code for the
 * different components of the app.
 */
public class MazeExplorer
{
	private MazePanel mazeGUI; // the maze GUI
	private ControlPanel controlsGUI; // the control panel GUI
	private MazeExplorerGUI gui; // the maze explorer GUI
	private Maze ogMaze; // the original maze
	private Maze maze; // copy of the maze
	private MazeSolver solver; // the DFS maze solver
	private Thread solverThread; // the maze solver thread

	public MazeExplorer()
	{
		//maze = MazeGenerator.generateMaze(MazeGenerator.Algorithm.PRIM);
		maze = MazeGenerator.generateMaze(MazeGenerator.Algorithm.RANDOM);
		// = new Maze();
		System.out.println(maze);
		setup();
	}

	public MazeExplorer(int seed)
	{
		maze = MazeGenerator.generateMaze(MazeGenerator.Algorithm.PRIM, seed);
		setup();
	}

	private void setup()
	{
		solver = new GUIDepthFirstSolver(maze);
		ogMaze = new Maze(maze);
		mazeGUI = new MazePanel(maze);
		controlsGUI = new ControlPanel(this);
		gui = new MazeExplorerGUI(mazeGUI, controlsGUI);

		runSolver();
	}

	/**
	 * Gets the maze solver.
	 * 
	 * @return the DFS solver instance
	 */
	public MazeSolver getSolver()
	{
		return solver;
	}

	/**
	 * Gets the maze.
	 * 
	 * @return the maze instance
	 */
	public Maze getMaze()
	{
		return maze;
	}

	/**
	 * Sets the maze.
	 * 
	 * @param maze the maze instance
	 */
	public void setMaze(Maze maze)
	{
		this.maze = maze;
	}

	/**
	 * Gets the MazePanel instance.
	 * 
	 * @return the mazeGUI instance
	 */
	public MazePanel getMazeGUI()
	{
		return mazeGUI;
	}

	/**
	 * Sets the MazePanel instance.
	 * 
	 * @param mazeGUI the mazeGUI instance
	 */
	public void setMazeGUI(MazePanel mazeGUI)
	{
		this.mazeGUI = mazeGUI;
	}

	/**
	 * Gets the maze explorer GUI.
	 * 
	 * @return the maze explorer GUI instance
	 */
	public MazeExplorerGUI getGui()
	{
		return gui;
	}

	/**
	 * Sets the maze explorer GUI
	 * 
	 * @param gui the maze explorer GUI instance
	 */
	public void setGui(MazeExplorerGUI gui)
	{
		this.gui = gui;
	}

	/**
	 * Reset the whole app.
	 */
	public void reset()
	{
		if (solverThread != null)
		{
			solverThread.interrupt();
		}

		// keep checking to see if the recursion has returned
		try
		{
			while (solver != null && !solver.isCleared())
			{
				Thread.sleep(5);
			}
			Thread.sleep(5);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		// reset all maze cell types to original cell types
		for (int row = 0; row < maze.getHeight(); row++)
		{
			for (int col = 0; col < maze.getWidth(); col++)
			{
				Location loc = new Location(row, col);
				if (ogMaze.getCellAtLocation(loc).isPath())
				{
					maze.getCellAtLocation(loc)
							.setStatus(ogMaze.getCellAtLocation(loc).getStatus());
				}
			}
		}

		mazeGUI.updateCells();

		solver = new GUIDepthFirstSolver(maze);
	}

	/**
	 * Solve the maze.
	 */
	public void runSolver()
	{
		if (solver == null)
		{
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
	public void exit()
	{
		solverThread.interrupt();
		gui.getWindow().dispose();
		System.exit(0);
	}

	public static void main(String[] args)
	{
		new MazeExplorer();
	}
}
