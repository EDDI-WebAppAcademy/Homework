package lbk.homework.day0921.jpa.productsBoard.service;

import lbk.homework.day0921.jpa.productsBoard.entity.Board;
import lbk.homework.day0921.jpa.productsBoard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository repository;

    @Override
    public List<Board> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }
}
