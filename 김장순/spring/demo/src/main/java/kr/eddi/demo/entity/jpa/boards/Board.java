package kr.eddi.demo.entity.jpa.boards;

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

    @Column(length = 128, nullable = false) //null이면 안된다
    private String title;

    @Column(length = 32, nullable = false)
    private String writer;

    @Lob  //내용이 많을 수도 있을 때 사용
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}