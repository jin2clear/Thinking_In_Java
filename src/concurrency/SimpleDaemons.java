package concurrency;

import java.util.concurrent.*;
import static net.mindview.util.Print.*;

public class SimpleDaemons implements Runnable {
    @Override
    public void run(){
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(400);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e){
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); //must call before start()
            daemon.start();
        }
        print("All daemon started");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
