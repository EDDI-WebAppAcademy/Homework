package kr.eddi.demo.controller.goodsBoard;

import kr.eddi.demo.controller.goodsBoard.request.GoodsBoardRequest;
import kr.eddi.demo.entity.goodsBoard.GoodsBoard;
import kr.eddi.demo.service.jpa.goodsBoard.GoodsBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/goods-board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

public class GoodsBoardController {

    @Autowired
    private GoodsBoardService goodsBoardService;

    @GetMapping("/list")
    public List<GoodsBoard> goodsBoardList () {
        log.info("goodsBoardList()");

        return goodsBoardService.list();
    }

    @GetMapping("/{boardNo}")
    public GoodsBoard goodsBoardRead (@PathVariable("boardNo") Long boardNo) {
        log.info("goodsBoardRead()");

        return goodsBoardService.read(boardNo);
    }

    @PostMapping("/register")
    public void goodsBoardRegister (@RequestBody GoodsBoardRequest goodsBoardRequest ) {
        log.info("goodsBoardRegister()");

        goodsBoardService.register(goodsBoardRequest);
    }

    @DeleteMapping("/{boardNo}")
    public void goodsBoardRemove (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRemove()");

        goodsBoardService.remove(boardNo);
    }

    @PutMapping("/{boardNo}")
    public GoodsBoard goodsBoardModify (@PathVariable("boardNo") Long boardNo, @RequestBody GoodsBoard goodsBoard) {
        log.info("goodsBoardModify()");

        goodsBoard.setBoardNo(boardNo);
        goodsBoardService.modify(goodsBoard);

        return goodsBoard;
    }

}
