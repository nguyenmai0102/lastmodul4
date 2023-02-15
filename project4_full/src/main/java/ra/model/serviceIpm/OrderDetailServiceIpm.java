package ra.model.serviceIpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Order;
import ra.model.entity.OrderDetail;
import ra.model.service.OderDetailService;
import ra.repository.OrderDetailRepository;
import ra.repository.OrderRepository;

import java.util.List;

@Service
public class OrderDetailServiceIpm implements OderDetailService{
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<OrderDetail> findByOrderId(int orderId) {
        Order order = orderRepository.findById(orderId).get();
        return orderDetailRepository.findByOrder(order);
    }

    @Override
    public void save (OrderDetail orderDetail) {
    orderDetailRepository.save(orderDetail);
    }


}
