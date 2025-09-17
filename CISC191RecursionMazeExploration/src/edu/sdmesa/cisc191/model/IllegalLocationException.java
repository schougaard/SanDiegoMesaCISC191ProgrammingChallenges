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
 *         Version: 2025-08-09
 */
package edu.sdmesa.cisc191.model;

/**
 * Purpose: The responsibility of this class is to notify of an impossible
 * location
 *
 * IllegalLocationException is-a RuntimeException, similar to an index out range exception
 */
public class IllegalLocationException extends RuntimeException
{
	public IllegalLocationException(int row, int column)
	{
		super("Location: (" + row + "," + column
				+ ") is not allowed. Row must be between 0 and " + Maze.HEIGHT
				+ " and column must be between 0 and " + Maze.WIDTH);
	}

}
