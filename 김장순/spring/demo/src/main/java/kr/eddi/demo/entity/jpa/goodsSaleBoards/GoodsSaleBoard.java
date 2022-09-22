package kr.eddi.demo.entity.jpa.goodsSaleBoards;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class GoodsSaleBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 32, nullable = false)
    private String seller;

    @Column(length = 32, nullable = false)
    private String price;

    @Lob
    private String content;


}
