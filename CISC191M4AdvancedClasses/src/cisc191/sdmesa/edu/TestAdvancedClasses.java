package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

/**
 * Lead Author(s):
 * @author Tasha Frankie
 * @author Allan Schougaard 
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
 * Test class and methods to support a push bike shop
 */

/**
 * Your mission, should you choose to accept it:
 * 
 * For each of the test methods below create a method in the appropriate class that
 * makes the test run and pass.
 * 
 * Read the test methods to understand what the TestAdvancedClasses class methods
 * should do. The assertEquals methods check to see if the two arguments are
 * equal. If they are equal the test passes; if not, the test will be marked as
 * failed and the execution stops.
 * 
 * To run the tests from the main menu, select Run -> Run.
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

class TestAdvancedClasses
{
	@Test
	void testAbstractInheritance1()
	{
		Cycle cycle = new Unicycle("Uni1");
		assertEquals("Uni1", cycle.getMake());
		assertEquals(1, cycle.getNumberOfWheels());
		cycle.setColor(Color.RED);
		assertEquals(Color.RED, cycle.getColor());
	}

//	@Test
//	void testAbstractInheritance2()
//	{
//		Bicycle bike = new ElectricMountainBike("BMC");
//		assertEquals("BMC", bike.getMake());
//		assertEquals(2, bike.getNumberOfWheels());
//		bike.setColor(Color.GREEN);
//		assertEquals(Color.GREEN, bike.getColor());
//	}
	
//	@Test
//	void testToString()
//	{
//		Cycle cycle1 = new Unicycle("Uni");
//		Cycle cycle2 = new Unicycle("Uni");
//		assertTrue(cycle1.toString().contains("Uni"));
//		assertTrue(cycle2.toString().contains("Uni"));
//		assertTrue(cycle1.toString().contains(String.valueOf(cycle1.getFrameNumber())));
//		assertTrue(cycle2.toString().contains(String.valueOf(cycle2.getFrameNumber())));
//		assertNotEquals(cycle1.toString(), cycle2.toString());
//		cycle1.setColor(Color.BLUE);
//		cycle2.setColor(Color.GREEN);
//		assertTrue(cycle1.toString().contains("java.awt.Color[r=0,g=0,b=255]"));
//		assertTrue(cycle2.toString().contains("java.awt.Color[r=0,g=255,b=0]"));
//		
//		Bicycle bike1 = new Bicycle("Toony");
//		Bicycle bike2 = new Bicycle("Toony");
//		assertTrue(bike1.toString().contains("Uni"));
//		assertTrue(bike2.toString().contains("Uni"));
//		assertTrue(bike1.toString().contains(String.valueOf(bike1.getFrameNumber())));
//		assertTrue(bike2.toString().contains(String.valueOf(bike2.getFrameNumber())));
//		assertNotEquals(bike1.toString(), bike2.toString());
//		bike1.setColor(Color.BLUE);
//		bike2.setColor(Color.RED);
//		assertTrue(bike1.toString().contains("java.awt.Color[r=0,g=0,b=255]"));
//		assertTrue(bike2.toString().contains("java.awt.Color[r=255,g=0,b=0]"));
//	}
	
//	@Test
//	void testEquals()
//	{
//		Cycle cycle1 = new Unicycle("Uni");
//		cycle1.setColor(Color.BLUE);
//		Cycle cycle2 = new Unicycle("Uni");
//		cycle2.setColor(Color.BLUE);
//		
//		// Cycles are "equal" is they frame number
//		assertTrue(cycle1.equals(cycle1));
//		assertFalse(cycle1.equals(cycle2));
//		assertFalse(cycle2.equals(cycle1));
//		
//		Bicycle bike1 = new Bicycle("Toony");
//		bike1.setColor(Color.RED);
//		Bicycle bike2 = new Bicycle("Toony");
//		bike2.setColor(Color.RED);
//
//		assertTrue(bike1.equals(bike1));
//		assertFalse(bike1.equals(bike2));
//		assertFalse(bike2.equals(bike1));
//		
//		assertFalse(cycle1.equals("Not a bike"));
//		assertFalse(cycle1.equals(null));
//
//		assertFalse(bike1.equals("Not a bike"));
//		assertFalse(bike1.equals(null));
//	}

//	@Test
//	void testGearable()
//	{
//		Gearable vehicle2 = new ElectricMountainBike("E2");
//		assertEquals(1, vehicle2.getGear());
//		assertEquals("E2", ((Cycle) vehicle2).getMake());
//	}

//	@Test
//	void testElectric()
//	{
//		Electric vehicle3 = new ElectricMountainBike("E3");
//		assertEquals(0, vehicle3.getCharge());
//		vehicle3.charge(100);
//		assertEquals(100, vehicle3.getCharge());
//		assertEquals("E3", ((Cycle) vehicle3).getMake());
//	}

//	@Test
//	void testMovable()
//	{
//		Movable vehicle1 = new ElectricMountainBike("E1");
//		assertEquals(0, vehicle1.getSpeed());
//		assertEquals("E1", ((Cycle) vehicle1).getMake());
//	}

}