package lbk.homework.day0921.jpa.productsBoard.controller;

import lbk.homework.day0921.jpa.productsBoard.controller.request.BoardRequest;
import lbk.homework.day0921.jpa.productsBoard.entity.Board;
import lbk.homework.day0921.jpa.productsBoard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products-board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    BoardService service;

    @GetMapping("/lists")
    public List<Board> responseToRequestBoardListFromVue () {
        log.info("요청이 들어온걸 확인하고 싶어요!");
        return service.list();
    }

    @GetMapping("/{boardNo}")
    public Board boardRead (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRead()");
        return service.read(boardNo);
    }

    @PostMapping("/register")
    public void productRegister (@RequestBody BoardRequest boardRequest) {
        log.info("boardRegister()" + boardRequest.toString());
        service.register(boardRequest);
    }

    @PutMapping("/{boardNo}")
    public Board boardModify (@PathVariable("boardNo") Long boardNo, @RequestBody Board board) {
        log.info("boardModify()");

        board.setBoardNo(boardNo);
        service.modify(board);

        return board;
    }

}
