import java.util.*;

public class Train {

	private String name; 
	private int power;
	private ArrayList<Integer> cars = new ArrayList<Integer>();
	
	public Train(String n, int p) {
		try {
			if (n.length() < 1) {
				System.err.println("Parameter n for train must not be empty");
				// break here
			}
			this.name = n;
			this.power = p;
			
		} catch (NullPointerException e) {
			System.out.println(e.toString());
		}
		
	}
	
	private void setCars(int ...c) {
		for (int i = 0; i < c.length; i++) {
			if (c[i] < 1) {
				System.err.println("Car weight cannot be negative.");
				// break here
			}
			 this.cars.add(c[i]);			
		}
	}
	
	private int[] getCars() {
		int[] carsCopy = new int[this.cars.size()];
		for (int i = 0; i < this.cars.size(); i++) {
			carsCopy[i] = this.cars.get(i);
		}
		return carsCopy; 
	}
	
	
	private int getTotalWeightOfCars() {
		int total = 0;
		for (int i = 0; i < getCars().length; i++) {
			total += getCars()[i];
		}
		return total;
	}
	
	private int getNumberOfCars() {
		return getCars().length - 1;
	}
	
	private int maxSpeed() {
		int speed = this.power - this.getTotalWeightOfCars(); 
		if (speed > 150) {
			return 150;
		} else {
			return speed;
		}
	}
	
	private String toString() {
		String info = "*** Train Info ***" + "\n";
		info += "name: " + this.name + "\n";
		info += "power: " + this.power + "\n";
		info += "max speed: " + String.valueOf(this.maxSpeed()) + "\n";
		info += "number of cars: " + this.getNumberOfCars() + "\n";
		info += "total weight of cars: " + this.getTotalWeightOfCars() + "\n";
		
		
		
	}
}
