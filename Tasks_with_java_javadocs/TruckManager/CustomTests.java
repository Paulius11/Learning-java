import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lt.itakademija.exam.Packet;
import lt.itakademija.exam.Truck;

public class CustomTests {
	private TruckManagerImpl transportManager;

	@Before
	public void setUp() throws Exception {
		transportManager = new TruckManagerImpl();
	}

	@Test
	public void testAveragePacketVolume() {
		String truckId = "TRUCK-1";
		int capacity = 10;
		Truck registeredTruck = transportManager.registerTruck(truckId, capacity);

		String packageName = "Apples";
		int volume = 2;
		Packet applesPacket = new Packet(packageName, volume);
		Packet coffePacket = new Packet("Coffee", 4);
		applesPacket.assignTruck(registeredTruck);
		coffePacket.assignTruck(registeredTruck);

		double expectedVolume = this.transportManager.getAveragePackageVolume(truckId);

		Assert.assertThat(expectedVolume, Matchers.is(6.0));
	}

	@Test
	public void testGetBiggestCapacityTrucksName() {
		Truck registeredTruckBIG = transportManager.registerTruck("Truck-BIG", 100);
		Truck registeredTruckMEDIUM = transportManager.registerTruck("Truck-MEDIUM", 50);
		String biggestCapacityTruck = this.transportManager.getBiggestCapacityTruckName();
		Assert.assertThat(biggestCapacityTruck, Matchers.is("Truck-BIG"));
		Assert.assertNotEquals(biggestCapacityTruck, "Truck-MEDIUM");
	}

	@Test
	public void testGetBiggestTruckCapacity() {
		Truck registeredTruckBIG = transportManager.registerTruck("Truck-BIG", 150);
		Truck registeredTruckMEDIUM = transportManager.registerTruck("Truck-MEDIUM", 50);
		Integer biggestCapacityTruck = this.transportManager.getBiggestCapacityTruck();

		Assert.assertThat(biggestCapacityTruck, Matchers.is(150));

	}

}
