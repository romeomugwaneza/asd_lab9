package bankwithbuilder.factory;

import bankwithbuilder.dao.IAccountDAO;
import bankwithbuilder.integration.IEmailSender;

public interface IFactory {
    IAccountDAO getAccountDAO();
    IEmailSender getEmailSender();
}
