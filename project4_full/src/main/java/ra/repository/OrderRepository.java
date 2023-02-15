package ra.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Order;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByOrderId(int OrderId);

}
