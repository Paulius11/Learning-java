package moving.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Item implements Thing, Comparable<Item> {

	private String name;
	private int volume;

	public Item(String name, int volume) {
		this.name = name;
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public String toString() {
		return String.format("%s (%d dm^3)", name, volume);
	}

	@Override
	public int compareTo(Item o) {
		if (this.volume > o.volume)
			return 1;
		if (this.volume < o.volume)
			return -1;
		return 0;
	}

}
