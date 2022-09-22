package kr.eddi.demo.service.jpa.board;

import kr.eddi.demo.controller.jpa.board.request.BoardRequest;
import kr.eddi.demo.entity.jpa.boards.Board2;

import java.util.List;

public interface BoardService2 {
    public void register(BoardRequest boardRequest);
    public List<Board2> list();
    public Board2 read(Long boardNo);
    public void modify(Board2 board);
    public void remove(Long boardNo);
}
