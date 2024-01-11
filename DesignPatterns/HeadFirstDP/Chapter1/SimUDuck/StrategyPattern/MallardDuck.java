package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        // looks like a mallard
    }


}
