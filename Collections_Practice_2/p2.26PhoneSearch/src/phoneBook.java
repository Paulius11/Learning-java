import java.awt.Paint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class phoneBook {

	private Map<String, Set<String>> numbersMap = new HashMap<>();
	private Map<String, Set<String>> addressMap = new HashMap<>();

	public void addNumber(String person, String number) {
		// 1
		if (numbersMap.containsKey(person)) {
			numbersMap.get(person).add(number);
		} else {
			numbersMap.put(person, new HashSet<String>(Arrays.asList(number)));
		}
	}

	public void getPhoneNumberByName(String name, String message) {
		// 2 whose number
		if (numbersMap.containsKey(name))
			numbersMap.get(name).forEach(System.out::println);
		else {
			System.out.println(message);
		}

	}

	public void seachByPhoneNumber(String number) {
		// 3
		boolean found = false;
		for (Entry<String, Set<String>> pair : numbersMap.entrySet()) {
			if (pair.getValue().contains(number)) {
				System.out.println(pair.getKey());
				found = true;
			}
		}
		if (!found) {
			System.out.println("not found");
		}
	}

	public void addAddress(String name, String street, String city) {
		// 4
		String streetCityformat = street + "::" + city;
		if (addressMap.containsKey(name)) {
			numbersMap.get(name).add(streetCityformat);
		} else {
			addressMap.put(name, new HashSet<String>(Arrays.asList(streetCityformat)));
		}
	}

	public void getAddress(String name) {
		boolean printed = false;
		if (addressMap.containsKey(name)) {
			if (addressMap.get(name).isEmpty())
				System.out.println("address unknown");
			else {
				String[] split = addressMap.get(name).toString().split("::");
				String street = split[0];
				String city = split[1];
				System.out.println("adress " + street + " " + city);
				printed = true;
			}
			// TODO fix

		}

		if (!printed)
			System.out.println("address unknown");

	}

	public void getPersonalInformation(String name) {
		// 
		getAddress(name);
		getPhoneNumberByName(name, "phone number not found");

	}
	
	public void getPersonalInformation_(String name) {
		// 5
		if (addressMap.containsKey(name)) {
			getAddress(name);
			getPhoneNumberByName(name, "phone number not found");
		} else {
			System.out.println("not found");
		}


	}

	public void deletePersonalInformation(String name) {
		// 6
		numbersMap.remove(name);
		addressMap.remove(name);

	}

	public void searchByKeyword(String name) {
		// 7
		if (name.isEmpty()) {
			// print all information

			numbersMap.forEach((k, v) -> getPersonalInformation(k));
		} else if (!name.isEmpty()) {
			seachByKeyword_(name);

		}

	}

	public void seachByKeyword_(String name) {
		boolean contains = false;
		// search in name
		for (Entry<String, Set<String>> pair : numbersMap.entrySet()) {
			if (pair.getKey().contentEquals(name)) {
				System.out.println(name);
				getPersonalInformation(name);
				contains = true;
			}
			if (pair.getKey().indexOf(name) != -1) {
				System.out.println(pair.getKey());
				getPersonalInformation(pair.getKey());
				contains = true;
			}
		}
		// search in data
		for (Entry<String, Set<String>> addressPair : addressMap.entrySet()) {
			if (addressPair.getValue().toString().contains(name)) {
				name = addressPair.getKey();
				System.out.println(name);
				getPersonalInformation(name);
				contains = true;
			}
		}

		if (!contains) {
			System.out.println("not found");
		}
	}

}
