package ijse.POS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ijse.POS.entity.Item;
import ijse.POS.entity.OrderDetails;
import ijse.POS.entity.Orders;
import ijse.POS.entity.Stock;
import ijse.POS.repository.ItemRepository;
import ijse.POS.repository.OrderDetailsRepository;
import ijse.POS.repository.OrderRepository;
import ijse.POS.repository.StockRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Orders createOrder(Orders order) {
        
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public Orders addItemsToOrder(Long orderId, String itemCode, Long quantity) {
        
        Item item = itemRepository.findById(itemCode).orElse(null);
        if(item == null) {
            return null;
        }

        Stock stock = stockRepository.findById(itemCode).orElse(null);
        if(stock == null) {
            return null;
        }

        Orders order = orderRepository.findById(orderId).orElse(null);
        if(order == null) {
            return null;
        }

        OrderDetails orderDetail = new OrderDetails();
        orderDetail.setItem(item);
        orderDetail.setQuntity(quantity);
        orderDetail.setUnitPrice(stock.getUnitPrice());
        orderDetail.setTotalItemPrice(quantity*stock.getUnitPrice());

        
        order.setTotalPrice(order.getTotalPrice()+quantity*stock.getUnitPrice());
        orderDetail.setOrder(order);

        long newQtyOnHand = stock.getQtyOnHand()-quantity;
        stock.setQtyOnHand(newQtyOnHand);

        orderDetailsRepository.save(orderDetail);
        stockRepository.save(stock);

        return orderRepository.save(order);

    }

    @Override
    public Orders removeItemsFromOrder(Long orderId, String itemCode, Long quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemsFromOrder'");
    }

    @Override
    public List<Orders> getAllOrders() {

        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(Long orderId) {

        return orderRepository.findById(orderId).orElse(null);
        
    }

    @Override
    public List<OrderDetails> findbyOrderId(Long orderId) {
        
        return orderDetailsRepository.findByOrderOrderId(orderId);
    }


    @Transactional
    @Override
    public void removeProductToOrder(Long orderDetailId) {

        OrderDetails orderDetail = orderDetailsRepository.findById(orderDetailId).orElse(null);
        
        Item item = orderDetail.getItem();
        Orders order = orderDetail.getOrder();

        Stock stock = stockRepository.findById(item.getItemCode()).orElse(null);

        Double totalPrice = order.getTotalPrice() - orderDetail.getTotalItemPrice();
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);

        Long quantityOnHand = stock.getQtyOnHand() + orderDetail.getQuntity();
        stock.setQtyOnHand(quantityOnHand);
        stockRepository.save(stock);
        
        orderDetailsRepository.deleteById(orderDetailId);

    }
        


    
}
