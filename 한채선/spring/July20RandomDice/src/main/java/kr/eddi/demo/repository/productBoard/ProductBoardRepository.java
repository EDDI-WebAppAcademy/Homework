package kr.eddi.demo.repository.productBoard;

import kr.eddi.demo.entity.jpa.productBoard.ProductBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBoardRepository extends JpaRepository<ProductBoard, Long> {
}
