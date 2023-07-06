package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.integration.EmailSender;
import bank.integration.IEmailSender;

public interface IFactory {
    IAccountDAO getAccountDAO();
    IEmailSender getEmailSender();
}
