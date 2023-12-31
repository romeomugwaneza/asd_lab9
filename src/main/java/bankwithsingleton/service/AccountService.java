package bankwithsingleton.service;

import bankwithsingleton.dao.IAccountDAO;
import bankwithsingleton.domain.Account;
import bankwithsingleton.domain.Customer;
import bankwithsingleton.integration.IEmailSender;

import java.util.Collection;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private IEmailSender emailSender;

	public AccountService(IAccountDAO accountDAO, IEmailSender emailSender){
		this.accountDAO = accountDAO;
		this.emailSender = emailSender;
	}
	public void sendEmail(String message){
		emailSender.sendEmail(message);
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

}
