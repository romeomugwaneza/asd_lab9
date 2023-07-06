package bankwithsingleton.factory;

import bankwithsingleton.dao.IAccountDAO;
import bankwithsingleton.integration.IEmailSender;

public interface IFactory {
    IAccountDAO getAccountDAO();
    IEmailSender getEmailSender();
}
