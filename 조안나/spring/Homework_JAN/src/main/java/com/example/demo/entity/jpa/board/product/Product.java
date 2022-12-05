package com.example.demo.entity.jpa.board.product;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productNo;

    @Column(length = 128, nullable = false)
    private String title;

//    이미지 받는거 우선 String으로 설정
    @Column(length = 32, nullable = false)
    private String image;

    @Column(length = 32, nullable = false)
    private String writer;

    @Column
    private int price;

    @Column
    private String category;

    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
