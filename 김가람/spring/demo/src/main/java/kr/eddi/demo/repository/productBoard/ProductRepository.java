package kr.eddi.demo.repository.productBoard;

import kr.eddi.demo.entity.jpa.productBoard.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
