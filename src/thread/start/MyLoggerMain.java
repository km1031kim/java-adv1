package thread.start;

import util.MyLogger;

import static util.MyLogger.*;

public class MyLoggerMain {

    public static void main(String[] args) {
        log("hello Thread");
        log(123);

        Thread thread = new Thread(new HelloRunnable());
        thread.start();

    }
}
