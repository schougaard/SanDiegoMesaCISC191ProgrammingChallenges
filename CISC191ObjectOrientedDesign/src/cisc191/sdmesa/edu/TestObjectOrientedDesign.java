package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
//   void testOption()
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
//      Combustible combustible = new GasCar("VW", 15500, 45995, 4, null, 2);
//      combustible.tankUp();
//      assertEquals(100, combustible.getFuelLevel());
//      GasCar car = new GasCar("VW", 5500, 75995, 4, null, 2);
//      car.tankUp();
//      assertEquals(100, car.getFuelLevel());
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
//      chargeable.chargeUp();
//      assertEquals(100, chargeable.getBatteryCharge());
//      ElectricCar car = new ElectricCar("VW", 5500, 75995, 4, null, 2);
//      car.chargeUp();
//      assertEquals(100, car.getBatteryCharge());
//   }

//   @Test
//   void testHybridCar()
//   {
//      HybridCar car = new HybridCar("Toyota", 1000, 63995, 4, null, 2);
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
//      assertEquals(100, car.getFuelLevel());
//      car.chargeUp();
//      assertEquals(100, car.getBatteryCharge());
//
//      Combustible combustible = car;
//      assertEquals(100, combustible.getFuelLevel());
//      Chargeable chargeable = car;
//       assertEquals(100, chargeable.getBatteryCharge());
//   }

}
