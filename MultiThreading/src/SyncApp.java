package MultiThreading.src;

public class SyncApp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==== Application started =====");

        // one single printer object
        Printer pr = new Printer();

        // scenario is we have multiple threads working on same Printer object
        // If multiple threads works on same single object then we must synchronize
        MyThread mThread = new MyThread(pr);
        YourThread yThread = new YourThread(pr);
        mThread.start();
        yThread.start();
        System.out.println("====  Application ended =====");
    }
}

class Printer {
    // synchronized keyword puts an intrinsic lock, and each thread then acquires lock on this method.
    // unless the lock is freed by a thread, no other thread can access the same function
    void printer(int num, String name) {
        for(int i = 0; i<num; i++) {
            System.out.println("printing ::::  "+name+" " +i);
        }
    }
}

class MyThread extends Thread {

    final Printer pRef;
    public MyThread(Printer p) {
        this.pRef = p;
    }

    @Override
    public void run() {
        synchronized (this.pRef) {
            this.pRef.printer(10, "SumitProfile");
        }

    }
}

class YourThread extends Thread {

    final Printer pRef;
    public YourThread(Printer p) {
        this.pRef = p;
    }

    @Override
    public void run() {
        synchronized (this.pRef) {
            this.pRef.printer(10, "KavitaProfile");
        }

    }
}