package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.awt.Color;

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
 * Test class and methods to support a boat shop
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
class TestBeginningClasses
{

	@Test
	void testNoArgConstructor()
	{
		Boat boat = new Boat();
		assertEquals(null, boat.getMake());
		assertEquals(null, boat.getColor());
		assertEquals(0, boat.getSpeed());
		assertEquals(-1, boat.getPrice());
	}

//	@Test
//	void testConstructor()
//	{
//		Boat boat = new Boat("Aqualina", Color.GREEN);
//		assertEquals("Aqualina", boat.getMake());
//		assertEquals(Color.GREEN, boat.getColor());
//		assertEquals(0, boat.getSpeed());
//  	assertEquals(-1, boat.getPrice());
//	}
//
//	@Test
//	void testCopyConstructor()
//	{
//		Boat boat1 = new Boat("Aqualina", Color.GREEN);
//		boat1.setPrice(100);
//      Boat boat2 = new Boat(boat1);	
//		assertEquals("Aqualina", boat2.getMake());
//		assertEquals(Color.GREEN, boat2.getColor());
//		assertEquals(0, boat2.getSpeed());
//	    assertEquals(100, boat2.getPrice());
//	}
//
//	@Test
//	void testMutators()
//	{
//		Boat boat = new Boat();
//		boat.setColor(Color.GREEN);
//		assertEquals(Color.GREEN, boat.getColor());
//	    boat.setColor(Color.RED);
//	    assertEquals(Color.RED, boat.getColor());
//	    boat.setPrice(10000);
//	    assertEquals(10000, boat.getPrice());
//	}
//
//	@Test
//	void testSpeedMethods()
//	{
//		Boat boat = new Boat("BHM", Color.BLUE);
//		assertEquals(0, boat.getSpeed());
//		boat.speedUp();
//		assertEquals(1, boat.getSpeed());
//		boat.speedUp();
//		assertEquals(2, boat.getSpeed());
//		boat.slowDown();
//		assertEquals(1, boat.getSpeed());
//		boat.slowDown();
//		assertEquals(0, boat.getSpeed());
//	}
//
//	@Test
//	void testToString()
//	{
//		Boat boat = new Boat("BSC", Color.GREEN);
//		assertEquals("Boat: make: BSC color: java.awt.Color[r=0,g=255,b=0]", boat.toString());
//		
//		Boat boat2 = new Boat("Marlin", Color.RED);
//		assertEquals("Boat: make: Marlin color: java.awt.Color[r=255,g=0,b=0]", boat2.toString());
//	}
//
//
//	@Test
//	void testCreateNewSerialNumber()
//	{
//		// The boat class creates a unique serial numbers for each boat
//      // See Java Static Variables in https://beginnersbook.com/2013/04/java-static-class-block-methods-variables/
//		assertTrue(Boat.createNewSerialNumber() > 0);
//      // Serial numbers are monotonically increasing
//	    assertTrue(Boat.createNewSerialNumber() < Boat.createNewSerialNumber());
//		assertEquals(Boat.createNewSerialNumber() + 1,  Boat.createNewSerialNumber());
//	}
//
//	@Test
//	void testBoatHasASerialNumber()
//	{
//		// Each boat is assigned a unique immutable serial number when they are created
//		// Hint: use createNewSerialNumber
//		Boat boat0 = new Boat();
//		int boat0SerialNumber = boat0.getSerialNumber();
//		assertTrue(boat0SerialNumber > 0);
//		
//		// Check that serial number does not change
//		assertEquals(boat0SerialNumber, boat0.getSerialNumber());
//		assertEquals(boat0SerialNumber, boat0.getSerialNumber());
//		Boat boat1 = new Boat("BMC", Color.GREEN);
//		// Check that serial number does not change, again
//		assertEquals(boat0SerialNumber, boat0.getSerialNumber());	
//
//		// Check that serial numbers increase
//		assertTrue(boat1.getSerialNumber() > boat0SerialNumber);
//		Boat boat2 = new Boat(boat1);
//		assertTrue(boat2.getSerialNumber() > boat1.getSerialNumber());
//		
//		// Check that serial number does not change, again
//		assertEquals(boat0SerialNumber, boat0.getSerialNumber());	
//	}
//
//  // **********************************************************
// 	// Note: Each class is to be implemented in a separate file
//  // **********************************************************
//
//	@Test
//	void testHarbor()
//	{
//      // A harbor has many boats
//
//		Boat boat1 = new Boat("BMC", Color.GREEN);
//		Boat boat2 = new Boat("BMX", Color.RED);
//		Boat boat3 = new Boat("UXB", Color.YELLOW);
//		
//		Harbor stock = new Harbor(5);
//		assertEquals(null, stock.getBoatAt(0));
//		assertEquals(null, stock.getBoatAt(1));
//		assertEquals(null, stock.getBoatAt(2));
//		assertEquals(null, stock.getBoatAt(3));
//		assertEquals(null, stock.getBoatAt(4));
//		
//		// Hint: parkBoatAt is not just an accessor, and not just a mutator
//		assertEquals(null, stock.parkBoatAt(boat1, 3));
//		Boat retrievedBoat = stock.parkBoatAt(boat2, 3);
//		assertEquals(boat1, retrievedBoat);
//		retrievedBoat = stock.parkBoatAt(boat3, 3);
//		assertEquals(boat2, retrievedBoat);
//		Boat[] inventory = stock.getInventory();
//		assertArrayEquals(new Boat[]{null, null, null, boat3, null}, inventory);
//		stock.parkBoatAt(boat2, 1);
//      // The inventory is a carbon copy list of boats that is handed out to interested parties.
//		assertArrayEquals(new Boat[]{null, null, null, boat3, null}, inventory); // This is correct!
//		assertArrayEquals(new Boat[]{null, boat2, null, boat3, null}, stock.getInventory());
//	}
//
//	@Test
//	void testCreditCardPayment()
//	{
//		Person person = new Person("Alex Keaton", "619-555-1212", "92111");
//		assertEquals("Alex Keaton 619-555-1212 92111", person.toString());
//		
//		CreditCard card = new CreditCard("4444111122223333", "12/24", "123", person);
//		assertEquals("4444111122223333 12/24 123 Alex Keaton", card.toString());
//		
//		Boat boat = new Boat("SpeedyBoat", Color.GREEN);
//		boat.setPrice(19995);
//				
//		CreditCardCharge charge = new CreditCardCharge(2020, 8, 14, boat, "BoatCo", card);
//		assertEquals("2020/8/14 4444111122223333 12/24 123 Alex Keaton BoatCo SpeedyBoat $19995", charge.toString());
//	}
//
//	@Test
//	void testBoatHasAnOwner()
//	{
//		Person person = new Person("Alexandra Keaton", "858-555-1313", "92123");
//		Boat boat = new Boat("SailyBoat", Color.MAGENTA);
//		boat.setPrice(188888);
//      boat.setOwner(person);
//      assertEquals("Alexandra Keaton", boat.getOwner().getName());
//      // Owner changes name
//      person.setName("Alexandra Smith");
//      assertEquals("Alexandra Smith", boat.getOwner().getName());
//	}	

}
