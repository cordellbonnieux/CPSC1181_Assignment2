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
		
		// Below are the other get methods 
		int totalWeight = 5 + 10 + 15 + 20 + 25 + 30 + 35;
		assertEquals(totalWeight, train1.getTotalWeightOfCars());
		assertEquals(7, train1.getNumberOfCars());
		
		// expected max speed, maximum possible speed is 150
		int maxSpeed = ((train1.getPower() - totalWeight) > 150) ? 150 : (train1.getPower() - totalWeight);
		assertEquals(maxSpeed, train1.maxSpeed());
		
		train1.removeAllCars();
		assertEquals(0, train1.getCars().length);
	
	}
	
	@Test
	@DisplayName("Test Cars Array for Null")
	void testCarsForNull() throws Exception {
		
		train2 = new Train("Duckie", 100);
		
		try {
			train2.setCars(null);
			fail("Null array should cause exception.");
			
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}
		
		train2.setCars(1, 2);
		assertArrayEquals(new int[] {1, 2}, train2.getCars());
		
		
		try {
			train2.addCars(null);
			fail("Null array should cause exception.");
			
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}
		
		train2.addCars(3, 4);
		assertArrayEquals(new int[] {1, 2, 3, 4}, train2.getCars());
		
		// .addCars() also works without .setCars() being used
		train2.removeAllCars();
		train2.addCars(10, 15);
		assertArrayEquals(new int[] {10, 15}, train2.getCars());

	}
	
	@Test
	@DisplayName("Test Merging Trains")
	void testMergeTrains () throws Exception{
		
		// expected values for each train
		int pow = 100, numOfCars = 5, totalWeight = 15;
		int[] carsArray = new int[] {1, 2, 3, 4, 5}, mergedArrays = new int[] {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
		
		// two trains with the same values
		train1 = new Train("Denis", pow);
		train1.setCars(carsArray);
		assertEquals(pow, train1.getPower());
		assertEquals(numOfCars, train1.getNumberOfCars());
		assertEquals(totalWeight, train1.getTotalWeightOfCars());
		
		train2 = new Train("Julian", pow);
		train2.setCars(carsArray);
		assertEquals(pow, train2.getPower());
		assertEquals(numOfCars, train2.getNumberOfCars());
		assertEquals(totalWeight, train2.getTotalWeightOfCars());
		
		// train1 now has all attributes of train2 (excluding the same)
		train1.mergeTrains(train2);
		assertArrayEquals(mergedArrays, train1.getCars());
		assertEquals(pow * 2, train1.getPower());
		assertEquals(numOfCars * 2, train1.getNumberOfCars());
		assertEquals(totalWeight * 2, train1.getTotalWeightOfCars());
		
		// train2 now has no power or cars
		assertEquals(0, train2.getCars().length);
		assertEquals(0, train2.getPower());
		assertEquals(0, train2.getNumberOfCars());
		assertEquals(0, train2.getTotalWeightOfCars());
		
		// test merging with null 
		try {
			train2.mergeTrains(null);
			fail("Null object pointer should throw exception.");
			
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}
		
	}

}
