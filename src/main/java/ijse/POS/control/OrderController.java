package ijse.POS.control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ijse.POS.dto.AddProductDto;
import ijse.POS.entity.OrderDetails;
import ijse.POS.entity.Orders;
import ijse.POS.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("auth/orders")
    public List<Orders> getAllOrders(){

        return orderService.getAllOrders();

    }

    @GetMapping("auth/orders/{orderId}")
    public Orders getOrderById(@PathVariable Long orderId){

        return orderService.getOrderById(orderId);

    }

    @GetMapping("auth/orderDetails/{orderId}")
    public List<OrderDetails> getOrderDetailsById(@PathVariable Long orderId){

        return orderService.findbyOrderId(orderId);
    }
    
    @PostMapping("auth/orders")
    public Orders createOrder() {
        
        Orders order = new Orders();
        order.setOrderDate(new Date());
        
        order.setTotalPrice(0.0);
        order.setStatus(false);

        return orderService.createOrder(order);
    }

    @PostMapping("auth/orders/{orderId}/addProducts")
    public Orders addProductToOrder(@PathVariable Long orderId, @RequestBody AddProductDto addProductDto) {
        return orderService.addItemsToOrder(orderId, addProductDto.getItemCode(), addProductDto.getQuantity());
    }

    @DeleteMapping("auth/orders/removeProducts/{orderDetailsId}")
    public void removeProductToOrder(@PathVariable Long orderDetailsId) {
        orderService.removeProductToOrder(orderDetailsId);
    }




    
}
