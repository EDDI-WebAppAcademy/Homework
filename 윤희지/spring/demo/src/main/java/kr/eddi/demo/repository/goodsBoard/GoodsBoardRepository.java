package kr.eddi.demo.repository.goodsBoard;

import kr.eddi.demo.entity.goodsBoard.GoodsBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsBoardRepository extends JpaRepository<GoodsBoard, Long> {
}
