package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck.StrategyPattern;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        // implements duck flying
        System.out.println("I am flying !!");
    }
}
