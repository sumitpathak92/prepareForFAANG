package DesignPatterns.HeadFirstDP.Chapter3.DecoratorPattern.Starbuzz;

public class SteamedMilk extends CondimentDecorator{

    public SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + getCostBasedOnSize() + .10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Steamed Milk";
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }
}
