package DesignPatterns.ChainOfResponsibility;

/**
 * Used for creating various beans of different managers in the heirarchy
 * **/
public class ChainCreator {

    public Managers createChain() {
        HiringManager hiringManager = new HiringManager(10000, "michael");
        SeniorManager seniorManager = new SeniorManager(30000, "Christina");
        Director director = new Director(50000, "Bob");


        hiringManager.setManager(seniorManager);
        seniorManager.setManager(director);
        return hiringManager;
    }
}
