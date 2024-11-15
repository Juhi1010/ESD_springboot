package com.juhi.signuplogin.repo;

import com.juhi.signuplogin.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price ASC LIMIT 2")
    List<Product> findTop2ByPriceRangeOrderByPrice(Double minPrice, Double maxPrice);
}
