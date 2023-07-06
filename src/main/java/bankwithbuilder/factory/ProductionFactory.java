package bankwithbuilder.factory;

import bankwithbuilder.dao.AccountDAO;
import bankwithbuilder.dao.IAccountDAO;
import bankwithbuilder.integration.EmailSender;
import bankwithbuilder.integration.IEmailSender;

public class ProductionFactory implements IFactory {
    @Override
    public IAccountDAO getAccountDAO() {
        return new AccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return new EmailSender();
    }
}
