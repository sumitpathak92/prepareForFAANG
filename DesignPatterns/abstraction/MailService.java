package DesignPatterns.abstraction;

public class MailService {

    public void sendEmail(){
        connect(10);
        authenticate();
        disconnect();
    }

    private void connect(int timeout) {
        System.out.println("connect");
    }

    private void disconnect() {
        System.out.println("disconnected");
    }

    private void authenticate() {
        System.out.println("authenticated");
    }
}
