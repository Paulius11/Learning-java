import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

	private Map<String, String> translateWordMap = new HashMap<>();

	public void add(String english, String finish) {
		translateWordMap.put(english, finish);
	}

	public String translate(String englishString) {
		if (translateWordMap.containsKey(englishString)) {
			return translateWordMap.get(englishString);
		}
		return null;
	}

	public int amountOfWords() {
		return translateWordMap.size();
	}

	public ArrayList<String> translationList() {
		ArrayList<String> listOfTranslatedWords = new ArrayList<>();
		translateWordMap.forEach((k, v) -> listOfTranslatedWords.add(k + " = " + v));
		return listOfTranslatedWords;
	}

}
