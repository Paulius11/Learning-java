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
		transportManager = createTransportManager();
	}

	private TruckManagerImpl createTransportManager() {
		return new TruckManagerImpl();
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

}
