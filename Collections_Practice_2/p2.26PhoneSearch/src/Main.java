import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Start your program here
		// ATTENTION: In your program, you can create only one instance of class
		// Scanner!
		// #TODO: some test fails with filtering
		Scanner sc = new Scanner(System.in);
		phoneBook pb = new phoneBook();
		String options = "phone search\n" + "available operations:\n" + "1 add a number\n" + "2 search for a number\n"
				+ "3 search for a person by phone number\n" + "4 add an address\n"
				+ "5 search for personal information\n" + "6 delete personal information\n" + "7 filtered listing\n"
				+ "x quit";
		System.out.println(options);

		boolean loop = true;
		while (loop) {
			System.out.println("command: ");
			String command = sc.nextLine();
			
			String name;
			String number;
			String city;
			String street;
			
			switch (command) {
			case "1":
				name = getData(sc, "whose number: ");
				number = getData(sc, "number: ");
				pb.addNumber(name, number);
				break;
				
			case "2":
				name = getData(sc, "whose number: ");
				pb.getPhoneNumberByName(name, "not found");
				break;
				
			case "3":
				number = getData(sc, "number: ");
				pb.seachByPhoneNumber(number);
				break;
				
			case "4":
				name = getData(sc, "whose address: ");
				street = getData(sc, "street: ");
				city = getData(sc, "city: ");
				pb.addAddress(name, street, city);

				break;
			case "5":
				name = getData(sc, "whose information: ");
				pb.getPersonalInformation_(name);

				break;
			case "6":
				name = getData(sc, "whose information: ");
				pb.deletePersonalInformation(name);

				break;
			case "7":
				String keyword = getData(sc, "keyword (if empty, all listed): ");
				pb.searchByKeyword(keyword);
				break;

			case "x":
				loop = false;
				break;

			default:
				break;
			}
		}
	}

	private static String getData(Scanner sc, String  messege) {
		System.out.println(messege);
		return sc.nextLine();
	}
}
