package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Product;
import ra.model.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController() {
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Product> getAllProduct(){
        return productService.findAll();
    }
    @GetMapping("/{productId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Product getProductById(@PathVariable("productId") int productId){
        return productService.findById(productId);
    }
    @PostMapping
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public Product createProduct(@RequestBody Product product){
        return productService.saveOrUpdate(product);
    }
    @PutMapping("/{productId}")
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product){
        Product productUpDate = productService.findById(productId);
        productUpDate.setProductName(product.getProductName());
        productUpDate.setStatus(product.isStatus());
        productUpDate.setDescription(product.getDescription());
        productUpDate.setQuantity(product.getQuantity());
        productUpDate.setPrice(product.getPrice());
        return productService.saveOrUpdate(productUpDate);
    }
    @DeleteMapping("/{productId}")
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteProduct (@PathVariable("productId") int productId){
        productService.delete(productId);
    }
    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Product> searchByNameOrId(@RequestParam("productName")String productName, @RequestParam("productId") int productId){
        return this.productService.searchByName(productName, productId);
    }


    @GetMapping("/sortByName")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> sortProductByProductName(@RequestParam("direction") String direction){
        List<Product> listProduct = productService.sortProductByProductName(direction);
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }
    @GetMapping("/sortByNameAndPrice")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> sortProductByNameAndPrice(@RequestParam("directionName") String directionName,
                                                                   @RequestParam("directionPrice") String directionPrice){
        List<Product> listProduct = productService.sortByNameAndPrice(directionName,directionPrice);
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }

    @GetMapping("/sortByNameAndPriceAndId")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> sortProductByNameAndPriceAndId(@RequestParam("directionName") String directionName,
                                                                   @RequestParam("directionPrice") String directionPrice,
                                                                   @RequestParam("directionId") String directionId){
        List<Product> listBooks = productService.sortByName_Price_Id(directionName,directionPrice, directionId);
        return new ResponseEntity<>(listBooks, HttpStatus.OK);

    }
    @GetMapping("/getPagging")
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Map<String,Object>> getPagging(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3")int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pageBook = productService.getPagging(pageable);
        Map<String, Object> data = new HashMap<>();
        data.put("products", pageBook.getContent());
        data.put("total", pageBook.getSize());
        data.put("totalItems", pageBook.getTotalElements());
        data.put("totalPages", pageBook.getTotalPages());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/getPaggingAndSortByName")
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Map<String,Object>> getPaggingAndSortByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3")int size,
            @RequestParam String direction){
        Sort.Order order;
        if (direction.equals("asc")){
            order=new Sort.Order(Sort.Direction.ASC, "productName");
        }else {
            order=new Sort.Order(Sort.Direction.DESC, "productName");
        }
        Pageable pageable = PageRequest.of(page,size,Sort.by(order));
        Page<Product> pageProduct = productService.getPagging(pageable);
        Map<String,Object> data = new HashMap<>();
        data.put("product", pageProduct.getContent());
        data.put("total", pageProduct.getSize());
        data.put("totalItems", pageProduct.getTotalElements());
        data.put("totalPages", pageProduct.getTotalPages());
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

}
