package bankwithsingleton.domain;

import bankwithsingleton.dao.IAccountDAO;
import bankwithsingleton.integration.IEmailSender;

public interface IFactory {
    IEmailSender getEmailSender();
    IAccountDAO getAccountDAO();
}
