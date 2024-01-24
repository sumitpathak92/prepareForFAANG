package DesignPatterns.HeadFirstDP.Chapter3.DecoratorPattern.Starbuzz;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso coffee";
    }

    public double cost() {
        return 1.99;
    }
}
