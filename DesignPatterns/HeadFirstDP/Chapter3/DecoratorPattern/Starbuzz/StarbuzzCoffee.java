package DesignPatterns.HeadFirstDP.Chapter3.DecoratorPattern.Starbuzz;

public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() +
                " $" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1.setSize(Beverage.Size.VENTI);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);

        System.out.println(beverage1.getDescription() +
                " $" + beverage1.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2.setSize(Beverage.Size.GRANDE);
        beverage2 = new SteamedMilk(beverage2);
        beverage2 = new Whip(beverage2);
//        beverage2 = new Whip(beverage2);

        System.out.println(beverage2.getDescription() +
                " $" + beverage2.cost());


    }
}
