import java.util.Scanner;

public class TextUserInterface {

	private Scanner reader = new Scanner(System.in);
	private Dictionary dict;

	public TextUserInterface(Scanner reader, Dictionary dictionary) {
		this.reader = reader;
		this.dict = dictionary;
	}

	public void start() {
		String options = "Statements:\r\n" + "add - adds a word pair to the dictionary\r\n"
				+ "translate - asks a word and prints its translation\r\n" + "quit - quits the text user interface";

		System.out.println(options);

		String command = "";
		do {
			command = commandPrompt("Statement:");
			switch (command) {
			case "add":
				String english = commandPrompt("In Finnish:");
				String finish = commandPrompt("Translation:");
				dict.add(english, finish);
				break;

			case "translate":
				String englishString = commandPrompt("Give a word:");
				String translation = dict.translate(englishString);
				System.out.println("Translation: " + translation);
				break;

			case "quit":
				System.out.println("Cheers!");
				break;

			default:
				System.out.println("Unknown statement");
				break;
			}
		} while (!command.equals("quit"));
	}

	public String commandPrompt(String inputMessage) {
		System.out.println(inputMessage);
		return reader.nextLine();
	}
}
