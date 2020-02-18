import java.util.ArrayList;
import java.util.List;

import lt.itakademija.exam.Packet;
import lt.itakademija.exam.Truck;
import lt.itakademija.exam.TruckManager;

public class TruckManagerImpl  implements TruckManager {

	private List<Truck> truckList = new ArrayList<>();
	private List<Packet> paketList = new ArrayList<>();
	private Packet packet;

	@Override
	public void assignTruck(Truck truck, Packet packet) {
		packet.assignTruck(truck);

	}

	@Override
	public List<Packet> getPackets(String truckId) {
//		List<Packet> newList = new ArrayList<>();
//		for(Truck truck: truckList) {
//			if(truck.getId().equals(truckId))
//				for(Packet p: truck.getPackets())
//					newList.add(p);
//		}
//		return newList;
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
		// TODO Auto-generated method stub
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

}
