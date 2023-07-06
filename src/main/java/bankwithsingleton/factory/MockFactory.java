package bankwithsingleton.factory;

import bankwithsingleton.dao.IAccountDAO;
import bankwithsingleton.dao.MockAccountDAO;
import bankwithsingleton.integration.IEmailSender;
import bankwithsingleton.integration.MockEmailSender;

public class MockFactory implements IFactory {
    @Override
    public IAccountDAO getAccountDAO() {
        return new MockAccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return new MockEmailSender();
    }
}
