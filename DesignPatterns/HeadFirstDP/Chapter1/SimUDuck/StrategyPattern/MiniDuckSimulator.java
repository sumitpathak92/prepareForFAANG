package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck.StrategyPattern;

public class MiniDuckSimulator {

    public static void main(String[] args) {

        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        Duck decoyDuck = new DecoyDuck();
        decoyDuck.performQuack();
        decoyDuck.performFly();

        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();

    }
}
