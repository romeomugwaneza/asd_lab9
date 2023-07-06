package bank.factory;

import bank.dao.IAccountDAO;
import bank.dao.MockAccountDAO;
import bank.integration.IEmailSender;
import bank.integration.MockEmailSender;

public class MockFactory implements IFactory{
    @Override
    public IAccountDAO getAccountDAO() {
        return new MockAccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return new MockEmailSender();
    }
}
