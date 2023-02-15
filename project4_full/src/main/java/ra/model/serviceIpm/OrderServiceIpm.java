package ra.model.serviceIpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ra.model.entity.Order;
import ra.model.service.OrderService;
import ra.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceIpm implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrUpdate(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateStatus(int orderId, int orderStatus) {
        Order order = orderRepository.findById(orderId).get();
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }


    @Override
    public void deleteId(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order searchById(int orderId) {
        return orderRepository.findById(orderId).get();
    }


}
