package com.example.demo.repository.board.product;

import com.example.demo.entity.jpa.board.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBoardRepository extends JpaRepository<Product, Long> {
}
