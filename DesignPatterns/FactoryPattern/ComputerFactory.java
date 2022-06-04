package DesignPatterns.FactoryPattern;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if("PC".equals(type)) return new PC(ram, hdd, cpu);
        else if("SERVER".equalsIgnoreCase(type)) {
            System.out.println("came here :: ");
            return new Server(ram, hdd, cpu);
        }
        return null;
    }
}
