package lbk.homework.day0921.jpa.productsBoard.repository;

import lbk.homework.day0921.jpa.productsBoard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BoardRepository extends JpaRepository<Board, Long> {

}
