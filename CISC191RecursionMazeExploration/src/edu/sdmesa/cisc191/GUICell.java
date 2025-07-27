/**
 * Lead Author(s):
 * 
 * @author a; student ID
 * @author Full name; student ID
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         <<Add more references here>>
 *
 *         Version: 2025-07-15
 */
package edu.sdmesa.cisc191;

import java.awt.Color;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.sdmesa.cisc191.Maze.CellType;

/**
 * Purpose: The responsibility of GUICell is to display a cell in the maze
 *
 * GUICell is-a JPanel
 */
public class GUICell extends JPanel
{
	/**
	 * A GUICell has-a location in a maze
	 */
	private Location location;

	/**
	 * A GUICell has-a maze
	 */
	private Maze maze;

	/**
	 * A GUICell has-a label to show letters
	 */
	private JLabel label;

	private final static Color WALL_COLOR = Color.black;
	private final static Color PATH_COLOR = Color.white;
	private final static Color VISITED_COLOR = Color.red;
	private final static Color CURRENT_COLOR = Color.blue;
	private final static Color SOLUTION_COLOR = Color.green;
	private final static Color EVALUATING_COLOR = Color.lightGray;
	private final static Color WAITING_COLOR = Color.darkGray;
	private final static Color FRONTIER_COLOR = Color.pink;

	private final static Hashtable<CellType, Color> cellType2Color = new Hashtable<CellType, Color>();
	static
	{
		cellType2Color.put(CellType.WALL, WALL_COLOR);
		cellType2Color.put(CellType.PATH, PATH_COLOR);
		cellType2Color.put(CellType.FRONTIER, FRONTIER_COLOR);
		cellType2Color.put(CellType.VISITED, VISITED_COLOR);
		cellType2Color.put(CellType.CURRENT, CURRENT_COLOR);
		cellType2Color.put(CellType.EVALUATING, EVALUATING_COLOR);
		cellType2Color.put(CellType.SOLUTION, SOLUTION_COLOR);
		cellType2Color.put(CellType.WAITING, WAITING_COLOR);
	}

	public GUICell(Maze initMaze, Location initLocation)
	{
		maze = initMaze;
		location = initLocation;

		label = new JLabel("");
		label.setForeground(Color.white);
		add(label);
	}

	public void setText(String text)
	{
		label.setText(text);
	}

	public void update()
	{
		setBackground(cellType2Color.get(maze.getCellValueAt(location)));
		label.setText(
				String.valueOf(maze.getCellValueAt(location).name().charAt(0)));
	}
	
	public static Color getColorFor(Maze.CellType t)
	{
		return cellType2Color.get(t);
	}

}
