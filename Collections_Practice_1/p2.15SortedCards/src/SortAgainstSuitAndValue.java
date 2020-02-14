import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card> {

	@Override
	public int compare(Card obj1, Card obj2) {
		if(obj1.getSuit() == obj2.getSuit())
			return Integer.compare(obj1.getValue(), obj2.getValue());
		return obj1.getSuit() - obj2.getSuit();
	}

}
