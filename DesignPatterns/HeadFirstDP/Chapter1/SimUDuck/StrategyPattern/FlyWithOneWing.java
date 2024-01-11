package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck.StrategyPattern;

public class FlyWithOneWing implements FlyBehavior{
    @Override
    public void fly() {
        // duck flies with just one wing!!
        System.out.println("Flying with just one wing !!");
    }
}
