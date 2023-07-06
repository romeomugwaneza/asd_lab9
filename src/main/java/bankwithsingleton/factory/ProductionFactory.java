package bankwithsingleton.factory;

import bankwithsingleton.dao.AccountDAO;
import bankwithsingleton.dao.IAccountDAO;
import bankwithsingleton.integration.EmailSender;
import bankwithsingleton.integration.IEmailSender;

public class ProductionFactory implements IFactory {
    @Override
    public IAccountDAO getAccountDAO() {
        return new AccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return EmailSender.getInstance();
    }
}
