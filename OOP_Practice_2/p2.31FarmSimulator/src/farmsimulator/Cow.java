package farmsimulator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cow implements Milkable, Alive {
	private String name;
	private double udersMilkCapacity = 15 + new Random().nextInt(26);
	private double udersMilkAmount;

	private static final String[] NAMES = new String[] { "Anu", "Arpa", "Essi", "Heluna", "Hely", "Hento", "Hilke",
			"Hilsu", "Hymy", "Ihq", "Ilme", "Ilo", "Jaana", "Jami", "Jatta", "Laku", "Liekki", "Mainikki", "Mella",
			"Mimmi", "Naatti", "Nina", "Nyytti", "Papu", "Pullukka", "Pulu", "Rima", "Soma", "Sylkki", "Valpu",
			"Virpi" };

	public Cow() {
		name = NAMES[new Random().nextInt(NAMES.length)];
	}

	public String getName() {
		return name;
	}

	public Cow(String name) {
		this.name = name;
	}

	public double getCapacity() {
		return udersMilkCapacity;
	}

	public double getAmount() {
		return udersMilkAmount;
	}

	@Override
	public void liveHour() {
		// TODO Auto-generated method stub
		double hourlMilkProduction = ThreadLocalRandom.current().nextInt(7, 20 + 1) / 10.0;
		if (udersMilkAmount + hourlMilkProduction < udersMilkCapacity) {
			udersMilkAmount += hourlMilkProduction;
		}

	}

	@Override
	public double milk() {
		// TODO Auto-generated method stub
		double tempUdersMilkAmount = udersMilkAmount;
		udersMilkAmount = 0;
		return tempUdersMilkAmount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %.2f/%.2f", name, udersMilkAmount, udersMilkCapacity);
	}

}
