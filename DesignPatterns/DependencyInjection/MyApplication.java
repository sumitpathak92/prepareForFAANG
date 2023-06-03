package DesignPatterns.DependencyInjection;

public class MyApplication {

    private EmailService emailService;

    public MyApplication(EmailService emailService) {
        this.emailService = emailService;
    }

//    public void processMessages(String msg, String rec) {
//        this.emailService.sendEmail(msg, rec);
//    }
}
