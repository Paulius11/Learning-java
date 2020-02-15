package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {

	private int capasity;

	private List<Thing> listOfThings = new ArrayList<>();

	public MaxWeightBox(int maxWeight) {
		this.capasity = maxWeight;
	}

	public void add(Thing thing) {
		int totalVolume = listOfThings.stream().mapToInt(x -> x.getWeight()).sum();
		if (totalVolume + thing.getWeight() <= capasity)
			listOfThings.add(thing);

	}

	public boolean isInTheBox(Thing thing) {
		for (Thing t : listOfThings) {
			if (t.getName().equals(thing.getName()))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Box box = new MaxWeightBox(5);
		box.add(new Thing("a", 1));
		box.add(new Thing("b", 2));
		box.add(new Thing("c", 2));
		box.add(new Thing("d", 1));
		box.add(new Thing("f", 0));
		System.out.println(box.isInTheBox(new Thing("c")));
	}

}
