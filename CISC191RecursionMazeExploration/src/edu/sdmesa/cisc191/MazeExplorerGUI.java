package edu.sdmesa.cisc191;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
 * This class is the main GUI of the app. It contains the maze and the control
 * panel GUI.
 */
public class MazeExplorerGUI
{
	private JFrame window;
	private JPanel mainContainer;
	
	private MazeGUI mazeGUI;			// has-a maze GUI
	private ControlsGUI controlsGUI;	// has-a control panel GUI
	
	public MazeExplorerGUI(MazeGUI mazeGUI, ControlsGUI controlsGUI)
	{
		this.mazeGUI = mazeGUI;
		this.controlsGUI = controlsGUI;
		
		setupMainContainer();
		setupWindow();
	}

	/**
	 * Gets the main window of the app.
	 * @return the main window
	 */
	public JFrame getWindow() {
		return window;
	}

	/**
	 * Gets the main container of the app, which contains the maze GUI and
	 * the control panel GUI.
	 * @return the main container
	 */
	public JPanel getMainContainer() {
		return mainContainer;
	}

	/**
	 * Gets the interactive maze GUI.
	 * @return the maze GUI
	 */
	public MazeGUI getMazeGUI() {
		return mazeGUI;
	}

	/**
	 * Gets the control panel GUI.
	 * @return the control panel GUI
	 */
	public ControlsGUI getControlsGUI() {
		return controlsGUI;
	}

	/**
	 * The method for setting up the main app GUI.
	 */
	private void setupWindow()
	{
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(mainContainer);
		window.setTitle("Marza the Explorer");
		window.pack();
		window.setVisible(true);
	}
	
	/**
	 * The method for setting up the main container, which contains the maze
	 * GUI and the control panel GUI.
	 */
	private void setupMainContainer()
	{
		mainContainer = new JPanel(new BorderLayout());
		mainContainer.add(mazeGUI, BorderLayout.CENTER);
		mainContainer.add(controlsGUI, BorderLayout.EAST);
	}
}
