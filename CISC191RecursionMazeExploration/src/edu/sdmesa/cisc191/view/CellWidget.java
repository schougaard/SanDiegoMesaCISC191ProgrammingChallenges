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
package edu.sdmesa.cisc191.view;

import java.awt.Color;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.sdmesa.cisc191.model.Cell;

/**
 * Purpose: The responsibility of CellWidget is to display the status of a cell in the maze
 *
 * GUICell is-a JPanel
 */
public class CellWidget extends JPanel
{
	/**
	 * A cell widget has-a cell in a maze
	 */
	private Cell cell;

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

	private final static Hashtable<Cell.Type, Color> cellType2Color = new Hashtable<Cell.Type, Color>();
	static
	{
		cellType2Color.put(Cell.Type.WALL, WALL_COLOR);
		cellType2Color.put(Cell.Type.PATH, PATH_COLOR);
		cellType2Color.put(Cell.Type.FRONTIER, FRONTIER_COLOR);
		cellType2Color.put(Cell.Type.VISITED, VISITED_COLOR);
		cellType2Color.put(Cell.Type.CURRENT, CURRENT_COLOR);
		cellType2Color.put(Cell.Type.EVALUATING, EVALUATING_COLOR);
		cellType2Color.put(Cell.Type.SOLUTION, SOLUTION_COLOR);
		cellType2Color.put(Cell.Type.WAITING, WAITING_COLOR);
	}

	public CellWidget(Cell initCell)
	{
		cell = initCell;

		// when a CellWidget is created, associate the cell with itself.
		cell.setCellWidget(this);

		label = new JLabel("");
		label.setForeground(Color.white);
		add(label);
	}
	
	/**
	 * 
	 * Purpose: Set direction, etc
	 * @param text
	 */
	public void setText(String text)
	{
		label.setText(text);
	}
	
	public void clear()
	{
		setBackground(Color.PINK);
		setText("_");
	}

	public void update()
	{
		setBackground(cellType2Color.get(cell.getType()));
		label.setText(
				String.valueOf(cell.getDirection().name().charAt(0)));
	}
	
	public static Color getColorFor(Cell.Type t)
	{
		return cellType2Color.get(t);
	}

	public Color getColor()
	{
		return getBackground();
	}

	public Cell getCell()
	{
		return cell;
	}

	public void setCell(Cell cell)
	{
		this.cell = cell;
	}
}
