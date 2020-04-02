import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class StorageFacility {
	private HashMap<String, String> map = new HashMap<>();
	private HashMap<String, ArrayList<String>> arrayMap = new HashMap<>();

	public void add(String unit, String item) {
		if (map.containsKey(unit)) {
			arrayMap.get(unit).add(item);
		} else {
			arrayMap.put(unit, new ArrayList<String>());
			arrayMap.get(unit).add(item);
			map.put(unit, item);
		}

	}

	public void remove(String storageUnit, String item) {
		if (arrayMap.get(storageUnit).contains(item)) {
			arrayMap.get(storageUnit).remove(item);
		}
	}

	public ArrayList<String> storageUnits() {
		ArrayList<String> list = new ArrayList<>();
		for (Entry<String, ArrayList<String>> s : arrayMap.entrySet()) {
			if (s.getValue().isEmpty()) {
			} else {
				list.add(s.getKey());
			}
		}
		return list;
	}

	public ArrayList<String> contents(String storageUnit) {
		ArrayList<String> emptyList = new ArrayList<String>();
		return arrayMap.getOrDefault(storageUnit, emptyList);
	}

}
