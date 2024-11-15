package com.juhi.signuplogin.controller;

import com.juhi.signuplogin.entity.Product;
import com.juhi.signuplogin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/top-products")
    public List<Product> getTopProductsInRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        return productService.getTopProductsInRange(minPrice, maxPrice);
    }

    @PostMapping("/createProd")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

}