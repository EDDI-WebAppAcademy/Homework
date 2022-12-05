package kr.eddi.demo.entity.goodsBoard;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity

public class GoodsBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 100, nullable = false)
    private String goodsName;

    @Column(length = 50, nullable = false)
    // 테스트 해야해서 일단 string으로
    private String price;

    @Column(length = 100, nullable = false)
    private String seller;

    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

}
