package kr.eddi.product.controller;

import kr.eddi.product.controller.request.GoodsRequest;
import kr.eddi.product.entity.Goods;
import kr.eddi.product.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/goods")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public List<Goods> goodsList() {
        log.info("goodsList()");

        return goodsService.list();
    }

    @PostMapping("/register")
    public void register(@RequestBody GoodsRequest goodsRequest) {
        log.info("register()");

        goodsService.register(goodsRequest);
    }

    @GetMapping("/{goodsNo}")
    public Goods goodsRead(@PathVariable("goodsNo") Long goodsNo) {
        log.info("goodsRead()");

        return goodsService.read(goodsNo);
    }

}
