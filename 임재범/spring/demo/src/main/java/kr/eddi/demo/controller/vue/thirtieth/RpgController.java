package kr.eddi.demo.controller.vue.thirtieth;

import kr.eddi.demo.entity.vue.RandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/30th/rpg")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgController {

    @GetMapping("/item")
    public void rpgTest () {
        log.info("rpgTest()");



    }
}