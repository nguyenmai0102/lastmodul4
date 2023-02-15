package ra.model.serviceIpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.model.service.ProductService;
import ra.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceIpm  implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> searchByName(String productName, int productId) {
        return productRepository.findByProductNameOrProductId(productName,productId);
    }

    @Override
    public List<Product> sortProductByProductName(String direction) {
        if (direction.equals("asc")){
            return productRepository.findAll(Sort.by("productName").ascending());
        }else {
            return productRepository.findAll(Sort.by("productName").ascending());
        }
    }
    @Override
    public List<Product> sortByNameAndPrice(String directionName, String directionPrice) {
        if (directionName.equals("asc")){
            if (directionPrice.equals("asc")){
                return  productRepository.findAll(Sort.by("productName").and(Sort.by("price")));
            }else {
                return productRepository.findAll(Sort.by("productName").and(Sort.by("price").descending()));
            }
        }else {
            if (directionPrice.equals("asc")){
                return  productRepository.findAll(Sort.by("productName").descending().and(Sort.by("price")));
            }else {
                return productRepository.findAll(Sort.by("productName").descending().and(Sort.by("price").descending().descending()));
            }
        }
    }

    @Override
    public List<Product> sortByName_Price_Id(String directionName, String directionPrice, String directionId) {
        List<Sort.Order> listOrder = new ArrayList<>();
        if (directionName.equals("asc")){
            listOrder.add(new Sort.Order(Sort.Direction.ASC,"productName"));
        }else {
            listOrder.add(new Sort.Order(Sort.Direction.DESC,"productName"));
        }
        if (directionPrice.equals("asc")){
            listOrder.add(new Sort.Order(Sort.Direction.ASC, "price"));
        }else {
            listOrder.add(new Sort.Order(Sort.Direction.DESC, "price"));
        }
        if (directionId.equals("id")){
            listOrder.add(new Sort.Order(Sort.Direction.ASC, "productId"));
        }else {
            listOrder.add(new Sort.Order(Sort.Direction.DESC, "productId"));
        }
        return productRepository.findAll(Sort.by(listOrder));
    }

    @Override
    public Page<Product> getPagging(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


}
