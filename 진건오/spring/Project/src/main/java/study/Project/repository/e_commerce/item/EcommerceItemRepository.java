package study.Project.repository.e_commerce.item;

import org.springframework.data.jpa.repository.JpaRepository;
import study.Project.entity.e_commerce.item.EcommerceItem;

public interface EcommerceItemRepository extends JpaRepository<EcommerceItem, Long> {
}
