package bankwithbuilder.domain;

import bankwithbuilder.dao.IAccountDAO;
import bankwithbuilder.integration.IEmailSender;

public interface IFactory {
    IEmailSender getEmailSender();
    IAccountDAO getAccountDAO();
}
