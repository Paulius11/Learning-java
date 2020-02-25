import java.math.BigDecimal;
import java.util.UUID;

import ibank.Account;

enum AccountType {
	CREDIT, DEBIT,
}

public class AccountImpl implements Account {

	private String accountNumber = UUID.randomUUID().toString().replace("-", "");
	private String holderName;
	private BigDecimal balance = BigDecimal.ZERO;
	private BigDecimal creditLimit = BigDecimal.ZERO;
	private AccountType accType;

	public AccountImpl(String holderName) {
		super();
		this.holderName = holderName;
		accType = accType.DEBIT;

	}

	public AccountImpl(String holderName, BigDecimal creditLimit) {
		super();
		this.holderName = holderName;
		this.creditLimit = creditLimit;
		accType = accType.CREDIT;
	}

	@Override
	public String getNumber() {
		return accountNumber;
	}

	@Override
	public String getHolderName() {
		return holderName;
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public boolean deposit(BigDecimal paramBigDecimal) {
		if (paramBigDecimal.signum() > 0 || balance.compareTo(creditLimit) <= 0) {
			balance = balance.add(paramBigDecimal);
			return true;
		}
		return false;
	}

	@Override
	public boolean withdraw(BigDecimal paramBigDecimal) {
		if (paramBigDecimal.signum() > 0
				&& Math.abs(balance.subtract(paramBigDecimal).intValue()) <= creditLimit.intValue()
				&& accType == AccountType.CREDIT) {
			balance = balance.subtract(paramBigDecimal);
			return true;
		}
		if (paramBigDecimal.signum() > 0 && accType == AccountType.DEBIT) {
			balance = balance.subtract(paramBigDecimal);
			return true;
		}

		return false;
	}

}
