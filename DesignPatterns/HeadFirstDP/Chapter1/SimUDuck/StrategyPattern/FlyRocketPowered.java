package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck.StrategyPattern;

public class FlyRocketPowered implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I am flying with a rocket!!");
    }
}
