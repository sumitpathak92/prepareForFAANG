package OODDesignPatterns.com.interfaces;

public class Main {

    public static void main(String[] args) {
//        Engine car = new Car();
//
//        car.accelerate(); // dynamic method dispatch
//        car.start();
////        car.brake();
//        car.stop();

        Media carMedia = new Car();
        carMedia.stop();

        NiceCar car = new NiceCar();
        car.start();
        car.startMusic();
//        car.upgradeEngine();
    }
}
