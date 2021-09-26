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
		
		train2 = new Train(train1.getName(), train1.getPower());
		assertEquals(train1.getName(), train2.getName());
		
		train1.setName("");
		assertEquals("", train1.getName());
		
		train2.setName("Insane Train");
		assertEquals("Insane Train", train2.getName());
	}

	@Test
	@DisplayName("Test Power")
	void setPowerTest() {

		train1 = new Train("Dean", 1);
		assertEquals(1, train1.getPower());
		
		train1.setPower(0);
		assertEquals(0, train1.getPower());
		
		train2 = new Train("Jones", -1);
		assertEquals(0, train2.getPower());
		
		train1.setPower(train2.getPower());
		assertEquals(0,train1.getPower());
		
		train2.setPower(500);
		assertEquals(500, train2.getPower());
		
		train1.setPower(-500);
		assertEquals(0, train1.getPower());		
	}

	@Test
	@DisplayName("Test Cars Array")
	void testCars() {
		
		train1 = new Train("Thomas", 400);
		train1.setCars(new int[] {0, 3, 24, 7, 84, 0, 0, 0});
		int[] arr = {1, 3, 24, 7, 84, 1, 1, 1};
		assertArrayEquals(arr, train1.getCars());
		
		train1.addCars(5, 6, 7, 8);
		int[] arr2 = {1, 3, 24, 7, 84, 1, 1, 1, 5, 6, 7, 8};
		assertArrayEquals(arr2, train1.getCars());
		
		int total = 1 + 3 + 24 + 7 + 84 + 1 + 1 + 1 + 5 + 6 + 7 + 8;
		assertEquals(total, train1.getTotalWeightOfCars());
		
		int numOfCars = 12;
		assertEquals(numOfCars, train1.getNumberOfCars());
		
		int speed = train1.getPower() - (1 + 3 + 24 + 7 + 84 + 1 + 1 + 1 + 5 + 6 + 7 + 8);
		if (speed > 150) {
			assertEquals(150, train1.maxSpeed());
		} else {
			assertEquals(speed, train1.maxSpeed());
		}
		
		train1.removeAllCars();
		assertEquals(0, train1.getTotalWeightOfCars());
		
		int[] empty = new int[0];
		assertArrayEquals(empty, train1.getCars());
		
		train2 = new Train("Terry", 100);
		train2.setCars(-24, -88, -300, 0, -10, 1);
		assertEquals(6, train2.getTotalWeightOfCars());
		assertEquals(train2.getTotalWeightOfCars(), train2.getNumberOfCars());
		
		train1 = new Train("Skeeter", 69);
		train1.setCars(null);
		assertArrayEquals(empty, train1.getCars());
		assertEquals(train1.getTotalWeightOfCars(), train1.getNumberOfCars());
		
		train1.setCars(0, -1, 300, 22, 1);
		assertEquals(325, train1.getTotalWeightOfCars());
		assertEquals(5, train1.getNumberOfCars());
		
	}
	
	@Test
	@DisplayName("Test Merging Trains")
	void testMergeTrains () {
		
		train1 = new Train("Denis", 44);
		train2 = new Train("Julian", 66);
		
		train1.setCars(1, 2, 3, 4, 5);
		assertEquals(5, train1.getNumberOfCars());
		assertEquals(15, train1.getTotalWeightOfCars());
		assertEquals(29, train1.maxSpeed());
		
		train2.setCars(6, 7, 8, 9, 10);
		assertEquals(5, train2.getNumberOfCars());
		assertEquals(40, train2.getTotalWeightOfCars());
		assertEquals(26, train2.maxSpeed());
	}
	
	

}
