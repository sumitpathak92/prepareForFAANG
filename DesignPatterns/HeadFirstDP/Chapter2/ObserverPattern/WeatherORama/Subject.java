package DesignPatterns.HeadFirstDP.Chapter2.ObserverPattern.WeatherORama;

public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();

}
