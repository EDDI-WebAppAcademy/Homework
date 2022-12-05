package kr.eddi.demo.entity.jpa.productBoards;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ProductBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product;

    @Column(length = 128, nullable = false)
    private String ProductName;

    @Column(length = 40, nullable = false)
    private Integer price;

    @Column(length = 40, nullable = false)
    private String writer;

    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

}
