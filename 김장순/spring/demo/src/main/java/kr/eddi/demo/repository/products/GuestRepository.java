package kr.eddi.demo.repository.products;

import kr.eddi.demo.entity.jpa.products.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
