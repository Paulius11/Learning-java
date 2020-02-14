import java.util.HashMap;
import java.util.Map;

public class VehicleRegister {

	private HashMap<RegistrationPlate, String> owners = new HashMap<>();

	public boolean add(RegistrationPlate plate, String owner) {
		if (owners.containsKey(plate)) {
			return false;
		} else {
			owners.put(plate, owner);
			return true;
		}

	}

	public String get(RegistrationPlate plate) {
		if (owners.containsKey((plate)))
			return owners.get(plate);
		else
			return null;

	}

	public boolean delete(RegistrationPlate plate) {
		if (owners.containsKey((plate))) {
			owners.remove(plate);
			return true;
		} else
			return false;

	}

	public void printRegistrationPlates() {
		owners.forEach((k, v) -> System.out.println(k));
	}

	public void printOwners() {
		// print unique values with streams
		owners.entrySet().stream().map(Map.Entry::getValue).distinct().forEach(System.out::println);
	}

	public static void main(String[] args) {
		VehicleRegister ver = new VehicleRegister();
		ver.add(new RegistrationPlate("LT", "AAB-123"), "John");
		ver.add(new RegistrationPlate("LT", "ACB-143"), "Bohn");
		ver.add(new RegistrationPlate("LT", "ZAB-123"), "John");
		ver.printOwners();
	}

}
