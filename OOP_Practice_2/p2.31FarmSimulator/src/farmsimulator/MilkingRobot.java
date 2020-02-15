package farmsimulator;

public class MilkingRobot {

	private BulkTank tank;

	public MilkingRobot() {

	}

	public BulkTank getBulkTank() {
		return tank;
	}

	public void setBulkTank(BulkTank tank) {
		this.tank = tank;
	}

	public void milk(Milkable milkable) {
		if (tank == null)
			throw new IllegalStateException();
		else
			tank.addToTank(milkable.milk());

	}
}
