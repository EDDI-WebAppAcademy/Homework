package com.example.product.entity.repository.productBoard;

import com.example.product.entity.jpa.productBoard.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
