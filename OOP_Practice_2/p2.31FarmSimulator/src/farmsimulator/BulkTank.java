package farmsimulator;

import java.util.concurrent.ThreadLocalRandom;

public class BulkTank {
	private double capacity;
	private double volume;

	public double getCapacity() {
		return capacity;
	}

	public double getVolume() {
		return volume;
	}

	public BulkTank() {
		capacity = 2000;
	}

	public double howMuchFreeSpace() {
		return capacity - volume;
	}

	public void addToTank(double amount) {
		if (amount > 0) {
			if (amount > capacity)
				volume = capacity;
			else
				volume += amount;
		}

	}

	public BulkTank(double capacity) {
		this.capacity = capacity;
	}

	public double getFromTank(double amount) {
		if (amount > 0) {
			if (amount > volume) {
				double tempVolume = volume;
				volume = 0;
				return tempVolume;
			}
			if (volume - amount > 0) {
				volume = volume - amount;
				return volume;
			}

		}
		return 0;

	}

	@Override
	public String toString() {
		return String.format("%.2f/%.2f", volume, capacity);

	}

}
