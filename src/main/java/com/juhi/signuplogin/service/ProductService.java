package com.juhi.signuplogin.service;

import com.juhi.signuplogin.entity.Product;
import com.juhi.signuplogin.repo.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productRepository;

    public List<Product> getTopProductsInRange(double minPrice, double maxPrice) {
        return productRepository.findTop2ByPriceRangeOrderByPrice(minPrice, maxPrice);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

}


