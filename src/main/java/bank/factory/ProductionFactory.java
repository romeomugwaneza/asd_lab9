package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.integration.EmailSender;
import bank.integration.IEmailSender;

public class ProductionFactory implements IFactory{
    @Override
    public IAccountDAO getAccountDAO() {
        return new AccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return new EmailSender();
    }
}
