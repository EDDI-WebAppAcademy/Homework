package kr.eddi.demo.entity.jpa.products;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 32, nullable = false)
    private String seller;

    @Column(nullable = false)
    private Integer price;

    @Lob
    private String content;


}
