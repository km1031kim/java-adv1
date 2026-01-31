package thread.executor.test;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.Callable;

public class InventoryWork implements Callable<Boolean> {

    private final String orderNo;

    public InventoryWork(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public Boolean call() throws Exception {
        MyLogger.log("재고 업데이트 : " + orderNo);
        ThreadUtils.sleep(1000);
        return true;
    }
}
