package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Order;
import ra.model.entity.OrderDetail;
import ra.model.service.OderDetailService;
import ra.model.serviceIpm.OrderDetailServiceIpm;
import ra.repository.OrderDetailRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/orderDetail")
public class OrderDertailController {
    @Autowired
    private OderDetailService oderDetailService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<OrderDetail> getAllOrderDetail(){
        return oderDetailService.findAll();
    }
    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<OrderDetail> findByOrderId(@RequestParam("orderId") int orderId){
        return oderDetailService.findByOrderId (orderId);
    }
}
