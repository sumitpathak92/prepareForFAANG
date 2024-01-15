package DesignPatterns.HeadFirstDP.Chapter2.ObserverPattern.LifeChangingApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevilListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(" Don't do it, you might regret !! ");
    }
}
