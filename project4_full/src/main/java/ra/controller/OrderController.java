package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.entity.Order;
import ra.model.entity.Product;
import ra.model.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController() {
    }
   @GetMapping
   @PreAuthorize("hasRole('ADMIN')")
    public List<Order> getAllOrder(){
        return orderService.findAll();
    }
    @GetMapping("/{orderId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Order getOrderById(@PathVariable("orderId") int orderId){
        return orderService.searchById(orderId);
    }
    @PostMapping
    @PreAuthorize("hasRole('USER') ")
    public Order createOrder(@RequestBody Order order){
        return orderService.saveOrUpdate(order);
    }
    @PutMapping("/{orderId}")
    @PreAuthorize("hasRole('USER') ")
    public Order updateOrderStatus(@PathVariable("orderId") int orderId, @RequestParam int orderStatus) {
        return orderService.updateStatus(orderId,orderStatus);
    }
    @DeleteMapping("/{orderId}")
    @PreAuthorize("hasRole('USER') ")
        public void deleteOrder(@PathVariable("orderId") int orderId){
            orderService.deleteId(orderId);
        }
    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') ")
        public Order searchById(@RequestParam("orderId") int orderId){
            return orderService.searchById( orderId);
        }
}
