package bankwithsingleton.integration;

public class EmailSender implements IEmailSender {
    private static EmailSender emailSender;
    private EmailSender() {
        if (emailSender != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    public static EmailSender getInstance(){
        if (emailSender == null)
            synchronized (EmailSender.class){
                if (emailSender == null) emailSender = new EmailSender();
            }
        return emailSender;
    }

    public void sendEmail(String message){
        System.out.println("Sending email...." + message);
    }
}
