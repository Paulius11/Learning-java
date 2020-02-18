import lt.itakademija.exam.TruckManager;
import lt.itakademija.exam.test.BaseTest;

public class BaseTestExt extends BaseTest  {

	@Override
	protected TruckManager createTransportManager() {
		// TODO Auto-generated method stub
		return new TruckManagerImpl();
	}

}
