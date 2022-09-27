package kr.eddi.product.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Goods {
    @Id
    @GeneratedValue
    private Long goodsNo;

    @Column(length = 128, nullable = false)
    private String goodsName;

    @Column(length = 32, nullable = false)
    private String seller;

    @Lob
    private String goodsDescription;

    @Column(nullable = false)
    private Integer price;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

}
