package moving.logic;

import java.util.ArrayList;
import java.util.List;

import moving.domain.Box;
import moving.domain.Thing;

public class Packer {
	private List<Box> packerBoxes = new ArrayList<>();
	private Box boxy;
	private int boxesVolume;

	public Packer(int boxesVolume) {
		this.boxesVolume = boxesVolume;
		boxy = new Box(boxesVolume); // determines, how big boxes should be
	}

	public List<Box> packThings(List<Thing> things) {
		for (Thing thing : things) {
			if (boxy.addThing(thing)) {

			} else {
				packerBoxes.add(boxy);
				boxy = new Box(boxesVolume);
				boxy.addThing(thing);

			}

		}
		packerBoxes.add(boxy);

		return packerBoxes;
	}
}
