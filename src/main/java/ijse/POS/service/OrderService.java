package ijse.POS.service;

import java.util.List;

import ijse.POS.entity.OrderDetails;
import ijse.POS.entity.Orders;

public interface OrderService {

     Orders createOrder(Orders orders);
     Orders addItemsToOrder(Long orderId, String itemCode, Long quantity);
     Orders removeItemsFromOrder(Long orderId, String itemCode, Long quantity);
     List<Orders> getAllOrders();
     Orders getOrderById(Long orderId);
     List<OrderDetails> findbyOrderId(Long orderId);
     void removeProductToOrder(Long orderDetailId);
     Orders confirmOrder(Long orderId);
    
    
}
