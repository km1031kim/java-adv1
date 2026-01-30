package thread.executor.future;

import util.MyLogger;
import util.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.*;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        // callable을 넘기려면 submit
        Integer result = es.submit(new MyCallable()).get();
        log("result value = " + result);
        es.close();
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            ThreadUtils.sleep(1000);
            int value = new Random().nextInt(10);
            log("create value = " + value);
            log("Callable 완료");
            return value;
        }
    }
}
