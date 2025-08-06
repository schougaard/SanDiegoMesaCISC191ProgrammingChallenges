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
* Version: 2025-08-06
*/
package edu.sdmesa.cisc191.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

/**
 * Purpose: The reponsibility of LocationTest is ...
 *
 * LocationTest is-a ...
 * LocationTest is ...
 */
class LocationTest
{

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#Location(int, int)}.
	 */
	@Test
	void testLocation()
	{
		Location location = new Location(2, 3);
		assertEquals(2, location.getRow());
		assertEquals(3, location.getColumn());
	} 

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#getLocationToRight()}.
	 */
	@Test
	void testGetLocationToRight()
	{
		Location location = new Location(2, 3).getLocationToRight();
		assertEquals(2, location.getRow());
		assertEquals(4, location.getColumn());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#getLocationToLeft()}.
	 */
	@Test
	void testGetLocationToLeft()
	{
		Location location = new Location(2, 4).getLocationToLeft();
		assertEquals(2, location.getRow());
		assertEquals(3, location.getColumn());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#getLocationAbove()}.
	 */
	@Test
	void testGetLocationAbove()
	{
		Location location = new Location(2, 4).getLocationAbove();
		assertEquals(1, location.getRow());
		assertEquals(4, location.getColumn());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#getLocationBelow()}.
	 */
	@Test
	void testGetLocationBelow()
	{
		Location location = new Location(2, 4).getLocationBelow();
		assertEquals(3, location.getRow());
		assertEquals(4, location.getColumn());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#isOuterPerimeter()}.
	 */
	@Test
	void testIsOuterPerimeter()
	{
		assertTrue(new Location(0, 0).isOuterPerimeter());
		assertTrue(new Location(1, 0).isOuterPerimeter());
		assertTrue(new Location(0, 1).isOuterPerimeter());
		assertFalse(new Location(1, 1).isOuterPerimeter());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#getAdjacentLocations()}.
	 */
	@Test
	void testGetAdjacentLocations()
	{
		Location location = new Location(2, 4);
		LinkedList<Location> locations = location.getAdjacentLocations();
		assertFalse(locations.contains(location));
		assertTrue(locations.contains(new Location(1, 4)));
		assertTrue(locations.contains(new Location(3, 4)));
		assertTrue(locations.contains(new Location(2, 3)));
		assertTrue(locations.contains(new Location(2, 5)));	
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#getRow()}.
	 */
	@Test
	void testGetRow()
	{
		assertEquals(2, new Location(2, 4).getRow());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#getColumn()}.
	 */
	@Test
	void testGetColumn()
	{
		assertEquals(4, new Location(2, 4).getColumn());
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject()
	{
		assertTrue(new Location(2, 4).equals(new Location(2, 4)));
		assertFalse(new Location(2, 4).equals(new Location(1, 4)));
		assertFalse(new Location(2, 4).equals(new Location(2, 5)));
	}

	/**
	 * Test method for {@link edu.sdmesa.cisc191.model.Location#toString()}.
	 */
	@Test
	void testToString()
	{
		assertEquals("(2,4)", new Location(2, 4).toString());
	}

}
