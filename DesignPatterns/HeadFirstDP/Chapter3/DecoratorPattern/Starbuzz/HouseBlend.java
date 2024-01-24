package DesignPatterns.HeadFirstDP.Chapter3.DecoratorPattern.Starbuzz;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
