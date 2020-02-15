package farmsimulator;

import java.util.Collection;

public class CowHouse {

	private BulkTank tank;
	private MilkingRobot milkingRobot;

	public CowHouse(BulkTank tank) {
		this.tank = tank;
	}

	public BulkTank getBulkTank() {
		return tank;
	}

	public void installMilkingRobot(MilkingRobot milkingRobot) {
		this.milkingRobot = milkingRobot;
	}

	public void takeCareOf(Cow cow) {
		if (milkingRobot == null)
			throw new IllegalStateException();
		else
			tank.addToTank(cow.milk());

	}

	public void takeCareOf(Collection<Cow> cows) {
		if (milkingRobot == null)
			throw new IllegalStateException();
		else
			cows.stream().forEach(x -> tank.addToTank(x.milk()));
	}

	@Override
	public String toString() {
		return String.format("%.2f/%.2f ", tank.getVolume(), tank.getCapacity());
	}
}
