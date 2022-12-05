package study.Project.controller.e_commerce.ItemController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.Project.entity.e_commerce.item.EcommerceItem;
import study.Project.service.e_commerce.item.ItemService;

@Slf4j
@RestController
@RequestMapping("/ecommerce")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class EcommerceItemReadController {

    @Autowired
    private ItemService itemservice;

    @GetMapping("/{itemId}")
    public EcommerceItem selectedItem(@PathVariable("itemId") Long itemId) {
        log.info("selectedItem");

        return itemservice.read(itemId);
    }
}
