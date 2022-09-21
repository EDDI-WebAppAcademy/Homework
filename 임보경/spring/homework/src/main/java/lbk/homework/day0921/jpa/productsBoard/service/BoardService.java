package lbk.homework.day0921.jpa.productsBoard.service;

import lbk.homework.day0921.jpa.productsBoard.entity.Board;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {

    public List<Board> list();
}
