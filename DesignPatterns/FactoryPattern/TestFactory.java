package DesignPatterns.FactoryPattern;

public class TestFactory {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC", " 2 GB", "512 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("SERVER", "16 GB", "1 TB", "3.2 GHz");

        System.out.println("Fcatory PC config "+pc);
        System.out.println("Factory Server config  "+server);
    }
}
