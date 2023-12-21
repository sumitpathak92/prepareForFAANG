package DesignPatterns.FactoryPattern;

public class OperatingSystemFactory {

    public OS getInstance(String type) {
        if(type.equals("Open")) {
            return new Android();
        }
        if(type.equals("Closed")) {
            return new iOS();
        } else
            return new Windows();
    }

}
