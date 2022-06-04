package MultiThreading.src;

public class Application {

    // main method represents main thread
    public static void main(String[] args) {
        // whatever we write here will be executed by main thread
        // threads always execute the jobs in sequence
        // Execution context

        // job1
        System.out.println("Application started  :::::    ");

        // job2
//        MyTask task = new MyTask(); // child thread / worker thread
//        task.run(); // start will internally execute the run method

        Runnable r = new MyTask();
        Thread task = new Thread(r);
        task.start();

        //until job two is not finished, below jobs are waiting and are not executed

        // now main and mytask are running parallely or concurrently
        // job3
        for(int doc = 1; doc<=10; doc ++) {
            System.out.println("Printing document # "+doc + "  printer 1");
        }

        System.out.println("Application finished :::::   ");

    }
}

// my task is-a Thread now
class MyTask extends CA implements Runnable {
    @Override
    public void run(){
        for(int doc = 1; doc<=10; doc ++) {
            System.out.println("@@@@   Printing document # "+doc +" printer 2");
        }
    }
}

class CA {

}
