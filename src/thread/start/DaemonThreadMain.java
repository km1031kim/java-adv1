package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // true. 기본적으로는 false. 사용자 스레드다.
        daemonThread.start();
        Thread.sleep(1000);

    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run()");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " end");
        }
    }
}
