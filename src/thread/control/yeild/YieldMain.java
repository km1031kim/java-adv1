package thread.control.yeild;

import util.ThreadUtils;

public class YieldMain {

    private static final int THREAD_COUNT = 1000;
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1. empty
                // 2. sleep(1)
                //ThreadUtils.sleep(1);

                // RUNNABLE 상태 두가지. 실행 중 or 실행 대기 스케쥴링
                // yield 호출 시 스케줄링 대기 큐에 들어간다. 즉 RUNNABLE 상태가 유지된다.
                Thread.yield(); // 3. yield

            }
        }
    }
}
