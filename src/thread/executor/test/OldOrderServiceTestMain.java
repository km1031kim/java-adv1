package thread.executor.test;

public class OldOrderServiceTestMain {

    public static void main(String[] args) throws Exception {
        String orderNo = "Order#1234";
//        OldOrderService orderService = new OldOrderService();
        OrderService orderService = new OrderService();
        orderService.order(orderNo);

    }
}
