package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;
    @Column(name = "ProductName", columnDefinition = "nvarchar(50)", nullable = false, unique = true)
    private String productName;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "Description", columnDefinition = "nvarchar(225)")
    private String description;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "Price", columnDefinition = "nvarchar(225)")
    private String price;
    @ManyToOne
    @JoinColumn( name= "catalogId")
    @JsonIgnore
    private  Catalog catalog;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> listOrderDetail = new ArrayList<>();

}
