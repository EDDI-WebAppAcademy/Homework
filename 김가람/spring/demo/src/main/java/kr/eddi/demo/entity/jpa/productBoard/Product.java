package kr.eddi.demo.entity.jpa.productBoard;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productNo;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private Integer price;

    @Column(length = 32, nullable = false)
    private Integer stock;

    @Lob
    private String description;


}
