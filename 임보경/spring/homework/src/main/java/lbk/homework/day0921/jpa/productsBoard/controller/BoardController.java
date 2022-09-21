package lbk.homework.day0921.jpa.productsBoard.controller;

import lbk.homework.day0921.jpa.productsBoard.entity.Board;
import lbk.homework.day0921.jpa.productsBoard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
