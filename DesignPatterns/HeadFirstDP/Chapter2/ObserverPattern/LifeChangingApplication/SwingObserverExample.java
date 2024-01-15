package DesignPatterns.HeadFirstDP.Chapter2.ObserverPattern.LifeChangingApplication;

import javax.swing.*;

public class SwingObserverExample {

    private JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample swingObserverExample = new SwingObserverExample();
        swingObserverExample.go();
    }

    public void go() {
        frame = new JFrame();
        JButton button = new JButton("Should I do it ?? ");

        button.addActionListener(event -> System.out.println("Come on , do it !!"));
        button.addActionListener(event -> System.out.println("Don't do it, you will regret !!"));

        // set some frame properties

    }
}
