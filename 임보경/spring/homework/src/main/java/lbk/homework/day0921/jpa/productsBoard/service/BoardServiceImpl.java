package lbk.homework.day0921.jpa.productsBoard.service;

import lbk.homework.day0921.jpa.productsBoard.controller.request.BoardRequest;
import lbk.homework.day0921.jpa.productsBoard.entity.Board;
import lbk.homework.day0921.jpa.productsBoard.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository repository;

    @Override
    public List<Board> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public void register(BoardRequest boardRequest) {
       Board board = new Board();
       board.setProductName(boardRequest.getProductName());
       board.setDetails(boardRequest.getDetails());
       board.setPrice(boardRequest.getPrice());
       board.setNumberInStock(boardRequest.getNumberInStock());

       repository.save(board);
    }

    @Override
    public Board read(Long boardNo) {
        Optional<Board> maybeBoard = repository.findById(boardNo);

        if (maybeBoard.equals(Optional.empty())) {
            log.info("Can't read board!!!");
            return null;
        }
        return maybeBoard.get();
    }
}
