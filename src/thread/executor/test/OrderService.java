package thread.executor.test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;

public class OrderService {

    public void order(String orderNo) throws Exception {

        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        ExecutorService es = Executors.newFixedThreadPool(10);

        Future<Boolean> inventoryFuture = es.submit(inventoryWork);
        Future<Boolean> shippingFuture = es.submit(shippingWork);
        Future<Boolean> accountingFuture = es.submit(accountingWork);

        Boolean inventoryResult = inventoryFuture.get();
        Boolean shippingResult = shippingFuture.get();
        Boolean accountingResult = accountingFuture.get();

        if (inventoryResult && shippingResult && accountingResult) {
            log("모든 주문 처리가 성공적으로 완료되었습니다ㅏ.");
        } else {
            log("일부 작업이 실패했습니다.");
        }

        es.close();
    }
}
