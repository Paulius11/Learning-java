package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {

	private int maximumCapacity;
	private List<Thing> boxy = new ArrayList<>();

	public Box(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}

	public boolean addThing(Thing thing) {
		if (thing.getVolume() + getVolume() > maximumCapacity)
			return false;
		boxy.add(thing);
		return true;

	}

	@Override
	public int getVolume() {
		return boxy.stream().map(x -> x.getVolume()).reduce(Integer::sum).orElse(0);
	}

	public static void main(String[] args) {
		Box box = new Box(1000);
		box.addThing(new Item("AAA", 10));
		box.addThing(new Item("BBB", 5));
		System.out.println(box.getVolume());
	}

}
