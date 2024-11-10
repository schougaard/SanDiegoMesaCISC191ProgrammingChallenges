package edu.sdmesa.cisc191.grader;

/**
 * Lead Author(s):
 * @author Allan Schougaard 
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Version/date: 2024-11
 * 
 * Responsibilities of class:
 * Start the Grader app
 */
import edu.sdmesa.cisc191.grader.model.Grader;
import edu.sdmesa.cisc191.grader.view.GradeView;

/**
 * The main class to start the app
 */
public class GradeApp
{
	public static void main(String args[])
	{
		Grader grader = new Grader();
		new GradeView(grader);
	}
}
