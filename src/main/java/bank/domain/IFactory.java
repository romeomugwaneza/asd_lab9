package bank.domain;

import bank.dao.IAccountDAO;
import bank.integration.IEmailSender;

public interface IFactory {
    IEmailSender getEmailSender();
    IAccountDAO getAccountDAO();
}
