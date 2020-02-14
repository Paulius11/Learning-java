import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
	
	private List<Card> cardDeck = new ArrayList<>();
	public void add(Card card) {
		cardDeck.add(card);
	}
	
	public void print() {
//		cardDeck.forEach((o)-> System.out.println(o));
		cardDeck.forEach(System.out::println);
	}

	public void sort() {
		Collections.sort(cardDeck);
	}
	public List<Card> getCardDeck() {
		return cardDeck;
	}
	
	public void sortAgainstSuit() {
		cardDeck.sort(new SortAgainstSuit());
	}

	@Override
	public int compareTo(Hand object) {
		int sumOfValue = cardDeck.stream().mapToInt((o)->o.getValue()).sum();
		int sumOfValueObject = object.getCardDeck().stream().mapToInt((o)->o.getValue()).sum();
		return Integer.compare(sumOfValue, sumOfValueObject);
	}
}
