package DesignPatterns.HeadFirstDP.Chapter3.DecoratorPattern.Starbuzz;

public class Whip extends CondimentDecorator {

    @Override
    public double cost() {
        return beverage.cost() + getCostBasedOnSize() + .25;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }
}
