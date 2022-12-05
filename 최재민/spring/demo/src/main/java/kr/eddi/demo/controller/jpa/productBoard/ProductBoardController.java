package kr.eddi.demo.controller.jpa.productBoard;

import kr.eddi.demo.entity.jpa.productBoards.ProductBoard;
import kr.eddi.demo.service.jpa.productBoard.ProductBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/40th/product")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductBoardController {

    @Autowired
    private ProductBoardService productBoardService;

    @GetMapping("/board-list")
    public List<ProductBoard> ProductBoardList() {
        log.info("ProductBoardList()");

        return productBoardService.list();
    }
}
