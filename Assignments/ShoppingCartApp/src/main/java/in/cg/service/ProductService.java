package in.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import in.cg.model.Product;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Mobile", 20000));
        products.add(new Product(3, "Headphones", 3000));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}