package lbk.homework.day0921.jpa.productsBoard.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String productName;

    @Column(length = 32, nullable = false)
    private Long price;

    @Lob
    private String details;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @Column(length = 32, nullable = false)
    private Long NumberInStock;
}
