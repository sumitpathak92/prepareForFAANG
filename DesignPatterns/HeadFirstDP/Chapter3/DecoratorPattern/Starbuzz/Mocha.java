package DesignPatterns.HeadFirstDP.Chapter3.DecoratorPattern.Starbuzz;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + getCostBasedOnSize() + .20;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }
}
