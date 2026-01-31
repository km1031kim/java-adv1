package thread.executor.test;

import util.MyLogger;

import static util.MyLogger.*;

public class OldOrderService {

    public void order(String orderNo) throws Exception {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        Boolean inventoryResult = inventoryWork.call();
        Boolean shippingResult = shippingWork.call();
        Boolean accountingResult = accountingWork.call();

        if (inventoryResult && shippingResult && accountingResult) {
            log("모든 주문 처리가 성공적으로 완료되었습니다ㅏ.");
        } else {
            log("일부 작업이 실패했습니다.");
        }

    }
}
