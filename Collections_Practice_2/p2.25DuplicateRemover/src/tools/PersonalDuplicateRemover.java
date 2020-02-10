package tools;

import java.util.Set;
import java.util.TreeSet;

public class PersonalDuplicateRemover implements DuplicateRemover {
	private Set<String> uniqueWordList = new TreeSet<String>();
	private int doublicateCounter = 0;

	@Override
	public void add(String characterString) {
		if (uniqueWordList.contains(characterString))
			doublicateCounter++;
		else
			uniqueWordList.add(characterString);
	}

	@Override
	public int getNumberOfDetectedDuplicates() {
		return doublicateCounter;
	}

	@Override
	public Set<String> getUniqueCharacterStrings() {
		return uniqueWordList;
	}

	@Override
	public void empty() {
		uniqueWordList.clear();
		doublicateCounter = 0;
	}

}
