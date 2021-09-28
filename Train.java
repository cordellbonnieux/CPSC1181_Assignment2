/**
 * Train.class
 *  
 *  This class simulates a freight train.
 *  
 *  Each train has a name, an integer representing it's engine power, 
 *  and an integer array of freight cars where the integer value of each array item 
 *  represents the weight(in tons) of that car.
 * 
 * @author Cordell Bonnieux	
 * @version 1.0.0
 * @since September 27 2021
 */

public class Train {

	private String name; 
	private int power;
	private int[] cars = new int[0];
	
	/**
	 * Train Constructor
	 * Used to create an instance of Train.
	 * n represents it's name, and p represents it's power.
	 * @param n String representing the name.
	 * @param p integer representing the power.
	 * @exception IllegalArgumentException if p is negative
	 * @exception NullPointerException if n is null
	 */
	public Train(String n, int p) {
		if (p < 0) { 
			throw new IllegalArgumentException("Power cannot be negative.");
			
		} else {
			this.power = p;
		}
		
		if (n == null) {
			throw new NullPointerException("Name cannot be null");
			
		} else {
			this.name = n;	
		}
	}
	
	/**
	 * Set Name
	 * Sets the name of the caller instance.
	 * @param n String representing the name.
	 * @exception NullPointerException if n is null
	 */
	public void setName(String n) {
		if (n.equals(null)) {
			throw new NullPointerException("Name cannot be null");
			
		} else {
			this.name = n;
		}
	}
	/**
	 * Get Name
	 * Returns the name of the caller instance.
	 * @return String representing the name.
	 */
	public String getName() {
		String n = this.name;
		return n;
	}
	
	/**
	 * Set Power
	 * Sets the power of the caller instance.
	 * @param p integer representing the power.
	 * @exception IllegalArgumentException if p is negative
	 */
	public void setPower(int p) {
		if (p < 0) { 
			throw new IllegalArgumentException("Power cannot be negative.");
			
		} else {
			this.power = p;
		}
	}
	
	/**
	 * Get Power
	 * Returns the power of the caller instance.
	 * @return integer representing the power.
	 */
	public int getPower() {
		int p = this.power;
		return p;
	}
	
	/**
	 * Set Cars
	 * Sets the caller instance's cars array. 
	 * To append cars to the existing array use addCars(int[]).
	 * @param c an array of integers
	 * @exception NullPointerException if c is null
	 * @exception IllegalArgumentException if "i" in c is negative OR zero
	 */
	public void setCars(int... c) throws Exception{
		if (c.equals(null)) {
			throw new NullPointerException("Cars array cannot point to null");
		}
		int[] newCars = new int[c.length];
		for (int i = 0; i < newCars.length; i++) {
			if (c[i] < 1) {
				throw new IllegalArgumentException("Car weight cannot be negative or zero");
				
			} else {
				newCars[i] = c[i];	
			}
		}
		
		this.cars = new int[newCars.length];
		for (int i = 0; i < newCars.length; i++) {
			this.cars[i] = newCars[i];
		}
	}
	
	/**
	 * Add Cars
	 * Appends cars to the end of an instance's cars array.
	 * @param c an array of integers
	 * @exception NullPointerException if c is null
	 * @exception IllegalArgumentException if "i" in c is negative OR zero
	 */
	public void addCars(int... c) {	
		if (c.equals(null)) {
			throw new NullPointerException("Cars array cannot point to null");
		}
		int[] newCars = new int[c.length + this.cars.length];	
		for (int i = 0; i < newCars.length; i++) {
			if (i < this.cars.length) {
				newCars[i] = this.cars[i];
				
			} else if (c[i - this.cars.length] >= 1){
				newCars[i] = c[i - this.cars.length];
				
			} else {
				throw new IllegalArgumentException("Car weight cannot be negative or zero");
			}
		}
		
		this.cars = new int[newCars.length];
		for (int i = 0; i < newCars.length; i++) {
			this.cars[i] = newCars[i];
		}
	}
	
	/**
	 * Get Cars
	 * Creates and returns a copy of the current instance's cars array.
	 * @return an array of integers, representing the train's car's weights
	 */
	public int[] getCars() {
		int[] carsCopy = new int[this.cars.length];
		for (int i = 0; i < this.cars.length; i++) {
			carsCopy[i] = this.cars[i];
		}
		return carsCopy; 
	}
	
	/**
	 * Get Total Weight Of Cars
	 * Adds and returns the sum of all of the caller's cars array items.
	 * @return an integer representing the summed weight of cars
	 */
	public int getTotalWeightOfCars() {
		int total = 0;
		for (int i = 0; i < this.cars.length; i++) {
			total += this.cars[i];
		}
		return total;
	}
	
	/**
	 * Get Number Of Cars
	 * Returns the number of items in the caller's cars array.
	 * @return an integer representing the number of cars
	 */
	public int getNumberOfCars() {
		return getCars().length;
	}
	
	/**
	 * Max Speed
	 * Returns the total total speed of the caller's train,
	 * which is calculated by subtracting the total weight of the cars array
	 * from the train's power. If the power is over the maximum speed of 150, then the speed
	 * is truncated to 150.
	 * @return an integer representing the maximum speed of the train
	 */
	public int maxSpeed() {
		int speed = this.power - this.getTotalWeightOfCars(); 
		if (speed > 150) {
			return 150;
			
		} else {
			return speed;
		}
	}
	
	/**
	 * Remove All Cars
	 * Removes all items from the caller's cars array.
	 */
	public void removeAllCars() {
		this.cars = new int[0];
	}
	
	/**
	 * Merge Trains
	 * Merges other with the caller Train, by transferring other's power
	 * and cars array to the caller.
	 * @param other a Train object
	 * @exception NullPointerException if other is null
	 */
	public void mergeTrains(Train other) {
		if (other.equals(null)) {
			throw new NullPointerException("Train cannot be merged with null");
		}
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
	 * To String
	 * @return a String describing the caller's attributes
	 */
	public String toString() {
		String info = "*** Train Info ***" + "\n";
		info += "Name: " + this.name + "\n";
		info += "Power: " + this.power + "\n";
		info += "Max speed: " + String.valueOf(this.maxSpeed()) + "\n";
		info += "Number of cars: " + String.valueOf(this.getNumberOfCars()) + "\n";
		info += "Total weight of cars: " + this.getTotalWeightOfCars() + "\n";
		info += "Weight of Cars: ";
		for (int i = 0; i < this.cars.length; i++) {
			if (i != this.cars.length - 1) {
				info += this.cars[i] + ", ";
			} else {
				info += this.cars[i];
			}
		}
		return info;	
	}
}
