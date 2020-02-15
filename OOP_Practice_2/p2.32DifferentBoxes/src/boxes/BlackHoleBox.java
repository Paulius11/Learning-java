package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box {
	private List<Thing> listOfThings = new ArrayList<>();

	@Override
	public void add(Thing thing) {
		listOfThings.add(thing);

	}

	@Override
	public boolean isInTheBox(Thing thing) {
		// TODO Auto-generated method stub
		return false;
	}

}
