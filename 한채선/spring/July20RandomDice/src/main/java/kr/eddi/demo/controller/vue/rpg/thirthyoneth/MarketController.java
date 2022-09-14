package kr.eddi.demo.controller.vue.rpg.thirthyoneth;


import kr.eddi.demo.entity.vue.thirthyoneth.MarketManager;
import kr.eddi.demo.entity.vue.thirthyoneth.ShopItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("31th/market-controller")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MarketController {

    private MarketManager marketManager = new MarketManager();

    @GetMapping("/random-shop-item-lists")
    public List<ShopItem> randomShopItemLists() {
        log.info("randomShopItemLists()");
        marketManager.buildRandomShopItemsList(10);
        return marketManager.getRandomShopList();
    }
}
