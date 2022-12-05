package lbk.homework.day0921.jpa.productsBoard.service;

import lbk.homework.day0921.jpa.productsBoard.controller.request.BoardRequest;
import lbk.homework.day0921.jpa.productsBoard.entity.Board;

import java.util.List;

public interface BoardService {

    public List<Board> list();

    public void register(BoardRequest boardRequest);
    public Board read(Long boardNo);
    public void modify(Board board);
    public void remove(Long boardNo);
}
