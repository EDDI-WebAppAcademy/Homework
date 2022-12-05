package kr.eddi.demo.controller.jpa.productBoard;

import kr.eddi.demo.controller.jpa.board.request.BoardRequest;
import kr.eddi.demo.controller.jpa.productBoard.request.ProductRequest;
import kr.eddi.demo.entity.jpa.productBoard.Product;
import kr.eddi.demo.service.jpa.productBoard.ProductBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/40th/jpa/product-board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductBoardController {

    @Autowired
    private ProductBoardService productBoardService;

    @PostMapping("/list")
    public List<Product> productBoardList () {
        log.info("productBoardList()");

        return productBoardService.list();
    }

    @PostMapping("/register")
    public void productRegister (@RequestBody ProductRequest productRequest) {
        log.info("productRegister()");

        productBoardService.register(productRequest);
    }

}
