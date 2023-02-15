package ra.model.service;
import org.springframework.stereotype.Service;
import ra.model.entity.Order;
import ra.model.entity.OrderDetail;

import java.util.List;

@Service
public interface OderDetailService {
    List<OrderDetail> findAll();
    List<OrderDetail> findByOrderId(int orderId);
    void save(OrderDetail orderDetail);

}
