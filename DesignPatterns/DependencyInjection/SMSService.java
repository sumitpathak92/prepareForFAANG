package DesignPatterns.DependencyInjection;

public class SMSService implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("SMS sent to ::  "+rec + " with message ::  "+msg);
    }
}
