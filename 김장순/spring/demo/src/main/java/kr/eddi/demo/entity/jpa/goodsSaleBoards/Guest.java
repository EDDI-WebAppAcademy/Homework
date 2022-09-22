package kr.eddi.demo.entity.jpa.goodsSaleBoards;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Guest {

    @Id
    @GeneratedValue
    private Long guestNo;

    @Column(length = 32, nullable = false)
    private String id;

    @Column(length = 32, nullable = false)
    private String password;

    @Column(length = 32, nullable = false)
    private String email;

}
