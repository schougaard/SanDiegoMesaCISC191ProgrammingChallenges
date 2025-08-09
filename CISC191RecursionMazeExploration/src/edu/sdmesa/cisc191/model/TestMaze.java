/**
* Lead Author(s):
* @author a; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-08-04
*/
package edu.sdmesa.cisc191.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Purpose: The reponsibility of TestMaze is ...
 *
 * TestMaze is-a ...
 * TestMaze is ...
 */
class TestMaze
{

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#Maze()}.
	 */
	@Test
	void testMaze()
	{
		Maze maze = new Maze();
		for (int row = 0; row < maze.getHeight(); row ++)
		{
			for (int col = 0; col < maze.getWidth(); col++)
			{
				assertNotNull(maze.getCellAtLocation(new Location(row, col)));
			}
		} 
		System.out.println(maze);
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#Maze(edu.sdmesa.cisc191.model.Cell[][])}.
	 */
	@Test
	void testMazeCellArrayArray()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#Maze(edu.sdmesa.cisc191.model.Maze)}.
	 */
	@Test
	void testMazeMaze()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getWidth()}.
	 */
	@Test
	void testGetWidth()
	{
		assertEquals(19, new Maze().getWidth());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getHeight()}.
	 */
	@Test
	void testGetHeight()
	{
		assertEquals(19, new Maze().getHeight());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getCellAtLocation(edu.sdmesa.cisc191.model.Location)}.
	 */
	@Test
	void testGetCellAtLocation()
	{
		Maze maze = new Maze();
		System.out.println(maze);
		assertEquals(new Cell(new Location(0,0), Cell.Type.WALL), maze.getCellAtLocation(new Location(0,0)));
		assertEquals(new Cell(new Location(maze.getHeight()-1,1), Cell.Type.PATH), maze.getCellAtLocation(new Location(maze.getHeight()-1,1)));
	}

//	/**
//	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getCellToRight(edu.sdmesa.cisc191.model.Cell)}.
//	 */
//	@Test
//	void testGetCellToRight()
//	{
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getCellToLeft(edu.sdmesa.cisc191.model.Cell)}.
//	 */
//	@Test
//	void testGetCellToLeft()
//	{
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getCellAbove(edu.sdmesa.cisc191.model.Cell)}.
//	 */
//	@Test
//	void testGetCellAbove()
//	{
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getCellBelow(edu.sdmesa.cisc191.model.Cell)}.
//	 */
//	@Test
//	void testGetCellBelow()
//	{
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getReachableCells(edu.sdmesa.cisc191.model.Cell)}.
	 */
	@Test
	void testGetReachableCells()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#canBeAPath(edu.sdmesa.cisc191.model.Cell)}.
	 */
	@Test
	void testCanBeAPath()
	{
		fail("Not yet implemented");
	}

//	/**
//	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#toString()}.
//	 */
//	@Test
//	void testToString()
//	{
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getEntranceCell()}.
	 */
	@Test
	void testGetEntranceCell()
	{
		Maze maze = new Maze();
		assertEquals(new Cell(new Location(maze.getHeight()-1,1), Cell.Type.PATH), maze.getEntranceCell());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getExitCell()}.
	 */
	@Test
	void testGetExitCell()
	{
		Maze maze = new Maze();
		
		// width - 2 since the exit is 2 away from the width of the maze
		assertEquals(new Cell(new Location(0, maze.getWidth()-2), Cell.Type.PATH), maze.getExitCell());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#isExit(edu.sdmesa.cisc191.model.Location)}.
	 */
	@Test
	void testIsExit()
	{
		Maze maze = new Maze();
		assertTrue(maze.isExit(new Location(0, maze.getWidth()-2)));
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#isEntrance(edu.sdmesa.cisc191.model.Location)}.
	 */
	@Test
	void testIsEntrance()
	{
		Maze maze = new Maze();
		assertTrue(maze.isEntrance(new Location(maze.getHeight()-1, 1)));
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#isLocationOnPath(edu.sdmesa.cisc191.model.Location)}.
	 */
	@Test
	void testIsLocationOnPath()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Maze#getSurroundingPossiblePaths(edu.sdmesa.cisc191.model.Location)}.
	 */
	@Test
	void testGetSurroundingPossiblePaths()
	{
		fail("Not yet implemented");
	}

}
