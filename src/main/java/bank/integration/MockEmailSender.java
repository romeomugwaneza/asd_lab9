package bank.integration;

public class MockEmailSender implements IEmailSender{
    public void sendEmail(String message){
        System.out.println("Mock Email Sender :: Sending email..." + message);
    }
}
