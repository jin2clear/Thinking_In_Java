package concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.*;

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(2);
    }
}

class ADaemon implements Runnable {

    @Override
    public void run() {
        try{
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            print("Exiting via InterruptedException");
        } finally {
            print("This should always run?");
        }
    }
}
