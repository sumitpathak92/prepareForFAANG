package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck.StrategyPattern;

public class ModelDuck extends Duck{

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("Its a model duck!!");
    }
}
