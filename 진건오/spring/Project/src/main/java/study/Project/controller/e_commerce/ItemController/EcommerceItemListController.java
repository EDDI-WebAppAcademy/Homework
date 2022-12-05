package study.Project.controller.e_commerce.ItemController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.Project.entity.e_commerce.item.EcommerceItem;
import study.Project.service.e_commerce.item.ItemService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ecommerce/item")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class EcommerceItemListController {

    @Autowired
    private ItemService service;

    @GetMapping("/list")
    public List<EcommerceItem> ecommerceItemList() {
        log.info("ecommerceItemList");

        return service.list();
    }
}
