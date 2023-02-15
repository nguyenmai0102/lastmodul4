package ra.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ra.model.entity.Product;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponseDTO {
    private List<Integer> amount;
    private List<Product> product;
}
