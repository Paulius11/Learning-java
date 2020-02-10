package dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

	private Map<String, Set<String>> hashMapValues = new HashMap<>();

	@Override
	public void add(String word, String entry) {
		if (hashMapValues.get(word) == null) {
			hashMapValues.put(word, new HashSet<String>(Arrays.asList(entry)));
		} else {
			hashMapValues.get(word).add(entry);
		}

	}

	@Override
	public Set<String> translate(String word) {
		return hashMapValues.get(word);
	}

	@Override
	public void remove(String word) {
		hashMapValues.remove(word);
	}

}
