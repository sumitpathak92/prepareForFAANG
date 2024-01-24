package DesignPatterns.HeadFirstDP.Chapter3.DecoratorPattern.Starbuzz;

public class DarkRoast extends Beverage{

    public DarkRoast() {
        description = "Dark Roast Coffee ";
    }

    @Override
    public double cost() {
        return 0.35;
    }
}
