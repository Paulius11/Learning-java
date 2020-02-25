import ibank.Bank;
import ibank.BaseBankTest;

public class BaseBankTests extends BaseBankTest {

	@Override
	protected Bank createBank() {
		return new BankImpl();
	}

}
