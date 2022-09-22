package kr.eddi.demo.controller.jpa.productBoard;

import kr.eddi.demo.controller.jpa.productBoard.request.ProductBoardRequest;
import kr.eddi.demo.entity.jpa.productBoards.ProductBoard;
import kr.eddi.demo.service.jpa.productBoard.ProductBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/40th/jpa/product-board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaProductBoardController {

    @Autowired
    private ProductBoardService productBoardService;

    @GetMapping("/list")
    public List<ProductBoard> productBoardList() {
        log.info("productBoardList()");

        return productBoardService.productList();
    }

    @PostMapping("/register")
    public void boardRegister (@RequestBody ProductBoardRequest productBoardRequest) {
        log.info("boardRegister()");

        productBoardService.register(productBoardRequest);
    }
}
