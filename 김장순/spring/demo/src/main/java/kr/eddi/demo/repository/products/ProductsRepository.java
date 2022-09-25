package kr.eddi.demo.repository.products;

import kr.eddi.demo.entity.jpa.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
