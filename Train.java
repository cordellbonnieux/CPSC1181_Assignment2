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
 */

public class Train {

	private String name; 
	private int power;
	private int[] cars = new int[0];
	
	/**
	 * Train Constructor
	 * Used to create an instance of Train.
	 * @param n String representing the name.
	 * @param p integer representing the power.
	 * @throws Exception IllegalArgumentException thrown if (n < 0) OR (p < 0).
	 */
	public Train(String n, int p) throws Exception{
		if (n == null) {
			throw new IllegalArgumentException("Name cannot be empty.");
		} else if (p < 0) {
			throw new IllegalArgumentException("Power must be greater than zero.");
		}
		this.name = n;
		this.power = p;
	}
	
	/**
	 * Set Name
	 * Sets the name of the caller instance.
	 * @param n String representing the name.
	 */
	public void setName(String n) {
		this.name = n;
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
	 */
	public void setPower(int p) {
		this.power = p;
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
	 * setCars()
	 * Sets the caller instance's cars array. 
	 * To append cars to the existing array use addCars(int[]).
	 * @param c
	 * @throws Exception
	 */
	public void setCars(int... c) throws Exception {
		int[] newCars = new int[c.length];
		for (int i = 0; i < newCars.length; i++) {
			if (newCars[i] < 0) {
				throw new IllegalArgumentException("Car weight cannot be negative.");
			}
			newCars[i] = c[i];
		}
		this.cars = new int[newCars.length];
		for (int i = 0; i < newCars.length; i++) {
			this.cars[i] = newCars[i];
		}
	}
	
	/**
	 * addCars()
	 * Appends cars to the end of an instance's cars array.
	 * @param c
	 */
	public void addCars(int... c) throws Exception{
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
	public int[] getCars() {
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
	public int getTotalWeightOfCars() {
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
	public int getNumberOfCars() {
		return getCars().length;
	}
	
	/**
	 * maxSpeed() - Returns the total total speed of the caller's train,
	 * which is calculated by subtracting the total weight of the cars array
	 * from the train's power. If the power is over the maximum speed of 150, then the speed
	 * is truncated to 150.
	 * @return
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
	 * removeAllCars() - Removes all items from the caller's cars array.
	 */
	public void removeAllCars() {
		this.cars = new int[0];
	}
	
	/**
	 * mergeTrains() -
	 * @param other
	 */
	public void mergeTrains(Train other) {
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
	public String toString() {
		String info = "*** Train Info ***" + "\n";
		info += "name: " + this.name + "\n";
		info += "power: " + this.power + "\n";
		info += "max speed: " + String.valueOf(this.maxSpeed()) + "\n";
		info += "number of cars: " + String.valueOf(this.getNumberOfCars()) + "\n";
		info += "total weight of cars: " + this.getTotalWeightOfCars() + "\n";
		return info;	
	}
}
