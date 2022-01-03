package OODDesignPatterns.com.interfaces;

public class NiceCar {

    private Engine engine;
    private CDplayer cDplayer;

    public NiceCar() {
        this.engine = new PowerEngine();
        this.cDplayer = new CDplayer();
    }

    public NiceCar(Engine engine) {
        this.engine = engine;
    }

    public void start(){
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void startMusic() {
        cDplayer.start();
    }

    public void upgradeEngine(Engine engine) {
        this.engine = engine;
    }
}
