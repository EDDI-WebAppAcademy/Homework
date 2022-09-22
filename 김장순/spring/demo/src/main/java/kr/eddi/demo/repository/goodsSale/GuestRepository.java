package kr.eddi.demo.repository.goodsSale;

import kr.eddi.demo.entity.jpa.goodsSaleBoards.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
