package thread.bounded;

import util.MyLogger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BoundedQueueV6_3 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_3(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        try {
            boolean result = queue.offer(data, 1, TimeUnit.NANOSECONDS);
            MyLogger.log("저장 시도 결과 = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {
            String result = queue.poll(2, TimeUnit.SECONDS);
            MyLogger.log("소비 시도 결과 = " + result);
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
