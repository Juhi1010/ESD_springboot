package com.juhi.signuplogin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "product_id")
        private Long productId;

        @Column(name = "name", nullable = false, length = 255)
        private String name;

        @Column(name = "price", nullable = false)
        private Long price;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }

}


