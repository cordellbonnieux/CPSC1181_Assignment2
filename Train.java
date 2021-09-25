import java.util.*;
/**
 * Train.class
 *  
 *  This class simulates a freight train.
 *  
 *  Each train has a name, an integer representing it's engine power, 
 *  and an integer array of freight cars where the integer value of each array item 
 *  represents the weight(in tons) of that car.
 * 
 * @author Cordell Bonnieux	@version 1.0.0
 */

public class Train {

	private String name; 
	private int power;
	private int[] cars = new int[0];
	
	/**
	 * Train() - constructor method, used to create an instance of Train.
	 * @param n
	 * @param p
	 * @throws Exception
	 */
	public Train(String n, int p) throws Exception{
		if (n.length() < 1) {
			throw new IllegalArgumentException("Parameter n for train must not be empty");
		} else if (p < 0) {
			throw new IllegalArgumentException("power cannot be negative");
		}
		this.name = n;
		this.power = p;
	}
	
	/**
	 * setCars() - adds cars to the end of an instance's cars array.
	 * @param c
	 */
	private void setCars(int... c) throws Exception{
		int[] newCars = new int[c.length + this.cars.length];
		for (int i = 0; i < newCars.length; i++) {
			if (newCars[i] < 0) {
				throw new IllegalArgumentException("Car weight cannot be negative.");
			}
			if (i < this.cars.length) {
				newCars[i] = this.cars[i];
				
			} else {
				newCars[i] = c[i - this.cars.length];
			}
		}
		this.cars = new int[newCars.length];
		for (int i = 0; i < newCars.length; i++) {
			this.cars[i] = newCars[i];
		}
	}
	
	/**
	 * getCars() - Creates and returns a copy of the current instance's cars array.
	 * @return
	 */
	private int[] getCars() {
		int[] carsCopy = new int[this.cars.length];
		for (int i = 0; i < this.cars.length; i++) {
			carsCopy[i] = this.cars[i];
		}
		return carsCopy; 
	}
	
	/**
	 * getTotalWeightOfCars() - Adds and returns the sum of all 
	 * of the caller's cars array items.
	 * @return 
	 */
	private int getTotalWeightOfCars() {
		int total = 0;
		for (int i = 0; i < this.cars.length; i++) {
			total += this.cars[i];
		}
		return total;
	}
	
	/**
	 * getNumberOfCars() - Returns the number of items in the caller's cars array.
	 * @return
	 */
	private int getNumberOfCars() {
		return getCars().length;
	}
	
	/**
	 * maxSpeed() - Returns the total total speed of the caller's train,
	 * which is calculated by subtracting the total weight of the cars array
	 * from the train's power. If the power is over the maximum speed of 150, then the speed
	 * is truncated to 150.
	 * @return
	 */
	private int maxSpeed() {
		int speed = this.power - this.getTotalWeightOfCars(); 
		if (speed > 150) {
			return 150;
		} else {
			return speed;
		}
	}
	
	/**
	 * removeAllCars() - Removes all items from the caller's cars array.
	 */
	private void removeAllCars() {
		this.cars = new int[0];
	}
	
	/**
	 * mergeTrains() -
	 * @param other
	 */
	private void mergeTrains(Train other) {
		this.power += other.power;
		int[] mergedCars = new int[this.cars.length + other.cars.length];
		for (int i = 0; i < (other.cars.length + this.cars.length); i++) {
			if (i < this.cars.length) {
				mergedCars[i] = this.cars[i];
			} else {
				mergedCars[i] = other.cars[i - this.cars.length];
			}
		}
		other.power = 0;
		other.removeAllCars();
		this.cars = new int[mergedCars.length];
		for (int i = 0; i < mergedCars.length; i++) {
			this.cars[i] = mergedCars[i];
		}
	}
	
	/**
	 * toString()
	 * @return
	 */
	private String toString() {
		String info = "*** Train Info ***" + "\n";
		info += "name: " + this.name + "\n";
		info += "power: " + this.power + "\n";
		info += "max speed: " + String.valueOf(this.maxSpeed()) + "\n";
		info += "number of cars: " + String.valueOf(this.getNumberOfCars()) + "\n";
		info += "total weight of cars: " + this.getTotalWeightOfCars() + "\n";
		return info;	
	}
}
