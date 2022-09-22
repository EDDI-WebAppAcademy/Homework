package study.Project.entity.e_commerce.item;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class EcommerceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(length = 128, nullable = false)
    private String itemName;

    @Column(length = 64, nullable = false)
    private String seller;

    @Column(length = 32, nullable = false)
    private Long itemPrice;

    @Lob
    private String itemInformation;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;
}
