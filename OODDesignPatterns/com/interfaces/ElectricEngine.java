package OODDesignPatterns.com.interfaces;

public class ElectricEngine implements Engine{

    @Override
    public void start() {
        System.out.println("Electric Engine start");
    }

    @Override
    public void stop() {
        System.out.println("Electric Engine stops");
    }

    @Override
    public void accelerate() {
        System.out.println("Electric engine accelerates");
    }

}
