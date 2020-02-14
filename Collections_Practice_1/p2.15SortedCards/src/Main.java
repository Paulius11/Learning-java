import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
    	// 15.1
//    	Card first = new Card(2, Card.DIAMONDS);
//    	Card second = new Card(14, Card.CLUBS);
//    	Card third = new Card(12, Card.HEARTS);
//    	System.out.println(first);
//    	System.out.println(second);
//    	System.out.println(third);
//    	System.out.println(first.compareTo(second));
    	
    	// 15.2
//    	Hand hand = new Hand();
//    	hand.add( new Card(2, Card.SPADES) );
//    	hand.add( new Card(14, Card.CLUBS) );
//    	hand.add( new Card(12, Card.HEARTS) );
//    	hand.add( new Card(2, Card.CLUBS) );
//    	hand.print();
    	
    	// 15.3
//    	Hand hand = new Hand();
//    	hand.add( new Card(2, Card.SPADES) );
//    	hand.add( new Card(14, Card.CLUBS) );
//    	hand.add( new Card(12, Card.HEARTS) );
//    	hand.add( new Card(2, Card.CLUBS) );
//    	hand.sort();
//    	hand.print();
    	
    	// 15.4
//    	Hand hand1 = new Hand();
//    	hand1.add( new Card(2, Card.SPADES) );
//    	hand1.add( new Card(14, Card.CLUBS) );
//    	hand1.add( new Card(12, Card.HEARTS) );
//    	hand1.add( new Card(2, Card.CLUBS) );
//    	Hand hand2 = new Hand();
//    	hand2.add( new Card(11, Card.DIAMONDS) );
//    	hand2.add( new Card(11, Card.CLUBS) );
//    	hand2.add( new Card(11, Card.HEARTS) );
//    	int comparison = hand1.compareTo(hand2);
//    	if ( comparison < 0 ) {
//	    	System.out.println("the most valuable hand contains the cards");
//	    	hand2.print();
//    	} else if ( comparison > 0 ){
//	    	System.out.println("the most valuable hand contains the cards");
//	    	hand1.print();
//    	} else {
//    		System.out.println("the hands are equally valuable");
//    	}
    
    	// 15.5
//    	ArrayList<Card> cards = new ArrayList<Card>();
//    	cards.add( new Card(3, Card.CLUBS) );
//    	cards.add( new Card(2, Card.DIAMONDS) );
//    	cards.add( new Card(14, Card.CLUBS) );
//    	cards.add( new Card(12, Card.HEARTS) );
//    	cards.add( new Card(2, Card.CLUBS) );
//    	SortAgainstSuit suitSorter = new SortAgainstSuit();
//    	Collections.sort(cards, suitSorter);
//    	Collections.sort(cards, new SortAgainstSuitAndValue() );
//    	for (Card c : cards) {
//    		System.out.println( c );
//    	}
    	
    	// 15.6    	
    	Hand hand = new Hand();
    	hand.add( new Card(12, Card.HEARTS) );
    	hand.add( new Card(4, Card.CLUBS) );
    	hand.add( new Card(2, Card.DIAMONDS) );
    	hand.add( new Card(14, Card.CLUBS) );
    	hand.add( new Card(7, Card.HEARTS) );
    	hand.add( new Card(2, Card.CLUBS) );
    	hand.sortAgainstSuit();
    	hand.print();
    	
    }
}
