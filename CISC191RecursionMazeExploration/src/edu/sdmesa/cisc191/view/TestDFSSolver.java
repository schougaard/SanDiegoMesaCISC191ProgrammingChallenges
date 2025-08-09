package edu.sdmesa.cisc191.view;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import edu.sdmesa.cisc191.model.Cell;
import edu.sdmesa.cisc191.model.Location;
import edu.sdmesa.cisc191.model.Maze;
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
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M.,
 *         Rancourt, J. D., & Stein, C. (n.d.).
 *         JUnit 5 user guide. JUnit 5.
 *         https://junit.org/junit5/docs/current/user-guide/
 * 
 *         Version/date: 1.0
 * 
 *         Responsibilities of class:
 *         Test class and methods to solve a maze with DFS.
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
 * To run the tests in this file from the main menu, select Run -> Run As ->
 * JUnit
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

	@BeforeEach
	void setUp()
	{
		mazeExplorer = new MazeExplorer(0);
	}
	
	@Test
	void testMazeConstructor1()
	{
		//Maze m = new Maze(MazeGenerator.generateMaze(Algorithm.PRIM, 0));
		Maze maze = new Maze();
		assertEquals(new Cell(new Location(18, 1), Cell.Type.PATH), maze.getEntranceCell());
		assertEquals(new Cell(new Location(0, 17), Cell.Type.PATH), maze.getExitCell());
		assertEquals(Cell.Type.WALL, maze.getCellAtLocation(new Location(0, 0)));
		assertEquals(Cell.Type.PATH, maze.getCellAtLocation(maze.getEntranceCell().getLocation()));
		assertEquals(Cell.Type.PATH, maze.getCellAtLocation(maze.getExitCell().getLocation()));
		
//		Cell oneAboveEntrance = m.getEntranceCell().getCellAbove();
		
//		ArrayList<Cell> reachableCells = new ArrayList<Cell>();
//		reachableCells.add(oneAboveEntrance.getCellAbove().getCellAbove());
//		reachableCells.add(oneAboveEntrance.getCellToRight().getCellToRight());
//		
//		assertEquals(reachableCells, m.getReachableCells(oneAboveEntrance));
	}

	@Test
	void testColorEntranceAsCurrent() throws InterruptedException
	{
		MazePanel mazeGUI = mazeExplorer.getMazeGUI();
		Maze maze = mazeExplorer.getMaze();
		Cell l = maze.getEntranceCell();
		mazeExplorer.getSolver().nextStep();
		Color colorAtEntrance = mazeGUI.getCellWidgetAtLocation(maze.entranceLocation).getColor();
		assertEquals(CellWidget.getColorFor(Cell.Type.CURRENT), colorAtEntrance);
		mazeExplorer.reset();
	}

	// Checks the base case where, if called on the exit point, the method
	// should return true.
	@Test
	void testCheckExit()
	{
		Maze maze = mazeExplorer.getMaze();
		MazePanel mazeGUI = mazeExplorer.getMazeGUI();
		Location l = maze.getExitCell().getLocation();
		MazeSolver.pauseMillis = 0;
		mazeExplorer.getSolver().togglePause(); // unpause

		assertTrue(((GUIDepthFirstSolver)(mazeExplorer.getSolver())).solveRecursive(l));
		mazeGUI.waitForGUI();
		Color colorAtExit = mazeGUI.getCellWidgetAtLocation(maze.entranceLocation).getColor();
		assertEquals(CellWidget.getColorFor(Cell.Type.SOLUTION), colorAtExit);

		mazeExplorer.getSolver().setCleared(true);
		mazeExplorer.reset();
	}

	@Test
	void testCheckUpFromEntrance1() throws InterruptedException
	{
		mazeExplorer.getSolver().setCleared(true);
		mazeExplorer.reset();
		MazeSolver.pauseMillis = MazeSolver.maxWait;
		
		Maze maze = mazeExplorer.getMaze();
		MazePanel mazeGUI = mazeExplorer.getMazeGUI();
		
		// getting solver needs to be here since reset returns a new solver
		MazeSolver solver = mazeExplorer.getSolver();
		mazeExplorer.runSolver();

		// take however many steps needed for the current cell to change
		mazeExplorer.getSolver().nextStep();
		Cell previousCell = maze.getCellAtLocation(solver.getCurrentLocation());
		
		do {
			mazeExplorer.getSolver().nextStep();
		} while (maze.getCellAtLocation(solver.getCurrentLocation()).equals(previousCell));

		Cell oneUp = maze.getCellAbove(maze.getEntranceCell());
		assertEquals(CellWidget.getColorFor(Cell.Type.CURRENT),
			mazeGUI.getCellWidgetAtLocation(oneUp.getLocation()).getColor());
	}
	
	@Test
	void testCheckUpFromEntrance2() throws InterruptedException
	{
		// currently paused from test 3
		mazeExplorer.getSolver().setCleared(true);
		mazeExplorer.reset();
		MazeSolver.pauseMillis = MazeSolver.maxWait;
		
		Maze maze = mazeExplorer.getMaze();
		MazePanel mazeGUI = mazeExplorer.getMazeGUI();
		
		mazeExplorer.runSolver();
		mazeExplorer.getSolver().nextStep();
		
		MazeSolver solver = mazeExplorer.getSolver();
		
		// advance until the current Cell is no longer the previous Cell
		// do this twice
		for (int i = 0; i < 2; i++) {
			Cell previousCell = maze.getCellAtLocation(solver.getCurrentLocation());
			do {
				mazeExplorer.getSolver().nextStep();
			} while (mazeGUI.getCellWidgetAtLocation(solver.getCurrentLocation()).equals(previousCell));
		}

		// the "current" point from the last test
		Cell l = maze.getCellAbove(maze.getEntranceCell());
		
		Location aboveCellLoc = maze.getCellAbove(l).getLocation();
		Location rightCellLoc = maze.getCellToRight(l).getLocation();
		
		CellWidget aboveCellWidget = mazeGUI.getCellWidgetAtLocation(aboveCellLoc);
		CellWidget rightCellWidget = mazeGUI.getCellWidgetAtLocation(rightCellLoc);

		Color currentColor = CellWidget.getColorFor(Cell.Type.CURRENT);
		
		assertTrue(aboveCellWidget.getColor().equals(currentColor) ||
				rightCellWidget.getColor().equals(currentColor));
	}

	// @Test
	// void testCheckUp() throws InterruptedException
	// {
	// // paused at this point
	// Maze maze = mazeExplorer.getMaze();
	// MazePanel mazeGUI = mazeExplorer.getMazeGUI();
	// mazeExplorer.getSolver().setCleared(true);
	// mazeExplorer.getController().reset();
	// mazeExplorer.getController().setMillis(1000);

	// mazeExplorer.runSolver();
	// mazeExplorer.getController().togglePause(); // pause again

	// // run for 23 steps. Should have explored the hallway
	// for (int i = 0; i < 23; i++) {
	// mazeExplorer.getController().nextStep();
	// }

	// // give it ample time to wait for cell update
	// Thread.sleep(300);

	// // check each cell going up
	// int row = maze.getEntrancePoint().y;
	// int column = maze.getEntrancePoint().x;
	// while (row >= 0 && maze.getCellValueAt(row - 1, column) !=
	// Cell.Type.WALL) {
	// assertTrue(mazeGUI.getColorAt(row, column).equals(Maze.WAITING_COLOR));
	// row--;
	// }

	// // the uppermost cell should be current
	// assertTrue(mazeGUI.getColorAt(row, column).equals(Maze.CURRENT_COLOR));

	// mazeExplorer.getSolver().setCleared(true);
	// mazeExplorer.getController().reset();
	// }
	//
	// @Order(4)
	// @Test
	// void testAll() throws InterruptedException
	// {
	// MazePanel mazeGUI = mazeExplorer.getMazeGUI();
	// mazeExplorer.getSolver().setCleared(true);
	// mazeExplorer.getController().reset();
	// mazeExplorer.getController().setMillis(0);
	//
	// mazeExplorer.runSolver();
	//
	// // give it ample time to wait for cell update
	// Thread.sleep(1000);
	//
	// // solution points
	// int[][] solutionPoints = {
	// {17, 0}, {17, 1}, {17, 2}, {17, 3},
	// {16, 3}, {15, 3}, {15, 4}, {15, 5},
	// {14, 5}, {13, 5}, {13, 6}, {13, 7},
	// {13, 8}, {13, 9}, {13, 10}, {13, 11},
	// {13, 12}, {13, 13}, {13, 14}, {13, 15},
	// {12, 15}, {11, 15}, {10, 15}, {9, 15},
	// {8, 15}, {7, 15}, {6, 15}, {5, 15},
	// {4, 15}, {3, 15}, {3, 16}, {3, 17},
	// {2, 17}, {1, 17}, {1, 18}
	// };
	//
	// // check all points
	// for (int[] point : solutionPoints) {
	// assertTrue(mazeGUI.getColorAt(point[1],
	// point[0]).equals(Maze.SOLUTION_COLOR));
	// }
	// }

	@AfterAll
	static void cleanUp()
	{
		mazeExplorer.exit();
	}

}
