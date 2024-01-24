package DesignPatterns.HeadFirstDP.Chapter3.DecoratorPattern.Starbuzz;

public abstract class CondimentDecorator extends Beverage {

    Beverage beverage;
    public abstract String getDescription();
    public abstract Size getSize();

    public double getCostBasedOnSize() {
        if(beverage.getSize().equals(Size.GRANDE)) {
            return .15;
        }
        if(beverage.getSize().equals(Size.TALL)) {
            return .10;
        }
        else return .20;
    }
}
