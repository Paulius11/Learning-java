
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		// 7.1

//    	dictionary.add("apina", "monkey");
//    	dictionary.add("banaani", "banana");
//    	dictionary.add("cembalo", "harpsichord");
//    	System.out.println(dictionary.translate("apina"));
//    	System.out.println(dictionary.translate("porkkana"));

		// 7.2

//    	dictionary.add("apina", "monkey");
//    	dictionary.add("banaani", "banana");
//    	System.out.println(dictionary.amountOfWords());
//    	dictionary.add("cembalo", "harpsichord");
//    	System.out.println(dictionary.amountOfWords());

		// 7.3

//    	dictionary.add("apina", "monkey");
//    	dictionary.add("banaani", "banana");
//    	dictionary.add("cembalo", "harpsichord");
//    	ArrayList<String> translations = dictionary.translationList();
//    	for(String translation: translations) {
//    	System.out.println(translation);
//    	}

		// 7.4

		TextUserInterface t = new TextUserInterface(new Scanner(System.in), new Dictionary());
		t.start();
	}
}
