package thread.start;

public class HelloRunnableMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " main() start");

        HelloRunnable helloRunnable = new HelloRunnable();

        // 스레드와 해당 스레드가 실행할 작업이 분리되어 있다.
        Thread thread = new Thread(helloRunnable);
        thread.start();

        System.out.println(Thread.currentThread().getName() + " main() end");

    }
}
