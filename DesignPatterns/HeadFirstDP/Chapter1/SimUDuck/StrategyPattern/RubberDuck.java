package DesignPatterns.HeadFirstDP.Chapter1.SimUDuck;

public class RubberDuck extends Duck {
    @Override
    public void display() {
        // looks like a rubber duck
    }

    // should not be able to fly and also quack, since this is rubber duck

    public void quack() {
        // squeaking sound
    }

    public void fly() {
        // override to do nothing
    }
}
