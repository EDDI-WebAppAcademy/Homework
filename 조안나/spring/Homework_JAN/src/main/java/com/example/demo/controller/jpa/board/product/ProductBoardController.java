package com.example.demo.controller.jpa.board.product;

import com.example.demo.controller.jpa.request.product.ProductRequest;
import com.example.demo.entity.jpa.board.product.Product;
import com.example.demo.service.jpa.board.product.ProductBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product-board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductBoardController {

    @Autowired
    private ProductBoardService productBoardService;

    /*
    상품 리스트
     */
    @GetMapping("/list")
    public List<Product> productBoardList () {
        log.info("productBoardList()");

        return productBoardService.list();
    }

    /*
    상품 등록
     */
    @PostMapping("/register")
    public void productBoardRegister (@RequestBody ProductRequest productRequest) {
        log.info("productBoardRegister()");

        productBoardService.register(productRequest);
    }

    /*
    상품 읽기
     */
    @GetMapping("/{productNo}")
    public Product productBoardRead (@PathVariable("productNo") Long productNo) {
        log.info("productBoardRead()");

        return productBoardService.read(productNo);
    }

    /*
    상품 수정
     */
    @PutMapping("/{productNo}")
    public Product productBoardModify (@PathVariable("productNo") Long productNo, @RequestBody Product product) {
        log.info("productBoardModify()");

        product.setProductNo(productNo);
        productBoardService.modify(product);

        return product;
    }

    /*
    상품 삭제
     */
    @DeleteMapping("/{productNo}")
    public void productBoardRemove (@PathVariable("productNo") Long productNo) {
        log.info("productBoardRemove()");

        productBoardService.remove(productNo);
    }
}
