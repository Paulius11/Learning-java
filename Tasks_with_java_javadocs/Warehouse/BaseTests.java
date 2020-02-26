import lt.itakademija.exam.IdGenerator;
import lt.itakademija.exam.Warehouse;
import lt.itakademija.exam.test.BaseTest;

public class BaseTests extends BaseTest {

	@Override
	protected Warehouse createWarehouse(IdGenerator clientIdGenerator, IdGenerator packageIdGenerator, int totalSpace) {
		return new WerehouseImpl(clientIdGenerator, packageIdGenerator, totalSpace);
	}

}
