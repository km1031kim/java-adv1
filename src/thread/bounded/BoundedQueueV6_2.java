package thread.bounded;

import util.MyLogger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        boolean result = queue.offer(data);
        MyLogger.log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() {
        String result = queue.poll();
        MyLogger.log("소비 시도 결과 = " + result);
        return result;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
