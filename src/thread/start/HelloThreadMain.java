package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        Thread thread = Thread.currentThread();

        System.out.println("thread = " + thread);
        System.out.println("main start");
        helloThread.start();
        System.out.println("main end");
    }
}
