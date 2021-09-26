import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 * @author Cordell Bonnieux
 * @since September 24 2021
 * 
 */
public class TrainTest {
	
	private Train train1;
	//private Train train2;
	
	@Test
	@DisplayName("Constructor Name Null Test")
	void constructorNameNullTest() throws Exception{
		try {
			train1 = new Train("", 99);
		} catch (IllegalArgumentException e) {
			assertEquals("Name cannot be empty.", e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Constructor Negative Power Test")
	void constructorNegativePowerTest() throws Exception{
		try {
			train1 = new Train("Choo Choo Express", -1);
		} catch (IllegalArgumentException e) {
			assertEquals("Power must be greater than zero.", e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Test Name")
	void setNameTest() throws Exception{
		try {
			train1 = new Train("Moro", 120);
		} catch (IllegalArgumentException e) {
			fail("setNameTest() instance assignment failed.");
		}
		assertEquals("Moro", train1.getName());
		
		train1.setName("Donnie");
		assertEquals("Donnie", train1.getName());		
	}

	@Test
	@DisplayName("Test Power")
	void setPowerTest() throws Exception{
		try {
			train1 = new Train("Dean", 25);
		} catch (IllegalArgumentException e) {
			fail("setPowerTest() first instance assignment failed.");
		}
		assertEquals(25, train1.getPower());
		
		train1.setPower(666);
		assertEquals(666, train1.getPower());		
	}


}
