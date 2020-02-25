import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lt.itakademija.exam.Packet;
import lt.itakademija.exam.Truck;
import lt.itakademija.exam.TruckManager;

/**
 * @author Sup
 *
 */
public class TruckManagerImpl implements TruckManager {

	private List<Truck> truckList = new ArrayList<>();
	private List<Packet> paketList = new ArrayList<>();
	private Packet packet;

	@Override
	public void assignTruck(Truck truck, Packet packet) {
		packet.assignTruck(truck);

	}

	@Override
	public List<Packet> getPackets(String truckId) {
		return getTruckById(truckId).getPackets();
	}

	@Override
	public int getTotalTruckCapacity() {
		return truckList.stream().mapToInt(x -> x.getCapacity()).sum();
	}

	@Override
	public Truck getTruckById(String truckId) {
		return truckList.stream().filter(x -> x.getId().equals(truckId)).findFirst().orElse(null);
	}

	@Override
	public List<Truck> getTrucks() {
		return truckList;
	}

	@Override
	public Packet registerPacket(String id, int volume) {
		if (volume <= 0 || id.isEmpty())
			throw new IllegalArgumentException();

		Packet paketas = new Packet(id, volume);
		paketList.add(paketas);
		return paketas;
	}

	@Override
	public Truck registerTruck(String id, int capacity) {
		if (id == null)
			throw new NullPointerException();
		if (capacity <= 0 || id.isEmpty())
			throw new IllegalArgumentException();
		Truck truck = new Truck(id, capacity);
		truckList.add(truck);
		return truck;
	}

	/**
	 * Gets average of specified truck name
	 * 
	 * @param truckId - truck you want to find an average of
	 * @return packet average
	 */
	public double getAveragePackageVolume(String truckId) {
		List<Packet> pakets = getTruckById(truckId).getPackets();
		return pakets.stream().map(Packet::getVolume).reduce(0, Integer::sum);

	}

	/**
	 * Gets truck name with biggest Capacity
	 * 
	 * @return Truck name, if null return ""
	 */
	public String getBiggestCapacityTruckName() {
		int maxCapacity = 0;
		String truckName = "";
		for (Truck truck : truckList) {
			if (truck.getCapacity() > maxCapacity) {
				maxCapacity = truck.getCapacity();
				truckName = truck.getId();
			}

		}
		return truckName;
	}

	/**
	 * Gets largest truck volume from truck list
	 * 
	 * @return volume integer, if null return 0
	 */
	public Integer getBiggestCapacityTruck() {
		return truckList.stream().map(Truck::getCapacity).reduce(Integer::max).orElse(0);
	}

}
