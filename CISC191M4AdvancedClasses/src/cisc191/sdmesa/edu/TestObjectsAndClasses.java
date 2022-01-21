package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
 * Read the test methods to understand what the TestObjectsAndClasses class methods
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

class TestObjectsAndClasses
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
//		assertEquals("BMC 2 wheels java.awt.Color[r=0,g=255,b=0]", bike.getDescription());
//	}

//	@Test
//	void testMovable()
//	{
//		Movable vehicle1 = new ElectricMountainBike("E1");
//		assertEquals(0, vehicle1.getSpeed());
//		assertEquals("E1", ((Cycle) vehicle1).getMake());
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
//	void testToString()
//	{
//		Cycle bike = new ElectricMountainBike("BMC");
//		bike.setColor(Color.GREEN);
//		assertEquals("ElectricMountainBike: make: BMC wheels: 2 color: java.awt.Color[r=0,g=255,b=0]", bike.toString());
//	}

//	@Test
//	void testEquals()
//	{
//		Cycle bike1 = new ElectricMountainBike("BMC", Color.GREEN);
//		Cycle bike2 = new ElectricMountainBike("BMC", Color.GREEN);
//		Cycle bike3 = new ElectricMountainBike("BMX", Color.GREEN);
//		Cycle bike4 = new ElectricMountainBike("BMC", Color.RED);
//		Cycle cycle = new Unicycle("UniToo");
//		assertEquals(true, bike1.equals(bike1));
//		assertEquals(true, bike1.equals(bike2));
//		assertEquals(false, bike1.equals(bike3));
//		assertEquals(false, bike1.equals(bike4));
//		assertEquals(false, bike1.equals(null));
//		assertEquals(false, bike1.equals("BMC"));
//		assertEquals(false, bike1.equals(cycle));
//	}

}
