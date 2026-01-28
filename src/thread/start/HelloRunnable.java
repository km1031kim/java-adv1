package thread.start;

import util.MyLogger;

import static util.MyLogger.*;

public class HelloRunnable implements Runnable{


    @Override
    public void run() {
        log("hello");
    }
}
