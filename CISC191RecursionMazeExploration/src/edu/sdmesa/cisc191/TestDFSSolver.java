package edu.sdmesa.cisc191;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Lead Author(s):
 * @author Alex Chow
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt, J. D., & Stein, C. (n.d.). 
 * JUnit 5 user guide. JUnit 5. 
 * https://junit.org/junit5/docs/current/user-guide/
 * 
 * Version/date: 1.0
 * 
 * Responsibilities of class:
 * Test class and methods to solve a maze with DFS.
 */

/**
 * Your mission, should you choose to accept it:
 * 
 * For each of the test methods below create a method in a class that
 * makes the test run and pass.
 * 
 * Each class must be in a separate file. Use File -> New -> Class
 * 
 * Read the test methods to understand what the classes' methods
 * should do. The assertEquals methods check to see if the two arguments are
 * equal. If they are equal the test passes; if not, the test will be marked as
 * failed and the execution stops.
 * 
 * To run the tests in this file from the main menu, select Run -> Run As -> JUnit
 * with the file selected.
 * 
 * To implement a test method:
 * 
 * 1. Uncomment the entire test method. To uncomment a block, select the block
 * and hold down Ctrl while typing /
 * 
 * 2. To make the test compile and run: implement a method with the correct
 * signature, but returning a fake value, such as -1, null or similar. After
 * this the test method should run but fail.
 * 
 * 3. To make the tests pass: Then change the method to return the correct value
 * and run the test again.
 * 
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestDFSSolver
{
	static MazeExplorer mazeExplorer;
	
	@BeforeAll
	static void setUp() {
		mazeExplorer = new MazeExplorer(0);
	}
	
	@Order(1)
	@Test
	void testColorEntranceAsCurrent()
	{
		MazeGUI mazeGUI = mazeExplorer.getMazeGUI();
		Maze maze = mazeExplorer.getMaze();
		Point p = maze.getEntrancePoint();
		Color colorAtEntrance = mazeGUI.getColorAt(p.y, p.x);
		assertEquals(Maze.CURRENT_COLOR, colorAtEntrance);
		mazeExplorer.getController().reset();
	}
	
//	@Order(2)
//	@Test
//	void testCheckExit()
//	{
//		Maze maze = mazeExplorer.getMaze();
//		Point p = maze.getExitPoint();
//		mazeExplorer.getController().setMillis(0);
//		mazeExplorer.getController().togglePause(); // unpause
//		assertTrue(mazeExplorer.getSolver().solveRecursive(p.y, p.x));
//		mazeExplorer.getSolver().setCleared(true);
//		mazeExplorer.getController().reset();
//	}
//	
//	@Order(3)
//	@Test
//	void testCheckUp() throws InterruptedException
//	{
//		// paused at this point
//		Maze maze = mazeExplorer.getMaze();
//		MazeGUI mazeGUI = mazeExplorer.getMazeGUI();
//		mazeExplorer.getSolver().setCleared(true);
//		mazeExplorer.getController().reset();
//		mazeExplorer.getController().setMillis(1000);
//		
//		mazeExplorer.runSolver();
//		mazeExplorer.getController().togglePause(); // pause again
//		
//		// run for 23 steps. Should have explored the hallway
//		for (int i = 0; i < 23; i++) {
//			mazeExplorer.getController().nextStep();
//		}
//		
//		// give it ample time to wait for cell update
//		Thread.sleep(300);
//		
//		// check each cell going up
//		int row = maze.getEntrancePoint().y;
//		int column = maze.getEntrancePoint().x;
//		while (row >= 0 && maze.getCellValueAt(row - 1, column) != Maze.CellType.WALL) {
//			assertTrue(mazeGUI.getColorAt(row, column).equals(Maze.WAITING_COLOR));
//			row--;
//		}
//		
//		// the uppermost cell should be current
//		assertTrue(mazeGUI.getColorAt(row, column).equals(Maze.CURRENT_COLOR));
//		
//		mazeExplorer.getSolver().setCleared(true);
//		mazeExplorer.getController().reset();
//	}
//	
//	@Order(4)
//	@Test
//	void testAll() throws InterruptedException
//	{
//		MazeGUI mazeGUI = mazeExplorer.getMazeGUI();
//		mazeExplorer.getSolver().setCleared(true);
//		mazeExplorer.getController().reset();
//		mazeExplorer.getController().setMillis(0);
//		
//		mazeExplorer.runSolver();
//		
//		// give it ample time to wait for cell update
//		Thread.sleep(1000);
//		
//		// solution points
//		int[][] solutionPoints = {
//		    {17, 0}, {17, 1}, {17, 2}, {17, 3},
//		    {16, 3}, {15, 3}, {15, 4}, {15, 5},
//		    {14, 5}, {13, 5}, {13, 6}, {13, 7},
//		    {13, 8}, {13, 9}, {13, 10}, {13, 11},
//		    {13, 12}, {13, 13}, {13, 14}, {13, 15},
//		    {12, 15}, {11, 15}, {10, 15}, {9, 15},
//		    {8, 15}, {7, 15}, {6, 15}, {5, 15},
//		    {4, 15}, {3, 15}, {3, 16}, {3, 17},
//		    {2, 17}, {1, 17}, {1, 18}
//		};
//		
//		// check all points
//		for (int[] point : solutionPoints) {
//			assertTrue(mazeGUI.getColorAt(point[1], point[0]).equals(Maze.SOLUTION_COLOR));
//		}
//	}
	
	@AfterAll
	static void cleanUp() {
		mazeExplorer.exit();
	}

}
