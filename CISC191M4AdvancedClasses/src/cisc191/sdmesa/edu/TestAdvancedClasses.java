package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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
class TestAdvancedClasses
{
	
	@Test
    @Order(1)
	void testAbstractInheritance1()
	{
		Cycle cycle = new Unicycle("Uni");
		assertEquals("Uni1", cycle.getMake());
		assertEquals(1, cycle.getNumberOfWheels());
		assertEquals("Uni1", cycle.getFrameNumber());
		cycle.setColor(Color.RED);
		assertEquals(Color.RED, cycle.getColor());
	}

	// Hint:
	// Where is the best class to implement color, so you do not have to repeat code in multiple classes?
	
//	@Order(2)
//	@Test
//	void testAbstractInheritance2()
//	{
//		Cycle bike = new Bicycle("Tooney");
//		assertEquals("Tooney", bike.getMake());
//		assertEquals(2, bike.getNumberOfWheels());
//		assertEquals("Tooney1", bike.getFrameNumber());
//		bike.setColor(Color.GREEN);
//		assertEquals(Color.GREEN, bike.getColor());
//		
//		Cycle eBike = new ElectricMountainBike("EMB");
//		assertEquals("EMB", eBike.getMake());
//		assertEquals(2, eBike.getNumberOfWheels());
//		assertEquals("EMB2", eBike.getFrameNumber());
//		eBike.setColor(Color.RED);
//		assertEquals(Color.RED, eBike.getColor());
//	}
//	
//	@Order(3)
//	@Test
//	void testToString()
//	{
//		Cycle cycle1 = new Unicycle("Uni");
//		cycle1.setColor(Color.RED);
//		int cycle1FrameNumber = cycle1.getFrameNumber();
//		assertEquals("Uni2 " + Color.RED, cycle1.toString());
//		
//		Cycle cycle2 = new Unicycle("Uni"); 
//		cycle2.setColor(Color.BLUE);
//		int cycle2FrameNumber = cycle2.getFrameNumber();
//		assertEquals("Uni3 " + Color.BLUE, cycle2.toString());
//
//		assertNotEquals(cycle1.toString(), cycle2.toString());
//	}
//	
//  @Order(4)	
//	@Test
//	void testEquals()
//	{
//		Cycle cycle1 = new Unicycle("Uni");
//		cycle1.setColor(Color.BLUE);
//		Cycle cycle2 = new Unicycle("Uni");
//		cycle2.setColor(Color.BLUE);
//		
//		// Cycles are "equal" if their frame numbers are the same
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

//  @Order(5)
//	@Test
//	void testGearable()
//	{
//		Gearable conveyance = new ElectricMountainBike("EMBG");
//		// Test that conveyance is-a Cycle
//		assertInstanceOf(Cycle.class, conveyance);
//		assertTrue(conveyance.toString().contains("EMBG"));
//		
//		assertEquals(1, conveyance.getGear());
//		conveyance.gearUp();
//		assertEquals(2, conveyance.getGear());
//		conveyance.gearDown();
//		assertEquals(1, conveyance.getGear());
//		conveyance.gearDown();
//		assertEquals(1, conveyance.getGear());
//	}
//	
//  @Order(6)private int frameNumber;
//	@Test
//	void testMovable()
//	{
//		Movable conveyance = new ElectricMountainBike("EMBM");
//		// Test that conveyance is-a Cycle
//		assertInstanceOf(Cycle.class, conveyance);
//		assertTrue(conveyance.toString().contains("EMBM"));
//		
//		assertEquals(0, conveyance.getSpeed());
//		conveyance.speedUp();
//		assertEquals(1, conveyance.getSpeed());
//		conveyance.speedUp();
//		assertEquals(2, conveyance.getSpeed());
//	    conveyance.speedUp();
//	    assertEquals(3, conveyance.getSpeed());
//      conveyance.slowDown();
//      assertEquals(1, conveyance.getSpeed());
//      conveyance.slowDown();
//      assertEquals(0, conveyance.getSpeed());
//	}
//
//  @Order(7)
//	@Test
//	void testChargable()
//	{
//		Chargeable conveyance = new ElectricMountainBike("EMBC");
//		// Test that conveyance is-a Cycle
//		assertInstanceOf(Cycle.class, conveyance);
//		assertTrue(conveyance.toString().contains("EMBC"));
//		
//		assertEquals(0, conveyance.getCharge());
//		conveyance.chargeTo(80);
//	    assertEquals(80, conveyance.getCharge());
//	    conveyance.chargeTo(100);
//      assertEquals(100, conveyance.getCharge());
//      conveyance.chargeTo(120);
//      assertEquals(100, conveyance.getCharge());
//	}
//	
//	@Order(8)	
//	@Test
//	void testDynamicBinding()
//	{
//		BikeShop shop = new BikeShop("Joe's Bike Rack");
//		assertEquals("Joe's Bike Rack", shop.getName());
//		assertTrue(shop.toString().contains("Joe's Bike Rack"));
//		
//		// Model that a bike shop has-many cycles
//	    // Make sure the bike shop can have at least 10 bikes.
//		assertEquals(0, shop.getNumberOfBikesInInventory());
//		
//		ElectricMountainBike conveyance1 = new ElectricMountainBike("BigMountainBike");
//		shop.addToInventory(conveyance1);
//		assertEquals(1, shop.getNumberOfBikesInInventory());
//		assertTrue(shop.toString().contains(conveyance1.toString()));
//		
//		Cycle conveyance2 = new Unicycle("Looney");
//		shop.addToInventory(conveyance2);
//		assertEquals(2, shop.getNumberOfBikesInInventory());
//		assertTrue(shop.toString().contains(conveyance2.toString()));
//		assertTrue(shop.toString().contains(conveyance1.toString()));
//		
//		Cycle conveyance3 = new Bicycle("Tooney");
//		shop.addToInventory(conveyance3);
//		assertEquals(3, shop.getNumberOfBikesInInventory());
//		assertTrue(shop.toString().contains(conveyance3.toString()));
//		assertTrue(shop.toString().contains(conveyance2.toString()));
//		assertTrue(shop.toString().contains(conveyance1.toString()));
//		
//		Cycle conveyance4 = new ElectricMountainBike("SmallMountainBike");
//		shop.addToInventory(conveyance4);
//		assertEquals(4, shop.getNumberOfBikesInInventory());
//		assertTrue(shop.toString().contains(conveyance4.toString()));
//		assertTrue(shop.toString().contains(conveyance3.toString()));
//		assertTrue(shop.toString().contains(conveyance2.toString()));
//		assertTrue(shop.toString().contains(conveyance1.toString()));
//	}

}




