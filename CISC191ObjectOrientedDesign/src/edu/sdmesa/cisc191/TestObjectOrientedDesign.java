package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.*;

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
 * Test class and methods to support an Object Oriented design
 */

class TestObjectOrientedDesign
{

   @Test
   void testVehicle()
   {
      Vehicle vehicle = new Vehicle("GMC", 80000, 7995, 4, null);

      assertEquals("GMC", vehicle.getManufacturerName());
      assertEquals(80000, vehicle.getMilesOnVehicle());
      assertEquals(7995, vehicle.getPrice());
      assertEquals(4, vehicle.getNumberOfSeats());
   }

//   @Test
//   void testOptions()
//   {
//      Option moonroof = new Option("Moonroof");
//      assertEquals("Moonroof", moonroof.getDetails());
//      Option leather = new Option("Leather");
//      assertEquals("Leather", leather.getDetails());
//      Option[] options = { moonroof, leather };
//      Vehicle vehicle = new Vehicle("BMW", 90000, 10995, 4, options);
//
//      assertEquals("Moonroof", vehicle.getOptions()[0].getDetails());
//      assertEquals("Leather", vehicle.getOptions()[1].getDetails());
//   }

//   @Test
//   void testCar()
//   {
//      Car car = new Car("BMW", 190000, 5995, 4, null, 2);
//
//      assertEquals("BMW", car.getManufacturerName());
//      assertEquals(190000, car.getMilesOnVehicle());
//      assertEquals(5995, car.getPrice());
//      assertEquals(4, car.getNumberOfSeats());
//      assertEquals(2, car.getNumberOfDoors());
//   }

//   @Test
//   void testPickupTruck()
//   {
//      PickupTruck truck = new PickupTruck("Dodge", 9000, 65995, 3, null, 1400);
//
//      assertEquals("Dodge", truck.getManufacturerName());
//      assertEquals(9000, truck.getMilesOnVehicle());
//      assertEquals(65995, truck.getPrice());
//      assertEquals(3, truck.getNumberOfSeats());
//      assertEquals(1400, truck.getCargoCapacity());
//   }

//   @Test
//   void testSportsUtilityVehicle()
//   {
//      SportsUtilityVehicle suv = new SportsUtilityVehicle("Toyota", 19000, 75995, 6, null, 4500);
//
//      assertEquals("Toyota", suv.getManufacturerName());
//      assertEquals(19000, suv.getMilesOnVehicle());
//      assertEquals(75995, suv.getPrice());
//      assertEquals(6, suv.getNumberOfSeats());
//      assertEquals(4500, suv.getMaxTowingWeight());
//   }

//   @Test
//   void testGasCar()
//   {
//      GasCar car = new GasCar("BMW", 5500, 75995, 4, null, 2);
//
//      assertEquals("BMW", car.getManufacturerName());
//      assertEquals(5500, car.getMilesOnVehicle());
//      assertEquals(75995, car.getPrice());
//      assertEquals(4, car.getNumberOfSeats());
//      assertEquals(2, car.getNumberOfDoors());
//   }

//   @Test
//   void testCarIsCombustible()
//   {
//	  GasCar car = new GasCar("VW", 5500, 75995, 4, null, 2);
//	  assertEquals(0, car.getFuelLevel());
//	  Combustible combustible = new GasCar("VW", 15500, 45995, 4, null, 2);
//	  // Fuel capacity is 50 units
//	  combustible.addFuel(10);
//	  assertEquals(10, combustible.getFuelLevel());
//	  combustible.addFuel(10);
//	  assertEquals(20, combustible.getFuelLevel());
//	  combustible.addFuel(30);
//	  assertEquals(50, combustible.getFuelLevel());
//	  combustible.addFuel(30);
//	  assertEquals(50, combustible.getFuelLevel());
//	  combustible.addFuel(30);
//	  assertEquals(50, combustible.getFuelLevel());
//   }

//   @Test
//   void testElectricCar()
//   {
//      ElectricCar car = new ElectricCar("Nissan", 10000, 35995, 4, null, 2);
//
//      assertEquals("Nissan", car.getManufacturerName());
//      assertEquals(10000, car.getMilesOnVehicle());
//      assertEquals(35995, car.getPrice());
//      assertEquals(4, car.getNumberOfSeats());
//      assertEquals(2, car.getNumberOfDoors());
//   }

//   @Test
//   void testCarIsChargeable()
//   {
//      Chargeable chargeable = new ElectricCar("Nissan", 10000, 35995, 4, null, 2);
//      assertEquals(0, chargeable.getBatteryCharge());      
//      chargeable.chargeUp(10);
//      assertEquals(10, chargeable.getBatteryCharge());
//      chargeable.chargeUp(10);
//      assertEquals(20, chargeable.getBatteryCharge());
//      chargeable.chargeUp(50);
//      assertEquals(70, chargeable.getBatteryCharge());
//      chargeable.chargeUp(50);
//      assertEquals(100, chargeable.getBatteryCharge());
//      ElectricCar car = new ElectricCar("VW", 5500, 75995, 4, null, 2);
//      car.chargeUp(100);
//      assertEquals(100, car.getBatteryCharge());
//   }

//   @Test
//   void testHybridCar()
//   {
//      HybridCar car = new HybridCar("Toyota", 1000, 63995, 4, null, 2);
// 		// Hint: is it a GasCar that is also chargeable? or an ElectricCar that is also combustible?
//
//      assertEquals("Toyota", car.getManufacturerName());
//      assertEquals(1000, car.getMilesOnVehicle());
//      assertEquals(63995, car.getPrice());
//      assertEquals(4, car.getNumberOfSeats());
//      assertEquals(2, car.getNumberOfDoors());
//   }

//   @Test
//   void testHybridCarIsCombustibleAndChargeable()
//   {
//      HybridCar car = new HybridCar("Toyota", 1000, 63995, 4, null, 2);
//      car.tankUp();
//      assertEquals(50, car.getFuelLevel());
//      car.chargeUp();
//      assertEquals(100, car.getBatteryCharge());
//
//      Combustible combustible = car;
//      assertEquals(50, combustible.getFuelLevel());
//      Chargeable chargeable = car;
//      assertEquals(100, chargeable.getBatteryCharge());
//   }

}
