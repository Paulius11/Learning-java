import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import ibank.Account;
import ibank.Bank;

public class BankImpl implements Bank {

	Set<Account> accountList = new HashSet<>();

	@Override
	public void closeAccount(Account account) {
		boolean flag = false;
		for (Account acc : accountList) {
			if (account == acc) {
				flag = true;
			}
		}
		if (flag)
			accountList.remove(account);
	}

	@Override
	public Account getAccountByHolderName(String holderName) {
		return accountList.stream().filter(x -> x.getHolderName().equals(holderName)).findAny().orElse(null);
	}

	@Override
	public Account getAccountByNumber(String accountNumber) {
		return accountList.stream().filter(x -> x.getNumber().equals(accountNumber)).findAny().orElse(null);
	}

	@Override
	public Collection<Account> getAllAccounts() {
		return accountList;
	}

	@Override
	public int getNumberOfAccounts() {
		return accountList.size();
	}

	@Override
	public BigDecimal getTotalReserves() {
		return accountList.stream().map(Account::getBalance).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

	@Override
	public Account openCreditAccount(String accountHolderName, BigDecimal crediLimit) {
		AccountImpl newAcc = new AccountImpl(accountHolderName, crediLimit);
		if (getAccountByHolderName(accountHolderName) == null) {
			accountList.add(newAcc);
		} else {
			return null;
		}

		return getAccountByHolderName(accountHolderName);
	}

	@Override
	public Account openDebitAccount(String accountHolderName) {
		if (getAccountByHolderName(accountHolderName) == null) {
			accountList.add(new AccountImpl(accountHolderName, BigDecimal.ZERO));
		} else {
			return null;
		}
		return getAccountByHolderName(accountHolderName);
	}

	public static void main(String[] args) {
		Bank bank = new BankImpl();
		Account account = bank.openCreditAccount("John", BigDecimal.ONE);
		bank.getAccountByHolderName("John").withdraw(new BigDecimal(500));

		System.out.println(account.getBalance());
	}

}
