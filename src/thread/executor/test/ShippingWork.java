package thread.executor.test;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.Callable;

public class ShippingWork implements Callable<Boolean> {

    private final String orderNo;

    public ShippingWork(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public Boolean call() throws Exception {
        MyLogger.log("배송 시스템 알림 : " + orderNo);
        ThreadUtils.sleep(1000);
        return true;    }
}
