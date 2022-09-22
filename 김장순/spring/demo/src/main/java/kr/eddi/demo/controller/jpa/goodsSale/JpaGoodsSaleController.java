package kr.eddi.demo.controller.jpa.goodsSale;

import kr.eddi.demo.entity.jpa.goodsSaleBoards.GoodsSaleBoard;
import kr.eddi.demo.entity.jpa.goodsSaleBoards.request.ProductRequest;
import kr.eddi.demo.service.jpa.goodsSale.GoodsSaleBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/goods/sale")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaGoodsSaleController {

    @Autowired
    private GoodsSaleBoardService service;

    @GetMapping("/list")
    public List<GoodsSaleBoard> goodsSaleBoardList() {
        log.info("goodsSaleBoardList()");

        return service.list();
    }


}
