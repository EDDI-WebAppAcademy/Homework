package kr.eddi.demo.controller.jpa.board;

import kr.eddi.demo.controller.jpa.board.request.BoardRequest;
import kr.eddi.demo.entity.jpa.boards.Board;
import kr.eddi.demo.entity.jpa.boards.Board2;
import kr.eddi.demo.service.jpa.board.BoardService;
import kr.eddi.demo.service.jpa.board.BoardService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("39th/jpa/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaBoardController {

    @Autowired
    private BoardService service;
    @Autowired
    private BoardService2 service2; //Autowired를 따로 안해줘서 문제가 발생했었네

    @GetMapping("/list")
    public List<Board> boardList () {
        log.info("boardList()");

        return service.list();
    }

    @GetMapping("/list2")
    public List<Board2> boardList2 () {
        log.info("boardList2()");

        return service2.list(); //
    }

    @GetMapping("/{boardNo}/list2")
    public Board2 boardRead2 (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRead2()");

        return service2.read(boardNo);
    }



    @PostMapping("/register")
    public void boardRegister (@RequestBody BoardRequest boardRequest) {
        log.info("boardRegister()");

        service.register(boardRequest);
    }

    @PostMapping("/register2")
    public void boardRegister2 (@RequestBody BoardRequest boardRequest) {
        log.info("boardRegister2()");

        service2.register(boardRequest);
    }

    @GetMapping("/{boardNo}")
    public Board boardRead (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRead()");

        return service.read(boardNo);
    }

    @DeleteMapping("/{boardNo}")
    public void boardRemove (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRemove()");

        service.remove(boardNo);
    }

    @PutMapping("/{boardNo}")
    public Board boardModify (@PathVariable("boardNo") Long boardNo, @RequestBody Board board) {
        log.info("boardModify()");

        board.setBoardNo(boardNo);
        service.modify(board);

        return board;
    }
}
