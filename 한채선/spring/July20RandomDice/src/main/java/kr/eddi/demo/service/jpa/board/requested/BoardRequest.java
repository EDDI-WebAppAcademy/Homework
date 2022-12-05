package kr.eddi.demo.service.jpa.board.requested;

import lombok.Getter;

@Getter
public class BoardRequest {

    private String title;
    private String writer;
    private String content;
}
