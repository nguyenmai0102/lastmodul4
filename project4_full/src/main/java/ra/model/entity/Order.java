package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "orderId")
    private int orderId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JoinColumn(name = "createDate")
    private Date createDate;
    @Column(name = "OrderStatus")
    private int orderStatus;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
    private List<OrderDetail> listOrderDetails = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "orderDetail",
//            joinColumns = @JoinColumn(name = "order_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
//    List<Product> roles = new ArrayList<>();

}
