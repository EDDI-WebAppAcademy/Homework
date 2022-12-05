package kr.eddi.demo.controller.jpa.product;

import kr.eddi.demo.entity.jpa.products.Product;
import kr.eddi.demo.entity.jpa.products.request.ProductRequest;
import kr.eddi.demo.service.jpa.products.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/goods/sale")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/list")
    public List<Product> goodsSaleBoardList() {
        log.info("goodsSaleBoardList()");

        return service.list();
    }
    @PostMapping("/register")
    public void productRegister(@RequestBody ProductRequest productRequest){
        log.info("productRegister(): " + productRequest);

        service.register(productRequest);
    }



}
