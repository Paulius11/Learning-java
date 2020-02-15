package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

	private String farmOwner;
	private CowHouse barn;
	private List<Cow> listOfCows = new ArrayList<>();

	public Farm(String name, CowHouse barn) {
		farmOwner = name;
		this.barn = barn;

	}

	@Override
	public void liveHour() {
		listOfCows.stream().forEach(cow -> cow.liveHour());

	}

	public void installMilkingRobot(MilkingRobot milkingRobot) {
		barn.installMilkingRobot(milkingRobot);
	}

	public void manageCows() {
		barn.takeCareOf(listOfCows);
	}

	public String getOwner() {
		return farmOwner;
	}

	public void addCow(Cow cow) {
		listOfCows.add(cow);
	}

	@Override
	public String toString() {
		String result = "Farm farmOwner: " + farmOwner + "\n" + "Barn : " + barn + "\n" + "Animals: " + "\n";
		for (Cow cow : listOfCows) {
			result += cow + "\n";
		}
		return result;
	}

}
