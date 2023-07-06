package bankwithbuilder.factory;

import bankwithbuilder.dao.IAccountDAO;
import bankwithbuilder.dao.MockAccountDAO;
import bankwithbuilder.integration.IEmailSender;
import bankwithbuilder.integration.MockEmailSender;

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
