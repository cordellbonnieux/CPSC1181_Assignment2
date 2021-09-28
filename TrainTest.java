import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @author Cordell Bonnieux
 * @since September 24 2021
 * 
 */
public class TrainTest {
	
	private Train train1;
	private Train train2;
	
	@Test
	@DisplayName("Test Name")
	void setNameTest() {
		
		train1 = new Train("Moro", 120);
		assertEquals("Moro", train1.getName());
		
		train1.setName("Donnie");
		assertEquals("Donnie", train1.getName());
		
		train1.setName("");
		assertEquals("", train1.getName());
		
		try {
			train1.setName(null);
			fail("Name as null should throw an exception.");
			
		} catch (NullPointerException e) {
			assertEquals(null, e.getMessage());
		}
		
		try {
			train1 = new Train(null, 44);
			fail("Name as null should throw an exception.");
			
		} catch (NullPointerException e) {
			assertEquals("Name cannot be null", e.getMessage());
		}
	}

	@Test
	@DisplayName("Test Power")
	void setPowerTest() {

		train1 = new Train("Dean", 1);
		assertEquals(1, train1.getPower());
		
		train1.setPower(0);
		assertEquals(0, train1.getPower());
		
		try {
			train1.setPower(-1);
			fail("Negative number should throw exception.");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Power cannot be negative.", e.getMessage());
		}
		
		try {
			train1 = new Train("Jones", -1);
			fail("Negative number should throw exception.");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Power cannot be negative.", e.getMessage());
		}
	}

	@Test
	@DisplayName("Test Cars Array")
	void testCars() throws Exception{
		
		train1 = new Train("Thomas", 400);
		int[] badValues = new int[] {52, 3, 24, 7, 84, 0, -3, 10}; // contains 0 & negative numbers
		int[] goodValues = new int[] {5, 10, 15, 20, 25}; // reasonable weights in tons for a train cars
		
		try {
			train1.setCars(badValues);
			fail("Weight of 0 should throw exception");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Car weight cannot be negative or zero", e.getMessage());
		}
		
		train1.setCars(goodValues);
		assertArrayEquals(goodValues, train1.getCars());
		
		try {
			train1.addCars(badValues);
			fail("Weight of 0 should throw exception");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Car weight cannot be negative or zero", e.getMessage());
		}
		
		assertArrayEquals(goodValues, train1.getCars());
		
		train1.addCars(30, 35);
		assertArrayEquals(new int[] {5, 10, 15, 20, 25, 30, 35}, train1.getCars());
		
		// ok now test all the other methods for the train cars!		
	}
	
	@Test
	@DisplayName("Test Cars Array for Null")
	void testCarsForNull() throws Exception {
		
		train2 = new Train("Terry", 100);
		try {
			train2.setCars(-24, -88, -300, 0, -10, 1);
			
		} catch (NullPointerException e) {
			fail("Valid int[] threw exception \n" + e.getMessage());
		}
		
		assertEquals(6, train2.getTotalWeightOfCars());
		assertEquals(train2.getTotalWeightOfCars(), train2.getNumberOfCars());
		
		train1 = new Train("Skeeter", 69);
		try {
			train1.setCars(null);
			fail("Null should throw an exception.");
			
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "null");
			
		}
		
		train1.setCars(0, -1, 300, 22, 1);
		assertEquals(325, train1.getTotalWeightOfCars());
		assertEquals(5, train1.getNumberOfCars());
		
		train1.addCars(1, 2, -1, 0);
		assertEquals(330, train1.getTotalWeightOfCars());
		assertEquals(9, train1.getNumberOfCars());
		
		
		
	}
	
	@Test
	@DisplayName("Test Merging Trains")
	void testMergeTrains () throws Exception{
		
		train1 = new Train("Denis", 44);
		train2 = new Train("Julian", 66);
		
		try {
			train1.setCars(1, 2, 3, 4, 5);
			
		} catch (NullPointerException e) {
			fail("Valid int[] threw exception \n" + e.getMessage());
		}
		
		assertEquals(5, train1.getNumberOfCars());
		assertEquals(15, train1.getTotalWeightOfCars());
		assertEquals(29, train1.maxSpeed());
		
		try {
			train2.setCars(6, 7, 8, 9, 10);
			
		} catch (NullPointerException e) {
			fail("Valid int[] threw exception \n" + e.getMessage());
		}
		
		assertEquals(5, train2.getNumberOfCars());
		assertEquals(40, train2.getTotalWeightOfCars());
		assertEquals(26, train2.maxSpeed());
		
		
		int[] expectedCars = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int expectedWeight = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
		int expectedPower = train1.getPower() + train2.getPower();
		int expectedMaxSpeed = train1.maxSpeed() + train2.maxSpeed();
				
		train1.mergeTrains(train2);
		assertEquals(expectedMaxSpeed, train1.maxSpeed());
		assertEquals(expectedPower, train1.getPower());
		assertEquals(expectedWeight, train1.getTotalWeightOfCars());
		assertArrayEquals(expectedCars, train1.getCars());
		
		assertEquals(0, train2.getPower());
		assertEquals(0, train2.maxSpeed());
		assertEquals(0, train2.getTotalWeightOfCars());
		assertArrayEquals(new int[0], train2.getCars());
		
	}
	
	

}
