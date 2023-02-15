package ra.model.service;

import org.apache.catalina.User;
import ra.model.entity.Catalog;
import ra.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();

    Order saveOrUpdate(Order order);

    Order updateStatus(int orderId, int orderStatus);

    void deleteId(int orderId);

    Order searchById( int orderId);

}
