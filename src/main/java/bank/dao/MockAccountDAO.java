package bank.dao;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class MockAccountDAO implements IAccountDAO{
    Collection<Account> accountlist = new ArrayList<Account>();

    public void saveAccount(Account account) {
        System.out.println("MockAccountDAO saving new account...");
        accountlist.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountnumber());
        if (accountexist != null) {
            System.out.println("MockAccountDAO updating account...");
            accountlist.remove(accountexist);
            accountlist.add(account);
        }

    }

    public Account loadAccount(long accountnumber) {
        System.out.println("MockAccountDAO loading account...");
        for (Account account : accountlist) {
            if (account.getAccountnumber() == accountnumber) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {
        return accountlist;
    }
}
