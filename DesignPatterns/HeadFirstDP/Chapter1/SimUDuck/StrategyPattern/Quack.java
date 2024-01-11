package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck.StrategyPattern;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        // implements duck quacking
        System.out.println("Quack Quack !!");
    }

}
