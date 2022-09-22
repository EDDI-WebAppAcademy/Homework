package kr.eddi.demo.repository.goodsSale;

import kr.eddi.demo.entity.jpa.goodsSaleBoards.GoodsSaleBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsSaleRepository extends JpaRepository<GoodsSaleBoard, Long> {
}
