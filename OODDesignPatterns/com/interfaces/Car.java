package OODDesignPatterns.com.interfaces;

public class Car implements Brake, Engine, Media{

    @Override
    public void brake() {
        System.out.println("I can brake like a normal car");
    }

    @Override
    public void start() {
        System.out.println("Start engine like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("Stop engine like a normal car");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerate engine like a normal car");
    }
}
