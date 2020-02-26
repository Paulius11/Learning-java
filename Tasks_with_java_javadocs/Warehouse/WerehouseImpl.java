package BaseTests;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lt.itakademija.exam.Client;
import lt.itakademija.exam.ClientPredicate;
import lt.itakademija.exam.IdGenerator;
import lt.itakademija.exam.InsufficientSpaceException;
import lt.itakademija.exam.Package;
import lt.itakademija.exam.Warehouse;

public class WerehouseImpl extends Warehouse {

	private List<Package> packages = new LinkedList<>();
	private List<Client> clients = new LinkedList<>();
	private int totalSpace;

	public WerehouseImpl(IdGenerator clientIdGenerator, IdGenerator packageIdGenerator, int totalSpace_) {
		super(clientIdGenerator, packageIdGenerator, totalSpace_);
		if (totalSpace_ <= 0)
			throw new IllegalArgumentException();
		this.totalSpace = totalSpace_;

	}

	@Override
	public Package createPackage(String name, int space) {
		if (space <= 0)
			throw new IllegalArgumentException();
		Package newPackage = new Package(packageIdGenerator.generateId(), name, space);
		packages.add(newPackage);
		return newPackage;
	}

	@Override
	public List<Client> findClientsBy(ClientPredicate predicate) {
		return clients.stream().filter(x -> predicate.test(x)).collect(Collectors.toList());
	}

	@Override
	public int getAvailableSpace() {
		return this.totalSpace - getReservedSpace();
	}

	@Override
	public Client getClientById(int id) {
		return clients.stream().filter(x -> x.getId() == id).findAny().orElse(null);
	}

	@Override
	public int getReservedSpace() {
		return clients.stream().map(Client::getReservedSpace).reduce(Integer::sum).orElse(0);
	}

	@Override
	public int getTotalAvailableSpace() {
		int totalPackOccSpace = 0;
		for (Client cl : clients) {
			for (Package pk : cl.getPackages()) {
				totalPackOccSpace += pk.getSpace();
			}
		}
		return this.totalSpace - totalPackOccSpace;
	}

	@Override
	public int getTotalSpace() {
		return this.totalSpace;
	}

	@Override
	public boolean hasClientById(int id) {
		for (Client client : clients)
			if (client.getId() == id)
				return true;
		return false;
	}

	@Override
	public Client registerClient(String name, int reservingSpace) {
		if (reservingSpace <= 0)
			throw new IllegalArgumentException();
		if (reservingSpace > this.totalSpace)
			throw new InsufficientSpaceException(name);

		Client newClient = new Client(clientIdGenerator.generateId(), name, reservingSpace);
		clients.add(newClient);
		return newClient;
	}

	@Override
	public void storePackage(Client client, Package aPackage) {
		if (client.getReservedSpace() < aPackage.getSpace())
			throw new InsufficientSpaceException(client.getName());
		client.addPackage(aPackage);

	}

}
