package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck.StrategyPattern;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        // decoy duck
    }

}
