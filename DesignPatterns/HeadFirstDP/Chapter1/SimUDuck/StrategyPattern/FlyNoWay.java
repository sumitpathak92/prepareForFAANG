package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck.StrategyPattern;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        // implements no fly behavior, do nothing - can't fly
        System.out.println("I cannot fly!!");
    }
}
