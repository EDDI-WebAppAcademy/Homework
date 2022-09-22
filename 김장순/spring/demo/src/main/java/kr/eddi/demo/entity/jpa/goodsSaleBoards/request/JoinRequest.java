package kr.eddi.demo.entity.jpa.goodsSaleBoards.request;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class JoinRequest {

    private String id;

    private String password;

    private String email;
}
