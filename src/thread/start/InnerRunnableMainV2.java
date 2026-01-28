package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        log("main() start");
        log("main() end");

        Thread thread = new Thread(() -> log("run()"));
        thread.start();

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run()");

        }
    }

}
