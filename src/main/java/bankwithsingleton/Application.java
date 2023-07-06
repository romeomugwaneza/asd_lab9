package bankwithsingleton;

import bankwithsingleton.dao.IAccountDAO;
import bankwithsingleton.domain.Account;
import bankwithsingleton.domain.AccountEntry;
import bankwithsingleton.domain.Customer;
import bankwithsingleton.factory.Factory;
import bankwithsingleton.factory.IFactory;
import bankwithsingleton.integration.IEmailSender;
import bankwithsingleton.service.AccountService;
import bankwithsingleton.service.IAccountService;

import java.util.Collection;

public class Application {
	public static void main(String[] args) {
		// Create factory
		Factory mainFactory = new Factory();
		IFactory factory =mainFactory.getFactoryInstance();
		IAccountDAO accountDAO = factory.getAccountDAO();
		IEmailSender emailSender = factory.getEmailSender();
		IAccountService accountService = new AccountService(accountDAO, emailSender);
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdraw(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		accountService.sendEmail("\n\nTest email\n\n");
		// show balances
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}

	}

}


