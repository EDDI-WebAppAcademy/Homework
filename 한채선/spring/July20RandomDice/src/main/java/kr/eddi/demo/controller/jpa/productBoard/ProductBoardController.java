package kr.eddi.demo.controller.jpa.productBoard;


import kr.eddi.demo.entity.jpa.productBoard.ProductBoard;
import kr.eddi.demo.service.jpa.productBoard.ProductBoardService;
import kr.eddi.demo.service.jpa.productBoard.requested.ProductBoardRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/41th/jpa/prudoct-board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductBoardController {

    @Autowired
    private ProductBoardService service;

    @GetMapping("/board-list")
    public List<ProductBoard> boardList() {
        log.info("boardList()");

        return service.list();
    }

    @PostMapping("/board-register")
    public void boardRegister(@RequestBody ProductBoardRequest productBoardRequest) {
        log.info("boardRegister");

        service.register(productBoardRequest);
    }

}
