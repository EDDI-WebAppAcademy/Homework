package kr.eddi.demo.service.jpa.board;

import kr.eddi.demo.controller.jpa.board.request.BoardRequest;
import kr.eddi.demo.entity.jpa.boards.Board2;
import kr.eddi.demo.repository.board.BoardRepository2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl2 implements BoardService2 {

    @Autowired
    BoardRepository2 repository2;

    @Override
    public void register(BoardRequest boardRequest) {
        Board2 board = new Board2();
        board.setTitle(boardRequest.getTitle());
        board.setContent(boardRequest.getContent());
        board.setWriter(boardRequest.getWriter());

        repository2.save(board);
    }

    @Override
    public List<Board2> list() {
        return repository2.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public Board2 read(Long boardNo) {
        Optional<Board2> maybeBoard = repository2.findById(boardNo);

        if (maybeBoard.equals(Optional.empty())) {
            log.info("Can't read board!!!");
            return null;
        }

        return maybeBoard.get();
    }

    @Override
    public void modify(Board2 board) {
        repository2.save(board);
    }

    @Override
    public void remove(Long boardNo) {
        repository2.deleteById(boardNo);
    }
}
